package com.nsuh.suhMod.enchantments;

import com.nsuh.suhMod.effects.ExecuteEffect;
import com.nsuh.suhMod.registry.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.effect.StatusEffects;

public class ExecuteEnchantment extends Enchantment {

    public ExecuteEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 20;
    }

    @Override
    public int getMaxPower(int level) {
        return 50;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        //not minecart, armor stand
        if(target instanceof LivingEntity)
        {
            ((LivingEntity)(target)).addStatusEffect(new StatusEffectInstance(ModItems.EXECUTE, 60, 1));
        }
        super.onTargetDamaged(user, target, level);
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }
}
