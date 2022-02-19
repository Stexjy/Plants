package stexjy.plants;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import stexjy.plants.commands.PlantsCommand;
import stexjy.plants.events.PotPlacedEvent;

public class PlantsMain extends JavaPlugin {
	
	private static PlantsMain instance;
	
	public void onEnable() {
		
		instance = this;
		
		registerCommands();
		registerEvents();
		
	}
	
	public static PlantsMain getInstance() {
		
		return instance;
		
	}
	
	private void registerCommands() {
		
		getCommand("plants").setExecutor(new PlantsCommand());
		
	}
	
	private void registerEvents() {
		
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new PotPlacedEvent(), this);
		
	}
	
}
