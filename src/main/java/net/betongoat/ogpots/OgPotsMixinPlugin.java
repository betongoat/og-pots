package net.betongoat.ogpots;

import java.util.List;
import java.util.Set;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.VersionParsingException;
import net.fabricmc.loader.api.metadata.version.VersionPredicate;
import org.objectweb.asm.tree.ClassNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

public class OgPotsMixinPlugin implements IMixinConfigPlugin {
    private static final Logger LOGGER = LoggerFactory.getLogger("ogpots");

    private String activeMixin;

    @Override
    public void onLoad(String mixinPackage) {
        Version version = FabricLoader.getInstance().getModContainer("minecraft").orElseThrow().getMetadata().getVersion();
        String mixin;
        if (matches(version, ">=26.1-")) {
            mixin = "PotionItemMixin26_1";
        } else if (matches(version, ">=1.21.5-")) {
            mixin = "PotionItemMixin1_21_5";
        } else {
            mixin = "PotionItemMixin1_21";
        }
        activeMixin = mixinPackage + "." + mixin;
        LOGGER.info("Minecraft {} detected, using {}", version.getFriendlyString(), mixin);
    }

    private static boolean matches(Version version, String predicate) {
        try {
            return VersionPredicate.parse(predicate).test(version);
        } catch (VersionParsingException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return mixinClassName.equals(activeMixin);
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }
}
