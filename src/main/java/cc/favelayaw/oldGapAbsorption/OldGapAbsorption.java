package cc.favelayaw.oldGapAbsorption;

import org.bukkit.plugin.java.JavaPlugin;

public final class OldGapAbsorption extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Loading OldGapAbsorption");
        getServer().getPluginManager().registerEvents(new PlayerItemConsumeListener(), this);
        System.out.println("Finished loading OldGapAbsorption");
    }
}
