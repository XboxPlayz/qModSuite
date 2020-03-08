package us.retrohq.qmodsuite.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import us.retrohq.qmodsuite.util.Color;

public class invseeCommand implements CommandExecutor, Listener {


    private void openInvseeMenu(Player playerToInvsee, Player playerWhoWantsToSeeTheOtherPlayer) {
        playerWhoWantsToSeeTheOtherPlayer.openInventory(playerToInvsee.getInventory());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Color.msg("&cPlayer use only."));
            return true;
        }

        Player player = (Player) sender;

        if (!(player.hasPermission("qmodsuite.staff.invsee"))) {
            player.sendMessage(ChatColor.RED + "No perimission.");
            return true;
        }

        if(args == null || args.length == 0 || args[0] == null || args[0].isEmpty()) {
            player.sendMessage(Color.msg("&cUsage: /invsee <player>"));
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (player == null || !player.isOnline()) {
            player.sendMessage(Color.msg("&cCould not find " + args[0] + "&c!"));
            return true;
        }

        openInvseeMenu(target, player);
//        player.sendMessage(Color.msg("&6Opening the inventory of:&r " + target.getDisplayName()));


        return true;
    }

    @EventHandler
    public void playerRightClickPlayer(PlayerInteractEntityEvent e){

        if(e.getRightClicked().getType().equals(EntityType.PLAYER)){
            //right click another player
            Player playerWhoRightClicked = e.getPlayer();
            Player playerWhoGotClicked = (Player) e.getRightClicked();

            if(playerWhoRightClicked.getItemInHand() != null){
                ItemStack is = playerWhoRightClicked.getItemInHand();

                if(is.getItemMeta() != null){
                    ItemMeta im = is.getItemMeta();
                    if(im.getDisplayName() != null && !im.getDisplayName().isEmpty()){

                        if(im.getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&bInspection Book"))){
                            openInvseeMenu(playerWhoGotClicked, playerWhoRightClicked);
                            playerWhoRightClicked.sendMessage(Color.msg("&6Opening the inventory of:&r " + playerWhoGotClicked.getDisplayName()));
                        }

                    }
                }

            }
        }

    }


}


