package us.retrohq.qmodsuite.commands;

import net.frozenorb.qlib.command.Command;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RenameCommand
{
    @Command( names = { "rename" }, permission = "qmodsuite.staff", description = "Rename the item you are currently holding.", hidden = true )
    public static void commandRename( Player p, String[] args )
    {
        ItemStack heldItem = p.getItemInHand();
        ItemMeta meta = heldItem.getItemMeta();
        StringBuilder sb = new StringBuilder();
        if ( args.length == 1 )
        {
            meta.setDisplayName( args[ 0 ] );
        } else
        {
            for ( String s : args )
            {
                sb.append( s );
                sb.append( " " );
            }
            String result = sb.toString();
            meta.setDisplayName( result );
            heldItem.setItemMeta( meta );
            p.sendMessage( ChatColor.GREEN + "You have successfully renamed your held item to " + result + "!" );
        }

    }
}
