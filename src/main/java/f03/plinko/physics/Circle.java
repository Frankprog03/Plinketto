package f03.plinko.physics;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Sollazzi
 */
public class Circle {
    private Vector2 pos;
    private Vector2 vel = new Vector2();
    private Vector2 acc = new Vector2(0.0, 1.0);
    
    private Ellipse2D.Double ellipse;
    
    private double radius;
    
    public Circle(Vector2 pos, double radius){
        this.pos = pos;
        this.radius = radius;
        
        ellipse = new Ellipse2D.Double(-radius, -radius, radius*2.0, radius*2.0);
    }
    
    public Vector2 checkCollision(Circle c){
        Vector2 diff = pos.sub(c.pos);
        
        double l;
        if((l = diff.length()) < radius + c.radius){
            double delta = radius + c.radius - diff.length();
            
            diff.norm();
            
            return diff.scale(delta);
        }
        
        return new Vector2();
    }
    
    public void update(){
        pos.addLocal(vel);
        vel.addLocal(acc);
    }
    
    public void draw(Graphics2D g){
        g.translate(pos.x, pos.y);
        g.fill(ellipse);
        g.translate(-pos.x, -pos.y);
    }
    
    public Vector2 getPosition(){
        return pos;
    }
    
    public double getRadius(){
        return radius;
    }
    
}
