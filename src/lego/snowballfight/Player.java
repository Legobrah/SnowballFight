package lego.snowballfight;

public class Player
{
	private String name;
	public String getName(){return name;}
	
	private int kills;
	public int getKills(){return kills;}
	public void addkill(int kills){this.kills += kills;}
	
	private int deaths;
	public int getDeaths(){return deaths;}
	public void addDeath(int deaths){this.deaths += deaths;}
	
	public Player(String name)
	{
		this.name = name;
	}
	
}
