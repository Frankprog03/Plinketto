package f03.plinko.physics;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Sollazzi
 * @author GABRIELE MARIA
 */
public class Circle {
    private Vector2 pos;
    private Vector2 vel = new Vector2();
    private Vector2 acc = new Vector2(0.0, 0.1);
    
    private Ellipse2D.Double ellipse;
    
    private double mass = 2;
    private double radius;
    private boolean fixed;
    
    public Circle(Vector2 pos, double radius){
        this(pos, radius, true);
    }
    
    public Circle(Vector2 pos, double radius, boolean fixed){
        this.pos = pos;
        this.radius = radius;
        this.fixed = fixed;
        
        ellipse = new Ellipse2D.Double(-radius, -radius, radius*2.0, radius*2.0);
    }
    
    public Circle(Vector2 pos, double radius, boolean fixed, double entropy){
        this(pos, radius, fixed);
        
        Vector2 v = new Vector2(entropy * Math.random(), entropy * Math.random());
        pos.addLocal(v);
    }
    
    public Vector2 checkCollision(Circle c, boolean applyMomentum){
        Vector2 diff = pos.sub(c.pos);
        
        double l;
        if((l = diff.length()) < radius + c.radius){
            double delta = radius + c.radius - l;
            
            diff.norm();
            
            if(applyMomentum){
                setPosition(c.getPosition().add(diff.scale(2.0*c.getRadius())));
                vel.set(0.0, 0.0);
                applyMomentum(diff.scale(0.5));
            }
                
            return diff.scaleLocal(delta);
        }
        
        return new Vector2();
    }
    
    public Vector2 checkCollision(Circle c){
        return checkCollision(c, true);
    }
    
    public void update(){
        if(!fixed){
            vel.addLocal(acc);
            pos.addLocal(vel);
            acc.set(0.0, 0.1);
        }
    }
    
    public void draw(Graphics2D g){
        g.translate(pos.x, pos.y);
        g.fill(ellipse);
        g.translate(-pos.x, -pos.y);
    }
    
    public Vector2 getPosition(){
        return pos;
    }
    
    public void tp(Vector2 pos){
        setPosition(pos);
        vel.set(0.0, 0.0);
    }
    
    public void setPosition(Vector2 pos){
        this.pos.set(pos);
    }
    
    public void setVelocity(Vector2 vel){
        this.vel.set(vel);
    }
    
    public void setAcceleration(Vector2 acc){
        this.acc.set(acc);
    }
    
    public void applyMomentum(Vector2 p){
        vel.addLocal(p);
    }
    
    public void applyForce(Vector2 f){
        acc.addLocal(f.scale(-1.0/mass));
    }
    
    public double getRadius(){
        return radius;
    }
}
