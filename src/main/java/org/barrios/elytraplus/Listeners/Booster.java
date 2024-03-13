package org.barrios.elytraplus.Listeners;

import org.barrios.elytraplus.ElytraPlus;
import org.barrios.elytraplus.Tasks.RenderParticles;
import org.barrios.elytraplus.Util.ParticleRect;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


public class Booster implements Listener {

    List<Integer> taskID = new ArrayList<Integer>(); //TODO make a linked list

    Plugin plugin = ElytraPlus.getPlugin(ElytraPlus.class);

    @EventHandler
    public void CreateBooster(BlockIgniteEvent e) {
        if (e.getCause() == BlockIgniteEvent.IgniteCause.FLINT_AND_STEEL && e.getBlock().getRelative(0,-1,0).getType().equals(Material.LAPIS_ORE)) {

                  BukkitRunnable render = new RenderParticles(new ParticleRect(e.getBlock().getLocation(),5,5,3));
                  render.runTaskTimer(plugin,0,1);
            System.out.println("Test");

            int task = render.getTaskId();
           taskID.add(task);

            }



        //todo make if statement that if blocks broken cube vanishes (stop task)
    }

    public void deleteBooster(BlockBreakEvent e) {

        if (e.getBlock().getType().equals(Material.LAPIS_ORE)) {

            Bukkit.getScheduler().cancelTask(taskID.get(0));


        }

    }



}
