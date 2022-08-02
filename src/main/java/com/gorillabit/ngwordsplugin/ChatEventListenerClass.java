package com.gorillabit.ngwordsplugin;

import com.google.common.base.Present;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ChatEventListenerClass implements Listener{

    public ChatEventListenerClass(Map<String, String> ngwordsmap) {
    }

    @EventHandler
    public void onEveryChat(AsyncPlayerChatEvent e){
        String message = e.getMessage();
        String player = e.getPlayer().getName();
        Path path = Paths.get("test.csv");
        System.out.println("####ngwordsmap.get(player) = "+ngwordsmap.get(player));
            System.out.println("####message = "+message);
            if(Objects.equals(ngwordsmap.get(player), message)){
                Bukkit.broadcastMessage(player+"がNGワードを言いました");
                e.getPlayer().setHealth(0.0);
            }
    }
}
