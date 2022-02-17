package stexjy.plants.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import stexjy.plants.commands.utils.CommandStringUtils;
import stexjy.plants.item.ItemManager;
import stexjy.plants.plants.PlantsType;

public class PlantsCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(args.length == 0) {
			
			sender.sendMessage(CommandStringUtils.getHelp());
			
			return false;
			
		}
		
		if(args[0].equalsIgnoreCase("giveplant")) givePlant(sender, command, label, args);
		
		return false;
	}
	
	public void givePlant(CommandSender sender, Command command, String label, String[] args) {
		
		if(args.length != 3) {
			
			sender.sendMessage(CommandStringUtils.invalidArgs());
			
			return;
			
		}
		
		Player player = Bukkit.getPlayer(args[1]);
		
		if(player == null) {
			    
			sender.sendMessage(ChatColor.RED + "The given player is not online!");
			
			return;
			
		}
		
		if(!PlantsType.exists(args[2].toUpperCase())) {
			//TODO scrivere quali sono i plant types
			sender.sendMessage(ChatColor.RED + "Invalid plant type.");
			
			return;
			
		}
		
		ItemManager.givePlantItem(player, args[2].toUpperCase());
		
	}
	
}
