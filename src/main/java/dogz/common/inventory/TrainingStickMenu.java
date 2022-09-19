package dogz.common.inventory;

import dogz.common.entity.DogEntity;
import dogz.common.util.MenuUtil;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

public class TrainingStickMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {

    public final static HashMap<String, Object> guistate = new HashMap<>();
    public final Level world;
    public final Player entity;

    public int x, y, z;
    private IItemHandler internal;
    private final Map<Integer, Slot> customSlots = new HashMap<>();
    private boolean bound = false;


    public TrainingStickMenu(int id, Inventory inv, FriendlyByteBuf extraData) {

        super(MenuUtil.TRAINING_STICK, id);
        this.entity = inv.player;
        this.world = inv.player.level;

        this.internal = new ItemStackHandler(0);
        BlockPos pos = null;
        if (extraData != null) {
            pos = extraData.readBlockPos();
            this.x = pos.getX();
            this.y = pos.getY();
            this.z = pos.getZ();
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    public Map<Integer, Slot> get() {
        return customSlots;
    }
    //creates new container with no slots
}
