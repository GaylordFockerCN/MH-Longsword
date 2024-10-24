package com.p1nero.longsword.item;

import com.p1nero.longsword.LongSwordMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LongSwordItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LongSwordMod.MOD_ID);
    public static final RegistryObject<Item> MISTSPLITTER_REFORGED = ITEMS.register("mistsplitter_reforged", () -> new LongSwordWeapon(Tiers.NETHERITE, 1, 0, (new Item.Properties()).rarity(Rarity.EPIC)));

}
