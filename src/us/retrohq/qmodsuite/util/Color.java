package us.retrohq.qmodsuite.util;

import org.bukkit.ChatColor;

public class Color {

    public static final String msg(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }

}
