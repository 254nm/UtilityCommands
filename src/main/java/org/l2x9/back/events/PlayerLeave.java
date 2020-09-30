package org.l2x9.back.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.l2x9.back.Back;

public class PlayerLeave implements Listener {
    Back instance;
    public PlayerLeave(Back back) {
        instance = back;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        instance.deathEvent.deathMap.remove(event.getPlayer());
    }
}
