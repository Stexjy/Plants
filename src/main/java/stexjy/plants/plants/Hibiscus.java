package stexjy.plants.plants;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

public class Hibiscus implements Plant {
	
	public void spawn(Location l) {
		
		for(int angle = 0; angle < 360; angle+=10) {
			
			double x = Math.sin(Math.toRadians(angle));
			double z = Math.cos(Math.toRadians(angle));
			
			Location tempLoc = l.clone().add(x, 0 , z);
			
			ArmorStand armorStand = (ArmorStand) l.getWorld().spawnEntity(tempLoc, EntityType.ARMOR_STAND);
			EntityEquipment equipment = armorStand.getEquipment();
			
			armorStand.setInvisible(true);
			armorStand.setGravity(false);
			armorStand.setSmall(false);
			
			armorStand.setRotation(0, angle);
			
			equipment.setHelmet(new ItemStack(Material.OAK_LEAVES));
			
			
			
		}
		
	}
	
}
