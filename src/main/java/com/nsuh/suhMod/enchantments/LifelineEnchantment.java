package com.nsuh.suhMod.enchantments;

import com.nsuh.suhMod.registry.ModEnchants;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

import java.util.Objects;

public class LifelineEnchantment extends Enchantment {

    public LifelineEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
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
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {

        if(user.getHealth() < 10.0f && !user.hasStatusEffect(ModEnchants.LIFELINE_COOLDOWN))
        {
            ((PlayerEntity)(user)).playSound(SoundEvents.BLOCK_BELL_USE, 20.0f, 1.0f); //try type casting to palyer
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 200, level - 1));
            user.addStatusEffect(new StatusEffectInstance(ModEnchants.LIFELINE_COOLDOWN, 6000, 0));
        }
        super.onUserDamaged(user, attacker, level);
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != ModEnchants.RESISTANCE_ENCHANTMENT;
    }
}
