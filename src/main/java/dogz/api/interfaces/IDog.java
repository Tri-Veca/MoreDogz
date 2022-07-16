package dogz.api.interfaces;

import dogz.api.abstracts.AbstractDogEntity;
import net.minecraft.world.entity.LivingEntity;

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


}



