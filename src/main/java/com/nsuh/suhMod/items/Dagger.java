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

    public Dagger(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.bonusDamage = toolMaterial.getAttackDamage() + attackDamage;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        System.out.println(target.getHealth());

        if(attacker.isSneaking() && target.forwardSpeed == 0)
        {

            target.damage(DamageSource.player((PlayerEntity)(attacker)), (bonusDamage + 1) * 3);

        }

        System.out.println(target.getHealth());
        return super.postHit(stack, target, attacker);
    }
}