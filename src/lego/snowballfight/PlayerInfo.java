package lego.snowballfight;

public class PlayerInfo
{
	private String name;
	public String getName(){return name;}
	
	private int kills;
	public int getKills(){return kills;}
	public void addkill(int kills){this.kills += kills;}
	
	private int deaths;
	public int getDeaths(){return deaths;}
	public void addDeath(int deaths){this.deaths += deaths;}
	
	public PlayerInfo(String name)
	{
		this.name = name;
		this.kills = 0;
		this.deaths = 0;
	}
	

}
