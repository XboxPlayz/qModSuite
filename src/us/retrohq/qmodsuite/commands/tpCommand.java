package us.retrohq.qmodsuite.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.retrohq.qmodsuite.Main;
import us.retrohq.qmodsuite.util.Color;

public class tpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(Main.getConsoleMsg());
            return true;
        }

        Player player = (Player) sender;

        if(player.hasPermission("qmodsuite.teleport")){
            if(args.length == 0){
                player.sendMessage(Color.msg("&cUsage: /tp <player>"));

                return true;
            }else{
                Player target = Bukkit.getPlayer(args[0]);
                player.sendMessage(Color.msg("&6You have been teleported to " + target.getDisplayName()));
                player.teleport(target);

                return true;
            }
        }else{
            sender.sendMessage(Main.getPermMsg());
        }

        return true;
    }

}
