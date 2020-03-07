package us.retrohq.qmodsuite;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import us.retrohq.qmodsuite.commands.*;
import us.retrohq.qmodsuite.handlers.ModModeHandler;
import us.retrohq.qmodsuite.handlers.OnlineStaff;
import us.retrohq.qmodsuite.util.Color;


public class Main extends JavaPlugin {


    private static Main instance;
    @Getter private static final String PermMsg = Color.msg("&cNo permission.");
    @Getter private static final String ConsoleMsg = Color.msg("&cThis command can only be executed by players!");
    public ModModeHandler mm = new ModModeHandler();

    @Override
    public void onEnable(){
        instance = this;

        getLogger().info("Registering events...");
        setupEvents();
        getLogger().info("Events registered!");
        getLogger().info("Registering commands...");
        setupCommands();
        getLogger().info("Commands registered!");

    }

    @Override
    public void onDisable(){
        instance = null;
    }

    public void setupEvents(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new ModModeHandler(), this);
        pm.registerEvents(new OnlineStaff(), this);
        pm.registerEvents(new modmodeCommand(), this);
    }

    public void setupCommands(){
        getCommand("gm").setExecutor(new gmCommand());
        getCommand("gmc").setExecutor(new gmcCommand());
        getCommand("gms").setExecutor(new gmsCommand());
        getCommand("tp").setExecutor(new tpCommand());
        getCommand("tphere").setExecutor(new tphereCommand());
        getCommand("invsee").setExecutor(new invseeCommand());
        getCommand("clearchat").setExecutor(new clearchatCommand());
        getCommand("clear").setExecutor(new clearCommand());
        getCommand("mod").setExecutor(new modmodeCommand());
    }

    public static Main getInstance() {
        return instance;
    }

}
