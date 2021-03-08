package com.nsuh.suhMod.enchantments;

import net.fabricmc.loader.util.sat4j.core.Vec;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class VolleyEnchantment extends Enchantment {

    public VolleyEnchantment() {
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
        return 1;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        //not minecart, armor stand
        World world = user.world;
        ArrowEntity[] arrowArray = new ArrowEntity[9];
        int random = 2;
        int height = 60;
        if(target instanceof LivingEntity)
        {
            for(int i = 0; i < arrowArray.length; i++) {
                arrowArray[i] = EntityType.ARROW.create(world);
            }

            arrowArray[0].setPos(target.getX(), target.getY() + height + (5 * Math.random()), target.getZ());
            arrowArray[1].setPos(target.getX() + 1 + random * Math.random(), target.getY() + height + (5 * Math.random()), target.getZ() + random * Math.random() - 0.5);
            arrowArray[2].setPos(target.getX() - 1 - random * Math.random(), target.getY() + height + (5 * Math.random()), target.getZ() + random * Math.random() - 0.5);
            arrowArray[3].setPos(target.getX() + 1 + random * Math.random(), target.getY() + height + (5 * Math.random()), target.getZ() + 1 + random * Math.random());
            arrowArray[4].setPos(target.getX() - 1 - random * Math.random(), target.getY() + height + (5 * Math.random()), target.getZ() + 1 + random * Math.random());
            arrowArray[5].setPos(target.getX() + 1 + random * Math.random(), target.getY() + height + (5 * Math.random()), target.getZ() - 1 - random * Math.random());
            arrowArray[6].setPos(target.getX() - 1 - random * Math.random(), target.getY() + height + (5 * Math.random()), target.getZ() - 1 - random * Math.random());
            arrowArray[7].setPos(target.getX() + random * Math.random() - 0.5, target.getY() + height + (5 * Math.random()), target.getZ() + 1 + random * Math.random());
            arrowArray[8].setPos(target.getX() + random * Math.random() - 0.5, target.getY() + height + (5 * Math.random()), target.getZ() - 1 - random * Math.random());


            for(int i = 0; i < arrowArray.length; i++)
            {
                //arrowArray[i].setVelocity(arrowArray[i].getX(), arrowArray[i].getY(), arrowArray[i].getZ(), 10.0f, 1);
                arrowArray[i].setVelocity(0, -4,0);
                world.spawnEntity(arrowArray[i]);
            }

        }
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.FIRE_ASPECT;
    }
}