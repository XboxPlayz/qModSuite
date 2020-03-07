package us.retrohq.qmodsuite.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.retrohq.qmodsuite.Main;
import us.retrohq.qmodsuite.util.Color;

public class clearCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            return true;
        }

        Player player = (Player) sender;

        if (player.hasPermission("qmodsuite.clear")){

            if(args.length == 0){
                player.getInventory().clear();
                player.sendMessage(Color.msg("&6Your inventory has been cleared."));
                return true;
            }
            if(args.length == 1){
                Player target = Bukkit.getPlayer(args[0]);
                target.closeInventory();
                target.getInventory().clear();
                target.sendMessage(Color.msg("&6Your inventory has been cleared."));
                player.sendMessage(Color.msg("&6You have cleared &r" + target.getDisplayName() + "&6's inventory."));
                return true;
            }

        }else{
            sender.sendMessage(Color.msg("&cNo permission."));
        }

        return false;
    }

}
