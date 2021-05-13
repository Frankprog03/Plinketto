package f03.plinko.gui;

import f03.plinko.Plinko;
import f03.plinko.physics.Circle;
import f03.plinko.physics.Vector2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;

import javax.swing.Timer;

/**
 *
 * @author Sollazzi
 */
public class GraphicsPanel extends javax.swing.JPanel {
    Plinko plinko = new Plinko();
    
    private Timer timer = new Timer(10, (ActionEvent evt) -> {
        repaint();
    });
    
    public GraphicsPanel() {
        initComponents();
        
        plinko.generatePlinko(14);
        
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
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
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
         
    }//GEN-LAST:event_formMouseMoved

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        plinko.addBall(
                new Circle(
                        new Vector2(
                                evt.getX() - getWidth()/2, 
                                evt.getY()
                        ), 
                        4.0, 
                        false,
                        5.0
                )
        );
    }//GEN-LAST:event_formMouseClicked

    @Override
    protected void paintComponent(Graphics g2){
        super.paintComponent(g2);
        
        Graphics2D g = (Graphics2D) g2;
        
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int w = getWidth();
        int h = getHeight();
        
        g.translate(w/2, 0);
        
        plinko.update(g);
    }
    
    public void setnumber(int b){
        plinko.reset();
        plinko.generatePlinko(b-1);
    }

    public void setnpalline(int np){
        for(int i=0;i<np;i++) plinko.addBall(new Circle(new Vector2(0, 10.0), 4.0, false));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
