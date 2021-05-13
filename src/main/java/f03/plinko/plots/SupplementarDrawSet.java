package f03.plinko.plots;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

import java.util.HashSet;

/**
 *
 * @author Sollazzi
 */
public class SupplementarDrawSet {
    private HashSet<StrokeElement> set = new HashSet<>();
    
    public void add(StrokeElement se){
        set.add(se);
    }
    
    public void clear(){
        set.clear();
    }
    
    public void draw(Graphics2D g){
        for(StrokeElement se : set){
            g.setColor(se.color);
            g.setStroke(se.stroke);
            g.draw(se.shape);
        }
    }
    
    public class StrokeElement {
        public Color color;
        public BasicStroke stroke;
        public Shape shape;
        
        public StrokeElement(Color color, BasicStroke stroke, Shape shape){
            this.color = color;
            this.stroke = stroke;
            this.shape = shape;
        }
    }
}
