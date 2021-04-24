package f03.plinko.gui;

import f03.plinko.physics.Circle;
import f03.plinko.physics.Vector2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;

import javax.swing.Timer;

/**
 *
 * @author Sollazzi
 */
public class GraphicsPanel extends javax.swing.JPanel {
    
    private Circle c = new Circle(new Vector2(100, 100), 10);
    
    private Timer timer = new Timer(10, (ActionEvent evt) -> {
        c.update();
        repaint();
    });
    
    public GraphicsPanel() {
        initComponents();
        
        timer.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

    @Override
    protected void paintComponent(Graphics g2){
        super.paintComponent(g2);
        
        Graphics2D g = (Graphics2D) g2;
        
        int w = getWidth();
        int h = getHeight();
        
        c.draw(g);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
