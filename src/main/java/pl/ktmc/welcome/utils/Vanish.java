package pl.ktmc.welcome.utils;

import org.bukkit.entity.Player;
import org.bukkit.metadata.MetadataValue;

public final class Vanish {

    private Vanish() {
    }

    public static boolean isSuperVanishVanished(Player player) {
        for (MetadataValue meta : player.getMetadata("vanished")) {
            if (meta.asBoolean())
                return true;
        }
        return false;
    }
}
