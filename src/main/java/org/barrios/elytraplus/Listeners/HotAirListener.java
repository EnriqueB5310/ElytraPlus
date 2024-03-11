package org.barrios.elytraplus.Listeners;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;

//Player gets velocity if looking up flying over fire source
public class HotAirListener implements Listener {

    @EventHandler
    public void flyOverFire(EntityToggleGlideEvent e) {

// if player flies over fire while looking up
        if (e.isGliding() && (e.getEntity() instanceof Player p)) {
            while (p.getLocation().getPitch() == -90 && p.getLocation().subtract(0,-5,0).getBlock().getType()  == Material.FIRE) {
            p.setVelocity(p.getVelocity().multiply(2));
            } ;

        }

    }
}




