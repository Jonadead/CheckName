package fr.jonadead.CheckName;


import java.util.Arrays;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CheckName extends JavaPlugin{
	
	private CheckNameListener listener = new CheckNameListener(this);
	
	@Override
	public void onDisable(){
		
		System.out.println("[CheckName] Unloaded !");
	}
	
	@Override
	public void onEnable (){
		
		System.out.println("[CheckName] Loaded !");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(listener, this);
		
		FileConfiguration config = this.getConfig();
		if(!config.contains("players")){
			String[] list = {"player1, replacement, color", "player2, replacement, color"};
		    config.set("players", Arrays.asList(list));
		}
		
		if(config.options().header() != "CheckName v1.0") {
			config.options().header("CheckName v1.0");
		}
		
		this.saveConfig();
	}
	
	
}
