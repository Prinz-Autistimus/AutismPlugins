package de.autismclan.changeAccess;

import de.autismclan.maintenance.MaintenancePlugin;
import de.autismclan.maintenance.ServerState;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e)
    {
        if(MaintenancePlugin.getServerState().equals(ServerState.maintenance) && !MaintenancePlugin.getAllowedPlayers().contains(e.getPlayer().getName())) {
            e.getPlayer().kick(Component.text("Der Server befindet sich momentan im Maintenance-Modus"));
        }
    }

}
