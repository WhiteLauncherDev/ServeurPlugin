package tk.whitelauncher.practice;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHelp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage("§f§l------------------");
            player.sendMessage("§bMenu d'aide: \n Commandes : \n /help, /aide, /? : afficher cette liste \n /plugins : affiche les plugins \n /duel : Fight des gens !");
            player.sendMessage("§f§l------------------");
        }
        return true;
    }
}
