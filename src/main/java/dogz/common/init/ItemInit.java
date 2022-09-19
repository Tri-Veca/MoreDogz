package dogz.common.init;

import dogz.MoreDogz;
import dogz.common.Types.ModEntityTypes;
import dogz.common.init.custom.items.TrainingStickItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ItemInit {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreDogz.MOD_ID);

    public static RegistryObject<Item> TASTY_TREAT = register("tasty_treat",
            () -> new Item(new Item.Properties().tab(MoreDogz.DOGZ)));

    public static RegistryObject<Item> TRAINING_STICK = register("training_stick",
            () -> new TrainingStickItem(new Item.Properties().tab(MoreDogz.DOGZ)));

    public static final RegistryObject<Item> GERMAN_SHEPARD_SPAWN_EGG = ITEMS.register("german_shepard_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DOG_ENTITY,0xb98349, 0x9e7347,
                    new Item.Properties().tab(MoreDogz.DOGZ)));


    public static <T extends Item>RegistryObject<T> register(String name, final Supplier<T> item){
        return ITEMS.register(name, item);
    }
}
