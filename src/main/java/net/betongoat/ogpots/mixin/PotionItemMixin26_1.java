package net.betongoat.ogpots.mixin;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.PotionContents;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PotionItem.class)
public abstract class PotionItemMixin26_1 extends Item {
    public PotionItemMixin26_1(Item.Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        PotionContents contents = stack.getComponents().get(DataComponents.POTION_CONTENTS);
        return super.isFoil(stack) || contents != null && contents.hasEffects();
    }
}
