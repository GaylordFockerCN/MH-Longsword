package com.p1nero.longsword.entity;

import com.p1nero.longsword.LongSwordMod;
import com.p1nero.longsword.entity.boss.Boss;
import com.p1nero.longsword.entity.dragon.Dragon;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LongSwordEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, LongSwordMod.MOD_ID);
    public static final RegistryObject<EntityType<Boss>> BOSS = register("boss",
            EntityType.Builder.of(Boss::new, MobCategory.CREATURE));
    public static final RegistryObject<EntityType<Dragon>> DRAGON = register("dragon",
            EntityType.Builder.of(Dragon::new, MobCategory.CREATURE).sized(2, 3));
    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.Builder<T> entityTypeBuilder) {
        return ENTITIES.register(name, () -> entityTypeBuilder.build(new ResourceLocation(LongSwordMod.MOD_ID, name).toString()));
    }

}
