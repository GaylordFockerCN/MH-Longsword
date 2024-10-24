package com.p1nero.longsword.gameasset;

import com.p1nero.longsword.LongSwordMod;
import com.p1nero.longsword.client.entity.dragon.DragonArmature;
import com.p1nero.longsword.entity.LongSwordEntities;
import yesman.epicfight.api.forgeevent.ModelBuildEvent;

import static yesman.epicfight.gameasset.Armatures.registerEntityTypeArmature;

public class LongSwordArmatures {
    public static DragonArmature dragonArmature;
public static void build(ModelBuildEvent.ArmatureBuild event) {
    dragonArmature = event.get(LongSwordMod.MOD_ID, "entity/dragon", DragonArmature::new);
    registerEntityTypeArmature(LongSwordEntities.DRAGON.get(), dragonArmature);
}
}