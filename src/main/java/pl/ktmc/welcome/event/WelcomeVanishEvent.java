package pl.ktmc.welcome.event;

import com.Zrips.CMI.events.CMIPlayerVanishEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static pl.ktmc.welcome.utils.Utils.playerLeft;

public class WelcomeVanishEvent implements Listener {

    @EventHandler
    public void onPlayerVanish(CMIPlayerVanishEvent event) {
        playerLeft(event.getPlayer());
    }
}
