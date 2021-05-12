package f03.plinko.plots;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import java.util.HashSet;

/**
 *
 * @author Sollazzi
 */
public class SupplementarLineSet {
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
            g.draw(se.line);
        }
    }
    
    public class StrokeElement {
        public Color color;
        public BasicStroke stroke;
        public Line2D.Double line;
        
        public StrokeElement(Color color, BasicStroke stroke, Line2D.Double line){
            this.color = color;
            this.stroke = stroke;
            this.line = line;
        }
    }
}
