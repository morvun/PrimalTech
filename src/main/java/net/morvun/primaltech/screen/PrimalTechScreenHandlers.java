package net.morvun.primaltech.screen;

import net.minecraft.screen.ScreenHandlerType;

public class PrimalTechScreenHandlers {
    public static ScreenHandlerType<PrimalGrindstoneScreenHandler> PRIMAL_GRINDSTONE_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {

        PRIMAL_GRINDSTONE_SCREEN_HANDLER = new ScreenHandlerType<>(PrimalGrindstoneScreenHandler::new);
    }
    
}
