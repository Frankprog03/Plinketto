package f03.plinko.physics;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/**
 *
 * @author Sollazzi
 */
public class Wall {
    Vector2 start, end;
    Vector2 center, diff;
    
    Line2D.Double line;
    
    public Wall(Vector2 start, Vector2 end){
        this.start = start;
        this.end = end;
        
        diff = start.sub(end);
        center = start.add(end).scaleLocal(.5);
        
        line = new Line2D.Double(start.x, start.y, end.x, end.y);
    }
    
    public void draw(Graphics2D g){
        g.draw(line);
    }
}
