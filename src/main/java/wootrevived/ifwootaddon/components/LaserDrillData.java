package wootrevived.ifwootaddon.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class LaserDrillData {
    public static final String ID = "laser_drill_data";

    public static final Codec<Component> CODEC = RecordCodecBuilder.create(inst ->
            inst.group(
                    ItemStack.OPTIONAL_CODEC.fieldOf("LensStack").forGetter(Component::stack)
            ).apply(inst, Component::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, Component> STREAM_CODEC = StreamCodec.composite(
            ItemStack.OPTIONAL_STREAM_CODEC, Component::stack,
            Component::new
    );

    public static ItemStack get(Component component) {
        return component == null ? ItemStack.EMPTY : component.stack;
    }

    public static Component of(ItemStack stack) {
        return new Component(stack.copy());
    }

    public static Component empty(){
        return new Component(ItemStack.EMPTY);
    }

    public record Component(
            @NotNull ItemStack stack
    ) {
        @Override
        public int hashCode() {
            return ItemStack.hashItemAndComponents(stack);
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Component c))
                return false;

            return ItemStack.isSameItemSameComponents(c.stack, stack);
        }
    }
}
