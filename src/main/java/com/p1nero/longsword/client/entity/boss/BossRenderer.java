package com.p1nero.longsword.client.entity.boss;

import com.p1nero.longsword.LongSwordMod;
import com.p1nero.longsword.entity.boss.Boss;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class BossRenderer extends LivingEntityRenderer<Boss, PlayerModel<Boss>> {
    public BossRenderer(EntityRendererProvider.Context context) {
        super(context, new PlayerModel<>(context.bakeLayer(ModelLayers.PLAYER_SLIM), true), 0.5F);
        this.addLayer(new HumanoidArmorLayer<>(this, new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_SLIM_INNER_ARMOR)), new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_SLIM_OUTER_ARMOR))));
        this.addLayer(new ItemInHandLayer<>(this));
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Boss boss) {
        return new ResourceLocation(LongSwordMod.MOD_ID, "textures/entity/boss.png");
    }
}
