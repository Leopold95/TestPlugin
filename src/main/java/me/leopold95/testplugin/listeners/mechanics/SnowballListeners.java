package me.leopold95.testplugin.listeners.mechanics;

import me.leopold95.testplugin.TestPlugin;
import me.leopold95.testplugin.core.States;
import me.leopold95.testplugin.core.Utils;
import me.leopold95.testplugin.globals.Globals;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collection;
import java.util.TreeMap;

public class SnowballListeners implements Listener {
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onSnowBallHit(ProjectileHitEvent event){
		if (!(event.getEntity() instanceof Snowball))
			return;

		if(!(event.getEntity().getShooter() instanceof Player))
			return;

		Player player = (Player) event.getEntity().getShooter();

		String state = player.getPersistentDataContainer().get(Globals.KEY_STATE, PersistentDataType.STRING);
		if(!state.equals(States.SNOWBALL.getState()))
			return;

		if(event.getHitBlock() == null)
			return;

		double radius = (double) TestPlugin.getPlugin().getConfig().get("snowball-radius");

		Utils.summonCircle(event.getHitBlock().getLocation().add(0, 1.0, 0), (int) radius, 200);

		Collection<Entity> collection = event.getHitBlock().getWorld().getNearbyEntities(
				event.getHitBlock().getLocation(),
				radius, radius, radius);

		for(Entity ent : collection){
			if (!(ent instanceof LivingEntity))
				continue;

			int duration = (int) TestPlugin.getPlugin().getConfig().get("snowball-fire-seconds") * 20;

			ent.setFireTicks(duration);
		}
	}


}
