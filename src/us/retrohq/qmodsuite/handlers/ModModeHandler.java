package us.retrohq.qmodsuite.handlers;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import us.retrohq.qmodsuite.util.Color;

import java.util.ArrayList;
import java.util.List;

public class ModModeHandler implements Listener {

    List<OfflinePlayer> isInModMode = new ArrayList<>();
    List<OfflinePlayer> Vanished = new ArrayList<OfflinePlayer>();

    public boolean isModMode(OfflinePlayer player) {
        return isInModMode.contains(player);
    }

    public boolean isVanished(Player player) {
        return Vanished.contains(player);
    }

        public void enableStaffMode(Player player){

            Inventory inv = player.getInventory();
            inv.clear();

            //staff items
            giveStaffItem(player, Material.COMPASS, "&bCompass", "", 0);
            giveStaffItem(player, Material.BOOK, "&bInspection Book", "", 1);
            giveStaffItemColored(player, Material.CARPET, "&6 ", (byte) 1, 2);
            giveSkull(player, "&bOnline Staff", "Steve", 7);

            if (player.hasPermission("qmodsuite.staff.headstaff")) {

                giveStaffItem(player, Material.COMPASS, "&bCompass", "", 0);
                giveStaffItem(player, Material.BOOK, "&bInspection Book", "", 1);
                giveStaffItem(player, Material.WOOD_AXE, "&bWorldEdit Wand", "&c", 2);
                giveStaffItemColored(player, Material.CARPET, "&6 ", (byte) 1, 3);
                giveSkull(player, "&bOnline Staff", "Steve", 7);
            }

            player.setAllowFlight(true);
            toggleVanish(player);
            player.sendMessage(Color.msg("&6Mod Mode: &aEnabled"));
        Vanished.add(player);

        if (player.hasPermission("qmodsuite.staff.creative")) {
            player.setGameMode(GameMode.CREATIVE);
        } else {
            player.setGameMode(GameMode.SURVIVAL);
        }
    }

    public void disableStaffMode(Player player){
        // Inform the player
        player.sendMessage(Color.msg("&6Mod Mode: &cDisabled"));
        toggleVanish(player);
        player.getInventory().clear();


        isInModMode.remove(player);

        player.setGameMode(GameMode.SURVIVAL);

        player.setAllowFlight(false);
    }

    private void toggleVanish(Player player){
        if (isVanished(player)) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.showPlayer(player);
            }
            Vanished.remove(player);
            giveStaffItemColored(player, Material.INK_SACK, "&bBecome Invisible", (byte) 10, 8);
        } else {
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.hidePlayer(player);
            }
            Vanished.add(player);
            giveStaffItemColored(player, Material.INK_SACK, "&bBecome Visible", (byte) 8, 8);
        }


        if(player.hasPermission("qmodsuite.staff")) {
            player.showPlayer(player);
        }
    }

    private void giveStaffItem(Player player, Material mat, String name, String lore, int slot) {
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(Color.msg(name));

        ArrayList<String> itemLore = new ArrayList<String>();
        itemLore.add(Color.msg(lore));

        item.setItemMeta(itemMeta);

        player.getInventory().setItem(slot, item);
    }

    private void giveStaffItemColored(Player player, Material mat, String name, byte colorMeta, int slot) {
        ItemStack item = new ItemStack(mat, 1, (byte) colorMeta);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(Color.msg(name));

        item.setItemMeta(itemMeta);

        player.getInventory().setItem(slot, item);
    }

    private void giveSkull(Player player, String name, String owner, int slot) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setDisplayName(Color.msg(name));
        skullMeta.setOwner(owner);
        skull.setItemMeta(skullMeta);
        player.getInventory().setItem(slot, skull);
    }


}
