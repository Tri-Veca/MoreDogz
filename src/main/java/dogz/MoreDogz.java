package dogz;

import dogz.common.init.ItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
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
    public MoreDogz(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        ItemInit.ITEMS.register(bus);
        //registers mod, ItemInt

    }

}
