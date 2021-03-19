package com.nsuh.suhMod.registry;

import com.nsuh.suhMod.SuhMod;
import com.nsuh.suhMod.blocks.RubyDoor;
import com.nsuh.suhMod.blocks.RubyDoorEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block RUBY_BLOCK = new Block(FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES, 4)
            .requiresTool()
            .strength(3.0F, 6.0F)
            .sounds(BlockSoundGroup.METAL));
    public static final Block RUBY_DOOR = new RubyDoor( FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES, 4)
            .requiresTool()
            .strength(3.0F, 6.0F)
            .sounds(BlockSoundGroup.METAL));
    public static BlockEntityType<RubyDoorEntity> RUBY_DOOR_ENTITY;

    public static void registerBlocks()
    {
        RUBY_DOOR_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, SuhMod.MOD_ID, BlockEntityType.Builder.create(RubyDoorEntity::new, RUBY_DOOR).build(null));
        Registry.register(Registry.BLOCK, new Identifier(SuhMod.MOD_ID, "ruby_block"), RUBY_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(SuhMod.MOD_ID, "ruby_door"), RUBY_DOOR);
    }
}
