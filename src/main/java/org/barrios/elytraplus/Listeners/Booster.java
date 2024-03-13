package org.barrios.elytraplus.Listeners;

import org.barrios.elytraplus.ElytraPlus;
import org.barrios.elytraplus.Tasks.RenderParticles;
import org.barrios.elytraplus.Util.ParticleRect;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;


public class Booster implements Listener {

    Plugin plugin = ElytraPlus.getPlugin(ElytraPlus.class);

    @EventHandler
    public void CreateBooster(BlockIgniteEvent e) {
        if (e.getCause() == BlockIgniteEvent.IgniteCause.FLINT_AND_STEEL && e.getBlock().getRelative(0,-1,0).getType().equals(Material.LAPIS_ORE)) {

                  BukkitRunnable render = new RenderParticles(new ParticleRect(e.getBlock().getLocation(),5,5,3));
                  render.runTaskTimer(plugin,0,0);
            System.out.println("Test");
        }
        //todo make if statement that if blocks broken cube vanishes (stop task)
    }



}
