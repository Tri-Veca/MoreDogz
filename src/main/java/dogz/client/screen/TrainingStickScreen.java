package dogz.client.screen;

import dogz.common.entity.DogEntity;
import dogz.common.inventory.TrainingStickMenu;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Widget;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.Minecraft;

import java.awt.*;
import java.util.HashMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraftforge.client.gui.widget.ExtendedButton;

public class TrainingStickScreen extends  AbstractContainerScreen<TrainingStickMenu> implements Widget, Button.OnPress {
    private final static HashMap<String, Object> guistate = TrainingStickMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    public DogEntity dogEntity;
    ExtendedButton GuiButton;
    private float xMouse;
    private float yMouse;

    private final Vec2i[] tabs = {
            new Vec2i(34, 4), //Down
            new Vec2i(6, 4), //Up
            new Vec2i(62, 4),
            new Vec2i(90, 4),
            new Vec2i(118, 4),
            new Vec2i(146, 4)
    };

    public TrainingStickScreen(TrainingStickMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 176;
        this.imageHeight = 166;

        this.passEvents = false;
    }

    private static final ResourceLocation texture = new ResourceLocation("dogz:textures/gui/training_stick_gui.png");

    @Override
    public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(ms);
        super.render(ms, mouseX, mouseY, partialTicks);
        this.renderTooltip(ms, mouseX, mouseY);
    }

    @Override
    protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {

        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderTexture(0, texture);

        this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
        RenderSystem.disableBlend();


        //InventoryScreen.renderEntityInInventory(x + 51, +60, 17, (float) (x + 51) - this.xMouse, (float) (y + 75 - 50) - this.yMouse, this.dogEntity);


    }




    @Override
    public boolean keyPressed(int key, int b, int c) {
        if (key == 256) {
            this.minecraft.player.closeContainer();
            return true;
        }
        return super.keyPressed(key, b, c);
    }

    @Override
    public void containerTick() {
        super.containerTick();

    }

    @Override
    protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
        this.font.draw(poseStack, "" + (entity.getPersistentData().getString("name")) + "Health",  78,  + 49,  Color.DARK_GRAY.getRGB());
        this.font.draw(poseStack, "" + (entity.getPersistentData().getString("name")) + "0/5",  118,  + 49,  Color.YELLOW.getRGB());
        this.font.draw(poseStack, "" + (entity.getPersistentData().getString("name")) + "Damage",  78,  + 66,  Color.DARK_GRAY.getRGB());
        this.font.draw(poseStack, "" + (entity.getPersistentData().getString("name")) + "0/5",  118,  + 66, Color.YELLOW.getRGB());
        this.font.draw(poseStack, "" + (entity.getPersistentData().getString("name")) + "Speed",  78,  + 83,  Color.DARK_GRAY.getRGB());
        this.font.draw(poseStack, "" + (entity.getPersistentData().getString("name")) +"0/5",  118,  + 83, Color.YELLOW.getRGB());
       //S this.font.draw(poseStack, "" + (entity.getPersistentData().getString("name")) +"Max",  17,  + 9, Color.BLACK.getRGB());
    }

    @Override
    public void onClose() {
        super.onClose();
        Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
    }

    @Override
    public void init() {

        super.init();
        this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
        GuiButton = addRenderableWidget(new ExtendedButton(this.leftPos + 143, this.topPos + 48, 9, 9, new TextComponent("+"), this::onPress));
    }

    @Override
    public void onPress(Button button) {

    }

    @Override
    public boolean mouseClicked(double x, double y, int btn) {
        if (MiscTools.inBounds(getGuiLeft() + tabs[1].x, getGuiTop() + tabs[1].y, 24, 12, x, y)) {
            Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK, 1.0F));
            return true;
        }
        return super.mouseClicked(x, y, btn);
    }

}

