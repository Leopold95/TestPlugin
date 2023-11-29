package me.leopold95.testplugin.globals;

import me.leopold95.testplugin.TestPlugin;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.*;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

public class Globals {
	public static final NamespacedKey KEY_STATE = new NamespacedKey(TestPlugin.getPlugin(), "player-state-key");

	public static ArrayList<EntityType> getEntities(){
		ArrayList<EntityType> ents = new ArrayList<>();

		//нужно заполнить всеми сущностями, котрые могут участвовать в рандомайзере
		ents.add(EntityType.BEE);
		ents.add(EntityType.HORSE);
		ents.add(EntityType.BLAZE);
		ents.add(EntityType.TURTLE);
		ents.add(EntityType.PIG);

		return ents;
	}
}
