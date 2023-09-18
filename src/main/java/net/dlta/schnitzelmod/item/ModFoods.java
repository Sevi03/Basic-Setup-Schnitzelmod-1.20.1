package net.dlta.schnitzelmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties SCHNITZEL = new FoodProperties.Builder().nutrition(10)
                .saturationMod(1f).effect(() -> new MobEffectInstance(MobEffects.SATURATION, 500), 1f).build();
}
