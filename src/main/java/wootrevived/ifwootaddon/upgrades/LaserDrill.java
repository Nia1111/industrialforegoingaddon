package wootrevived.ifwootaddon.upgrades;

import com.buuz135.industrial.module.ModuleCore;
import com.buuz135.industrial.recipe.LaserDrillFluidRecipe;
import com.hrznstudio.titanium.util.RecipeUtil;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import wootrevived.api.WootUpgradeItem;
import wootrevived.api.interfaces.WootDropsProperties;
import wootrevived.api.registrations.WootUpgradeItemRegistration;
import wootrevived.ifwootaddon.IFWootAddon;

import java.util.List;

public class LaserDrill extends WootUpgradeItem {
    public LaserDrill(int level) { super(new Properties(), level); }

    @Override
    @SuppressWarnings("unchecked")
    public void modifyDrops(WootDropsProperties properties, CompoundTag upgradeTag) {
        List<FluidStack> fluids = properties.getFluidDrops();

        List<LaserDrillFluidRecipe> fluidRecipes = (List<LaserDrillFluidRecipe>) RecipeUtil.getRecipes(properties.getLevel(), ModuleCore.LASER_DRILL_FLUID_TYPE.get());
        for(LaserDrillFluidRecipe recipe : fluidRecipes){
            if(!recipe.entity.equals(LaserDrillFluidRecipe.EMPTY) &&
                    recipe.entity.equals(BuiltInRegistries.ENTITY_TYPE.getKey(properties.getFactoryMob().getEntityType()))){
                fluids.add(recipe.output.copy());
            }
        }
    }

    /* Upgrade Item registration */

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, IFWootAddon.MOD_ID);

    public static void register(WootUpgradeItemRegistration registration){
        ITEMS.register(registration.getWootEventBus());
        registration.register(LASER_DRILL_ITEM);
    }

    public static final String LASER_DRILL_TAG = "laser_drill_upgrade";
    public static final DeferredHolder<Item, LaserDrill> LASER_DRILL_ITEM = ITEMS.register(LASER_DRILL_TAG, () -> new LaserDrill(1));
}
