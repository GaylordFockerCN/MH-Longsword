package com.p1nero.longsword.gameasset;

import com.p1nero.longsword.LongSwordMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.EpicFightSkills;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.particle.EpicFightParticles;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

import java.util.function.Function;

@Mod.EventBusSubscriber(modid = LongSwordMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LongSwordWeaponCapabilityPreset {
    public static final Function<Item, CapabilityItem.Builder> MH_LONGSWORD = (item) ->
            (CapabilityItem.Builder) WeaponCapability.builder().category(LongSwordWeaponCategories.MH_LONGSWORD)
                    .styleProvider((livingEntityPatch) -> CapabilityItem.Styles.TWO_HAND)
                    .collider(LongSwordColliders.LONGSWORD)
                    .hitSound(EpicFightSounds.BLUNT_HIT)
                    .hitParticle(EpicFightParticles.HIT_BLUNT.get())
                    .canBePlacedOffhand(false)
                    .comboCancel((style) -> false)
                    .newStyleCombo(CapabilityItem.Styles.TWO_HAND,
                            LongSwordAnimations.AUTO_1,
                            LongSwordAnimations.AUTO_2,
                            LongSwordAnimations.AUTO_3,
                            LongSwordAnimations.JIAN_QIE,
                            LongSwordAnimations.QI_REN_AUTO_1,
                            LongSwordAnimations.QI_REN_AUTO_2,
                            LongSwordAnimations.QI_REN_AUTO_35,
                            LongSwordAnimations.QI_REN_AUTO_4,
                            LongSwordAnimations.NA_DAO,
                            LongSwordAnimations.XIAO_JU_HE,
                            LongSwordAnimations.JIA_SHA,
                            LongSwordAnimations.NA_DAO,
                            LongSwordAnimations.DA_JU_HE,
                            LongSwordAnimations.QI_REN_TU_CI,
                            LongSwordAnimations.QI_REN_DOU_GE,
                            LongSwordAnimations.AUTO_1,
                            LongSwordAnimations.AUTO_2)
                    .innateSkill(CapabilityItem.Styles.TWO_HAND, (itemstack) -> EpicFightSkills.SWEEPING_EDGE)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND,
                            LivingMotions.IDLE,
                            LongSwordAnimations.BIPED_IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND,
                            LivingMotions.WALK,
                            LongSwordAnimations.BIPED_WALK)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND,
                            LivingMotions.CHASE,
                            LongSwordAnimations.BIPED_WALK)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND,
                            LivingMotions.RUN,
                            LongSwordAnimations.BIPED_WALK);
    @SubscribeEvent
    public static void register(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put("mh_longsword", MH_LONGSWORD);
    }

}
