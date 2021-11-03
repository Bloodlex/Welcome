package pl.ktmc.welcome.event;

import de.myzelyam.api.vanish.PlayerHideEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static pl.ktmc.welcome.messages.PlayerQuitMessages.farewell;

public class WelcomeVanishEvent implements Listener {

    @EventHandler
    public void onPlayerVanish(PlayerHideEvent event) {
        farewell(event.getPlayer());
    }
}
