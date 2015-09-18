package lego.snowballfight;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Match
{
	private int id;
	public int getMatchID(){return id;}
	
	private Arena arena;
	public Arena getArena(){return arena;}
	public String getArenaName(){return arena.getArenaName();}
	
	private Team team1;
	public Team getTeam1(){return team1;}
	public String getTeam1Name(){return team1.getTeamName();}
	
	private Team team2;
	public Team getTeam2(){return team2;}
	public String getTeam2Name(){return team2.getTeamName();}
	
	private int maxTeamSize;
	public int getMaxTeamSize(){return maxTeamSize;}
	
	
	/**
	 * Creates a match using the specified arena and team names, and sets the max players for both teams
	 * 
	 * @param arenaName This is the name of the arena
	 * @param team1Name This is the name of team 1
	 * @param team2Name This is the name of team 2
	 * @param maxTeamSize This is the player limit for both teams
	 */
	public Match(int matchID,String arenaName, int maxTeamSize)
	{
		id = matchID;
		this.arena = new Arena(arenaName);
		this.team1 = new Team("Team1", maxTeamSize);
		this.team2 = new Team("Team2", maxTeamSize);
		
		System.out.println("Created match id: " + id);
		
	}
	
	/**
	 * Checks which team the player should join
	 * 
	 * @return The team that the player should join
	 */
	private Team getTeamToJoin()
	{
		if(team1.getPlayerCount() > team2.getPlayerCount())
		{
			return team1;
		}
		else
		{
			return team2;
		}
		
		
	}
	
	/**
	 * Gets the team that the specified player is on
	 * 
	 * @param player The player to check
	 * @return The team that the player is on
	 */
	public Team getPlayerTeam(Player player)
	{
		if(team1.checkIfOnTeam(player))
		{
			return team1;
		}
		else if(team2.checkIfOnTeam(player))
		{
			return team2;
		}
		else
		{
			SnowballFight.log(player.getName() + " has no team!");
			
			return null;
		}
	}
	
	/**
	 * Adds player to the appropriate team
	 * 
	 * @param player The player to add to the team
	 */
	public void joinPlayer(Player player)
	{
		Team teamToJoin = getTeamToJoin();
		teamToJoin.addPlayer(player);
		teleportPlayer(player);
	}
	
	/**
	 * Teleports player to their team spawn
	 * 
	 * @param player The player that is being teleported
	 */
	public void teleportPlayer(Player player)
	{
		Team playerTeam = getPlayerTeam(player);
		
		if(playerTeam.getTeamName() == "Team1" && checkIfSpawnValid(arena.getSpawnLoc1()))
		{
			player.teleport(arena.getSpawnLoc1());
		}
		else if(playerTeam.getTeamName() == "Team2" && checkIfSpawnValid(arena.getSpawnLoc2()))
		{
			player.teleport(arena.getSpawnLoc2());
		}
		else
		{
			SnowballFight.log("Player has no team!");
		}
	}
	
	/**
	 * Checks to see is location is valid
	 * 
	 * @param loc The location you are checking
	 * @return True if valid, else false
	 */
	private boolean checkIfSpawnValid(Location loc)
	{
		if(loc != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	

}
