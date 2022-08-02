package com.gorillabit.ngwordsplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class NGwordsPlugin extends JavaPlugin {

    public static NGwordsPlugin plugin;

    @Override
    public void onEnable() {
        Map<String, String> ngwordsmap = null;
        // Plugin startup logic
        Path path = Paths.get("test.csv");
        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            ngwordsmap = lines.stream().collect(Collectors.toMap(
                    s -> s.split(",")[0],
                    s -> s.split(",")[1]));
        } catch (IOException ex) {
            Bukkit.broadcastMessage(String.valueOf(ex));
        }
        plugin = this;
        Bukkit.getServer().getPluginManager().registerEvents(new ChatEventListenerClass(ngwordsmap), this);
    }

    public static NGwordsPlugin getPlugin() {
        return plugin;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
