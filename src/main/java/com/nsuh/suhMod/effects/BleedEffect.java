package com.nsuh.suhMod.effects;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.world.World;

public class BleedEffect extends StatusEffect {
    public BleedEffect(StatusEffectType type, int color) {
        super(type, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
         entity.damage(DamageSource.OUT_OF_WORLD, amplifier * 1);// true damage
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 27 == 0;
    }
}
