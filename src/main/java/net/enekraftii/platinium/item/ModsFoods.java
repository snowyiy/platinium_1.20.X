package net.enekraftii.platinium.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModsFoods {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(3).fast().alwaysEat()
            .saturationMod(.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 0.2f).build();

}
