package com.yuanno.blockclover.init;

import com.yuanno.blockclover.Main;
import com.yuanno.blockclover.api.Beapi;
import com.yuanno.blockclover.api.spells.Spell;
import com.yuanno.blockclover.spells.fire.FireballSpell;
import com.yuanno.blockclover.spells.fire.FirebatSpell;
import com.yuanno.blockclover.spells.fire.FiredupSpell;
import com.yuanno.blockclover.spells.fire.FirewaveSpell;
import com.yuanno.blockclover.util.BeRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import java.util.Arrays;
import java.util.Objects;

public class ModSpells {

    public static final DeferredRegister<Spell> SPELLS = DeferredRegister.create(ModRegistry.SPELLS, Main.MODID);
    public static final Spell[] FIRE = new Spell[] {FireballSpell.INSTANCE, FiredupSpell.INSTANCE, FirebatSpell.INSTANCE, FirewaveSpell.INSTANCE};

    public static void register(IEventBus eventBus)
    {
        registerAbilities(FIRE);
    }

    private static void registerAbilities(Spell[] abilities)
    {
        Arrays.stream(abilities).filter(Objects::nonNull).forEach(abl -> registerSpell(abl));
    }

    public static <T extends Spell> Spell registerSpell(Spell spell)
    {
        String resourceName = Beapi.getResourceName(spell.getIDName());
        BeRegistry.getLangMap().put("spell." + Main.MODID + "." + resourceName, spell.getIDName());

        final ResourceLocation key = new ResourceLocation(Main.MODID, resourceName);
        RegistryObject<Spell> ret = RegistryObject.of(key, ModRegistry.SPELLS);
        if (!SPELLS.getEntries().contains(ret))
        {
            SPELLS.register(resourceName, () -> spell);
        }

        return spell;
    }
}
