package lego.snowballfight;

import org.bukkit.Location;

public class Arena
{
	private String arenaName;
	public String getArenaName(){return arenaName;}
	public void setArenaName(String newName){arenaName = newName;}
	
	private Location arenaSpawn1;
	public Location getSpawnLoc1(){return arenaSpawn1;}
	public void setSpawnLoc1(Location newLoc1){arenaSpawn1 = newLoc1;}
	
	private Location arenaSpawn2;
	public Location getSpawnLoc2(){return arenaSpawn2;}
	public void setSpawnLoc2(Location newLoc2){arenaSpawn1 = newLoc2;}
	
	
	public Arena(String arenaName, Location arenaSpawn1, Location arenaSpawn2)
	{
		this.arenaName = arenaName;
		this.arenaSpawn1 = arenaSpawn1;
		this.arenaSpawn2 = arenaSpawn2;
		
	}
	
	
}
