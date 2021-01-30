package me.murrobby.igsq.spigot.main;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.murrobby.igsq.spigot.Common;
import me.murrobby.igsq.spigot.Communication;

public class PlayerQuitEvent_Main implements Listener
{
	public PlayerQuitEvent_Main()
	{
		Bukkit.getPluginManager().registerEvents(this, Common.spigot);
	}
	
	@EventHandler
	public void PlayerQuit_Main(org.bukkit.event.player.PlayerQuitEvent event) 
	{
		Communication.deletePlayer(event.getPlayer());
	}
	
}