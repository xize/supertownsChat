package eu.supertowns.supertownsChat;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import eu.supertowns.supertownsChat.events.chatEvent;
import eu.supertowns.town.supertowns;

public class chat extends JavaPlugin {
	Logger log = Logger.getLogger("Minecraft");
	
	private chatEvent Chat = new chatEvent(this);
	
	public void onEnable() {
		if(Bukkit.getPluginManager().isPluginEnabled("supertowns")) {
			logger("has been enabled!", logType.info);
			Bukkit.getPluginManager().registerEvents(Chat, this);
		} else {
			logger("supertowns plugin not found!, this plugin only works with supertowns installed", logType.servere);
			Bukkit.getPluginManager().disablePlugin(this);
		}
	}
	
	public void onDisable() {
		logger("has been disabled", logType.info);
	}
	
	public void logger(String string, logType logtype) {
		String prefix = "[SuperTownsChat] ";
		if(logtype == logType.info) {
			log.info(prefix + string);
		} else if(logtype == logType.servere) {
			log.severe(prefix + string);
		}
	}
	
	public supertowns getMainPlugin() {
		supertowns towns = (supertowns) Bukkit.getPluginManager().getPlugin("supertowns");
		return towns;
	}

}
