package lego.snowballfight;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Team
{
	private String teamName;
	public String getTeamName(){return teamName;}
	
	private int maxPlayers;
	public int getMaxPlayers(){return maxPlayers;}
	
	private List<UUID> playerList = new ArrayList<UUID>();
	public List<UUID> getPlayer(){return playerList;}
	
	public Team(String teamName, int maxPlayers)
	{
		this.teamName = teamName;
		this.maxPlayers = maxPlayers;
		
	}
	
	public int getPlayerCount()
	{
		return playerList.size();
	}
	

}
