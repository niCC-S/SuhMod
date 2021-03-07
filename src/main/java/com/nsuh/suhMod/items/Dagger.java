package com.nsuh.suhMod.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.function.Consumer;

public class Dagger extends SwordItem{
    private float bonusDamage;
    public Dagger(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, float bonusDamage, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.bonusDamage = bonusDamage;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(attacker.isSneaking())
        {
            target.damage(DamageSource.player((PlayerEntity)(attacker)), bonusDamage);
        }
        return super.postHit(stack, target, attacker);
    }
}