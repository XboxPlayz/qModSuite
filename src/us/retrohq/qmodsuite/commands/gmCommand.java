package us.retrohq.qmodsuite.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.retrohq.qmodsuite.Main;
import us.retrohq.qmodsuite.util.Color;

public class gmCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            return true;
        }

        Player p = (Player) sender;
        if(p.hasPermission("qmodsuite.headstaff")){
            if(p.getGameMode() != GameMode.CREATIVE){
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(Color.msg("&6Your gamemode has been updated to &fCREATIVE&6."));
            }else{
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(Color.msg("&6Your gamemode has been updated to &fSURVIVAL&6."));
            }
            if(p.getGameMode() != GameMode.SURVIVAL){
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(Color.msg("&6Your gamemode has been updated to &fSURVIVAL&6."));
            }else{
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(Color.msg("&6Your gamemode has been updated to &fCREATIVE&6."));
            }
            return true;
        }else{
            sender.sendMessage(Color.msg("&cNo permission."));
        }

        return false;
    }
}
