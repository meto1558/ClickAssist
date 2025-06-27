package com.github.meto1558.clickassist;

import com.github.meto1558.clickassist.command.ToggleCommand;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = "clickassist", useMetadata=true)
public class ModMain {

    private final Logger logger = LogManager.getLogger("Click Assist Mod");

    public static final String NAME = "Click Assist Mod";
    public static final String AUTHOR = "meto1558";
    public static ClickBooster clickBooster = new ClickBooster();

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info(NAME + " by " + AUTHOR + "." + " Loading...");
        ClientCommandHandler.instance.registerCommand(new ToggleCommand());
        logger.info("Load completed.");
    }

    public static void addChatMessage(String msg) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(msg));
    }

}
