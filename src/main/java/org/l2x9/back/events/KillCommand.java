package org.l2x9.back.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class KillCommand implements Listener {
    @EventHandler
    public void onCmd(PlayerCommandPreprocessEvent event) {
        if (!event.getPlayer().isOp()) {
            if (event.getMessage().toLowerCase().startsWith("/kill")) {
                event.setCancelled(true);
                event.getPlayer().setHealth(0);
            }
        }
    }
}
