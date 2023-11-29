package me.leopold95.testplugin.listeners.mechanics;

import me.leopold95.testplugin.TestPlugin;
import me.leopold95.testplugin.core.States;
import me.leopold95.testplugin.core.Utils;
import me.leopold95.testplugin.globals.Globals;
import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerAnimationType;
import org.bukkit.persistence.PersistentDataType;

public class BowListners implements Listener {
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onSnowBallHit(ProjectileHitEvent event){
		if (!(event.getEntity() instanceof Arrow))
			return;

		if(!(event.getEntity().getShooter() instanceof Player))
			return;

		Player player = (Player) event.getEntity().getShooter();

		String state = player.getPersistentDataContainer().get(Globals.KEY_STATE, PersistentDataType.STRING);
		if(!state.equals(States.ARROW.getState()))
			return;

		if(event.getHitBlock() == null)
			return;

		player.getWorld().strikeLightning(event.getHitBlock().getLocation());

		Bukkit.getScheduler().runTaskLater(TestPlugin.getPlugin(), () -> {
			player.getWorld().spawnEntity(event.getHitBlock().getLocation().add(0, 1, 0), Utils.getRandomEntityClass());
		}, 15L);


	}

}
