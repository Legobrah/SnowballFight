package lego.snowballfight;

import org.bukkit.Location;

public class Arena
{
	private String arenaName;
	public String getArenaName(){return arenaName;}
	public void setArenaName(String newName){arenaName = newName;}
	
	private Location team1Spawn;
	public Location getSpawnLoc1(){return team1Spawn;}
	public void setSpawnLoc1(Location newLoc1){team1Spawn = newLoc1;}
	
	private Location team2Spawn;
	public Location getSpawnLoc2(){return team2Spawn;}
	public void setSpawnLoc2(Location newLoc2){team2Spawn = newLoc2;}
	
	
	public Arena(String arenaName)
	{
		this.arenaName = arenaName;
		
	}
	
	
}
