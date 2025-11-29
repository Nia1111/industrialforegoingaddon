package wootrevived.ifwootaddon.registries;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import wootrevived.ifwootaddon.IFWootAddon;
import wootrevived.ifwootaddon.components.LaserDrillData;

public class ComponentsRegistry {
    public static final DeferredRegister.DataComponents COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, IFWootAddon.MOD_ID);

    public static void register(IEventBus bus) {
        COMPONENTS.register(bus);
    }

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<LaserDrillData.Component>> LASER_DRILL_DATA =
            COMPONENTS.registerComponentType(
                    LaserDrillData.ID,
                    builder -> builder
                            .persistent(LaserDrillData.CODEC)
                            .networkSynchronized(LaserDrillData.STREAM_CODEC)
            );
}
