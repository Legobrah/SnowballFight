package lego.snowballfight.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import lego.snowballfight.SnowballFight;

public class SetSpawn implements CommandExecutor
{
	private SnowballFight snowballFight;
	
	
	public SetSpawn(SnowballFight snowballFight)
	{
		this.snowballFight = snowballFight;
	}
	
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) 
    {
    	if (!(sender instanceof Player))
        {
            return false;
        }
        Player player = (Player) sender;
        Location playerLoc = player.getLocation();
        
        if(args[0].equalsIgnoreCase("team1"))
    	{
        	snowballFight.getMatch().getArena().setSpawnLoc1(playerLoc);
    		
    		SnowballFight.log("Team 1 spawn set!");
    		return true;
    	}
    	else if(args[0].equalsIgnoreCase("team2"))
    	{
    		snowballFight.getMatch().getArena().setSpawnLoc2(playerLoc);
    		
    		SnowballFight.log("Team 2 spawn set!");
    		return true;
    	}
    	else
    	{
    		
    		SnowballFight.log("Did not set spawn!");
    		return false;
    	}
    }

}
