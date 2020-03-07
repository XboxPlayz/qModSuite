package us.retrohq.qmodsuite;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import us.retrohq.qmodsuite.commands.flyCommand;

public class Main extends JavaPlugin {

    @Getter private static Main instance;

    @Override
    public void onEnable(){
        instance = this;


        setupEvents();
        setupCommands();
    }

    @Override
    public void onDisable(){

    }

    public void setupEvents(){

    }

    public void setupCommands(){
        getCommand("fly").setExecutor(new flyCommand());
    }

}
