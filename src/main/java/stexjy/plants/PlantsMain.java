package stexjy.plants;

import org.bukkit.plugin.java.JavaPlugin;

import stexjy.plants.commands.PlantsCommand;

public class PlantsMain extends JavaPlugin {
	
	private static PlantsMain instance;
	
	public void onEnable() {
		
		instance = this;
		
		registerCommands();
		
	}
	
	public static PlantsMain getInstance() {
		
		return instance;
		
	}
	
	public void registerCommands() {
		
		getCommand("plants").setExecutor(new PlantsCommand());
		
	}
	
}
