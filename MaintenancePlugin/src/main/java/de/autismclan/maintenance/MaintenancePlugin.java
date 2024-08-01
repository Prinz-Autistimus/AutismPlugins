package de.autismclan.maintenance;

import de.autismclan.changeAccess.MaintenanceCommand;
import de.autismclan.changeAccess.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class MaintenancePlugin extends JavaPlugin {

    private static ServerState serverState = ServerState.open;
    private static ArrayList<String> allowedPlayers = new ArrayList<>();

    @Override
    public void onEnable() {
        allowedPlayers.add("HandyDandy04");

        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        this.getCommand("maintenance").setExecutor(new MaintenanceCommand());
    }

    public static ServerState getServerState(){
        return serverState;
    }

    public static void setServerState(ServerState newState) {
        serverState = newState;
    }

    public static ArrayList<String> getAllowedPlayers(){
        return allowedPlayers;
    }

}

