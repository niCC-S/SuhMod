package com.nsuh.suhMod.effects;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.world.World;

public class ExecuteEffect extends StatusEffect {
    public ExecuteEffect(StatusEffectType type, int color) {
        super(type, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        World world = entity.world;
        LightningEntity lightning = EntityType.LIGHTNING_BOLT.create(world);
        assert lightning != null;
        lightning.setPos(entity.getX(), entity.getY() + 2, entity.getZ());
        entity.damage(DamageSource.OUT_OF_WORLD, amplifier * 1.0f); // true damage
        world.spawnEntity(lightning);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration <= 1;
    }
}
