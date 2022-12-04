package net.morvun.primaltech.items.materials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.morvun.primaltech.registry.PrimalItems;

public class PrimalStoneMaterial implements ToolMaterial {

    public static final PrimalStoneMaterial PRIMAL_STONE_MATERIAL = new PrimalStoneMaterial();

    @Override
    public int getDurability() {
        return 59;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 2.0F;
    }

    @Override
    public float getAttackDamage() {
        return 0F;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 5;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(PrimalItems.PEBBLE_ITEM);
    }


    
}
