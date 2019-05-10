package com.focode.medic;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Medic extends JavaPlugin implements Listener{
	
	public void onEnable() {
		getLogger().info("Medic Enabled");
		
	}
	public void onDisable() {
		getLogger().info("Medic Disabled");
	}
	public boolean onCommand(CommandSender Sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("fullhealth")) {
			if(!(Sender instanceof Player)) {
				Sender.sendMessage(ChatColor.DARK_RED + "You cannot heal if you are not a player");
				return true;
			}
			Player p = (Player) Sender;
			p.setHealth(20);
			p.sendMessage(ChatColor.GREEN + "You have full hearts!");
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("fullhunger")) {
			if(!(Sender instanceof Player)) {
				Sender.sendMessage(ChatColor.DARK_RED + "You cannot feed if you are not a player");
				return true;
			}
			Player p = (Player) Sender;
			p.setFoodLevel(20);
			p.sendMessage(ChatColor.GREEN + "You have full hunger!");
			return true;
		}
		return true;
	}
	
}
