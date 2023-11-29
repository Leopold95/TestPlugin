package me.leopold95.testplugin.commands;

import me.leopold95.testplugin.TestPlugin;
import me.leopold95.testplugin.core.States;
import me.leopold95.testplugin.globals.Globals;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

public class BaseCommnd implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage("message");
			return true;
		}

		Player player = (((Player) sender).getPlayer());

		if(args[0].equals("sight")){
			player.getPersistentDataContainer().set(Globals.KEY_STATE, PersistentDataType.STRING, States.SIGHT.getState());
			player.sendMessage(TestPlugin.getPlugin().getConfig().get("message-sight-setted").toString());

		}else if(args[0].equals("arrow")){
			player.getPersistentDataContainer().set(Globals.KEY_STATE, PersistentDataType.STRING, States.ARROW.getState());
			player.sendMessage(TestPlugin.getPlugin().getConfig().get("message-arrow-setted").toString());

		}else if (args[0].equals("snowball")){
			player.getPersistentDataContainer().set(Globals.KEY_STATE, PersistentDataType.STRING, States.SNOWBALL.getState());
			player.sendMessage(TestPlugin.getPlugin().getConfig().get("message-snowball-setted").toString());
		}

		return true;
	}
}
