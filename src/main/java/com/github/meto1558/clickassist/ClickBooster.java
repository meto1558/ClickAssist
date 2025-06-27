package com.github.meto1558.clickassist;

import com.github.meto1558.clickassist.util.Timer;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;
import java.awt.event.InputEvent;

public class ClickBooster {

    private final Minecraft mc = Minecraft.getMinecraft();
    private Robot robot;
    private boolean isClicking;
    private Timer timer;

    public void enable() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        timer = new Timer();
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void disable() {
        robot = null;
        isClicking = false;
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    @SubscribeEvent
    public void onMouseUpdate(MouseEvent event) {
        if (event.button >= 0 && event.buttonstate) {
            if (mc.currentScreen == null && mc.thePlayer != null && event.button == 0) {
                if (isClicking) {
                    isClicking = false;
                } else {
                    if (timer.elapsed(150)) {
                        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                        isClicking = true;
                        timer.reset();
                    }
                }
            }
        }
    }

}
