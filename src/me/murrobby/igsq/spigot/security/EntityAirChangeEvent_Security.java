package me.murrobby.igsq.spigot.security;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.murrobby.igsq.spigot.Main_Spigot;

public class EntityAirChangeEvent_Security implements Listener
{
	public EntityAirChangeEvent_Security(Main_Spigot plugin)
	{
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void EntityAirChange_Security(org.bukkit.event.entity.EntityAirChangeEvent event) 
	{
		if(!event.isCancelled()) 
		{
			if(event.getEntity() instanceof Player) 
			{
				Player player = (Player) event.getEntity();
				if (Common_Security.SecurityProtectionQuery(player)) event.setAmount(300);
			}
		}
	}
	
}
