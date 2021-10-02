package pl.ktmc.welcome.event;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static pl.ktmc.welcome.utils.Utils.isVanished;
import static pl.ktmc.welcome.utils.Utils.playerLeft;

public class WelcomePlayerQuitEvent implements Listener {

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        event.quitMessage(Component.text(""));
        Player player = event.getPlayer();

        if (!isVanished(player) && !isVanished(player.getUniqueId())) {
            playerLeft(player);
        }
    }
}