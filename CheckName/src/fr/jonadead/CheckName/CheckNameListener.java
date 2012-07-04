package fr.jonadead.CheckName;

import java.util.List;

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
		
		List<String> players = config.getStringList("players");

		for(int i = 0 ; i < players.size() ; i++){
			
			String[] checked_player = players.get(i).split(", ");
			checked_player[0] = checked_player[0].toLowerCase();
			String origine = event.getMessage().toLowerCase();
			String[] org_split = null;
			if(origine.contains(" ")){
				org_split = origine.split(" ");
				
				for(int j = 0 ; j < org_split.length ; j++){
				
					if(org_split[j].equals(checked_player[0].toLowerCase())){
					
						ChatColor color = getColor(checked_player[2]);
						String newmessage = origine.replace(checked_player[0], color + checked_player[1] + ChatColor.RESET);
						event.setMessage(newmessage);
					}
				}	
			}
			else{
				
				if(origine.equals(checked_player[0].toLowerCase())){
					
					ChatColor color = getColor(checked_player[2]);
					String newmessage = origine.replace(checked_player[0], color + checked_player[1] + ChatColor.RESET);
					event.setMessage(newmessage);
				}
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
