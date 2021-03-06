package com.nsuh.suhMod;

import com.nsuh.suhMod.registry.ModBlocks;
import com.nsuh.suhMod.registry.ModEnchants;
import com.nsuh.suhMod.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class SuhMod implements ModInitializer {

    public static final String MOD_ID = "suhmod";

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier(MOD_ID, "general"),
            () -> new ItemStack(ModItems.RUBY)
    );

    private static final Identifier EMERALD_ORE_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/emerald_ore");
    private static final Identifier RUBY_BLOCK_LOOT_TABLE_ID = new Identifier(MOD_ID, "blocks/ruby_block");

    @Override
    public void onInitialize() {

        ModItems.registerItems();
        ModBlocks.registerBlocks();
        ModEnchants.registerItems();
    }
}

