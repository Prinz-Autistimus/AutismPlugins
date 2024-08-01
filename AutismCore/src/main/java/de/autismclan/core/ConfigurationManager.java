package de.autismclan.core;


import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class ConfigurationManager {

    private JavaPlugin plugin;
    private FileConfiguration config;

    public ConfigurationManager(JavaPlugin plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public Object get(String key){
        return config.get(key);
    }

    public void set(String key, Object value) {
        config.set(key, value);
    }

    public void load(String path) {
        try {
            config.load(path);
        } catch (InvalidConfigurationException | IOException e) {
            System.err.println("Exception while loading configuration file: " + path);
            e.printStackTrace();
        }
    }

}
