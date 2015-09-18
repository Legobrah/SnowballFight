package lego.snowballfight.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import lego.snowballfight.SnowballFight;

public class Join implements CommandExecutor
{
	private SnowballFight snowballFight;
	
	
	public Join(SnowballFight snowballFight)
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
        
        snowballFight.getMatch().joinPlayer(player);
		ItemStack item= new ItemStack(0,0);
		
		item.setAmount(64);
		item.setType(Material.SNOW_BALL);
		player.setItemInHand(item);
    	return true;
    }

}
