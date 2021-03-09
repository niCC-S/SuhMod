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
        lightning.setPos(entity.getX(), entity.getY(), entity.getZ());
        world.spawnEntity(lightning);
        entity.damage(DamageSource.LIGHTNING_BOLT, 1.5f);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration <= 1;
    }
}
