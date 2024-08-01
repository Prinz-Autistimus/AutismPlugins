package de.autismclan.changeAccess;

import de.autismclan.maintenance.MaintenancePlugin;
import de.autismclan.maintenance.ServerState;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

public class MaintenanceCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        ServerState currentState = MaintenancePlugin.getServerState();

        if(args.length == 0)
        {
            sender.sendMessage(Component.text("Aktuell befindet sich der Server " + (currentState == ServerState.open ? "nicht " : "") + "im Wartungszustand"));
            return true;
        }

        if(args.length != 1) { return false; }

        String argument = args[0];

        ServerState newState;

        if(argument.equals("on")){
            newState = ServerState.maintenance;
            kickNotAllowedPlayer(MaintenancePlugin.getAllowedPlayers());
        }else if(argument.equals("off")){
            newState = ServerState.open;
        }else {
            return false;
        }

        sender.sendMessage(Component.text("Der Wartunsmodus wird nun " + (newState.equals(ServerState.maintenance) ? "eingeschalten" : "ausgeschalten")));
        MaintenancePlugin.setServerState(newState);
        return true;
    }

    private void kickNotAllowedPlayer(ArrayList<String> player){
        for(Player p : Bukkit.getOnlinePlayers())
        {
            if(!player.contains(p.getName()))
            {
                p.kick(Component.text("Der Server wurde in den Wartungsmodus gestellt"));
            }
        }
    }
}
