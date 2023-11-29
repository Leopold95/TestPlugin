package me.leopold95.testplugin.listeners;

import me.leopold95.testplugin.core.States;
import me.leopold95.testplugin.globals.Globals;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataType;

public class PlayerJoin implements Listener {
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerKoin(PlayerJoinEvent event){
		event.getPlayer().getPersistentDataContainer().set(Globals.KEY_STATE, PersistentDataType.STRING, States.DEFAULT.getState());
	}


}
