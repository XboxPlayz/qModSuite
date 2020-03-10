package us.retrohq.qmodsuite.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RenameCommand implements CommandExecutor
{
    @Override
    public boolean onCommand( CommandSender sender, Command command, String s, String[] strings )
    {
        if ( !( sender instanceof Player ) )
        {
            sender.sendMessage( "Only players may execute this command!" );
            return true;
        }
        Player p = ( ( Player ) sender );
        ItemStack heldItem = p.getItemInHand();
        ItemMeta meta = heldItem.getItemMeta();
        StringBuilder sb = new StringBuilder();
        if ( strings.length == 1 )
        {
            meta.setDisplayName( strings[ 0 ] );
        } else
        {
            for ( String str : strings )
            {
                sb.append( str );
                sb.append( " " );
            }
            String result = sb.toString();
            meta.setDisplayName( result );
            heldItem.setItemMeta( meta );
            p.sendMessage( ChatColor.GREEN + "You have successfully renamed your held item to " + result + "!" );
        }
        return true;
    }
}
