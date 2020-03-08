package us.retrohq.qmodsuite.commands;


import net.frozenorb.qlib.command.Command;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import us.retrohq.qmodsuite.Main;

public class modmodeCommand {

    @Command(names = {"mod", "staff", "h"}, permission = "qmodsuite.staff")
    public static void modmode(Player p){

        if (Main.getInstance().getModModeHandler().switchModMode(p)) {
            p.sendMessage(ChatColor.GOLD + "Mod Mode: " + ChatColor.GREEN + "Enabled");
        } else {
            p.sendMessage(ChatColor.GOLD + "Mod Mode: " + ChatColor.RED + "Disabled");
        }

    }
}
