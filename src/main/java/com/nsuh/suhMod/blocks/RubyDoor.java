package com.nsuh.suhMod.blocks;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class RubyDoor extends DoorBlock implements BlockEntityProvider {

    public RubyDoor(Settings settings) {
        super(settings);
    }

    private int getOpenSoundEventId() {
        return this.material == Material.METAL ? 1011 : 1012;
    }

    private int getCloseSoundEventId() {
        return this.material == Material.METAL ? 1005 : 1006;
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BlockEntity blockEntity = world.getBlockEntity(pos);

        if(blockEntity instanceof RubyDoorEntity) {
            if (!((RubyDoorEntity) blockEntity).contains(player.getName().asString().hashCode())) {
                return ActionResult.PASS;
            } else {
                state = (BlockState) state.cycle(OPEN);
                world.setBlockState(pos, state, 10);
                world.syncWorldEvent(player, (Boolean) state.get(OPEN) ? this.getCloseSoundEventId() : this.getOpenSoundEventId(), pos, 0);
                return ActionResult.success(world.isClient);
            }
        }


        /*
        if(!world.isClient)
        {
            BlockEntity blockEntity = world.getBlockEntity(pos);

            if(blockEntity instanceof RubyDoorEntity)
            {
                System.out.println(((RubyDoorEntity)(blockEntity)).contains(player.getName().asString().hashCode()));
                ((RubyDoorEntity)(blockEntity)).add(player.getName().asString().hashCode());
                ((RubyDoorEntity)(blockEntity)).print();
                System.out.println(((RubyDoorEntity)(blockEntity)).contains(player.getName().asString().hashCode()));

            }

        }*/
        return ActionResult.SUCCESS;
    }


    @Override
    public @Nullable BlockEntity createBlockEntity(BlockView world) {
        return new RubyDoorEntity();
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
    }
}
