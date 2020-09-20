package cx.rain.mc.bukkit.dawn;

import org.bukkit.plugin.java.JavaPlugin;

public final class Dawn extends JavaPlugin {
    private static Dawn INSTANCE = null;

    @Override
    public void onEnable() {
        // Plugin startup logic
        INSTANCE = this;
        getLogger().info("Yes, I am working.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Goodbye!");
    }

    public static Dawn getInstance() {
        return INSTANCE;
    }
}
