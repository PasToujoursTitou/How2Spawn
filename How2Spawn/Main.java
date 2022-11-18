package fr.titou.How2Spawn;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		System.out.println("[How2Spawn] Enabling...");
		saveDefaultConfig();
		getCommand("spawn").setExecutor(this);
	}

	@Override
	public void onDisable() {
		System.out.println("[How2Spawn] Disabling...");
	}


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {


		if(cmd.getName().equalsIgnoreCase("spawn")) {

			if(sender instanceof Player) {




				if(sender.hasPermission("tp.use")) {


					Player player = (Player)sender;




					double x = getConfig().getInt("x");
					double y = getConfig().getInt("y");
					double z = getConfig().getInt("z");
					boolean prefix = getConfig().getBoolean("disable_prefix");


					Location spawn = new Location(player.getWorld(), x, y, z);
					player.teleport(spawn);
					if(prefix == true) {
						player.sendMessage("§2you have been successfully teleported");
					}else if(prefix == false) {
						player.sendMessage("§2[How2Spawn] you have been successfully teleported");
					}else if(prefix != true && prefix != false){
						player.sendMessage("§cERROR: INVALID 'disable_prefix' VALUE!");

					}




				}

				}


			}


		return false;
	}


}
