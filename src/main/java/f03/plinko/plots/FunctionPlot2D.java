package f03.plinko.plots;

import f03.plinko.math.Function;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

/**
 *
 * @author Sollazzi
 */
public class FunctionPlot2D {
    private double[] values;
    private double from, to, precision;
    
    private Function f;
    
    private SupplementarLineSet sls = null;
    
    public FunctionPlot2D(Function f, double from, double to, double precision){
        this.from = from;
        this.to = to;
        this.f = f;
        this.precision = precision;
        
        int len = (int)((to-from)/precision);
        values = new double[len];
        
        calc();
    }
    
    private void calc(){
        int pos = 0;
        for(double x = from; from < to && pos < values.length; x += precision){
            values[pos++] = f.eval(x);
        }
    }
    
    public void setSLS(SupplementarLineSet sls){
        this.sls = sls;
    }
    
    public void setLimits(double from, double to, double precision){
        this.from = from;
        this.to = to;
        
        int len = (int)((to-from)/precision);
        values = new double[len];
        
        calc();
    }
    
    public void draw(Rectangle frame, Graphics2D g2d){
        Graphics2D g = (Graphics2D) g2d.create(frame.x, frame.y, frame.width, frame.height);
        
        int w = frame.width;
        int h = frame.height;
        double n = values.length;
        double step = frame.width / n;
        
        double px = 0;
        double py = values[0];
        g.setColor(Color.red);
        g.setStroke(new BasicStroke(3));
        for(int i = 1; i < values.length; i++){
            Line2D line = new Line2D.Double(px, py, i*step, values[i] * h);
            
            g.draw(line);
        }
        
        if(sls != null){
            sls.draw(g);
        }
    }
}
