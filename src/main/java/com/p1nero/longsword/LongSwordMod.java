package com.p1nero.longsword;

import com.mojang.logging.LogUtils;
import com.p1nero.longsword.client.entity.dragon.DragonPatchRenderer;
import com.p1nero.longsword.client.entity.dragon.DragonRenderer;
import com.p1nero.longsword.entity.boss.Boss;
import com.p1nero.longsword.entity.boss.BossEntityPatch;
import com.p1nero.longsword.client.entity.boss.BossRenderer;
import com.p1nero.longsword.entity.LongSwordEntities;
import com.p1nero.longsword.entity.dragon.Dragon;
import com.p1nero.longsword.entity.dragon.DragonEntityPatch;
import com.p1nero.longsword.gameasset.LongSwordAnimations;
import com.p1nero.longsword.gameasset.LongSwordArmatures;
import com.p1nero.longsword.gameasset.LongSwordMeshes;
import com.p1nero.longsword.gameasset.LongSwordWeaponCategories;
import com.p1nero.longsword.item.LongSwordItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import yesman.epicfight.api.client.forgeevent.PatchedRenderersEvent;
import yesman.epicfight.api.client.model.Meshes;
import yesman.epicfight.api.forgeevent.EntityPatchRegistryEvent;
import yesman.epicfight.api.forgeevent.ModelBuildEvent;
import yesman.epicfight.client.renderer.patched.entity.PHumanoidRenderer;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

@Mod(LongSwordMod.MOD_ID)
public class LongSwordMod {
    public static final String MOD_ID = "mh_longsword";
    public static final Logger LOGGER = LogUtils.getLogger();
    public LongSwordMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        LongSwordItems.ITEMS.register(bus);
        LongSwordEntities.ENTITIES.register(bus);
        WeaponCategory.ENUM_MANAGER.loadPreemptive(LongSwordWeaponCategories.class);
        bus.addListener(LongSwordMeshes::build);
        bus.addListener(LongSwordArmatures::build);
        bus.addListener(LongSwordAnimations::registerAnimations);
        bus.addListener(LongSwordMod::onPatchedRenderer);
        bus.addListener(LongSwordMod::setPatch);
        bus.addListener(LongSwordMod::setArmature);
    }


    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents{
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){
            EntityRenderers.register(LongSwordEntities.BOSS.get(), BossRenderer::new);
            EntityRenderers.register(LongSwordEntities.DRAGON.get(), DragonRenderer::new);
        }

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents{

        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(LongSwordEntities.BOSS.get(), Boss.setAttributes());
            event.put(LongSwordEntities.DRAGON.get(), Dragon.setAttributes());
        }

    }
    @OnlyIn(Dist.CLIENT)
    public static void onPatchedRenderer(PatchedRenderersEvent.Add event){
        event.addPatchedEntityRenderer(LongSwordEntities.BOSS.get(), () -> new PHumanoidRenderer<>(Meshes.ALEX));
        event.addPatchedEntityRenderer(LongSwordEntities.DRAGON.get(), DragonPatchRenderer::new);
    }

    public static void setPatch(EntityPatchRegistryEvent event) {
        event.getTypeEntry().put(LongSwordEntities.BOSS.get(), (entity) -> BossEntityPatch::new);
        event.getTypeEntry().put(LongSwordEntities.DRAGON.get(), (entity) -> DragonEntityPatch::new);
    }

    public static void setArmature(ModelBuildEvent.ArmatureBuild event) {
        Armatures.registerEntityTypeArmature(LongSwordEntities.BOSS.get(), Armatures.BIPED);
        Armatures.registerEntityTypeArmature(LongSwordEntities.DRAGON.get(), LongSwordArmatures.dragonArmature);
    }


}
