package com.p1nero.longsword.gameasset;

import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.collider.MultiOBBCollider;
import yesman.epicfight.api.collider.OBBCollider;

public class LongSwordColliders {
    public static final Collider LONGSWORD = new MultiOBBCollider(6, 0.3, 0.3, 1.4, 0.0, 0.0, -0.8D);

    public static final Collider QI_REN_DOU_GE = new OBBCollider(2.0, 2.0, 2.0, 0.0, 0.0, 0.0);

}
