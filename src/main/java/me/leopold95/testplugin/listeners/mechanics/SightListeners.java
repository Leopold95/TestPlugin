package me.leopold95.testplugin.listeners.mechanics;

import me.leopold95.testplugin.TestPlugin;
import me.leopold95.testplugin.core.States;
import me.leopold95.testplugin.globals.Globals;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerAnimationType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.persistence.PersistentDataType;

public class SightListeners implements Listener {
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerClicked(PlayerInteractEvent event){
		//только главная рука
		if(event.getHand() != EquipmentSlot.HAND)
			return;


		//event.getPlayer().sendMessage(event.getAction().name());


		if(event.getAction() != Action.LEFT_CLICK_AIR)
			return;

		String state = event.getPlayer().getPersistentDataContainer().get(Globals.KEY_STATE, PersistentDataType.STRING);
		if(!state.equals(States.SIGHT.getState()))
			return;

		if(event.hasItem())
			return;

		int dist = TestPlugin.getPlugin().getConfig().getInt("lightning-max-dist");

		if(event.getPlayer().getTargetBlockExact(dist) == null)
			return;

		Location loc = event.getPlayer().getTargetBlockExact(dist).getLocation();

		loc.getWorld().strikeLightning(loc);
		loc.getWorld().strikeLightningEffect(loc);
	}
}
