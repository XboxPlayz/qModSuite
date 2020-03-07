package us.retrohq.qmodsuite.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import us.retrohq.qmodsuite.Main;
import us.retrohq.qmodsuite.handlers.ModModeHandler;

public class modmodeCommand implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            return true;
        }

        Player p = (Player) sender;

        if ( ModModeHandler.isModMode( p ) )
        {
            Main.getInstance().mm.disableStaffMode( p );
        } else
        {
            Main.getInstance().mm.enableStaffMode( p );
        }
        return false;
    }

    @EventHandler
    public void staffConnect(PlayerJoinEvent e){
        Player p = e.getPlayer();

        if(p.hasPermission("qmodsuite.staff")){
            Main.getInstance().mm.enableStaffMode(p);

        }else{
            return;
        }

    }

}
