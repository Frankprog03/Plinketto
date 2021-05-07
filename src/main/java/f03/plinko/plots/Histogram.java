package f03.plinko.plots;

import f03.plinko.Bidoncino;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Sollazzi
 */
public class Histogram {
    private Bidoncino[] buckets;
    
    public Histogram(int nOfBuckets){
        buckets = new Bidoncino[nOfBuckets];
    }
    
    public Histogram(Bidoncino[] boundBuckets){
        buckets = boundBuckets;
    }
    
    public void bind(Bidoncino[] boundBuckets){
        buckets = boundBuckets;
    }
    
    public void setValue(int i, Bidoncino v){
        buckets[i] = v;
    }
    
    public Bidoncino getValue(int i){
        return buckets[i];
    }
    
    public void draw(Rectangle frame, Graphics2D g2d){
        Graphics2D g = (Graphics2D) g2d.create(frame.x, frame.y, frame.width, frame.height);
        
        int w = frame.width;
        int h = frame.height;
        int n = buckets.length;
        int step = frame.width / n;
        
        Color theGreen = new Color(0, 180, 0);
        Color theDarkerGreen = theGreen.darker();
        
        boolean commute = false;
        
        g.drawRect(0, 0, w, h);
        g.setColor(new Color(220, 220, 220));
        g.setStroke(new BasicStroke(1));
        g.fillRect(0, 0, w, h);
        for(int i = 0; i < n; i++){
            g.setColor((commute =! commute) ? theGreen : theDarkerGreen);
            g.fillRect(i * step, 0, w, h);
            g.setColor(Color.black);
            g.drawLine(i * step, 0, i * step, h);
        }
    }
}
