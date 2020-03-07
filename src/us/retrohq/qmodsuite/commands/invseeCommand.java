package us.retrohq.qmodsuite.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.retrohq.qmodsuite.Main;
import us.retrohq.qmodsuite.util.Color;

public class invseeCommand implements CommandExecutor {

    private void openInvseeMenu(Player playerToInvsee, Player playerWhoWantsToSeeTheOtherPlayer) {
        playerWhoWantsToSeeTheOtherPlayer.openInventory(playerToInvsee.getInventory());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.getConsoleMsg());
            return true;
        }

        Player player = (Player) sender;

        if (!(player.hasPermission("qmodsuite.staff.invsee"))) {
            player.sendMessage(Main.getPermMsg());
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
        player.sendMessage(Color.msg("&6Opening the inventory of:&r " + target.getDisplayName()));


        return true;
    }


}
