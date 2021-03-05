package com.nsuh.suhMod;

import com.nsuh.suhMod.registry.ModBlocks;
import com.nsuh.suhMod.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.function.SetLootTableLootFunction;
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

        //modifyLootTables();
    }

    private void modifyLootTables()
    {
        LootTableLoadingCallback.EVENT.register(((resourceManager, manager, id, supplier, setter) -> {
            //checks for emerald ore loot table
            if(EMERALD_ORE_LOOT_TABLE_ID.equals(id))
            {
                //add single individual item
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(ModItems.DAGGER))
                        .withFunction(SetCountLootFunction.builder(ConstantLootTableRange.create(1)).build());
                supplier.withPool(poolBuilder.build());

                // add custom loot table
                FabricLootPoolBuilder poolBuilder2 = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(LootTableEntry.builder(RUBY_BLOCK_LOOT_TABLE_ID));
                supplier.withPool(poolBuilder2.build());
            }
        }));
    }
}
