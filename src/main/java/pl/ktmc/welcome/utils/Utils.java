package pl.ktmc.welcome.utils;

import com.Zrips.CMI.CMI;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.metadata.MetadataValue;
import pl.ktmc.welcome.Welcome;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

public class Utils {

    public static String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static Set<UUID> getVanished() {
        CMI cmi = CMI.getInstance();
        return cmi.getVanishManager().getAllVanished();
    }

    public static boolean isVanished(UUID uuid) {
        return getVanished().contains(uuid);
    }

    public static void playerJoined(Player player) {
        String displayName = player.getDisplayName();

        if (player.hasPlayedBefore()) {
            playedBefore(displayName);
        } else {
            firstTime(displayName);
        }
    }

    public static void playerLeft(Player player) {
        String displayName = player.getDisplayName();

        String message = "\n&8 [&a-&8] &b" + displayName + " &7-&a Do zobaczenia!\n";

        String textAfterClick = String.format("&cDo zobaczenia&r %s&c!", displayName).replace('§', '&');

        BaseComponent[] text = new ComponentBuilder()
                .append(sendCenteredString(message))
                .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Kliknij, by pożegnać!")))
                .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, textAfterClick))
                .create();

        for (Player foundPlayer : Bukkit.getOnlinePlayers()) {
            foundPlayer.spigot().sendMessage(text);
        }
    }

    private static void firstTime(String displayName) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Welcome.plugin, () -> {
            String message = "\n&8 [&a+&8] &b" + displayName + " &7-&a Przywitaj\n ";

            String textAfterClick = String.format("&aWitaj pierwszy raz u nas&r %s &a:)", displayName).replace('§', '&');

            BaseComponent[] components = new ComponentBuilder().append(sendCenteredString(message))
                    .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Kliknij, by przywitać!")))
                    .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, textAfterClick))
                    .create();

            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(sendCenteredString("&6&l    ********************************************************"));
                player.sendMessage(sendCenteredString("&b&lWitaj &a&l" + displayName + " &b&lpierwszy raz u nas :)"));
                player.sendMessage(sendCenteredString("&d&lMiłej Gry ❤"));
                player.sendMessage(sendCenteredString("&6&l    ********************************************************"));
                player.spigot().sendMessage(components);
            }
        }, 40L);
    }

    private static void playedBefore(String displayName) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Welcome.plugin, () -> {

            String message = "\n&8 [&a+&8] &b" + displayName + " &7-&a Przywitaj\n ";
            String textAfterClick = String.format("&aWitaj&r %s&r&a!", displayName.replace('§', '&'));

            BaseComponent[] components = new ComponentBuilder().append(sendCenteredString(message))
                    .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Kliknij, by przywitać!")))
                    .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, textAfterClick))
                    .create();

            for (Player player : Bukkit.getOnlinePlayers()) {
                player.spigot().sendMessage(components);
            }
        }, 40L);
    }

    private final static int CENTER_PX = 154;

    public static String sendCenteredString(String message) {
        String[] lines = ChatColor.translateAlternateColorCodes('&', message).split("\n", 40);
        StringBuilder returnMessage = new StringBuilder();
        String[] var3 = lines;
        int var4 = lines.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            String line = var3[var5];
            int messagePxSize = 0;
            boolean previousCode = false;
            boolean isBold = false;
            char[] var10 = line.toCharArray();
            int spaceLength = var10.length;

            int compensated;
            for (compensated = 0; compensated < spaceLength; ++compensated) {
                char c = var10[compensated];
                if (c == 167) {
                    previousCode = true;
                } else if (previousCode) {
                    previousCode = false;
                    isBold = c == 'l';
                } else {
                    DefaultFontInfo dFI = DefaultFontInfo.getDefaultFontInfo(c);
                    messagePxSize = isBold ? messagePxSize + dFI.getBoldLength() : messagePxSize + dFI.getLength();
                    ++messagePxSize;
                }
            }

            int toCompensate = 154 - messagePxSize / 2;
            spaceLength = DefaultFontInfo.SPACE.getLength() + 1;
            compensated = 0;

            StringBuilder sb;
            for (sb = new StringBuilder(); compensated < toCompensate; compensated += spaceLength) {
                sb.append(" ");
            }

            returnMessage.append(sb.toString()).append(line).append("\n");
        }

        return returnMessage.toString();
    }

    public static boolean isVanished(Player player) {
        Iterator var2 = player.getMetadata("vanished").iterator();

        MetadataValue meta;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            meta = (MetadataValue) var2.next();
        } while (!meta.asBoolean());

        return true;
    }

    public static String stripFormatting(String message) {
        message = ChatColor.stripColor(message);

        Set<String> colorCodes = new HashSet<>();
        colorCodes.add("&a");
        colorCodes.add("&b");
        colorCodes.add("&c");
        colorCodes.add("&d");
        colorCodes.add("&e");
        colorCodes.add("&f");
        colorCodes.add("&0");
        colorCodes.add("&1");
        colorCodes.add("&2");
        colorCodes.add("&3");
        colorCodes.add("&4");
        colorCodes.add("&5");
        colorCodes.add("&6");
        colorCodes.add("&7");
        colorCodes.add("&8");
        colorCodes.add("&9");
        colorCodes.add("&k");
        colorCodes.add("&m");
        colorCodes.add("&o");
        colorCodes.add("&l");
        colorCodes.add("&n");
        colorCodes.add("&r");

        colorCodes.add("§a");
        colorCodes.add("§b");
        colorCodes.add("§c");
        colorCodes.add("§d");
        colorCodes.add("§e");
        colorCodes.add("§f");
        colorCodes.add("§0");
        colorCodes.add("§1");
        colorCodes.add("§2");
        colorCodes.add("§3");
        colorCodes.add("§4");
        colorCodes.add("§5");
        colorCodes.add("§6");
        colorCodes.add("§7");
        colorCodes.add("§8");
        colorCodes.add("§9");
        colorCodes.add("§k");
        colorCodes.add("§m");
        colorCodes.add("§o");
        colorCodes.add("§l");
        colorCodes.add("§n");
        colorCodes.add("§r");

        for (String colorCode : colorCodes) {
            message = message.replaceAll(colorCode, "");
        }
        return message;
    }
}
