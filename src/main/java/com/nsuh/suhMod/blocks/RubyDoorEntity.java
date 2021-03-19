package com.nsuh.suhMod.blocks;

import com.nsuh.suhMod.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;

import java.util.ArrayList;
import java.util.Arrays;

public class RubyDoorEntity extends BlockEntity {
    private int[] players;
    int counter;
    public RubyDoorEntity(){
        super(ModBlocks.RUBY_DOOR_ENTITY);
        players = new int[10];
        counter = 0;
    }


    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);

        tag.putIntArray("players", players);

        return tag;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        this.players = tag.getIntArray("players");

    }

    public void add(int player)
    {
        for(int i = 0; i < players.length; i++)
        {
            if(players[i] == player)
                return;
            if(players[i] == 0)
            {
                players[i] = player;
                return;
            }
        }
    }

    public boolean contains(int player)
    {
        for(Integer i : players) {
            if (i == player)
                return true;
        }
        return false;
    }

    public void print()
    {
        for(Integer i : players)
            System.out.println(i);
    }


}
