package pl.ktmc.welcome.messages;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import static pl.ktmc.welcome.utils.center.Center.sendCenteredString;

public final class PlayerJoinMessages {

    private PlayerJoinMessages() {
    }

    public static void welcome(Player player) {
        String displayName = player.getDisplayName();

        if (player.hasPlayedBefore()) {
            playedBefore(displayName);
        } else {
            firstTime(displayName);
        }
    }

    private static void firstTime(String displayName) {
        String message = "\n&8 [&a+&8] &b" + displayName + " &7-&a Przywitaj\n ";

        String textAfterClick = String.format("&aWitaj pierwszy raz u nas&r %s &a:)", displayName).replace('§', '&');

        BaseComponent[] components = new ComponentBuilder().append(sendCenteredString(message))
                .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Kliknij, by przywitać!")))
                .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, textAfterClick))
                .create();

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(sendCenteredString("&6&m                            &8[ &a+ &8]&6&m                          "));
            player.sendMessage(sendCenteredString("&b&lWitaj &a&l" + displayName + " &b&lpierwszy raz u nas :)"));
            player.sendMessage(sendCenteredString("&d&lMiłej Gry ❤"));
            player.sendMessage(sendCenteredString("&6&m                                                            "));
            player.spigot().sendMessage(components);
        }
    }

    private static void playedBefore(String displayName) {
        String message = "\n&8 [&a+&8] &b" + displayName + " &7-&a Przywitaj\n ";
        String textAfterClick = String.format("&aWitaj&r %s&r&a!", displayName.replace('§', '&'));

        BaseComponent[] components = new ComponentBuilder().append(sendCenteredString(message))
                .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Kliknij, by przywitać!")))
                .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, textAfterClick))
                .create();

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.spigot().sendMessage(components);
        }
    }
}
