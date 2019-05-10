package com.fobcode.wc;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class WorldController extends JavaPlugin{
   public void onEnable() {
	   getLogger().info("WorldController Activated");
   }
   public void onDisable() {
	   getLogger().info("WorldController De-Activated");
   }
   
   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	   if(cmd.getName().equalsIgnoreCase("settime")) {
		   if(!(sender instanceof Player)) {
			   sender.sendMessage(ChatColor.RED + "You cannot set the time unless you are a player!");
			   return true;
		   }
		   if(!(args.length >0)) {
			   sender.sendMessage("You must provide a value for the time!");
			   return true;
		   }
		   String timeValue = args[0];
		   Player p = (Player) sender;
		   World world = p.getWorld();
		   if(timeValue.equalsIgnoreCase("day")) {
			   setTime(world, 4L);
		   }else if(timeValue.equalsIgnoreCase("night")) {
			   setTime(world, 14L);
		   }else {
			   try {
				   setTime(world, Long.parseLong(timeValue));
			   }catch (Exception e) {
				   p.sendMessage(ChatColor.RED + "You must provide a number between 0-24");
				   return true;
			   }
		   }
		   p.sendMessage(ChatColor.GREEN + "You have set the time to " + timeValue);
		   return true;
	   }
	   if(cmd.getName().equalsIgnoreCase("setweather")) {
		   if(!(sender instanceof Player)) {
			   sender.sendMessage(ChatColor.RED + "You cannot set the time unless you are a player!");
			   return true;
		   }
		   if(!(args.length >0)) {
			   sender.sendMessage(ChatColor.RED + "You must provide a value for the time!");
			   return true;
		   }
		   String weatherValue = args[0];
		   Player p = (Player) sender;
		   World world = p.getWorld();
		   if(weatherValue.equalsIgnoreCase("sunny")) {
			   world.setStorm(false);
			   world.setThundering(false);
			  
		   }else if(weatherValue.equalsIgnoreCase("rainy")) {
			   world.setStorm(true);
			   world.setThundering(true);
		   }else if(weatherValue.equalsIgnoreCase("thunder")) {
			   world.setStorm(false);
			   world.setThundering(true);
		   }else {
			   p.sendMessage(ChatColor.RED + "Please provide a value for weather from: Sunny, Rainy or Thunder.");
			   return true;
		   }
		   p.sendMessage(ChatColor.GREEN + "Weather has been set to " + weatherValue);
	   }
	   return true;
   }
   
   public void setTime(World world, Long time) {
	   world.setTime(time*1000);
   }
}
