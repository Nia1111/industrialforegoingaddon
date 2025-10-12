package wootrevived.ifwootaddon;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import wootrevived.api.IWootPlugin;
import wootrevived.api.WootPlugin;
import wootrevived.api.registrations.WootUpgradeItemRegistration;
import wootrevived.ifwootaddon.upgrades.LaserDrill;
import wootrevived.ifwootaddon.upgrades.MobCrusher;
import wootrevived.ifwootaddon.upgrades.MobSlaughterFactory;

@WootPlugin
@Mod(IFWootAddon.MOD_ID)
public class IFWootAddon implements IWootPlugin
{
    public static final String MOD_ID = "ifwootaddon";

    public IFWootAddon()
    {
    }

    @Override
    public void registerUpgradeItems(WootUpgradeItemRegistration registration){
        LaserDrill.register(registration);
        MobCrusher.register(registration);
        MobSlaughterFactory.register(registration);
    }

    public static @NotNull ResourceLocation location(String path) {
        return ResourceLocation.fromNamespaceAndPath(IFWootAddon.MOD_ID, path);
    }
}
