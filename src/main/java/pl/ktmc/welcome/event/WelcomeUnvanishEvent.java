package pl.ktmc.welcome.event;

import com.Zrips.CMI.events.CMIPlayerUnVanishEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static pl.ktmc.welcome.messages.PlayerJoinMessages.welcome;

public class WelcomeUnvanishEvent implements Listener {

    @EventHandler
    public void onPlayerUnvanish(CMIPlayerUnVanishEvent event) {
        welcome(event.getPlayer());
    }
}
