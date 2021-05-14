package f03.plinko.gui;

import f03.plinko.Plinko;
import f03.plinko.physics.Circle;
import f03.plinko.physics.Vector2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import javax.swing.JOptionPane;

import javax.swing.Timer;

/**
 *
 * @author Sollazzi
 * @author GABRIELE MARIA
 */
public class GraphicsPanel extends javax.swing.JPanel {
    Plinko plinko = new Plinko();
     
    int ct=0;
    int cp=0,pt=0;
    int delay=1;
    double mean=0,stdev=0;
    MainJFrame mjfr;
    
    private boolean fromIDE = false;
    
    private Timer timer = new Timer(10, (ActionEvent evt) -> {
        repaint();
        ct+=10;
        if((ct%((101-delay)*10)==0)&&(cp>0)){
            plinko.addBall(new Circle(new Vector2(0, 10.0), 4.0, false));
            cp--;
            mjfr.updateCounter(plinko.getNumberOfBalls());
            if(cp==0) mjfr.file();
        }
        mjfr.showStats(plinko.getMean(),plinko.getStdev(),plinko.getCorstdev());
    });
    
    public GraphicsPanel(){ fromIDE = true; }
    
    public GraphicsPanel(MainJFrame m) {
        initComponents();
        
        this.mjfr=m;
    }
    
    public void init(){
        plinko.generatePlinko(15);
        
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
        /*
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
        */
    }//GEN-LAST:event_formMouseClicked

    @Override
    protected void paintComponent(Graphics g2){
        super.paintComponent(g2);
        
        if(fromIDE) return;
        
        Graphics2D g = (Graphics2D) g2;
        
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int w = getWidth();
        int h = getHeight();
        
        g.translate(w/2, 0);
        
        try{
            plinko.update(g);
        } catch(Exception e){
            timer.stop();
            JOptionPane.showMessageDialog(this, 
                    "Si è verificato un errore durante l'esecuzione del plinko."
                            + "\nDettagli:\n" + e.toString(), "Errore", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(System.err);
            Arrays.asList(Window.getWindows()).forEach(f -> f.dispose());
        }
    }
    
    public void setNumber(int b){
        plinko.reset();
        plinko.generatePlinko(b-1);
    }

    public void setNPalline(int np){
        cp=np;
        pt=np;
    }
    
    public void addPallina(){
        plinko.addBall(new Circle(new Vector2(0, 10.0), 4.0, false));
    }
    
    public void setDelay(int d){
        delay=d;
    }
    
    public double getMean(){
        return plinko.getMean();
    }
    
    public double getStdev(){
        return plinko.getStdev();
    }
    
    public double getCorstdev(){
        return plinko.getCorstdev();
    }
    
    public int[] getBidoncini(){
        return plinko.getBidoncini();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
