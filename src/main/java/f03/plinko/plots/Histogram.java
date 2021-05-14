package f03.plinko.plots;

import f03.plinko.Plinko;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Sollazzi
 */
public class Histogram {
    private int[] buckets;
    
    int max = 1;
    
    public Histogram(int nOfBuckets){
        buckets = new int[nOfBuckets];
    }
    
    public Histogram(int[] boundBuckets){
        buckets = boundBuckets;
        
        max();
    }
    
    public void bind(int[] boundBuckets){
        buckets = boundBuckets;
        
        max();
    }
    
    public void setValue(int i, int v){
        buckets[i] = v;
        
        if(v > max) max = v;
    }
    
    public int getValue(int i){
        return buckets[i];
    }
    
    private void max(){
        if(buckets != null){
            for(int x : buckets) if(max < x) max = x;
        }
    }
    
    public void draw(Rectangle frame, Graphics2D g2d){
        Graphics2D g = (Graphics2D) g2d.create(frame.x, frame.y, frame.width, frame.height);
        
        max();
        
        int w = frame.width;
        int h = frame.height;
        int n = buckets.length;
        int step = frame.width /n;
        
        Color theGreen = new Color(0, 180, 0);
        Color theDarkerGreen = theGreen.darker();
        
        boolean commute = false;
        
        //g.setColor(new Color(220, 220, 220));
        //g.fillRect(0, 0, w, h);
        g.translate(0, h);
        g.scale(1, -1);
        g.drawRect(0, 0, w, h);
        g.setStroke(new BasicStroke(1));
        for(int i = 0; i < n; i++){
            g.setColor((commute =! commute) ? theGreen : theDarkerGreen);
            
            double value = buckets[i] / (double) max * h;
            
            g.fillRect(i * step, 0, step, (int) value);
            g.setColor(Color.black);
            g.drawRect(i * step, 0, step, (int) value);
            g.scale(1, -1);
            Plinko.drawCenteredString(g, Integer.toString(buckets[i]), new Rectangle(i*step, -10, step, -10));
            g.scale(1, -1);
        }
        
        g.dispose();
    }
    
    public void reset(){
        max=1;
    }
}
