package dogz;

import dogz.client.renderer.DogEntityRenderer;
import dogz.common.Types.ModEntityTypes;
import dogz.common.init.ItemInit;
import dogz.common.sound.ModSounds;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("dogz")
public class MoreDogz {
    public static String MOD_ID = "dogz";
    //modid
    public static CreativeModeTab DOGZ = new CreativeModeTab(MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.TASTY_TREAT.get());
        }
    };

    //creates a new creative tab and sets the icon to a tasty treat
    public MoreDogz() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        ItemInit.ITEMS.register(bus);
        ModEntityTypes.register(bus);
        ModSounds.register(bus);
        bus.addListener(MoreDogz::clientSetup);
        //registers mod, ItemInt, ModEntityTypes, ModSounds
        //listens clientSetup

    }


    private static void clientSetup(final FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntityTypes.DOG_ENTITY.get(), DogEntityRenderer::new);
    }

}
