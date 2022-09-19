package dogz.common.util;

import dogz.client.screen.TrainingStickScreen;
import dogz.common.entity.DogEntity;
import dogz.common.inventory.TrainingStickMenu;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
//runs client side
public class ScreenUtil {
   public DogEntity dogEntity;

    @SubscribeEvent
    public static void clientLoad(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(MenuUtil.TRAINING_STICK, TrainingStickScreen::new);
            //registers TrainingStickScreen

        });
    }
}
