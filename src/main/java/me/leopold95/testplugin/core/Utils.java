package me.leopold95.testplugin.core;

import me.leopold95.testplugin.globals.Globals;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.EntityType;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.Random;

public class Utils {
	public static EntityType getRandomEntityClass(){
		ArrayList<EntityType> givenList = Globals.getEntities();

		Random rand = new Random();


		return givenList.get(rand.nextInt(givenList.size()));
	}

	public static void summonCircle(Location location, int size, int duration) {
		for (int d = 0; d <= duration; d += 1) {
			Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
			particleLoc.setX(location.getX() + Math.cos(d) * size);
			particleLoc.setZ(location.getZ() + Math.sin(d) * size);
			location.getWorld().spawnParticle(Particle.REDSTONE, particleLoc, 1,
					new Particle.DustOptions(Color.WHITE, 5));
		}
	}
}
