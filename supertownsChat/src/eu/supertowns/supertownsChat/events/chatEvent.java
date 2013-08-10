package eu.supertowns.supertownsChat.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import eu.supertowns.supertownsChat.chat;

@SuppressWarnings("deprecation")
public class chatEvent implements Listener {
	
	chat plugin;
	public chatEvent(chat plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onChat(PlayerChatEvent e) {
		String town = plugin.getMainPlugin().getCoreApi().getTown(e.getPlayer());
		if(town == null || town == "null") {
			e.setFormat(ChatColor.RED + "(" + ChatColor.GRAY + "st" + ChatColor.RED + ")" + e.getFormat());
		} else {
			if(plugin.getMainPlugin().getCoreApi().isMayor(e.getPlayer(), town)) {
				e.setFormat(ChatColor.RED + "(" + ChatColor.GRAY + "st" + ChatColor.RED + ")" + ChatColor.GOLD + "(" + ChatColor.GRAY + town + ChatColor.GOLD + ")" + e.getFormat());
			} else {
				e.setFormat(ChatColor.RED + "(" + ChatColor.GRAY + "st" + ChatColor.RED + ")" + ChatColor.WHITE + "(" + ChatColor.GRAY + town + ChatColor.WHITE + ")" + e.getFormat());	
			}
		}
	}

}
