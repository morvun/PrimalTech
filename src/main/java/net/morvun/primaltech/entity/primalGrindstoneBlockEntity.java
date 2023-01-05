package net.morvun.primaltech.entity;

import org.jetbrains.annotations.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.morvun.primaltech.registry.PrimalBlocks;

public class primalGrindstoneBlockEntity extends BlockEntity {

    private int number = 7;
    public primalGrindstoneBlockEntity(BlockPos pos, BlockState state) {
        super(PrimalBlocks.PRIMAL_GRINDSTONE_BLOCK_ENTITY, pos, state);
    }
    
    @Override
    public void writeNbt(NbtCompound nbt) {
        nbt.putInt("number", number);

        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
    
        number = nbt.getInt("number");
    
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }
}