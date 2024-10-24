package com.p1nero.longsword.client.entity.dragon;

import com.p1nero.longsword.entity.dragon.Dragon;
import com.p1nero.longsword.entity.dragon.DragonEntityPatch;
import com.p1nero.longsword.gameasset.LongSwordMeshes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import yesman.epicfight.api.model.Armature;
import yesman.epicfight.client.renderer.patched.entity.PatchedLivingEntityRenderer;

@OnlyIn(Dist.CLIENT)
public class DragonPatchRenderer extends PatchedLivingEntityRenderer<Dragon, DragonEntityPatch, DragonModel<Dragon>, DragonMesh> {

    @Override
    public DragonMesh getMesh(DragonEntityPatch dragonEntityPatch) {
        return LongSwordMeshes.dragonMesh;
    }

//    @Override
//    protected void setJointTransforms(DragonEntityPatch entityPatch, Armature armature, float partialTicks) {
//        this.setJointTransform("Head", armature, entityPatch.getHeadMatrix(partialTicks));
//    }
}