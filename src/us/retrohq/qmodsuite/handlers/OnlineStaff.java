package us.retrohq.qmodsuite.handlers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import us.retrohq.qmodsuite.Main;
import us.retrohq.qmodsuite.util.ChestGUI;

public class OnlineStaff implements Listener {

//    public void openOnlineGUI(Player player) {
//        ChestGUI gui = new ChestGUI(ChatColor.YELLOW + "Online Staff", 9, new ChestGUI.OptionClickEventHandler() {
//
//            @Override
//            public void onOptionClick(ChestGUI.OptionClickEvent event) {
//                event.setWillClose(false);
//                event.setWillDestroy(false);
//            }
//        }, Main.getInstance());
//
//        int slot = 0;
//        for(Player p : Bukkit.getOnlinePlayers()){
//            if(p.hasPermission("qmodsuite.staff")){
//                gui.setOption(slot, getSkull(p.getName()), p.getDisplayName(), ChatColor.GOLD + "Mod Mode: "
//                        + getColorFormattedBoolean(Main.getInstance().mm.isModMode(p)));
//
//                slot++;
//            }
//        }
//        gui.open(player);
//
//    }
//
//    private String getColorFormattedBoolean(boolean value) {
//        return (value ? ChatColor.GREEN + "true" : ChatColor.RED + "false");
//    }
//
//
//
//    private ItemStack getSkull(String playerName) {
//        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
//        SkullMeta headmeta = (SkullMeta) head.getItemMeta();
//        headmeta.setOwner(playerName);
//        head.setItemMeta(headmeta);
//        return head;
//    }
//
//    @EventHandler
//    public void onPlayerInteractEvent(PlayerInteractEvent e) {
//        if (Main.getInstance().mm.isModMode(e.getPlayer())) {
//            if (e.getPlayer().getInventory().getItemInHand().getType().equals(Material.SKULL_ITEM)) {
//                openOnlineGUI(e.getPlayer());
//            }
//        }
//    }

}
