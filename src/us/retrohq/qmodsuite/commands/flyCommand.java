package us.retrohq.qmodsuite.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.retrohq.qmodsuite.util.Color;

public class flyCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage(Color.msg("&cThis command is for players only!"));

            return true;
        }

        Player p = (Player) sender;
        if(p.hasPermission("qmodsuite.staff")){

        }

        return false;
    }

}
