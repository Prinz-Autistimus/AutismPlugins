package de.autismclan.listener;

import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e)
    {
        Component msg = Component.text("Hallo " + e.getPlayer().getName() + ", du alter HUAN");
        e.joinMessage(msg);
    }

}
