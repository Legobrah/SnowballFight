package lego.snowballfight.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import lego.snowballfight.Match;
import lego.snowballfight.SnowballFight;

public class CreateMatch implements CommandExecutor
{
	private SnowballFight snowballFight;
	private int matchID = 0;
	
	public CreateMatch(SnowballFight snowballFight)
	{
		this.snowballFight = snowballFight;
	}
	
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) 
    {
        if(args.length == 2)
        {
        	snowballFight.setMatch(new Match(matchID, args[0], Integer.parseInt(args[1])));
        	matchID++;
        	return true;
        }
        

        return false;
    }

}
