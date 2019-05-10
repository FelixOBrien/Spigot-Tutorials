package com.fobcode.tp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Teleporter extends JavaPlugin{
	   public void onEnable() {
		   getLogger().info("Teleporter Activated");
	   }
	   public void onDisable() {
		   getLogger().info("Teleporter De-Activated");
	   }
	   
	   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		   if(cmd.getName().equalsIgnoreCase("goto")) {
			   if(!(sender instanceof Player)) {
				   sender.sendMessage(ChatColor.RED + "You msut be a player to teleport!");
				   return true;
			   }
			  if(!(args.length > 0)) {
				   sender.sendMessage(ChatColor.RED + "Please provide a player to teleport to!");
				   return true;
			  }
			  Player p = (Player) sender;
			  Player togo = Bukkit.getServer().getPlayer(args[0]);
			  if(togo != null) {
				  Location l = togo.getLocation();
				  p.teleport(l);
				  p.sendMessage(ChatColor.GREEN + "You have been teleported to this location");
				  return true;
			  }
			  p.sendMessage(ChatColor.RED + "Please provide an online player!");
			  return true;
		   }
		   if(cmd.getName().equalsIgnoreCase("cometo")) {
			   if(!(sender instanceof Player)) {
				   sender.sendMessage(ChatColor.RED + "You msut be a player to teleport!");
				   return true;
			   }
			  if(!(args.length > 0)) {
				   sender.sendMessage(ChatColor.RED + "Please provide a player to teleport to!");
				   return true;
			  }
			  Player p = (Player) sender;
			  Player cometo = Bukkit.getServer().getPlayer(args[0]);
			  if(cometo != null) {
				  Location l = p.getLocation();
				  cometo.teleport(l);
				  p.sendMessage(ChatColor.GREEN + args[0]+" Has been teleported to your location.");
				  cometo.sendMessage(ChatColor.GREEN + "You have been teleported");
				  return true;
			  }
			  p.sendMessage(ChatColor.RED + "Please provide an online player!");
			  return true;
		   }
		   if(cmd.getName().equalsIgnoreCase("gorandom")) {
			   if(!(sender instanceof Player)) {
				   sender.sendMessage(ChatColor.RED + "You msut be a player to teleport!");
				   return true;
			   }
			  Player p = (Player) sender;
			  	  int x = (int) (Math.random() *1000);
			  	  int z = (int) (Math.random() *1000);
			  	  int y = p.getWorld().getHighestBlockYAt(x, z);
			 
				  Location l = new Location(p.getWorld(), x, y, z);
				  p.teleport(l);
				  p.sendMessage(ChatColor.GREEN + "You have been teleported to a random location!");
				  return true;
		   }
		   return true;
	   }
}
