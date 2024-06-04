package net.enekraftii.platinum.datagen;

import net.enekraftii.platinum.Platinum;
import net.enekraftii.platinum.block.ModBlocks;
import net.enekraftii.platinum.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> PLATINUM_SMELTABLES = List.of(ModItems.RAW_PLATINUM.get(),
            ModBlocks.PLATINUM_ORE.get(), ModBlocks.DEEPSLATE_PLATINUM_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, PLATINUM_SMELTABLES, RecipeCategory.MISC, ModItems.PLATINUM_INGOT.get(), 0.5f, 150, "platinum");
        oreBlasting(pWriter, PLATINUM_SMELTABLES, RecipeCategory.MISC, ModItems.PLATINUM_INGOT.get(), 0.5f, 150, "platinum");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLATINUM_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.PLATINUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.PLATINUM_INGOT.get()), has(ModItems.PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PLATINUM_INGOT.get(), 9)
                .requires(ModBlocks.PLATINUM_BLOCK.get())
                .unlockedBy(getHasName(ModItems.PLATINUM_INGOT.get()), has(ModItems.PLATINUM_INGOT.get()))
                .save(pWriter);

//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATINUM_INGOT.get())
//                .pattern("DDD")
//                .pattern("DDD")
//                .pattern("DDD")
//                .define('D', ModItems.PLATINUM_NUGGET.get())
//                .unlockedBy(getHasName(ModItems.PLATINUM_NUGGET.get()), has(ModItems.PLATINUM_NUGGET.get()))
//                .save(pWriter);
//
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PLATINUM_NUGGET.get(), 9)
                .requires(ModItems.PLATINUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.PLATINUM_NUGGET.get()), has(ModItems.PLATINUM_NUGGET.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, Platinum.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
