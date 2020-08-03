package me.murrobby.igsq.bungee.main;

import me.murrobby.igsq.bungee.Common_Bungee;
import me.murrobby.igsq.bungee.Database_Bungee;
import me.murrobby.igsq.bungee.Main_Bungee;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ChatEvent_Bungee implements Listener
{
	private Main_Bungee plugin;
	public ChatEvent_Bungee(Main_Bungee plugin)
	{
		this.plugin = plugin;
		ProxyServer.getInstance().getPluginManager().registerListener(plugin, this);
	}
	
	@EventHandler
	public void Chat_Bungee(net.md_5.bungee.api.event.ChatEvent event) 
	{
		//Runs on bungee whenever a chat message is sent
		if(event.getSender() instanceof ProxiedPlayer) 
		{
			ProxiedPlayer player = (ProxiedPlayer) event.getSender();
			if(event.isCommand()) 
			{
				String server = null;
				if(event.isProxyCommand()) 
				{
					server = "PROXY";
				}
				else 
				{
					server = player.getServer().getInfo().getName().toUpperCase();
				}
				System.out.println(Common_Bungee.GetMessage("commandwatch","<player>",player.getName(),"<command>",event.getMessage(),"<server>",server));
				if(!player.hasPermission("igsq.commandwatchbypass"))
				{
					for(ProxiedPlayer selectedPlayer : plugin.getProxy().getPlayers())
					{
						if(selectedPlayer.hasPermission("igsq.commandwatch") && selectedPlayer != player)
						{
							selectedPlayer.sendMessage(new TextComponent(Common_Bungee.ChatColour(Common_Bungee.GetMessage("commandwatch","<player>",player.getName(),"<command>",event.getMessage(),"<server>",server))));
						}
					}
				}
			}
			else
			{
				
				for(ProxiedPlayer selectedPlayer : plugin.getProxy().getPlayers())
				{
					
					if(event.getMessage().contains(selectedPlayer.getName()))
					{
						try
						{
							Database_Bungee.UpdateCommand("INSERT INTO player_command_communicator(command_number,command,uuid,arg1,arg2,arg3) VALUES(null,'sound','"+ selectedPlayer.getUniqueId().toString() +"','BLOCK_NOTE_BLOCK_PLING','1','1');");
							if(selectedPlayer.getServer() != player.getServer()) 
							{
								Database_Bungee.UpdateCommand("INSERT INTO player_command_communicator(command_number,command,uuid,arg1) VALUES(null,'message','"+ selectedPlayer.getUniqueId().toString() +"','" + event.getMessage() +"');");
							}
						}
						catch(Exception exception) 
						{
							
						}
					}
				}
			}
		}
	}
}
