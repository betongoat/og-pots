package net.betongoat.ogpots.mixin;

import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1812;
import net.minecraft.class_1844;
import net.minecraft.class_9334;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(class_1812.class)
public abstract class PotionItemMixin1_21 extends class_1792 {
    public PotionItemMixin1_21(class_1792.class_1793 settings) {
        super(settings);
    }

    @Override
    public boolean method_7886(class_1799 stack) {
        class_1844 contents = stack.method_57353().method_57829(class_9334.field_49651);
        return super.method_7886(stack) || contents != null && contents.method_57405();
    }
}
