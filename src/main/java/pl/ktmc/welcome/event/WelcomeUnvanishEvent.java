package pl.ktmc.welcome.event;

import de.myzelyam.api.vanish.PlayerShowEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static pl.ktmc.welcome.messages.PlayerJoinMessages.welcome;

public class WelcomeUnvanishEvent implements Listener {

    @EventHandler
    public void onPlayerUnvanish(PlayerShowEvent event) {
        welcome(event.getPlayer());
    }
}
