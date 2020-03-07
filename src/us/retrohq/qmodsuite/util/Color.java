package us.retrohq.qmodsuite.util;

import org.bukkit.ChatColor;

import java.util.ArrayList;

public class Color {

    public static ArrayList< String > msg( ArrayList< String > s )
    {
        ArrayList< String > result = new ArrayList<>();
        for ( String i : s )
        {
            // creates a color-coded string from the iterated string
            String a = ChatColor.translateAlternateColorCodes( '&', i );
            result.add( a );
        }
        return result;
    }
    public static String msg( String s )
    {
        return ChatColor.translateAlternateColorCodes( '&', s );
    }
}
