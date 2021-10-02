package pl.ktmc.welcome;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import pl.ktmc.welcome.event.WelcomeUnvanishEvent;
import pl.ktmc.welcome.event.WelcomePlayerJoinEvent;
import pl.ktmc.welcome.event.WelcomePlayerQuitEvent;
import pl.ktmc.welcome.event.WelcomeVanishEvent;

import java.util.HashSet;
import java.util.Set;

public final class Welcome extends JavaPlugin {

    public static JavaPlugin plugin;

    public static Set<Player> vanishFirstLogin = new HashSet<>();

    public void setPlugin(JavaPlugin plugin) {
        Welcome.plugin = plugin;
    }

    @Override
    public void onEnable() {
        setPlugin(this);
        getServer().getPluginManager().registerEvents(new WelcomePlayerJoinEvent(), this);
        getServer().getPluginManager().registerEvents(new WelcomePlayerQuitEvent(), this);
        getServer().getPluginManager().registerEvents(new WelcomeUnvanishEvent(), this);
        getServer().getPluginManager().registerEvents(new WelcomeVanishEvent(), this);
    }

    @Override
    public void onDisable() {
    }
}
