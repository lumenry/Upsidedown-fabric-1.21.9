package net.lumenry.upsidedown.mixin;

import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(Player.class)
public abstract class ExampleMixin {
    @Shadow
    public abstract boolean isSwimming();

    @Inject(at = @At("HEAD"), method = "tick")
	private void init(CallbackInfo info) {
		// This code is injected into the start of MinecraftServer.loadWorld()
        if(this.isSwimming()){
            System.out.println("Hello World");
        }
	}
}