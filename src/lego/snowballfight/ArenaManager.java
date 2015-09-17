package lego.snowballfight;

import java.util.ArrayList;
import java.util.List;

public class ArenaManager
{
	private static  ArenaManager arenaManager;
	
	private List<Arena> arenas = new ArrayList<Arena>();
	
	private ArenaManager(){}
	
	//Initialize 
	public static ArenaManager getManager()
	{
		if (arenaManager == null)
		{
			arenaManager = new ArenaManager();
		}
		
		return arenaManager;
	}
	
	/**
	 * Gets an arena by searching for the arena name
	 * 
	 * @param arenaName the name of the arena you are searching for
	 * @return if true, returns that arena, else null
	 */
	public Arena getArena(String arenaName)
	{
		for(Arena arena : this.arenas)
		{
			if(arena.getArenaName().equalsIgnoreCase(arenaName))
			{
				return arena;
			}
		}
		
		return null;
		
	}
	
	/**
	 * Create an arena with the specified name
	 * 
	 * @param arenaName The name you want for the new arena
	 * @return Returns new arena
	 */
	public Arena createArena(String arenaName)
	{
		Arena arena = new Arena(arenaName);
		
		return arena;
	}

}
