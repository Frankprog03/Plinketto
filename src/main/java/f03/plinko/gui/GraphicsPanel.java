package f03.plinko.gui;

import f03.plinko.physics.Circle;
import f03.plinko.physics.Vector2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.Timer;

/**
 *
 * @author Sollazzi
 */
public class GraphicsPanel extends javax.swing.JPanel {
    Circle c = new Circle(new Vector2(529/2.0, 0.0), 2.0, false);
        
    ArrayList<Circle> franz = new ArrayList();
    
    private Timer timer = new Timer(10, (ActionEvent evt) -> {
        repaint();
    });
    
    public GraphicsPanel() {
        initComponents();
        
        generatePlinko(10);
        
        timer.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 787, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        //c0.setPosition(new Vector2(evt.getX(), evt.getY()));
        //repaint();
    }//GEN-LAST:event_formMouseMoved

    @Override
    protected void paintComponent(Graphics g2){
        super.paintComponent(g2);
        
        Graphics2D g = (Graphics2D) g2;
        
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int w = getWidth();
        int h = getHeight();
        
        g.translate(w/2, 0);
        
        for(Circle c0 : franz){
            c0.draw(g);
            c.checkCollision(c0);
            c.update();
            c.draw(g);
        }
    }
    
    public void generatePlinko(int b){
        franz.clear();
        
        for(int i=0; i<b; i++){ //i=n. colonna a partire dal centro	
            for(int k=i; k<b; k+=2){ //k=n. pirulo della colonna
                //disegno la colonna alla destra di quella centrale a una certa distanza
                Vector2 v = new Vector2(i*10, 100+k*10);
                Circle c = new Circle(v, 5);
                franz.add(c);
                //disegno la colonna corrispondente ma a sinistra 
                v = new Vector2(-i*10, 100+k*10);
                c = new Circle(v, 5);
                franz.add(c);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
