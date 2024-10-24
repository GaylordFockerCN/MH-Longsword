package com.p1nero.longsword.entity.boss;

import com.google.common.collect.ImmutableMap;
import com.p1nero.longsword.gameasset.LongSwordAnimations;
import com.p1nero.longsword.gameasset.LongSwordWeaponCategories;
import com.p1nero.longsword.gameasset.ai.LongswordBossCombatBehaviors;
import net.minecraft.world.damagesource.DamageSource;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.client.animation.ClientAnimator;
import yesman.epicfight.api.utils.AttackResult;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.world.capabilities.entitypatch.Faction;
import yesman.epicfight.world.capabilities.entitypatch.HumanoidMobPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.damagesource.StunType;

public class BossEntityPatch extends HumanoidMobPatch<Boss> {
    public BossEntityPatch() {
        super(Faction.NEUTRAL);
    }

    @Override
    public void initAnimator(ClientAnimator animator) {
        animator.addLivingAnimation(LivingMotions.IDLE, LongSwordAnimations.BIPED_IDLE);
        animator.addLivingAnimation(LivingMotions.WALK, Animations.BIPED_WALK_LONGSWORD);
        animator.addLivingAnimation(LivingMotions.CHASE, LongSwordAnimations.BIPED_WALK);
        animator.addLivingAnimation(LivingMotions.FALL, Animations.BIPED_FALL);
        animator.addLivingAnimation(LivingMotions.MOUNT, Animations.BIPED_MOUNT);
        animator.addLivingAnimation(LivingMotions.DEATH, Animations.BIPED_DEATH);
    }

    @Override
    public AttackResult tryHurt(DamageSource damageSource, float amount) {
        if(getOriginal().getRandom().nextInt(10) == 1){
            this.reserveAnimation(LongSwordAnimations.JIAN_QIE);
            return AttackResult.missed(0);
        }
        return super.tryHurt(damageSource, amount);
    }

    @Override
    protected void setWeaponMotions() {
        super.setWeaponMotions();
        this.weaponAttackMotions.put(LongSwordWeaponCategories.MH_LONGSWORD, ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, LongswordBossCombatBehaviors.BOSS));
    }

    @Override
    public void updateMotion(boolean b) {
        super.commonAggressiveMobUpdateMotion(b);
    }

    @Override
    public StaticAnimation getHitAnimation(StunType stunType) {
        return null;
    }
}
