package com.nsuh.suhMod.registry;

import com.nsuh.suhMod.SuhMod;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import org.w3c.dom.ranges.Range;

public class ModBlocks {

    public static final Block RUBY_BLOCK = new Block(FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 6.0F)
            .sounds(BlockSoundGroup.METAL));
    /*
    public static final Block RUBY_DOOR = new RubyDoor( FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES, 4)
            .requiresTool()
            .strength(3.0F, 6.0F)
            .sounds(BlockSoundGroup.METAL));
    public static BlockEntityType<RubyDoorEntity> RUBY_DOOR_ENTITY;
    */
    public static final Block RUBY_ORE = new Block( FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES, 2)
            .requiresTool()
            .strength(3.0F, 6.0F)
            .sounds(BlockSoundGroup.STONE));

    //vein size here :D
    private static final ConfiguredFeature<?, ?> RUBY_ORE_OVERWORLD = Feature.ORE.configure(
            new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, RUBY_ORE.getDefaultState(), 4))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 1, 16)))
            .spreadHorizontally()
            .repeat(2);




    public static void registerBlocks()
    {
        //RUBY_DOOR_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, SuhMod.MOD_ID, BlockEntityType.Builder.create(RubyDoorEntity::new, RUBY_DOOR).build(null));
        Registry.register(Registry.BLOCK, new Identifier(SuhMod.MOD_ID, "ruby_block"), RUBY_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(SuhMod.MOD_ID, "ruby_ore"), RUBY_ORE);
        RegistryKey<ConfiguredFeature<?, ?>> rubyOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier(SuhMod.MOD_ID, "ruby_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, rubyOreOverworld.getValue(), RUBY_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, rubyOreOverworld);

        //Registry.register(Registry.BLOCK, new Identifier(SuhMod.MOD_ID, "ruby_door"), RUBY_DOOR);
    }
}
