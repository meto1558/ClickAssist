package com.github.meto1558.clickassist;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;

public class ClickBooster {

    private final Minecraft mc = Minecraft.getMinecraft();
    private Robot robot;
    private boolean isClicking;

    public void enable() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void disable() {
        robot = null;
        isClicking = false;
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    @SubscribeEvent
    public void onMouseUpdate(MouseEvent event) {
        if (event.button == 0 && event.buttonstate && robot != null) {
            if (isClicking) {
                isClicking = false;
                System.out.println("is clicking is false");
            } else {
                robot.mouseRelease(16);
                robot.mousePress(16);
                isClicking = true;
                System.out.println("is clicking is true");
            }
        }
    }

}
