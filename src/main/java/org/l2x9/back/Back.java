package org.l2x9.back;

import org.bukkit.plugin.java.JavaPlugin;
import org.l2x9.back.commands.BackCommand;
import org.l2x9.back.events.DeathEvent;
import org.l2x9.back.events.KillCommand;
import org.l2x9.back.events.PlayerInteract;
import org.l2x9.back.events.PlayerLeave;

import java.util.Objects;

public final class Back extends JavaPlugin {
    public DeathEvent deathEvent = new DeathEvent();
    /*
    @author 254n_m
    @contact 254n-m#5890
    @site https://www.l2x9.org/
     */

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
        getServer().getPluginManager().registerEvents(deathEvent, this);
        Objects.requireNonNull(getCommand("back")).setExecutor(new BackCommand(this));
        getServer().getPluginManager().registerEvents(new KillCommand(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(this), this);

    }
}
