package us.retrohq.qmodsuite;

import lombok.Getter;
import net.frozenorb.qlib.command.FrozenCommandHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import us.retrohq.modified.ModModeHandler;
import us.retrohq.modified.ModModeListener;
import us.retrohq.qmodsuite.commands.RenameCommand;
import us.retrohq.qmodsuite.commands.invseeCommand;
import us.retrohq.qmodsuite.handlers.OnlineStaff;
import us.retrohq.qmodsuite.util.Color;


public class Main extends JavaPlugin {


    private static Main instance;
    @Getter private static final String PermMsg = Color.msg("&cNo permission.");
    @Getter private static final String ConsoleMsg = Color.msg("&cThis command can only be executed by players!");


    //    public ModModeHandler mm = new ModModeHandler();
     private ModModeHandler modModeHandler;

    @Override
    public void onEnable(){
        instance = this;
        modModeHandler = new ModModeHandler();
        FrozenCommandHandler.registerAll(this);

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

    private void setupEvents()
    {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new invseeCommand(), this);
        pm.registerEvents(new OnlineStaff(), this);
        pm.registerEvents(new ModModeListener(), this);
    }

    private void setupCommands()
    {
        getCommand("invsee").setExecutor(new invseeCommand());
        getCommand( "rename" ).setExecutor( new RenameCommand() );
    }

    public static Main getInstance() {
        return instance;
    }

    public ModModeHandler getModModeHandler() {
        return modModeHandler;
    }

}
