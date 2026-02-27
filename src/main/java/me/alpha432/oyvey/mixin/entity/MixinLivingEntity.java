package me.alpha432.oyvey.mixin.mixins;  // ← adjust to match your existing mixin package

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.modules.render.PlayerGlow;  // ← important: import your new module
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyReturnValue;
import net.minecraft.client.MinecraftClient;

@Mixin(LivingEntity.class)
public class MixinLivingEntity {

    @ModifyReturnValue(method = "isGlowing", at = @At("RETURN"))
    private boolean onIsGlowing(boolean original) {
        // Only apply when our module is toggled on
        Module glowModule = /* get module instance — see below */;

        if (glowModule != null && glowModule.isEnabled()) {
            LivingEntity entity = (LivingEntity) (Object) this;
            if (entity instanceof PlayerEntity player) {
                MinecraftClient mc = MinecraftClient.getInstance();
                if (mc.player != null && !mc.player.equals(player)) {
                    return true;  // force glow outline on other players
                }
            }
        }
        return original;
    }
}
