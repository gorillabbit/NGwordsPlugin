package com.gorillabit.ngwordsplugin;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;

public class ChatEventListenerClass implements Listener{

    public ChatEventListenerClass(Map<String, String> ngwordsmap) { //IntellJに言われるまま作ったクラス。なにこれ
    }

    @EventHandler
    public void onEveryChat(AsyncPlayerChatEvent e){ //ここに変数を渡したい。どうすればいい
        String message = e.getMessage();
        String player = e.getPlayer().getName();
        Path path = Paths.get("test.csv");
        System.out.println("####ngwordsmap.get(player) = "+ngwordsmap.get(player)); //問題のエラー部分「シンボル 'ngwordsmap' を解決できません」
            System.out.println("####message = "+message);
            if(Objects.equals(ngwordsmap.get(player), message)){
                Bukkit.broadcastMessage(player+"がNGワードを言いました");
                e.getPlayer().setHealth(0.0);
            }
    }
}
