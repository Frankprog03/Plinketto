package f03.plinko;

import f03.plinko.gui.MainJFrame;
import f03.plinko.math.Gaussian;

import f03.plinko.physics.Circle;
import f03.plinko.physics.Vector2;
import f03.plinko.plots.FunctionPlot2D;
import f03.plinko.plots.Histogram;
import f03.plinko.plots.SupplementarDrawSet;
import f03.plinko.plots.SupplementarDrawSet.StrokeElement;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import static java.lang.Double.isNaN;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author Sollazzi
 * @author GABRIELE MARIA
 */
public class Plinko {
    public static void main(String[] args){
        MainJFrame.main(args);
    }
    
    private int[] bidoncini;
    private int width = -1;
    private int left = -1;
    private int bottom = -1;
    private int size = -1;
    
    private int cnt = 0;
    
    private Double mean = 0.0;
    private Double stdev = 1.0;
    private Double corstdev = 1.0;
        
    private ArrayList<Circle> franz = new ArrayList();
    private HashSet<Circle> ballSet = new HashSet();
    
    private Random rand = new Random();
    
    private Gaussian gauss = new Gaussian(1.0, 0.0);
    private Histogram histogram = new Histogram(null);
    private FunctionPlot2D plot;
    
    private boolean finito=false;
    
    public void generatePlinko(int b){
        franz.clear();
        
        bidoncini = new int[b];
        histogram.bind(bidoncini);
        
        for(int i=0; i<b; i++){
            for(int k=i; k<b; k+=2){
                Vector2 v = new Vector2(i*15, 100+k*15);
                Circle c = new Circle(v, 5);
                franz.add(c);
                
                v = new Vector2(-i*15, 100+k*15);
                c = new Circle(v, 5);
                franz.add(c);
            }
        }
        
        size = b;
        bottom = 100+15*(b-1);
        left = -b*15;
        
        plot = new FunctionPlot2D(gauss = new Gaussian(Double.NaN, Double.NaN), 0.0, b, 0.01);
        plot.setNormalization(true);
        
        if(SettingsHolder.mainFrame != null){
            int minimumWidth = -2*left+SettingsHolder.mainFrame.lateralPanel.getWidth() + 80;
            int minimumHeight = bottom + 480;
            
            Dimension minAndPreferred = new Dimension(minimumWidth, minimumHeight);
            Dimension current = SettingsHolder.mainFrame.getSize();
            
            SettingsHolder.mainFrame.setPreferredSize(minAndPreferred);
            SettingsHolder.mainFrame.setMinimumSize(minAndPreferred);
            if(minAndPreferred.width > current.width || minAndPreferred.height > current.height)
                SettingsHolder.mainFrame.setSize(minAndPreferred);
        }
    }
    
