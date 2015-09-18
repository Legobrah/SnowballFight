package lego.snowballfight;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import lego.snowballfight.commands.CreateMatch;
import lego.snowballfight.commands.Join;
import lego.snowballfight.commands.SetSpawn;

public class SnowballFight extends JavaPlugin
{
	private Match mainMatch;
	public Match getMatch(){return mainMatch;};
	public void setMatch(Match mainMatch){this.mainMatch = mainMatch;};
	
	
	@Override
	public void onEnable()
	{
		log("is now loaded...");
		getServer().getPluginManager().registerEvents(new MatchListener(this), this);
        getCommand("creatematch").setExecutor(new CreateMatch(this));
        getCommand("join").setExecutor(new Join(this));
        getCommand("setspawn").setExecutor(new SetSpawn(this));
        
	}
	
	@Override
	public void onDisable()
	{
        log("is now disabled...");
	}
	
	public static void log(String string)
	{
		System.out.println("[SnowballFight] " + string);
	}
	
	public static void announce(String string)
	{
		Bukkit.broadcastMessage("[SnowballFight] ");
	}
        
}
