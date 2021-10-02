package pl.ktmc.welcome.event;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static pl.ktmc.welcome.messages.PlayerJoinMessages.welcome;
import static pl.ktmc.welcome.utils.Vanish.isVanished;

public class WelcomePlayerJoinEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.joinMessage(Component.text(""));
        Player player = event.getPlayer();

        if (!isVanished(player)) {
            welcome(player);
        }
    }
}
