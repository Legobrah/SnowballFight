package lego.snowballfight;

import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class MatchListener implements Listener
{
	private SnowballFight snowballFight;
	
	public MatchListener(SnowballFight snowballFight)
	{
		this.snowballFight = snowballFight;
	}

	
	/**
	 * Executed when a player kills another player
	 * 
	 * @param event The player kill event.
	 */
	@EventHandler
	public void onPlayerKill(EntityDeathEvent event)
	{
		if(event.getEntity() instanceof Player)
		{
			Player player = (Player) event.getEntity();
			Player killer = (Player) event.getEntity().getKiller();
			
			snowballFight.getMatch().onPlayerKill(killer, player);
		}
	}
	
	@EventHandler
	public void onSnowballHitPlayer(EntityDamageByEntityEvent event)
	{
		if(event.getDamager() instanceof Snowball)
		{
			
			event.setDamage(4);
		}
	}
	
	/**
	 * Teleports player to their spawn point on respawn
	 * 
	 * @param event The respawn event
	 */
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event)
	{
		Player player = event.getPlayer();
		
		if(snowballFight.getMatch() != null)
		{
			if(snowballFight.getMatch().getPlayerTeam(player) != null)
			{
				if(snowballFight.getMatch().getSpawnLoc(player) != null)
				{
					event.setRespawnLocation(snowballFight.getMatch().getSpawnLoc(player));
				}
			}
		}
	}
	
	

}
