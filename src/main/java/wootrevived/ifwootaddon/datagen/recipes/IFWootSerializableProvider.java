package wootrevived.ifwootaddon.datagen.recipes;

import com.buuz135.industrial.module.ModuleAgricultureHusbandry;
import com.buuz135.industrial.module.ModuleResourceProduction;
import com.buuz135.industrial.recipe.DissolutionChamberRecipe;
import com.buuz135.industrial.recipe.LaserDrillFluidRecipe;
import com.buuz135.industrial.recipe.LaserDrillOreRecipe;
import com.buuz135.industrial.recipe.LaserDrillRarity;
import com.buuz135.industrial.utils.IndustrialTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.neoforged.neoforge.fluids.FluidStack;
import wootrevived.ifwootaddon.upgrades.LaserDrill;
import wootrevived.ifwootaddon.upgrades.MobCrusher;
import wootrevived.ifwootaddon.upgrades.MobSlaughterFactory;
import wootrevived.woot.registries.FluidsRegistry;
import wootrevived.woot.registries.ItemsRegistry;
import wootrevived.woot.registries.UpgradeItemsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class IFWootSerializableProvider extends RecipeProvider {
    public IFWootSerializableProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) { super(packOutput, provider); }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        DissolutionChamberRecipe.createRecipe(output, LaserDrill.LASER_DRILL_TAG, new DissolutionChamberRecipe(
                List.of(
                        Ingredient.of(UpgradeItemsRegistry.UPGRADE_BASE_ITEM.get()),
                        Ingredient.of(IndustrialTags.Items.MACHINE_FRAME_ADVANCED),
                        Ingredient.of(UpgradeItemsRegistry.UPGRADE_BASE_ITEM.get()),
                        Ingredient.of(ModuleResourceProduction.FLUID_LASER_BASE.getBlock()),
                        Ingredient.of(ModuleResourceProduction.FLUID_LASER_BASE.getBlock()),
                        Ingredient.of(IndustrialTags.Items.GEAR_DIAMOND),
                        Ingredient.of(ModuleResourceProduction.LASER_DRILL.getBlock()),
                        Ingredient.of(IndustrialTags.Items.GEAR_DIAMOND)
                ),
                new FluidStack(FluidsRegistry.SOURCE_VITALITY_FUEL_FLUID.get(), 2000),
                150,
                Optional.of(LaserDrill.LASER_DRILL_ITEM.get().getDefaultInstance()),
                Optional.empty()
        ));

        DissolutionChamberRecipe.createRecipe(output, MobCrusher.MOB_CRUSHER_TAG, new DissolutionChamberRecipe(
                List.of(
                        Ingredient.of(UpgradeItemsRegistry.UPGRADE_BASE_ITEM.get()),
                        Ingredient.of(IndustrialTags.Items.MACHINE_FRAME_ADVANCED),
                        Ingredient.of(UpgradeItemsRegistry.UPGRADE_BASE_ITEM.get()),
                        Ingredient.of(ModuleAgricultureHusbandry.MOB_CRUSHER.getBlock()),
                        Ingredient.of(ModuleAgricultureHusbandry.MOB_CRUSHER.getBlock()),
                        Ingredient.of(Items.NETHERITE_SCRAP),
                        Ingredient.of(IndustrialTags.Items.GEAR_DIAMOND),
                        Ingredient.of(Items.NETHERITE_SCRAP)
                ),
                new FluidStack(FluidsRegistry.SOURCE_VITALITY_FUEL_FLUID.get(), 2000),
                150,
                Optional.of(MobCrusher.MOB_CRUSHER_ITEM.get().getDefaultInstance()),
                Optional.empty()
        ));

        DissolutionChamberRecipe.createRecipe(output, MobSlaughterFactory.MOB_SLAUGHTER_FACTORY_TAG, new DissolutionChamberRecipe(
                List.of(
                        Ingredient.of(UpgradeItemsRegistry.UPGRADE_BASE_ITEM.get()),
                        Ingredient.of(IndustrialTags.Items.MACHINE_FRAME_SIMPLE),
                        Ingredient.of(UpgradeItemsRegistry.UPGRADE_BASE_ITEM.get()),
                        Ingredient.of(ModuleAgricultureHusbandry.SLAUGHTER_FACTORY.getBlock()),
                        Ingredient.of(ModuleAgricultureHusbandry.SLAUGHTER_FACTORY.getBlock()),
                        Ingredient.of(IndustrialTags.Items.GEAR_GOLD),
                        Ingredient.of(Items.REDSTONE),
                        Ingredient.of(IndustrialTags.Items.GEAR_GOLD)
                ),
                new FluidStack(FluidsRegistry.SOURCE_VITALITY_FUEL_FLUID.get(), 2000),
                150,
                Optional.of(MobSlaughterFactory.MOB_SLAUGHTER_FACTORY_ITEM.get().getDefaultInstance()),
                Optional.empty()
        ));

        LaserDrillOreRecipe.createItemRecipe(
                output,
                ItemsRegistry.STYGIAN_DUST_ITEM.get(),
                2,
                new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(List.of(), List.of()), new LaserDrillRarity.DimensionRarity(List.of(BuiltinDimensionTypes.NETHER), List.of()), 7, 117, 10)
        );

        LaserDrillFluidRecipe.createRecipe(output, "warden", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 30000),
                10,
                ResourceLocation.fromNamespaceAndPath("minecraft", "warden"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        LaserDrillFluidRecipe.createRecipe(output, "wither", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 20000),
                10,
                ResourceLocation.fromNamespaceAndPath("minecraft", "wither"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        LaserDrillFluidRecipe.createRecipe(output, "ender_dragon", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 10000),
                10,
                ResourceLocation.fromNamespaceAndPath("minecraft", "ender_dragon"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        LaserDrillFluidRecipe.createRecipe(output, "wither_skeleton", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 5000),
                10,
                ResourceLocation.fromNamespaceAndPath("minecraft", "wither_skeleton"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        LaserDrillFluidRecipe.createRecipe(output, "ghast", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 5000),
                10,
                ResourceLocation.fromNamespaceAndPath("minecraft", "ghast"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        LaserDrillFluidRecipe.createRecipe(output, "enderman", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 5000),
                10,
                ResourceLocation.fromNamespaceAndPath("minecraft", "enderman"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        LaserDrillFluidRecipe.createRecipe(output, "blaze", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 2000),
                10,
                ResourceLocation.fromNamespaceAndPath("minecraft", "blaze"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        LaserDrillFluidRecipe.createRecipe(output, "zombie", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 1000),
                10,
                ResourceLocation.fromNamespaceAndPath("minecraft", "zombie"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        LaserDrillFluidRecipe.createRecipe(output, "skeleton", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 1000),
                10,
                ResourceLocation.fromNamespaceAndPath("minecraft", "skeleton"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        LaserDrillFluidRecipe.createRecipe(output, "creeper", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 1000),
                10,
                ResourceLocation.fromNamespaceAndPath("minecraft", "creeper"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        LaserDrillFluidRecipe.createRecipe(output, "spider", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 1000),
                10,
                ResourceLocation.fromNamespaceAndPath("minecraft", "spider"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        LaserDrillFluidRecipe.createRecipe(output, "cow", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 500),
                10,
                ResourceLocation.fromNamespaceAndPath("minecraft", "cow"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        LaserDrillFluidRecipe.createRecipe(output, "sheep", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 500),
                10,
                ResourceLocation.fromNamespaceAndPath("minecraft", "sheep"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        LaserDrillFluidRecipe.createRecipe(output, "chicken", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 500),
                10,
                ResourceLocation.fromNamespaceAndPath("minecraft", "chicken"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        LaserDrillFluidRecipe.createRecipe(output, "pig", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 500),
                10,
                ResourceLocation.fromNamespaceAndPath("minecraft", "pig"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
    }
}
