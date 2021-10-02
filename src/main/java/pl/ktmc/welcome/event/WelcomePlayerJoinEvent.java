package pl.ktmc.welcome.event;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static pl.ktmc.welcome.utils.Utils.isVanished;
import static pl.ktmc.welcome.utils.Utils.playerJoined;

public class WelcomePlayerJoinEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.joinMessage(Component.text(""));
        Player player = event.getPlayer();

        if (!isVanished(player) && !isVanished(player.getUniqueId())) {
            playerJoined(player);
        }
    }
}
