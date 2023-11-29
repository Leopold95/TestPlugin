package me.leopold95.testplugin.core;

import java.io.File;
import java.io.IOException;

import me.leopold95.testplugin.TestPlugin;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {
	private static File configFile;
	private static FileConfiguration cfg;

	public static String getString(String path){
		return cfg.getString(path);
	}

	public static int getInt(String path){
		return cfg.getInt(path);
	}

	public static double getDouble(String path){
		return cfg.getDouble(path);
	}

	public static void register(){
		createConfigFile("config.yml");
	}

	private static void createConfigFile(String file){
		configFile = new File(TestPlugin.getPlugin().getDataFolder(), file);
		if(!configFile.exists()){
			configFile.getParentFile().mkdirs();
			TestPlugin.getPlugin().saveResource(file, false);
		}
		YamlConfiguration config = new YamlConfiguration();
		try {
			config.load(configFile);
			config.save(configFile);
		}catch (IOException | InvalidConfigurationException exp){
			exp.printStackTrace();
		}
	}

}
