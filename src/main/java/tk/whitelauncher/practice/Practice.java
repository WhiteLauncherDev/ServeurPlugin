package tk.whitelauncher.practice;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class Practice extends JavaPlugin {

    private Map<Player, Player> duel = new HashMap<>();

    @Override
    public void onEnable() {
        getLogger().log(Level.ALL, "Plugin ready");
        getCommand("duel").setExecutor(this);
        getCommand("help").setExecutor(new CommandHelp());
    }

    @Override
    public void onDisable() {
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            if (label.equalsIgnoreCase("duel") && sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {

                    player.sendMessage("Aide : /duel <joueur> \n /duel <accept/deny>");
                    return true;
                }

                if (args.length == 1) {
                    String targetName = args[0];
                    if (args[0].equalsIgnoreCase("accept")) {
                        if (duel.containsKey(player)) {
                            player.sendMessage("Le duel se lance !");

                            Player targetOne = duel.get(player);
                            targetOne.sendMessage("Le duel se lance !");

                            player.teleport(new Location(Bukkit.getWorld("world"), 40, 100, 50));
                            targetOne.teleport(new Location(Bukkit.getWorld("world"), 40, 100, 50));

                            duel.remove(player);
                        }
                    } else if (args[0].equalsIgnoreCase("deny")) {
                        if (duel.containsKey(player)) {
                            Player targetOne = duel.get(player);
                            player.sendMessage("Vous avez refusé le duel ! (espèce de lâche !)");
                            targetOne.sendMessage("Le joueur " + player.getName() + " a refusé votre duel ce lâche !");

                            duel.remove(player);

                        }
                    } else if (Bukkit.getPlayer(targetName) != null) {

                        Player target = Bukkit.getPlayer(targetName);

                        if (duel.containsKey(target)) {
                            player.sendMessage("Ce joueur a déjà une demande  de duel !");
                            return true;
                        }
                        duel.put(target, player);
                        player.sendMessage("Vous venez de provoquer en duel §c" + targetName + " §r!");
                        target.sendMessage("Vous venez de recevoir une demande de Duel de §c" + player.getName() + "§r !");


                    } else {


                        player.sendMessage("§cLe joueur " + targetName + " est hors ligne !");

                    }
                    return true;
                }

            }

        return false;
    }
}
