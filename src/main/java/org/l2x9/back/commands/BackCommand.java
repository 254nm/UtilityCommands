package org.l2x9.back.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.l2x9.back.Back;

import java.util.HashMap;

public class BackCommand implements CommandExecutor {
    Back instance;

    public BackCommand(Back back) {
        instance = back;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            HashMap<Player, Location> locationHashMap = instance.deathEvent.deathMap;
            if (locationHashMap.containsKey(player)) {
                player.teleport(locationHashMap.get(player));
                locationHashMap.remove(player);
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Error:&r&c You have not died during this session so you do not have a location to go back to"));
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You must be a player");
        }
        return true;
    }
}
