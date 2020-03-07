package us.retrohq.qmodsuite.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.retrohq.qmodsuite.Main;
import us.retrohq.qmodsuite.util.Color;

public class clearchatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            for (int i = 0; i < 150; i++) {
                Bukkit.broadcastMessage(" ");
            }
            Bukkit.broadcastMessage(Color.msg("&aChat has been cleared by &4&lCONSOLE" + "&a."));
            return true;

        }

        Player player = (Player) sender;


        if(player.hasPermission("qmodsuite.bypass")) {

            for (int i = 0; i < 150; i++) {
                Bukkit.broadcastMessage(" ");
            }
            Bukkit.broadcastMessage(Color.msg("&aChat has been cleared by&r " + player.getDisplayName() + "&a."));
        }else{
            sender.sendMessage(Color.msg("&cNo permission."));
        }


        return false;
    }

}
