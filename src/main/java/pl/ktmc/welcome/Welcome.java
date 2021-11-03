package pl.ktmc.welcome;

import org.bukkit.plugin.java.JavaPlugin;
import pl.ktmc.welcome.event.WelcomePlayerJoinEvent;
import pl.ktmc.welcome.event.WelcomePlayerQuitEvent;

public final class Welcome extends JavaPlugin {

    public static JavaPlugin plugin;

    public void setPlugin(JavaPlugin plugin) {
        Welcome.plugin = plugin;
    }

    @Override
    public void onEnable() {
        setPlugin(this);
        getServer().getPluginManager().registerEvents(new WelcomePlayerJoinEvent(), this);
        getServer().getPluginManager().registerEvents(new WelcomePlayerQuitEvent(), this);
    }

    @Override
    public void onDisable() {
    }
}
