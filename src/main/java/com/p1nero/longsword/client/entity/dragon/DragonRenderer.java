package com.p1nero.longsword.client.entity.dragon;

import com.p1nero.longsword.LongSwordMod;
import com.p1nero.longsword.entity.dragon.Dragon;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class DragonRenderer extends MobRenderer<Dragon, DragonModel<Dragon>> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LongSwordMod.MOD_ID, "textures/entity/blackdragon.png");
    public DragonRenderer(EntityRendererProvider.Context context) {
        super(context, new DragonModel<>(), 1);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Dragon dragon) {
        return TEXTURE;
    }
}
