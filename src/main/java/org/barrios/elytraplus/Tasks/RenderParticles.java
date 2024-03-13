package org.barrios.elytraplus.Tasks;

import org.barrios.elytraplus.Util.ParticleRect;
import org.bukkit.scheduler.BukkitRunnable;

public class RenderParticles extends BukkitRunnable {

    //To-do: make method to stop task
    ParticleRect rect;
public RenderParticles(ParticleRect cuboid) {
this.rect = cuboid;

}
    @Override
    public void run() {
rect.draw();
    }
}
