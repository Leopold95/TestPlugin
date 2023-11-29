package me.leopold95.testplugin.commnds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class BaseTabCompliter implements TabCompleter {
	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
		if(args.length == 1){
			ArrayList<String> list = new ArrayList<String>();

			list.add("sight");
			list.add("arrow");
			list.add("snowball");

			return list;
		}
		return null;
	}
}
