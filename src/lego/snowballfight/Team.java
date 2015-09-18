package lego.snowballfight;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class Team
{
	private String teamName;
	public String getTeamName(){return teamName;}
	public void setTeamName(String teamName){this.teamName = teamName;}
	
	private int maxPlayers;
	public int getMaxPlayers(){return maxPlayers;}
	public void setMaxPlayer(int maxPlayers){this.maxPlayers = maxPlayers;}
	
	private List<PlayerInfo> playerList = new ArrayList<PlayerInfo>();
	public List<PlayerInfo> getPlayer(){return playerList;}
	
	public Team(String teamName, int maxPlayers)
	{
		this.teamName = teamName;
		this.maxPlayers = maxPlayers;
		
	}
	
	/**
	 * Get count of number of players on the team
	 * 
	 * @return the amount of players on the team
	 */
	public int getPlayerCount()
	{
		return playerList.size();
	}
	
	/**
	 * Adds specified player to the team
	 * 
	 * @param player The player being added to the team
	 */
	public void addPlayer(Player player)
	{
		PlayerInfo playerInfo = new PlayerInfo(player.getName());
		playerList.add(playerInfo);
		
	}
	
	/**
	 * Check to see if the specified player is on the team
	 * 
	 * @param player The player being checked
	 * @return If true, player is on team, else player is not on team
	 */
	public boolean isOnTeam(Player player)
	{
		for(PlayerInfo playerInfo : playerList)
		{
			if(playerInfo.isNamed(player.getName()))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Get the PlayerInfo of a specified player
	 * 
	 * 
	 * @param player The player you want the info for.
	 * @return If true, returns player info, else null
	 */
	public PlayerInfo getPlayerInfo(Player player)
	{
		
		for(PlayerInfo playerInfo : playerList)
		{
			if(playerInfo.isNamed(player.getName()))
			{
				return playerInfo;
			}
		}
		return null;
	}
	

}
