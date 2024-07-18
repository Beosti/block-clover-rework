package com.yuanno.blockclover.entity.fire;

import com.yuanno.blockclover.Main;
import com.yuanno.blockclover.api.Beapi;
import com.yuanno.blockclover.client.renderers.AbilityProjectileRenderer;
import com.yuanno.blockclover.models.CubeModel;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FireProjectiles {

    public static final RegistryObject<EntityType<FireballProjectile>> FIREBALL = Beapi.registerEntityType("Fireball",
            () -> Beapi.createEntityType(FireballProjectile::new)
                    .sized(1f, 1f)
                    .build(Main.MODID + ":fireball"));

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerEntityRenderers(FMLClientSetupEvent event)
    {
        RenderingRegistry.registerEntityRenderingHandler(FIREBALL.get(), new AbilityProjectileRenderer.Factory(new CubeModel())
                .setScale(1, 1, 1)
                .setColor("#FF0000"));
    }

}
