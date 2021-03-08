package com.nsuh.suhMod.enchantments;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.explosion.Explosion;

public class ExplosionEnchantment extends Enchantment {

    public ExplosionEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.BOW, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 5 + (level - 1) * 9;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 15;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        //not minecart, armor stand
        if(target instanceof LivingEntity && !(target instanceof PlayerEntity))
        {
            target.world.createExplosion( target, target.getX(), target.getY(), target.getZ(), 1.0f * (float)(level), Explosion.DestructionType.NONE);

        }
        super.onTargetDamaged(user, target, level);
    }

}
