package com.p1nero.longsword.gameasset;

import yesman.epicfight.world.capabilities.item.WeaponCategory;

public enum LongSwordWeaponCategories implements WeaponCategory {
    MH_LONGSWORD;
    private LongSwordWeaponCategories(){
        this.id = WeaponCategory.ENUM_MANAGER.assign(this);
    }
    final int id;
    @Override
    public int universalOrdinal() {
        return this.id;
    }

}