package f03.plinko;

import f03.plinko.gui.MainJFrame;
import f03.plinko.physics.Circle;
import f03.plinko.physics.Vector2;
import java.awt.Graphics2D;

import java.util.ArrayList;

/**
 *
 * @author Sollazzi
 */
public class Plinko {
    
    public static void main(String[] args){
        MainJFrame.main(args);
    }
        
    private ArrayList<Circle> franz = new ArrayList();
    
    public void generatePlinko(int b){
        franz.clear();
        
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
    }
    
    public void update(Graphics2D g, Circle c){
        for(Circle c0 : franz){
            c0.draw(g);
            c.checkCollision(c0);
            c.draw(g);
        }
    }
}
