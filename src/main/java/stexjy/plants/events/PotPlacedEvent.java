package stexjy.plants.events;

import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import stexjy.plants.PlantsMain;
import stexjy.plants.plants.Plant;

public class PotPlacedEvent implements Listener {
	
	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		
		ItemStack item = event.getItemInHand();
		Location loc = event.getBlock().getLocation();
		
		PersistentDataContainer dataCointainer = item.getItemMeta().getPersistentDataContainer();
		String plantName = dataCointainer.get(new NamespacedKey(PlantsMain.getInstance(), "plantName"), PersistentDataType.STRING);
		
		if(plantName == null) return;
		
		Plant plant = getPlantClass(plantName);
		
		if(plant == null) return;
		
		plant.spawn(loc);
		
	}
	
	@SuppressWarnings("deprecation")
	private static Plant getPlantClass(String plantName) {
		
		try {
			
			return (Plant) Class.forName("stexjy.plants.plants." + plantName).newInstance();
		
		} catch (InstantiationException e) {
			
			e.printStackTrace();
			
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		return null;
		
	}
	
}
