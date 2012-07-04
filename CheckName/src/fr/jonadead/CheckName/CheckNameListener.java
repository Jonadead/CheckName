package fr.jonadead.CheckName;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class CheckNameListener implements Listener{
	
	private CheckName plugin;
	public CheckNameListener(CheckName plugin){
		this.plugin = plugin;
		
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerChat(PlayerChatEvent event){
		
		FileConfiguration config = plugin.getConfig();
		
		String[] Names = config.getString("Names").split(", ");
		String[] Replaces = config.getString("Replace by").split(", ");
		String[] RepColor = config.getString("Color").split(", ");

		for(int i = 0;i<Names.length;i++){
			String name = Names[i];
			
			String origine = event.getMessage().toLowerCase();
			if(origine.contains(name.toLowerCase())){
				String replace = Replaces[i];
				ChatColor color = getColor(RepColor[i]);
				
				String newmessage = origine.replace(name, color + replace + ChatColor.RESET);
				event.setMessage(newmessage);
			}
		}   
	}
	
	public ChatColor getColor(String string){
		ChatColor color;
		
		if(string.equalsIgnoreCase("BLACK")){
			color = ChatColor.BLACK;
			
		}else if(string.equalsIgnoreCase("DARK_BLUE")){
			color = ChatColor.DARK_BLUE;
			
		}else if(string.equalsIgnoreCase("DARK_GREEN")){
			color = ChatColor.DARK_GREEN;
			
		}else if(string.equalsIgnoreCase("DARK_AQUA")){
			color = ChatColor.DARK_AQUA;
			
		}else if(string.equalsIgnoreCase("DARK_RED")){
			color = ChatColor.DARK_RED;
			
		}else if(string.equalsIgnoreCase("DARK_PURPLE")){
			color = ChatColor.DARK_PURPLE;
			
		}else if(string.equalsIgnoreCase("GOLD")){
			color = ChatColor.GOLD;
			
		}else if(string.equalsIgnoreCase("GRAY")){
			color = ChatColor.GRAY;
			
		}else if(string.equalsIgnoreCase("DARK_GRAY")){
			color = ChatColor.DARK_GRAY;
			
		}else if(string.equalsIgnoreCase("BLUE")){
			color = ChatColor.BLUE;
			
		}else if(string.equalsIgnoreCase("GREEN")){
			color = ChatColor.GREEN;
			
		}else if(string.equalsIgnoreCase("AQUA")){
			color = ChatColor.AQUA;
			
		}else if(string.equalsIgnoreCase("RED")){
			color = ChatColor.RED;
			
		}else if(string.equalsIgnoreCase("LIGHT_PURPLE")){
			color = ChatColor.LIGHT_PURPLE;
			
		}else if(string.equalsIgnoreCase("YELLOW")){
			color = ChatColor.YELLOW;
			
		}else if(string.equalsIgnoreCase("WHITE")){
			color = ChatColor.WHITE;
			
		}else if(string.equalsIgnoreCase("MAGIC")){
			color = ChatColor.MAGIC;
			
		}else if(string.equalsIgnoreCase("BOLD")){
			color = ChatColor.BOLD;
			
		}else if(string.equalsIgnoreCase("STRIKETHROUGH")){
			color = ChatColor.STRIKETHROUGH;
			
		}else if(string.equalsIgnoreCase("UNDERLINE")){
			color = ChatColor.UNDERLINE;
			
		}else if(string.equalsIgnoreCase("ITALIC")){
			color = ChatColor.ITALIC;
			
		}else return ChatColor.RESET;
		return color;
		
	}
	
}
