package org.barrios.elytraplus.Listeners;

import org.barrios.elytraplus.Util.ParticleRect;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;


public class Booster implements Listener {


    @EventHandler
    public void CreateBooster(BlockIgniteEvent e) {
        if (e.getCause() == BlockIgniteEvent.IgniteCause.FLINT_AND_STEEL && e.getBlock().getRelative(0,-1,0).getType().equals(Material.LAPIS_ORE)) {
            new ParticleRect(e.getBlock().getLocation(),5,5,3).draw();
            System.out.println("Test");
        }
    }

}
