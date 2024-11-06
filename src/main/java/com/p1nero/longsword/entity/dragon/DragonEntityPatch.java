package com.p1nero.longsword.entity.dragon;

import com.p1nero.longsword.gameasset.LongSwordAnimations;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.client.animation.ClientAnimator;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.world.capabilities.entitypatch.Faction;
import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
import yesman.epicfight.world.damagesource.StunType;

public class DragonEntityPatch extends MobPatch<Dragon> {
    public DragonEntityPatch() {
        super(Faction.NEUTRAL);
    }

    @Override
    public void initAnimator(ClientAnimator animator) {
        animator.addLivingAnimation(LivingMotions.IDLE, LongSwordAnimations.DRAGON_IDLE);
        animator.setCurrentMotionsAsDefault();
    }

    @Override
    public void updateMotion(boolean considerInaction) {
        if (this.state.inaction() && considerInaction) {
            this.currentLivingMotion = LivingMotions.IDLE;
        } else if (!(this.original.getDeltaMovement().y < -0.550000011920929) && !this.isAirborneState()) {
            if (this.original.getSpeed() > 0.08F) {
                this.currentLivingMotion = LivingMotions.WALK;
            } else {
                this.currentLivingMotion = LivingMotions.IDLE;
            }
        }
    }

    @Override
    public StaticAnimation getHitAnimation(StunType stunType) {
        return null;
    }

//    @Override
//    public OpenMatrix4f getModelMatrix(float partialTicks) {
//        return super.getModelMatrix(partialTicks).scale(0.4F, 0.4F, 0.4F);
//    }

}
