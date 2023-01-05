package net.morvun.primaltech.recipe.serializer;

import java.util.Optional;

import org.spongepowered.include.com.google.gson.JsonSyntaxException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.morvun.primaltech.recipe.primalGrindstoneRecipe;
import net.morvun.primaltech.recipe.json.primalGrindstoneRecipeJsonFormat;

public class primalGrindstoneRecipeSerializer implements RecipeSerializer<primalGrindstoneRecipe> {

    @Override
    public primalGrindstoneRecipe read(Identifier id, JsonObject json) {
        primalGrindstoneRecipeJsonFormat recipeJson = new Gson().fromJson(json, primalGrindstoneRecipeJsonFormat.class);

        if(recipeJson.inputA == null || recipeJson.inputB == null || recipeJson.outputItem == null) {
            throw new JsonSyntaxException("A required attribute is missing!");
        }

        if(recipeJson.outputAmount == 0) recipeJson.outputAmount = 1;

        Ingredient inputA = Ingredient.fromJson(recipeJson.inputA);
        Ingredient inputB = Ingredient.fromJson(recipeJson.inputB);
        Item outputItem = ((Optional<Item>) Registry.ITEM.getOrEmpty(new Identifier(recipeJson.outputItem)))
            .orElseThrow(() -> new JsonSyntaxException("No such Item " + recipeJson.outputItem));
        ItemStack output = new ItemStack(outputItem, recipeJson.outputAmount);

        return new primalGrindstoneRecipe(inputA, inputB, output, id);
    }

    @Override
    public void write(PacketByteBuf packetData, primalGrindstoneRecipe recipe) {
        recipe.getInputA().write(packetData);
        recipe.getInputB().write(packetData);
        packetData.writeItemStack(recipe.getOutput());
    }

    @Override
    public primalGrindstoneRecipe read(Identifier id, PacketByteBuf packetData) {
        Ingredient inputA = Ingredient.fromPacket(packetData);
        Ingredient inputB = Ingredient.fromPacket(packetData);
        ItemStack output = packetData.readItemStack();
        return new primalGrindstoneRecipe(inputA, inputB, output, id);
    }

    public static final primalGrindstoneRecipeSerializer INSTANCE = new primalGrindstoneRecipeSerializer();

    public static final Identifier ID = new Identifier("primalTech:primalGrindstone_recipe");
    
}
