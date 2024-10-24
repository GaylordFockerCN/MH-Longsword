package com.p1nero.longsword.gameasset;

import com.p1nero.longsword.LongSwordMod;
import com.p1nero.longsword.client.entity.dragon.DragonArmature;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import yesman.epicfight.api.animation.AnimationPlayer;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.forgeevent.AnimationRegistryEvent;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.model.armature.HumanoidArmature;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.capabilities.entitypatch.MobPatch;

public class LongSwordAnimations {
    public static StaticAnimation DRAGON_IDLE;
    //combat//
    public static StaticAnimation AUTO_1;
    public static StaticAnimation AUTO_2;
    public static StaticAnimation AUTO_3;
    public static StaticAnimation JIA_SHA;
    public static StaticAnimation QI_REN_AUTO_1;
    public static StaticAnimation QI_REN_AUTO_2;
    public static StaticAnimation QI_REN_AUTO_3;
    public static StaticAnimation QI_REN_AUTO_35;
    public static StaticAnimation QI_REN_AUTO_4;
    //living//
    public static StaticAnimation BIPED_IDLE;
    public static StaticAnimation BIPED_WALK;
    public static StaticAnimation NA_DAO;
    //skill//
    public static StaticAnimation DA_JU_HE;
    public static StaticAnimation XIAO_JU_HE;
    public static StaticAnimation QI_REN_TU_CI;
    public static StaticAnimation QI_REN_DOU_GE;
    public static StaticAnimation JIAN_QIE;
    @SubscribeEvent
    public static void registerAnimations(AnimationRegistryEvent event) {
        event.getRegistryMap().put(LongSwordMod.MOD_ID, LongSwordAnimations::build);
    }
    private static void build() {
        DragonArmature dragonArmature = LongSwordArmatures.dragonArmature;
        DRAGON_IDLE = new StaticAnimation(true, "dragon/idle", dragonArmature);

        HumanoidArmature biped = Armatures.BIPED;
        //combat//
        AUTO_1 = new BasicAttackAnimation(0.1F, 2.0F, 2.3F, 2.6F, null, biped.toolR, "biped/combat/auto1", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1) -> 2.0F));
        AUTO_2 = new BasicAttackAnimation(0.1F, 0.62F, 0.92F, 1.0F, null, biped.toolR, "biped/combat/auto2", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1) -> 2.0F));
        AUTO_3 = new BasicAttackAnimation(0.1F, 0.95F, 1.25F, 1.35F, null, biped.toolR, "biped/combat/auto3", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1) -> 2.0F));
        JIA_SHA = new BasicAttackAnimation(0.1F, 1.25F, 1.45F, 1.8F, null, biped.toolR, "biped/combat/jiasha", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1) -> 2.0F));
        QI_REN_AUTO_1 = new BasicAttackAnimation(0.1F, 2.0F, 2.2F, 2.4F, null, biped.toolR, "biped/combat/qiren1", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1) -> 2.0F));
        QI_REN_AUTO_2 = new BasicAttackAnimation(0.1F, 1.3F, 1.5F, 1.7F, null, biped.toolR, "biped/combat/qiren2", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1) -> 2.0F));
        QI_REN_AUTO_3 = new AttackAnimation(0.1F, "biped/combat/qiren3", biped,
                new AttackAnimation.Phase(0.1F, 0.95F, 1.15F, 1.2F, 1.2F, biped.toolR, null),
                new AttackAnimation.Phase(1.2F, 1.35F, 1.55F, 1.65F, 1.65F, biped.toolR, null));
        QI_REN_AUTO_35 = new BasicAttackAnimation(0.1F, 1.0F, 1.2F, 1.6F, null, biped.toolR, "biped/combat/qiren35", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1) -> 2.0F));
        QI_REN_AUTO_4 = new BasicAttackAnimation(0.1F, 1.25F, 1.75F, 2.1F, null, biped.toolR, "biped/combat/qiren4", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1) -> 2.0F));
        //living//
        BIPED_IDLE = new StaticAnimation(true, "biped/living/idle", biped);
        BIPED_WALK = new MovementAnimation(true, "biped/living/walk", biped);
        NA_DAO = new ActionAnimation(0.4F, 2F, "biped/living/uchigatana_scrap", biped)
                .addProperty(AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, true)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1) -> 2.0F));
        //skill//
        DA_JU_HE = new AttackAnimation(0.1F, 1.0F, 1.0F, 1.4F, 2.0F, null, biped.toolR, "biped/skill/dajuhe", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1) -> 2.0F));
        XIAO_JU_HE = new AttackAnimation(0.1F, "biped/skill/xiaojuhe", biped,
                new AttackAnimation.Phase(0.1F, 0.41F, 0.61F, 0.65F, 0.65F, biped.toolR, null),
                new AttackAnimation.Phase(0.65F, 0.66F, 0.86F, 1.0F, 1.0F, biped.toolR, null))
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1) -> 2.0F));
        QI_REN_TU_CI = new AttackAnimation(0.1F, 1F, 1F, 3.0F, 3.0F, null, biped.toolR, "biped/skill/qirentuci", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1) -> 2.0F));
        QI_REN_DOU_GE = new AttackAnimation(0.1F, 2.0F, 2.0F, 3.0F, 5.0F, null, biped.toolR, "biped/skill/qirendouge", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1) -> 2.0F));//TODO
        JIAN_QIE = new BasicAttackAnimation(0.1F, 2.9F, 2.9F, 3.1F, 3.4F, null, biped.toolR, "biped/skill/jianqie", biped){
            @Override
            protected void attackTick(LivingEntityPatch<?> entityPatch) {
                AnimationPlayer player = entityPatch.getAnimator().getPlayerFor(this);
                float elapsedTime = player.getElapsedTime();
                float prevElapsedTime = player.getPrevElapsedTime();
                EntityState state = this.getState(entityPatch, elapsedTime);
                EntityState prevState = this.getState(entityPatch, prevElapsedTime);
                Phase phase = this.getPhaseByTime(elapsedTime);
                if (state.getLevel() == 1 && !state.turningLocked() && entityPatch instanceof MobPatch<?> mobpatch) {
                    ((Mob)mobpatch.getOriginal()).getNavigation().stop();
                    ((LivingEntity)entityPatch.getOriginal()).attackAnim = 2.0F;
                    LivingEntity target = entityPatch.getTarget();
                    if (target != null) {
                        entityPatch.rotateTo(target, entityPatch.getYRotLimit(), false);
                    }
                }

                if (prevState.attacking() || state.attacking() || prevState.getLevel() < 2 && state.getLevel() > 2) {
                    if (!prevState.attacking() || phase != this.getPhaseByTime(prevElapsedTime) && (state.attacking() || prevState.getLevel() < 2 && state.getLevel() > 2)) {
                        entityPatch.playSound(this.getSwingSound(entityPatch, phase), 0.0F, 0.0F);
                        entityPatch.removeHurtEntities();
                    }

                    this.hurtCollidingEntities(entityPatch, prevElapsedTime, elapsedTime, prevState, state, phase);
                    if(!entityPatch.getCurrenltyAttackedEntities().isEmpty()){
                        entityPatch.playAnimationSynchronized(QI_REN_AUTO_4, 0.15F);
                    }
                }
            }
        }
        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1) -> 2.0F));
    }
}
