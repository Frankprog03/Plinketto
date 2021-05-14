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
    private double from, to, precision, max = 0;
    private boolean normalize = false;
    
    private Function f;
    
    private SupplementarDrawSet sds = null;
    
    public FunctionPlot2D(Function f, double from, double to, double precision){
        this.from = from;
        this.to = to;
        this.f = f;
        this.precision = precision;
        
        int len = (int)((to-from)/precision);
        values = new double[len];
        
        calc();
    }
    
    public final void calc(){
        int pos = 0;
        max = 0;
        
        for(double x = from; from < to && pos < values.length; x += precision){
            values[pos] = f.eval(x);
            if(values[pos] > max)
                max = values[pos];
            pos++;
        }
        
        if(normalize){
            for(int i = 0; i < values.length; i++){
                values[i] /= max;
            }
        }
    }
    
    public void setNormalization(boolean normalize){
        this.normalize = normalize;
    }
    
    public void setSDS(SupplementarDrawSet sds){
        this.sds = sds;
    }
    
    public void setLimits(double from, double to, double precision){
        this.from = from;
        this.to = to;
        
        int len = (int)((to-from)/precision);
        values = new double[len];
        
        calc();
    }
    
    public Function getFunction(){
        return f;
    }
    
    public void draw(Rectangle frame, Graphics2D g2d){
        Graphics2D g = (Graphics2D) g2d.create(frame.x, frame.y, frame.width, frame.height);
        
        int w = frame.width;
        int h = frame.height;
        double n = values.length;
        double step = frame.width / n;
        double x, y;
        double px = 0;
        double py = values[0] * h;
        
        //g.setStroke(new BasicStroke(3));
        g.translate(0, h);
        g.scale(1, -1);
        //g.drawLine(10, 0, 10, h);
        //g.drawLine(0, 10, w, 10);
        //g.translate(0, 10);
        
        g.setColor(Color.red);
        g.setStroke(new BasicStroke(1));
        for(int i = 1; i < values.length; i++){
            Line2D line = new Line2D.Double(px, py, px = i*step, py = values[i] * h);
            
            g.draw(line);
        }
        
        if(sds != null){
            sds.draw(g);
        }
    }
}
