package org.barrios.elytraplus.Util;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class ParticleRect {

    static ArrayList<ParticlePoint> sides = new ArrayList<ParticlePoint>();
    static Location start;

    public ParticleRect(Location start, double width, double length, double height){
        this.start = start;
        Vector A = new Vector(0,0,0);
        Vector B = new Vector(length,0,0);
        Vector C = new Vector(0,0,width);
        Vector D = new Vector(0,height,0);
        Vector E = new Vector(0,height,width);
        Vector F = new Vector(length,height,0);
        Vector G = new Vector(length,0,width);
        sides.add(new ParticlePoint(A,B));
        sides.add(new ParticlePoint(A,C));
        sides.add(new ParticlePoint(A,D));
        sides.add(new ParticlePoint(C,D));
        sides.add(new ParticlePoint(B,D));
        sides.add(new ParticlePoint(C,B));
        sides.add(new ParticlePoint(B,C));
        sides.add(new ParticlePoint(D,C));
        sides.add(new ParticlePoint(D,B));
        sides.add(new ParticlePoint(E,B));
        sides.add(new ParticlePoint(F,C));
        sides.add(new ParticlePoint(G,D));
    }

    public static Vector getPostion(double blocksAway, Vector origin, Vector direction) {
        return origin.clone().add(direction.clone().normalize().multiply(blocksAway));
    }

    public static ArrayList<Vector> traverse(Vector origin, Vector direction) {
        ArrayList<Vector> positions = new ArrayList<>();
        for (double d = 0; d <= direction.length(); d += 0.1) {
            positions.add(getPostion(d,origin,direction));
        }
        return positions;
    }

    public static void draw(){
        for(ParticlePoint point : sides){
            for(Vector position : traverse(point.origin,point.direction)){
                position = start.toVector().clone().add(position);
                start.getWorld().spawnParticle(Particle.REDSTONE,position.toLocation(start.getWorld()), 4,new Particle.DustOptions(Color.RED, 5));
            }
        }
    }

    private class ParticlePoint {
        Vector origin,direction;
        ParticlePoint(Vector origin, Vector direction) {
            this.origin = origin;
            this.direction = direction;
        }
    }



}
