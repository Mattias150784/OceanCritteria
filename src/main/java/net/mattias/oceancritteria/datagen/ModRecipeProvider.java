package net.mattias.oceancritteria.datagen;

import net.mattias.oceancritteria.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ICE_ARROW.get())
                .pattern("F")
                .pattern("S")
                .pattern("P")
                .define('P', ModItems.PENGUIN_FEATHER.get())
                .define('S', Items.STICK)
                .define('F', Items.FLINT)
                .unlockedBy(getHasName(ModItems.PENGUIN_FEATHER.get()), has(ModItems.PENGUIN_FEATHER.get()))
                .save(pWriter);

//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9)
//                .requires(ModBlocks.SAPPHIRE_BLOCK.get())
//                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
//                .save(pWriter);
    }
}
