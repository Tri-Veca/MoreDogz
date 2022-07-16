package dogz.common.util;

import dogz.common.inventory.TrainingStickMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.IContainerFactory;
import java.util.ArrayList;
import java.util.List;

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public class MenuUtil {
        private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
        public static final MenuType<TrainingStickMenu> TRAINING_STICK = register("training_stick",
                (id, inv, extraData) -> new TrainingStickMenu(id, inv, extraData));
        //creates new MenuType

        private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
            MenuType<T> menuType = new MenuType<T>(containerFactory);
            menuType.setRegistryName(registryname);
            REGISTRY.add(menuType);
            return menuType;
            //registers MenuType
        }

        @SubscribeEvent
        public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
            event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));

        }
    }

