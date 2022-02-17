package stexjy.plants.item;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import net.md_5.bungee.api.ChatColor;
import stexjy.plants.PlantsMain;
import stexjy.plants.plants.PlantsType;

public class ItemManager {
	
	public static void givePlantItem(Player player, String stringType) {
		
		PlantsType type = PlantsType.valueOf(stringType);
		
		if(player.getInventory().firstEmpty() == -1) return;
		
		player.getInventory().addItem(getPlantItemStack(type));
		
	}
	
	@SuppressWarnings("deprecation")
	public static ItemStack getPlantItemStack(PlantsType type) {
		
		ItemStack item = new ItemStack(Material.LEGACY_FLOWER_POT_ITEM);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.GREEN + type.getName());
		
		item.setItemMeta(meta);
		
		return item;
		
	}
	
	public static void setDataContainer(ItemMeta meta, String stringPlantsType) {
		
		PersistentDataContainer dataContainer = meta.getPersistentDataContainer();
		
		NamespacedKey key = new NamespacedKey(PlantsMain.getInstance(), "plant");
		
		dataContainer.set(key, PersistentDataType.STRING, stringPlantsType);
		
	}
	
}
