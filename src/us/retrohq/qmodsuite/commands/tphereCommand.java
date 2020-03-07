package us.retrohq.qmodsuite.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.retrohq.qmodsuite.Main;
import us.retrohq.qmodsuite.util.Color;

public class tphereCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(Main.getConsoleMsg());
            return true;
        }

        Player player = (Player) sender;



        if(player.hasPermission("qmodsuite.tphere")){
            if(args.length == 0){
                player.sendMessage(Color.msg("&cUsage: /tphere <player>"));
                return true;
            }

            Player target = Bukkit.getPlayer(args[0]);
            if(args.length == 1){
                player.sendMessage(Color.msg("&6You have teleported " + target.getDisplayName() + " &6to " + player.getDisplayName()));
                target.teleport(player);
            }else{
                player.sendMessage(Color.msg(target.getDisplayName() + "&cis not online!"));
                return true;
            }
        }else{
            sender.sendMessage(Main.getPermMsg());
        }

        return true;
    }

}
