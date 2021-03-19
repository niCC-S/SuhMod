package com.nsuh.suhMod.registry;

import com.nsuh.suhMod.SuhMod;
import com.nsuh.suhMod.effects.BleedEffect;
import com.nsuh.suhMod.effects.ExecuteEffect;
import com.nsuh.suhMod.effects.LifelineCooldownEffect;
import com.nsuh.suhMod.enchantments.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEnchants {
    public static final StatusEffect EXECUTE = new ExecuteEffect(StatusEffectType.HARMFUL, 0xFFF200);
    public static final StatusEffect BLEED = new BleedEffect(StatusEffectType.HARMFUL, 0xFF0000);
    public static final StatusEffect LIFELINE_COOLDOWN = new LifelineCooldownEffect(StatusEffectType.BENEFICIAL, 0);
    //enchants
    public static final Enchantment BLEED_ENCHANTMENT = new BleedEnchantment();
    public static final Enchantment LIFESTEAL_ENCHANTMENT = new LifestealEnchantment();
    public static final Enchantment EXPLOSION_ENCHANTMENT = new ExplosionEnchantment();
    public static final Enchantment VOLLEY_ENCHANTMENT = new VolleyEnchantment();
    public static final Enchantment EXECUTE_ENCHANTMENT = new ExecuteEnchantment();
    public static final Enchantment LIFELINE_ENCHANTMENT = new LifelineEnchantment();
    public static final Enchantment RESISTANCE_ENCHANTMENT = new ResistanceEnchantment();

    public static void registerItems() {
        Registry.register(Registry.ENCHANTMENT, new Identifier(SuhMod.MOD_ID, "bleed_enchantment"), BLEED_ENCHANTMENT);
        Registry.register(Registry.ENCHANTMENT, new Identifier(SuhMod.MOD_ID, "lifesteal_enchantment"), LIFESTEAL_ENCHANTMENT);
        Registry.register(Registry.ENCHANTMENT, new Identifier(SuhMod.MOD_ID, "explosion_enchantment"), EXPLOSION_ENCHANTMENT);
        Registry.register(Registry.ENCHANTMENT, new Identifier(SuhMod.MOD_ID, "volley_enchantment"), VOLLEY_ENCHANTMENT);
        Registry.register(Registry.ENCHANTMENT, new Identifier(SuhMod.MOD_ID, "execute_enchantment"), EXECUTE_ENCHANTMENT);
        Registry.register(Registry.ENCHANTMENT, new Identifier(SuhMod.MOD_ID, "lifeline_enchantment"), LIFELINE_ENCHANTMENT);
        Registry.register(Registry.ENCHANTMENT, new Identifier(SuhMod.MOD_ID, "resistance_enchantment"), RESISTANCE_ENCHANTMENT);

        Registry.register(Registry.STATUS_EFFECT, new Identifier(SuhMod.MOD_ID, "bleed_effect"), BLEED);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(SuhMod.MOD_ID, "execute_effect"), EXECUTE);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(SuhMod.MOD_ID, "lifeline_cooldown_effect"), LIFELINE_COOLDOWN);
    }
}
