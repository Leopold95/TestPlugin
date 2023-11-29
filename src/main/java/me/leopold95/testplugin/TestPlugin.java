package me.leopold95.testplugin;

import me.leopold95.testplugin.commnds.BaseCommnd;
import me.leopold95.testplugin.commnds.BaseTabCompliter;
import me.leopold95.testplugin.core.Config;
import me.leopold95.testplugin.listeners.PlayerJoin;
import me.leopold95.testplugin.listeners.mechanics.BowListners;
import me.leopold95.testplugin.listeners.mechanics.SightListeners;
import me.leopold95.testplugin.listeners.mechanics.SnowballListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin {
    private static TestPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        Config.register();

        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);

        getServer().getPluginManager().registerEvents(new BowListners(), this);
        getServer().getPluginManager().registerEvents(new SightListeners(), this);
        getServer().getPluginManager().registerEvents(new SnowballListeners(), this);


        getCommand("tchange").setExecutor(new BaseCommnd());
        getCommand("tchange").setTabCompleter(new BaseTabCompliter());

    }

    @Override
    public void onDisable() {
        plugin = null;
    }

    public static TestPlugin getPlugin(){
        return plugin;
    }


}
