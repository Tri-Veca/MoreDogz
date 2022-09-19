package dogz.api.interfaces;

import dogz.api.DataKey;
import dogz.api.abstracts.AbstractDogEntity;
import net.minecraft.world.entity.LivingEntity;

import java.util.function.Supplier;

public interface IDog {
    public AbstractDogEntity getDog();
    public void reHome();
    public boolean canInteract(LivingEntity playerIn);
    public int getDogSize();
    public void setDogSize(int size);
    public float getMaxHunger();
    public float getDogHunger();
    public void addHunger(float add);
    public void setDogHunger(float hunger);
    public boolean isLying();

    public float getWagAngle(float limbSwing, float limbSwingAmount, float partialTickTime);
    public float getShakeAngle(float partialTicks, float offset);
    public float getInterestedAngle(float partialTicks);
    @Deprecated
    public <T> void setData(DataKey<T> key, T value);
    /**
     * Tries to put the object in the map, does nothing if the key already exists
     */
    @Deprecated
    public <T> void setDataIfEmpty(DataKey<T> key, T value);
    @Deprecated
    public <T> T getData(DataKey<T> key);
    @Deprecated
    public <T> T getDataOrGet(DataKey<T> key, Supplier<T> other);
    @Deprecated
    public <T> T getDataOrDefault(DataKey<T> key, T other);
    @Deprecated
    public <T> boolean hasData(DataKey<T> key);

}



