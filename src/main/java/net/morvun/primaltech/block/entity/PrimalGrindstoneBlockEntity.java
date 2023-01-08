package net.morvun.primaltech.block.entity;

import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil.Test;
import org.jetbrains.annotations.Nullable;

import com.ibm.icu.impl.TextTrieMap.Output;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.morvun.primaltech.PrimalTech;
import net.morvun.primaltech.registry.PrimalItems;

public class PrimalGrindstoneBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory{

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);


    public PrimalGrindstoneBlockEntity(BlockPos pos, BlockState state) {
        super(PrimalBlockEntities.PRIMAL_GRINDSTONE_BLOCK, pos, state);
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {

        return new PrimalGrindstoneScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {

        return this.inventory;
    }

    @Override
    public Text getDisplayName() {

        return Text.translatable(PrimalTech.MOD_ID, "primal_grindstone");
    }
    
    public static void tick(World world, BlockPos blockPos, BlockState state, PrimalGrindstoneBlockEntity entity) {
        if (world.isClient()) {
            return;
        }

        if (hasRecipe(entity)) {
            craftItem(entity);
        }
    }

    private static void craftItem(PrimalGrindstoneBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        if (hasRecipe(entity)) {
            entity.removeStack(0,1);

            entity.setStack(2, new ItemStack(PrimalItems.SH, entity.getStack(2).getCount() + 1));
        }
    }

    private static boolean hasRecipe(PrimalGrindstoneBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        boolean hasFlintInFirstSlot = entity.getStack( 0).getItem() == Items.FLINT;

        return hasFlintInFirstSlot && canInsertAmountIntoOutputSlot(inventory, 1)
            && canInsertItemIntoOutputSlot(inventory, PrimalItems.SHARPENED_PEBBLE_ITEM);
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(2).getItem() == output || inventory.getStack(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory, int count) {
        return inventory.getStack(2).getMaxCount() > inventory.getStack(2).getCount() + count;
    }
}
