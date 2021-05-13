package f03.plinko;

import f03.plinko.gui.MainJFrame;
import f03.plinko.math.Gaussian;

import f03.plinko.physics.Circle;
import f03.plinko.physics.Vector2;
import f03.plinko.plots.FunctionPlot2D;
import f03.plinko.plots.Histogram;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

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
    
    private double mean = 0.0, stdev = 1.0;
        
    private ArrayList<Circle> franz = new ArrayList();
    private HashSet<Circle> ballSet = new HashSet();
    
    private Random rand = new Random();
    
    private Histogram histogram = new Histogram(null);
    private FunctionPlot2D plot = new FunctionPlot2D(new Gaussian(1.0, 0.0), -3.0, 3.0, 0.001);
    
    public void generatePlinko(int b){
        franz.clear();
        
        bidoncini = new int[b+1];
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
    }
    
    public void update(Graphics2D g){
        rand = new Random(); //shuffle seed
        
        //linee bidoncini
        boolean colorSwitch = false;
        for(int i = 0; i < size+1; i++){
            int x = (-size/2+i)*30-15;
            
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
                xpos -= left;
                int index = (int) (xpos/(size*30)*bidoncini.length);
                
                //g.fillOval(xpos/(size*30), left, index, left);
                //System.out.println(index);

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
        
        //per evitare la ConcurrentModificationException
        for(Circle toRemove : removeQueue){
            ballSet.remove(toRemove);
        }
        
        mean  = Statistics.mean(bidoncini);
        stdev = Statistics.stdev(bidoncini, mean);
        
        histogram.draw(new Rectangle((-size/2+1)*30-15, bottom + 10, (size-1)*30, 200), g);
        plot.draw(new Rectangle((-size/2+1)*30-15, bottom + 210, (size-1)*30, 200), g);
    }
    
    public void addBall(Circle c){
        ballSet.add(c);
    }
    
    public void removeBall(Circle c){
        ballSet.remove(c);
    }
    
    public void increment(int pos){
        bidoncini[pos]++;
    }
    
    public void reset(){
        bidoncini = new int[bidoncini.length];
        histogram.reset();
    }
    
    public void set(int pos, int val){
        bidoncini[pos] = val;
    }
    
    public int get(int pos){
        return bidoncini[pos];
    }
    
    public int[] getBidoncini(){
        return bidoncini;
    }
}
