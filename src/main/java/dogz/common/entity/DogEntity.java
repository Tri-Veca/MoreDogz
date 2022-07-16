package dogz.common.entity;

import dogz.api.abstracts.AbstractDogEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class DogEntity extends AbstractDogEntity {
    protected DogEntity(EntityType<? extends TamableAnimal> type, Level level) {
        super(type, level);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }

    @Override
    public void reHome() {

    }

    @Override
    public boolean canInteract(LivingEntity playerIn) {
        return false;
    }

    @Override
    public int getDogSize() {
        return 0;
    }

    @Override
    public void setDogSize(int size) {

    }

    @Override
    public float getMaxHunger() {
        return 0;
    }

    @Override
    public float getDogHunger() {
        return 0;
    }

    @Override
    public void addHunger(float add) {

    }

    @Override
    public void setDogHunger(float hunger) {

    }

    @Override
    public boolean isLying() {
        return false;
    }
}
