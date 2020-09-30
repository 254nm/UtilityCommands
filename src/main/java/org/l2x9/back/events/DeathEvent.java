package org.l2x9.back.events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashMap;

public class DeathEvent implements Listener {
    public HashMap<Player, Location> deathMap = new HashMap<>();

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        deathMap.put(event.getEntity(), event.getEntity().getLocation());
        event.getEntity().sendMessage(ChatColor.RED + "Use /back to return to your death point");
    }
}
