package org.l2x9.back.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteract implements Listener {
    @EventHandler
    public void onVehicleEnter(PlayerInteractAtEntityEvent event) {
        if (event.getRightClicked() instanceof Llama || event.getRightClicked() instanceof Mule || event.getRightClicked() instanceof Donkey) {
            if ((event.getPlayer().getInventory().getItemInMainHand().getType() == Material.CHEST) || (event.getPlayer().getInventory().getItemInOffHand().getType() == Material.CHEST)) {
                ChestedHorse entity = (ChestedHorse) event.getRightClicked();
                if (entity.getPassenger() == null) {
                    entity.setPassenger(event.getPlayer());
                    event.setCancelled(true);
                    for (ItemStack item : entity.getInventory().getContents()) {
                        if (item != null) {
                            if (!(item.getType() == Material.SADDLE)) {
                                entity.getWorld().dropItemNaturally(entity.getLocation(), item);
                            }
                        }
                    }
                    entity.setCarryingChest(false);
                    sendMessage(event.getPlayer(), "&cChests on llamas, donkeys, mules, Etc is currently disabled, this is to facilitate the SalC1 TreeMC dupe");
                }
            }
        }
    }
    private void sendMessage(Player player, String message) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
}
