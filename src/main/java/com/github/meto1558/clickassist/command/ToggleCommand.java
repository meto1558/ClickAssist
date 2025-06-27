package com.github.meto1558.clickassist.command;

import com.github.meto1558.clickassist.ModMain;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.EnumChatFormatting;

public class ToggleCommand extends CommandBase {

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public String getCommandName() {
        return "clickassist";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return EnumChatFormatting.RED + "Usage: " + "/clickassist on/off";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length < 1) {
            ModMain.addChatMessage(getCommandUsage(sender));
        } else if (args[0].equalsIgnoreCase("on")) {
            ModMain.clickBooster.enable();
            ModMain.addChatMessage(EnumChatFormatting.GREEN + "Enabled click assist. (Boosts your CPS between 3-4 CPS)");
        } else if (args[0].equalsIgnoreCase("off")) {
            ModMain.clickBooster.disable();
            ModMain.addChatMessage(EnumChatFormatting.RED + "Disabled click assist.");
        } else {
            ModMain.addChatMessage(getCommandUsage(sender));
        }
    }

}
