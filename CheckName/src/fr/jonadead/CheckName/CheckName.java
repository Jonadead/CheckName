package fr.jonadead.CheckName;

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
		if(!config.contains("Names")){
			config.set("Names", "Player");
		}
		if(!config.contains("Replace by")){
			config.set("Replace by", "@Player");
		}
		if(!config.contains("Color")){
			config.set("Color", "AQUA");
		}
		config.set("Names", config.getString("Names").toLowerCase());
		
		if(config.options().header() != "CheckName v1.0") {
			config.options().header("CheckName v1.0");
		}
		
		this.saveConfig();
	}
	
	
}
