package lego.snowballfight;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SnowballFight extends JavaPlugin
{
	private int matchID = 0;
	private Match mainMatch;
	
	
	@Override
	public void onEnable()
	{
		log("is now loaded...");
        getCommand("creatematch").setExecutor(this);
        getCommand("join").setExecutor(this);
        getCommand("setspawn").setExecutor(this);
        
	}
	
	@Override
	public void onDisable()
	{
        log("is now disabled...");
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
        	else
        	{
        		log("Did not set spawn!");
        	}
        }
        
        return false;
        
    }


        
}
