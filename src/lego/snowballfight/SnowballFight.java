package lego.snowballfight;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class SnowballFight extends JavaPlugin
{
	public final Logger log = Logger.getLogger("Minecraft");
	private int matchID = 0;
	private Match mainMatch;
	
	
	@Override
	public void onEnable()
	{
		PluginDescriptionFile pdfFile = this.getDescription();
        log.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " has been Enabled!");
        getCommand("creatematch").setExecutor(this);
        System.out.println("debug");
        
	}
	
	@Override
	public void onDisable()
	{
		PluginDescriptionFile pdfFile = this.getDescription();
        log.info(pdfFile.getName() + " has been Disabled!");
        
	}
	
	public static void log(String string)
	{
		System.out.println(string);
	}
	
	//Temporary code for debuging
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) 
    {
        if (!(sender instanceof Player))
        {
            return false;
        }
        
        Player player = (Player) sender;
        

        if(cmd.getName().equalsIgnoreCase("creatematch"))
        {

        	if(args.length == 4)
        	{
        		mainMatch = new Match(matchID, args[0], args[1],args[2], Integer.parseInt(args[3]));
        	}
        	
        	matchID++;
        	return true;
        	
        }
        else if(cmd.getName().equalsIgnoreCase("join"))
        {
        	mainMatch.joinPlayer(player);
        }
        
        return false;
        
    }


        
}
