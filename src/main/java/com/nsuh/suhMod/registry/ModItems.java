package com.nsuh.suhMod.registry;

import com.nsuh.suhMod.SuhMod;
import com.nsuh.suhMod.enchantments.PoisonEnchantment;
import com.nsuh.suhMod.items.*;
import com.nsuh.suhMod.materials.RubyArmorMaterial;
import com.nsuh.suhMod.materials.RubyMaterial;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    //items
    public static final Item RUBY = new Item(new Item.Settings().group(SuhMod.ITEM_GROUP));
    public static final Item DAGGER = new Item(new Item.Settings().group(SuhMod.ITEM_GROUP));


    //block items
    public static final BlockItem RUBY_BLOCK = new BlockItem(ModBlocks.RUBY_BLOCK, new Item.Settings().group(SuhMod.ITEM_GROUP ));

    //tool items?
    public static final ToolItem RUBY_PICKAXE = new ModPickaxe(RubyMaterial.INSTANCE, 5, -2.8f, new Item.Settings().group(SuhMod.ITEM_GROUP));
    public static final ToolItem RUBY_SHOVEL = new ShovelItem(RubyMaterial.INSTANCE, 5.5f, -3.0f, new Item.Settings().group(SuhMod.ITEM_GROUP));
    public static final ToolItem RUBY_SWORD = new SwordItem(RubyMaterial.INSTANCE, 7, -2.4f, new Item.Settings().group(SuhMod.ITEM_GROUP));
    public static final ToolItem RUBY_AXE = new ModAxe(RubyMaterial.INSTANCE, 9, -3.0f, new Item.Settings().group(SuhMod.ITEM_GROUP));
    public static final ToolItem RUBY_HOE = new ModHoe(RubyMaterial.INSTANCE, 0, -2.0f, new Item.Settings().group(SuhMod.ITEM_GROUP));
    //public static final TridentItem TEST = new TridentItem(new Item.Settings().group(ItemGroup.COMBAT).maxDamage(250));
    public static final ToolItem RUBY_DIGGING_TOOL = new ModDiggingTool(RubyMaterial.INSTANCE, 5, -2.4f, new Item.Settings().group(SuhMod.ITEM_GROUP));
    public static final ToolItem RUBY_DAGGER = new Dagger(RubyMaterial.INSTANCE, 6, -1.0f, new Item.Settings().group(SuhMod.ITEM_GROUP));

    //armor items
    public static final Item RUBY_HELMET = new ArmorItem(RubyArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings().group( SuhMod.ITEM_GROUP));
    public static final Item RUBY_CHESTPLATE = new ArmorItem(RubyArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(SuhMod.ITEM_GROUP));
    public static final Item RUBY_LEGGINGS = new ArmorItem(RubyArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings().group(SuhMod.ITEM_GROUP));
    public static final Item RUBY_BOOTS = new ArmorItem(RubyArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings().group(SuhMod.ITEM_GROUP));

    //enchants
    public static final Enchantment POISON_ENCHANTMENT = new PoisonEnchantment();

    public static void registerItems(){
        Registry.register(Registry.ITEM, new Identifier(SuhMod.MOD_ID, "dagger"), DAGGER);

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
        //Enchants
        Registry.register(Registry.ENCHANTMENT, new Identifier(SuhMod.MOD_ID, "poison_enchantment"), POISON_ENCHANTMENT);

    }
}