    public void update(Graphics2D g){
        rand = new Random(); //shuffle seed
        
        int s = (size % 2 == 1) ? 30 : 15;
        
        //linee bidoncini
        boolean colorSwitch = false;
        for(int i = 0; i < size+1; i++){
            int x = (-size/2+i)*30 - s;

            g.setStroke(new BasicStroke(3));
            g.setColor((colorSwitch) ? Color.red : new Color(127, 0, 0));
            g.drawLine(x, bottom, x + 30, bottom);

            colorSwitch =! colorSwitch;
        }
        
        //update plinketto e palline
        g.setColor(Color.black);
        for(Circle c0 : franz){
            c0.draw(g);
        }
        
        boolean physicsMode = SettingsHolder.mode == SettingsHolder.PlinkettoMode.PHYSICS;
        ArrayList<Circle> removeQueue = new ArrayList<>();
        for(Circle ball : ballSet){
            ball.update();
            double xpos = ball.getPosition().x;
            double ypos = ball.getPosition().y;
            if(ypos > bottom){
                xpos -= left - 15;
                int index = (int) -(xpos*size/(2*left));

                bidoncini[index]++;

                removeQueue.add(ball);
            }
            
            for (Circle c0 : franz) {
                if(!ball.checkCollision(c0, physicsMode).isZero()){
                    if(!physicsMode){
                        boolean rightFlag = rand.nextInt(2) == 0;
                        double vel = Math.sqrt(0.75);
                        
                        Vector2 correctedPos = new Vector2(c0.getPosition().sub(0, c0.getRadius() + 5));
                        Vector2 correctedVel = new Vector2((rightFlag) ? vel : -vel, 0);
                        
                        ball.setPosition(correctedPos);
                        ball.setVelocity(correctedVel);
                    }
                    break;
                }
            }
            ball.draw(g);
        }
        
        mean  = Statistics.mean(bidoncini);
        stdev = Statistics.stdev(bidoncini, mean);
        corstdev= Statistics.corstdev(bidoncini, mean);
        
        //per evitare la ConcurrentModificationException
        for(Circle toRemove : removeQueue){
            ballSet.remove(toRemove);
        
            SettingsHolder.mainFrame.mpp.update(mean, stdev);
            
            if(ballSet.isEmpty()) finito=true;
        }
        
        if(mean != gauss.getMean() || stdev != gauss.getStandardDeviation()){
            SupplementarDrawSet sds = new SupplementarDrawSet();
            
            
            sds.add(
                    new StrokeElement(
                            new Color(255, 0, 0, 50), 
                            new BasicStroke(1), 
                            new Rectangle2D.Double(
                                    (mean-1 - stdev) * -2*left / (double)size + 15,
                                    0, 
                                    (2 * stdev) * -2*left / (double)size, 
                                    200),
                            true
                    )
            );
            
            sds.add(
                    new StrokeElement(
                            Color.blue, 
                            new BasicStroke(1, 
                                    BasicStroke.CAP_SQUARE, 
                                    BasicStroke.JOIN_BEVEL, 
                                    1.0f,
                                    new float[]{5.0f, 3.0f},
                                    0.0f), 
                            new Line2D.Double(
                                    (mean-1)* -2*left / (double)size + 15, 0, (mean-1) * -2*left / (double)size + 15, 200
                            )
                    )
            );
            
            
            gauss.setMean(mean-1);
            gauss.setStandardDeviation(stdev);

            plot.setSDS(sds);
            plot.calc();
        }
        
        histogram.draw(new Rectangle(-size/2*30-s, bottom + 10, (size + 1)*30, 200), g);
        plot.draw(new Rectangle(-size/2*30-s, bottom + 220, (size + 1)*30, 200), g);
    }
    
    public void addBall(Circle c){
        ballSet.add(c);
        
        if(SettingsHolder.mainFrame != null){
            SettingsHolder.mainFrame.updateCounter(ballSet.size());
        }
    }
    
    public void removeBall(Circle c){
        ballSet.remove(c);
    }
    
    public void increment(int pos){
        bidoncini[pos]++;
        
        cnt++;
    }
    
    public void reset(){
        bidoncini = new int[bidoncini.length];
        ballSet.clear();
        histogram.reset();
        SettingsHolder.mainFrame.mpp.reset();
        
        if(SettingsHolder.mainFrame != null){
            SettingsHolder.mainFrame.updateCounter(0);
        }
        
        cnt = 0;
    }
    
    public void set(int pos, int val){
        bidoncini[pos] = val;
    }

    public void setFinito(boolean finito) {
        this.finito = finito;
    }

    public int get(int pos){
        return bidoncini[pos];
    }
    
    public int[] getBidoncini(){
        return bidoncini;
    }

    public double getMean() {
        if(isNaN(mean)) return 0;
        return mean;
    }

    public double getStdev() {
        if(isNaN(stdev)) return 0;
        return stdev;
    }
    
    public double getCorstdev() {
        if(isNaN(corstdev)) return 0;
        return corstdev;
    }
    
    public int getNumberOfBalls(){
        return cnt + ballSet.size();
    }
    
    public static void drawCenteredString(Graphics g, String text, Rectangle rect) {
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        
        g.drawString(text, x, y);
    }
    
    public boolean getFinito(){
        return finito;
    }
}
