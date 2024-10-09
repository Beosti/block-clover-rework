package com.yuanno.blockclover.spells.fire;

import com.yuanno.blockclover.api.spells.Spell;
import com.yuanno.blockclover.api.spells.components.ItemSpellComponent;
import com.yuanno.blockclover.init.ModItems;

public class FirebatSpell extends Spell {
    public static FirebatSpell INSTANCE = new FirebatSpell();

    private ItemSpellComponent firebatComponent = new ItemSpellComponent.ItemSpellComponentBuilder()
            .setItem(ModItems.FIRE_BAT::get)
            .build();

    public FirebatSpell()
    {
        this.setName("Firebat");
        this.setDescription("Creates a firebat you can use to fight");
        this.setMaxCooldown(10);
        this.setSpellMaxExperience(3);
        this.setExperienceGain(5);
        this.addSpellCompontent(firebatComponent);
    }
}