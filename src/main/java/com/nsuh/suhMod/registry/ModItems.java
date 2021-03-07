package com.nsuh.suhMod.registry;

import com.nsuh.suhMod.SuhMod;
import com.nsuh.suhMod.enchantments.PoisonEnchantment;
import com.nsuh.suhMod.enchantments.SlownessEnchantment;
import com.nsuh.suhMod.items.*;
import com.nsuh.suhMod.materials.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    //items
    public static final Item RUBY = new Item(new Item.Settings().group(SuhMod.ITEM_GROUP));


    //block items
    public static final BlockItem RUBY_BLOCK = new BlockItem(ModBlocks.RUBY_BLOCK, new Item.Settings().group(SuhMod.ITEM_GROUP ));

    //tool items?
    public static final ToolItem RUBY_PICKAXE = new ModPickaxe(RubyMaterial.INSTANCE, 5, -2.8f, new Item.Settings().group(SuhMod.ITEM_GROUP));
    public static final ToolItem RUBY_SHOVEL = new ShovelItem(RubyMaterial.INSTANCE, 5.5f, -3.0f, new Item.Settings().group(SuhMod.ITEM_GROUP));
    public static final ToolItem RUBY_SWORD = new SwordItem(RubyMaterial.INSTANCE, 7, -2.4f, new Item.Settings().group(SuhMod.ITEM_GROUP));
    public static final ToolItem RUBY_AXE = new ModAxe(RubyMaterial.INSTANCE, 9, -3.0f, new Item.Settings().group(SuhMod.ITEM_GROUP));
    public static final ToolItem RUBY_HOE = new ModHoe(RubyMaterial.INSTANCE, 0, -2.0f, new Item.Settings().group(SuhMod.ITEM_GROUP));
    public static final ToolItem RUBY_DIGGING_TOOL = new ModDiggingTool(RubyMaterial.INSTANCE, 5, -2.4f, new Item.Settings().group(SuhMod.ITEM_GROUP));
    public static final ToolItem RUBY_DAGGER = new Dagger(RubyMaterial.INSTANCE, 5, -2.4f, 10, new Item.Settings().group(SuhMod.ITEM_GROUP));


    //dagger items
    public static final ToolItem DIAMOND_DAGGER = new Dagger(DiamondMaterial.INSTANCE, 4, -2.4f, 8, new Item.Settings().group(SuhMod.ITEM_GROUP));

    public static final ToolItem NETHERITE_DAGGER = new Dagger(NetheriteMaterial.INSTANCE, 5, -2.4f, 10, new Item.Settings().group(SuhMod.ITEM_GROUP));

    public static final ToolItem IRON_DAGGER = new Dagger(IronMaterial.INSTANCE, 3, -2.4f, 6, new Item.Settings().group(SuhMod.ITEM_GROUP));

    public static final ToolItem STONE_DAGGER = new Dagger(StoneMaterial.INSTANCE, 2, -2.4f, 5, new Item.Settings().group(SuhMod.ITEM_GROUP));

    public static final ToolItem GOLD_DAGGER = new Dagger(GoldMaterial.INSTANCE, 1, -2.4f, 4, new Item.Settings().group(SuhMod.ITEM_GROUP));

    public static final ToolItem WOOD_DAGGER = new Dagger(WoodMaterial.INSTANCE, 1, -2.4f, 4, new Item.Settings().group(SuhMod.ITEM_GROUP));

    //armor items
    public static final Item RUBY_HELMET = new ArmorItem(RubyArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings().group( SuhMod.ITEM_GROUP));
    public static final Item RUBY_CHESTPLATE = new ArmorItem(RubyArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(SuhMod.ITEM_GROUP));
    public static final Item RUBY_LEGGINGS = new ArmorItem(RubyArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings().group(SuhMod.ITEM_GROUP));
    public static final Item RUBY_BOOTS = new ArmorItem(RubyArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings().group(SuhMod.ITEM_GROUP));

    //enchants
    public static final Enchantment POISON_ENCHANTMENT = new PoisonEnchantment();
    public static final Enchantment SLOWNESS_ENCHANTMENT = new SlownessEnchantment();

    public static void registerItems(){

        //Ruby items
        Registry.register(Registry.ITEM, new Identifier(SuhMod.MOD_ID, "ruby"), RUBY);
        Registry.register(Registry.ITEM, new Identifier(SuhMod.MOD_ID, "ruby_block"), RUBY_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(SuhMod.MOD_ID, "ruby_pickaxe"), RUBY_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier(SuhMod.MOD_ID, "ruby_shovel"), RUBY_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier(SuhMod.MOD_ID, "ruby_sword"), RUBY_SWORD);
        Registry.register(Registry.ITEM, new Identifier(SuhMod.MOD_ID, "ruby_axe"), RUBY_AXE);
        Registry.register(Registry.ITEM, new Identifier(SuhMod.MOD_ID, "ruby_hoe"), RUBY_HOE);
        Registry.register(Registry.ITEM, new Identifier(SuhMod.MOD_ID, "ruby_digging_tool"), RUBY_DIGGING_TOOL);
        Registry.register(Registry.ITEM, new Identifier(SuhMod.MOD_ID, "ruby_helmet"), RUBY_HELMET);
        Registry.register(Registry.ITEM, new Identifier(SuhMod.MOD_ID, "ruby_chestplate"), RUBY_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(SuhMod.MOD_ID, "ruby_leggings"), RUBY_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(SuhMod.MOD_ID, "ruby_boots"), RUBY_BOOTS);
        Registry.register(Registry.ITEM, new Identifier(SuhMod.MOD_ID, "ruby_dagger"), RUBY_DAGGER);

        Registry.register(Registry.ITEM, new Identifier(SuhMod.MOD_ID, "diamond_dagger"), DIAMOND_DAGGER);
        Registry.register(Registry.ITEM, new Identifier(SuhMod.MOD_ID, "netherite_dagger"), NETHERITE_DAGGER);
        Registry.register(Registry.ITEM, new Identifier(SuhMod.MOD_ID, "iron_dagger"), IRON_DAGGER);
        Registry.register(Registry.ITEM, new Identifier(SuhMod.MOD_ID, "gold_dagger"), GOLD_DAGGER);
        Registry.register(Registry.ITEM, new Identifier(SuhMod.MOD_ID, "stone_dagger"), STONE_DAGGER);
        Registry.register(Registry.ITEM, new Identifier(SuhMod.MOD_ID, "wood_dagger"), WOOD_DAGGER);
        //Enchants
        Registry.register(Registry.ENCHANTMENT, new Identifier(SuhMod.MOD_ID, "poison_enchantment"), POISON_ENCHANTMENT);
        Registry.register(Registry.ENCHANTMENT, new Identifier(SuhMod.MOD_ID, "slowness_enchantment"), SLOWNESS_ENCHANTMENT);
    }
}
