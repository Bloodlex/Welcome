package pl.ktmc.welcome.event;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.ktmc.welcome.Welcome;

import static pl.ktmc.welcome.messages.PlayerJoinMessages.welcome;
import static pl.ktmc.welcome.utils.Vanish.isSuperVanishVanished;

public class WelcomePlayerJoinEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.joinMessage(Component.text(""));
        Player player = event.getPlayer();

        Bukkit.getScheduler().scheduleSyncDelayedTask(Welcome.plugin, () -> {
            if (!isSuperVanishVanished(player)) {
                welcome(player);
            }
        }, 40L);
    }
}
