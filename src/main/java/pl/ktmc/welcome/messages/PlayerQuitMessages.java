package pl.ktmc.welcome.messages;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import static pl.ktmc.welcome.utils.center.Center.sendCenteredString;

public final class PlayerQuitMessages {

    private PlayerQuitMessages() {
    }

    public static void farewell(Player player) {
        String displayName = player.getDisplayName();

        String message = "\n&8 [&c-&8] &b" + displayName + " &7-&c Do zobaczenia!\n";

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

}
