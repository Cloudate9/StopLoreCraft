package me.awesomemoder316.stoplorecraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onCraft(PrepareItemCraftEvent e) {
        if (e.getRecipe() == null) return;
        for (ItemStack i:e.getInventory().getMatrix()) {
            if (i != null && i.hasItemMeta() && i.getItemMeta().hasLore()) {
                e.getInventory().setResult(new ItemStack(Material.AIR));
                for (HumanEntity ent:e.getViewers()) {
                    ent.sendMessage(ChatColor.RED + "One of your crafting ingredients has lore! Replace it with a vanilla item!");
                }
                return;
            }
        }
    }
}
