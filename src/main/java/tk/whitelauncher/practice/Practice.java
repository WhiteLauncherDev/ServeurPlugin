package tk.whitelauncher.practice;

import org.bukkit.plugin.java.JavaPlugin;

public class Practice extends JavaPlugin {


    @Override
    public void onEnable() {

        getCommand("help").setExecutor(new CommandHelp());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}