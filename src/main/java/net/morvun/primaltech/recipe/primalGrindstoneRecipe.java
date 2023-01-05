package net.morvun.primaltech.recipe;

import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.morvun.primaltech.recipe.serializer.primalGrindstoneRecipeSerializer;

public class primalGrindstoneRecipe implements Recipe<CraftingInventory> {

    private static Ingredient inputA;
    private static Ingredient inputB;

    private static ItemStack outputStack;

    private static Identifier id;

    public primalGrindstoneRecipe(Ingredient inputA, Ingredient inputB, ItemStack outputStack, Identifier id) {
        this.inputA = inputA;
        this.inputB = inputB;
        this.outputStack = outputStack;
        this.id = id;
    }

    public Ingredient getInputA() {
        return inputA;
    }

    public Ingredient getInputB() {
        return inputB;
    }

    @Override
    public boolean matches(CraftingInventory inventory, World world) {
        if(inventory.size() < 2) return false;
        return inputA.test(inventory.getStack(0)) && inputB.test(inventory.getStack(1));
    }

    @Override
    public ItemStack craft(CraftingInventory inventory) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean fits(int var1, int var2) {
        return false;
    }

    @Override
    public ItemStack getOutput() {
        return outputStack;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return primalGrindstoneRecipeSerializer.INSTANCE;
    }

    public static class Type implements RecipeType<primalGrindstoneRecipe> {
        private Type() {}
        public static final Type PRIMALGRINDSTONE = new Type();

        public static final String ID = "primalGrindstone";
    }

    @Override
    public RecipeType<?> getType() {
        return Type.PRIMALGRINDSTONE;
    }

}
 