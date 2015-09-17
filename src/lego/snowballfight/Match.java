package lego.snowballfight;

import org.bukkit.entity.Player;

public class Match
{
	private int id;
	public int getMatchID(){return id;}
	
	private Arena arena;
	public String getArenaName(){return arena.getArenaName();}
	
	private Team team1;
	public String getTeam1Name(){return team1.getTeamName();}
	
	private Team team2;
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
	public Match(int matchID,String arenaName, String team1Name, String team2Name, int maxTeamSize)
	{
		id = matchID;
		this.arena = new Arena(arenaName);
		this.team1 = new Team(team1Name, maxTeamSize);
		this.team2 = new Team(team2Name, maxTeamSize);
		
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
	 * Adds player to the appropriate team
	 * 
	 * @param player The player to add to the team
	 */
	public void joinPlayer(Player player)
	{
		Team teamToJoin = getTeamToJoin();
		teamToJoin.addPlayer(player);
	}
	
	
	

}
