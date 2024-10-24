package com.p1nero.longsword.gameasset;

import com.p1nero.longsword.LongSwordMod;
import com.p1nero.longsword.client.entity.dragon.DragonMesh;
import yesman.epicfight.api.forgeevent.ModelBuildEvent;

public class LongSwordMeshes {
    public static DragonMesh dragonMesh;
    public static void build(ModelBuildEvent.MeshBuild event) {
        dragonMesh = event.getAnimated(LongSwordMod.MOD_ID, "entity/dragon", DragonMesh::new);
    }
}