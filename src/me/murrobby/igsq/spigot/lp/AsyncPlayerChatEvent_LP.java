package me.murrobby.igsq.spigot.lp;


import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.murrobby.igsq.shared.Common_Shared;
import me.murrobby.igsq.spigot.Common;
import me.murrobby.igsq.spigot.YamlPlayerWrapper;
import me.murrobby.igsq.spigot.YamlWrapper;
import me.murrobby.igsq.spigot.Messaging;

public class AsyncPlayerChatEvent_LP implements Listener
{
	public AsyncPlayerChatEvent_LP()
	{
		Bukkit.getPluginManager().registerEvents(this, Common.spigot);
	}
	
	@EventHandler
	public void AsyncPlayerChat_Main(AsyncPlayerChatEvent event) 
	{
		//Player Chat Capturing
		if(!event.isCancelled()) 
		{
			YamlPlayerWrapper yaml = new YamlPlayerWrapper(event.getPlayer());
			if(Common.isCurrentChatController("mainlp", event.getPlayer())) 
			{
				
				String name = event.getPlayer().getName();
				if(yaml.isLinked()) name = yaml.getNickname();
				event.setFormat((Messaging.getFormattedMessage("message", new String[] {"<server>",YamlWrapper.getServerName(), "<prefix>",Common_LP.getPrefix(event.getPlayer()) , "<player>", name,"<suffix>",Common_Shared.removeNull(Common_LP.getSuffix(event.getPlayer())), "<message>", event.getMessage()})));
			}
		}
	}
}
