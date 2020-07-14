package me.murrobby.igsq.spigot.expert;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.murrobby.igsq.spigot.Common_Spigot;
import me.murrobby.igsq.spigot.Main_Spigot;

import org.bukkit.Material;
import java.util.Random;

public class BlockSpreadEvent_Expert implements Listener
{
	Random random = new Random();
	public BlockSpreadEvent_Expert(Main_Spigot plugin)
	{
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void BlockSpread_Expert(org.bukkit.event.block.BlockSpreadEvent event) 
	{
		if(Common_Spigot.ExpertCheck() && (!event.isCancelled())) 
		{
			if(event.getSource().getBlockData().getMaterial() == Material.FIRE) 
			{
				if(random.nextInt(25) == 1) 
				{
					event.getSource().setType(Material.SOUL_FIRE);
				}
				else if(random.nextInt(3) == 1) 
				{
					event.getSource().setType(Material.FIRE);
				}
			}
		}
	}
	
}