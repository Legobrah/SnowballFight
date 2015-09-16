package lego.snowballfight;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class SnowballFight extends JavaPlugin
{
	public final Logger log = Logger.getLogger("Minecraft");
	
	
	@Override
	public void onEnable()
	{
		PluginDescriptionFile pdfFile = this.getDescription();
        log.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " has been Enabled!");
        
	}
	
	@Override
	public void onDisable()
	{
		PluginDescriptionFile pdfFile = this.getDescription();
        log.info(pdfFile.getName() + " has been Disabled!");
        
	}
}
