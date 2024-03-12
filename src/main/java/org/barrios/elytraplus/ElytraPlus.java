package org.barrios.elytraplus;

import org.barrios.elytraplus.Listeners.Booster;
import org.barrios.elytraplus.Listeners.FlightEvents;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ElytraPlus extends JavaPlugin  {


    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Plugin By Enrique");
getServer().getPluginManager().registerEvents(new FlightEvents(), this);
getServer().getPluginManager().registerEvents(new Booster(),this);
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
