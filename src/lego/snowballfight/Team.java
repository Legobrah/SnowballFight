package lego.snowballfight;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
	
	public int getPlayerCount()
	{
		return playerList.size();
	}
	
	public void addPlayer(Player player)
	{
		PlayerInfo playerInfo = new PlayerInfo(player.getName());
		playerList.add(playerInfo);
		
	}
	

}
