package com.p1nero.longsword.client.entity.dragon;

import yesman.epicfight.api.animation.Joint;
import yesman.epicfight.api.model.Armature;

import java.util.Map;

public class BlockDragonArmature extends Armature {
    //right leg
    public final Joint thighR;
    public final Joint legR;
    public final Joint footR;
    public final Joint kneeR;
    //left leg
    public final Joint thighL;
    public final Joint legL;
    public final Joint footL;
    public final Joint kneeL;
    //body
    public final Joint torso;
    public final Joint chest;
    public final Joint neck1;
    public final Joint neck2;
    public final Joint neck3;
    public final Joint head;
    public final Joint chin;
    //right arm
    public final Joint shoulderR;
    public final Joint armR;
    public final Joint handR;
    //left arm
    public final Joint shoulderL;
    public final Joint armL;
    public final Joint handL;
    //right wing
    public final Joint wingR;
    public final Joint wing_1R;
    public final Joint wing1_1R;
    public final Joint wing1_2R;
    public final Joint wing2R;
    //left wing
    public final Joint wingL;
    public final Joint wing_1L;
    public final Joint wing1_1L;
    public final Joint wing1_2L;
    public final Joint wing2L;
    //tail
    public final Joint tail1;
    public final Joint tail2;
    public final Joint tail3;
    public final Joint tail4;
    public final Joint tail5;
    public final Joint tail6;
    public BlockDragonArmature(int jointNumber, Joint rootJoint, Map<String, Joint> jointMap) {
        super(jointNumber, rootJoint, jointMap);
        this.head = this.getOrLogException(jointMap, "Head");
        this.neck1 = this.getOrLogException(jointMap, "Neck1");
        this.neck2 = this.getOrLogException(jointMap, "Neck2");
        this.neck3 = this.getOrLogException(jointMap, "Neck3");
        this.chin = this.getOrLogException(jointMap, "Chin");
        this.chest = this.getOrLogException(jointMap, "Chest");
        this.torso = this.getOrLogException(jointMap, "Torso");
        this.shoulderR = this.getOrLogException(jointMap, "Shoulder_R");
        this.armR = this.getOrLogException(jointMap, "Arm_R");
        this.handR = this.getOrLogException(jointMap, "Hand_R");
        this.shoulderL = this.getOrLogException(jointMap, "Shoulder_L");
        this.armL = this.getOrLogException(jointMap, "Arm_L");
        this.handL = this.getOrLogException(jointMap, "Hand_L");
        this.thighR = this.getOrLogException(jointMap, "Thigh_R");
        this.legR = this.getOrLogException(jointMap, "Leg_R");
        this.footR = this.getOrLogException(jointMap, "Foot_R");
        this.kneeR = this.getOrLogException(jointMap, "Knee_R");
        this.thighL = this.getOrLogException(jointMap, "Thigh_L");
        this.legL = this.getOrLogException(jointMap, "Leg_L");
        this.footL = this.getOrLogException(jointMap, "Foot_L");
        this.kneeL = this.getOrLogException(jointMap, "Knee_L");
        this.wingR = this.getOrLogException(jointMap, "wing_R");
        this.wing_1R = this.getOrLogException(jointMap, "wing_1_R");
        this.wing1_1R = this.getOrLogException(jointMap, "wing_1_1_R");
        this.wing1_2R = this.getOrLogException(jointMap, "wing_1_2_R");
        this.wing2R = this.getOrLogException(jointMap, "wing_2_R");
        this.wingL = this.getOrLogException(jointMap, "wing_L");
        this.wing_1L = this.getOrLogException(jointMap, "wing_1_L");
        this.wing1_1L = this.getOrLogException(jointMap, "wing_1_1_L");
        this.wing1_2L = this.getOrLogException(jointMap, "wing_1_2_L");
        this.wing2L = this.getOrLogException(jointMap, "wing_2_L");
        this.tail1 = this.getOrLogException(jointMap, "Tail1");
        this.tail2 = this.getOrLogException(jointMap, "Tail2");
        this.tail3 = this.getOrLogException(jointMap, "Tail3");
        this.tail4 = this.getOrLogException(jointMap, "Tail4");
        this.tail5 = this.getOrLogException(jointMap, "Tail5");
        this.tail6 = this.getOrLogException(jointMap, "Tail6");
    }


}