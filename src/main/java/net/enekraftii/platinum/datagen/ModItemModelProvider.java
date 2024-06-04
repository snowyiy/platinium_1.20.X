package net.enekraftii.platinum.datagen;

import net.enekraftii.platinum.Platinum;
import net.enekraftii.platinum.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Platinum.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.PLATINUM_INGOT);
        simpleItem(ModItems.RAW_PLATINUM);

        simpleItem(ModItems.PLATINUM_DETECTOR);

        simpleItem(ModItems.STRAWBERRY);
        simpleItem(ModItems.PINE_CONE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Platinum.MOD_ID, "item/" + item.getId().getPath()));
    }
}
