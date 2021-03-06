package com.nsuh.suhMod.enchantments;

import com.nsuh.suhMod.effects.ExecuteEffect;
import com.nsuh.suhMod.registry.ModEnchants;
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
import net.minecraft.item.Items;

import java.util.Objects;

public class ExecuteEnchantment extends Enchantment {

    public ExecuteEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
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

        if(target instanceof LivingEntity && !user.handSwinging && !Objects.requireNonNull(((LivingEntity) (target)).getRecentDamageSource()).name.equals("arrow"))
        {
            ((LivingEntity)(target)).addStatusEffect(new StatusEffectInstance(ModEnchants.EXECUTE, 60, level));
        }
        super.onTargetDamaged(user, target, level);
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }
}
