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
import net.minecraft.sound.SoundEvents;

import java.util.Objects;

public class ResistanceEnchantment extends Enchantment {

    public ResistanceEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 10 + 20 * (level - 1);
    }

    @Override
    public int getMaxPower(int level) {
        return super.getMinPower(level) + 50;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        int amp;
        int random = (int)(Math.random() * 2);
        if (user.getStatusEffect(StatusEffects.RESISTANCE) == null) {
            amp = 0;
        } else if (random == 1){
            amp = 1 + Objects.requireNonNull(user.getStatusEffect(StatusEffects.RESISTANCE)).getAmplifier();
        } else {
            amp = Objects.requireNonNull(user.getStatusEffect(StatusEffects.RESISTANCE)).getAmplifier();
        }
        if (amp > level - 1) {
            amp = level - 1;
        }
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 60, amp));
        super.onUserDamaged(user, attacker, level);

    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != ModEnchants.LIFELINE_ENCHANTMENT;
    }
}
