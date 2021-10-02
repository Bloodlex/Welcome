package pl.ktmc.welcome.utils;

import com.Zrips.CMI.CMI;
import org.bukkit.entity.Player;
import org.bukkit.metadata.MetadataValue;

import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

public final class Vanish {

    private Vanish() {
    }

    public static Set<UUID> getCmiVanished() {
        CMI cmi = CMI.getInstance();
        return cmi.getVanishManager().getAllVanished();
    }

    public static boolean isVanished(Player player) {
        return getCmiVanished().contains(player.getUniqueId()) && isMetadataVanished(player);
    }

    public static boolean isMetadataVanished(Player player) {
        Iterator<MetadataValue> var2 = player.getMetadata("vanished").iterator();

        MetadataValue meta;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            meta = var2.next();
        } while (!meta.asBoolean());

        return true;
    }
}
