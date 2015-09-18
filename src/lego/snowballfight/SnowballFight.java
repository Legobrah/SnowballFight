package lego.snowballfight;

import java.util.logging.Logger;

import org.bukkit.Location;
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
		System.out.println("[SnowballFight] " + string);
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
        Location playerLoc = player.getLocation();
        

        if(cmd.getName().equalsIgnoreCase("creatematch"))
        {

        	if(args.length == 2)
        	{
        		mainMatch = new Match(matchID, args[0], Integer.parseInt(args[1]));
        	}
        	
        	matchID++;
        	return true;
        	
        }
        else if(cmd.getName().equalsIgnoreCase("join"))
        {
        	mainMatch.joinPlayer(player);
        }
        else if(cmd.getName().equalsIgnoreCase("setspawn"))
        {
        	if(args[0].equalsIgnoreCase("team1"))
        	{
        		mainMatch.getArena().setSpawnLoc1(playerLoc);
        		
        		log("Team 1 spawn set!");
        	}
        	else if(args[0].equalsIgnoreCase("team2"))
        	{
        		mainMatch.getArena().setSpawnLoc2(playerLoc);
        		
        		log("Team 2 spawn set!");
        	}
        }
        
        return false;
        
    }


        
}
