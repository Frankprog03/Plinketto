package f03.plinko.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import java.util.ArrayList;

/**
 *
 * @author Sollazzi
 */
public class MeanPlotPanel extends javax.swing.JPanel {
    private ArrayList<Double> means = new ArrayList<>();
    private ArrayList<Double> stdevs = new ArrayList<>();
    
    private int max = 100;
    
    private double maxmean = 0.0;
    
    public MeanPlotPanel() {
        initComponents();
    }
    
    @Override
    protected void paintComponent(Graphics g2){
        super.paintComponent(g2);
        
        double w = getWidth();
        double h = getHeight();
        
        Graphics2D g = (Graphics2D) g2;
        
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g.translate(0, h);
        g.scale(1, -1);
        
        AffineTransform scale = AffineTransform.getScaleInstance(w, h);
        
        double step = (means.size() < max) ? 1.0/(double)means.size() : 1.0/(double)max;
        double px = 0;
        if(means.size() > 0){
            double pymean = means.get(0) / maxmean;
            double pystdev = stdevs.get(0) / maxmean;
            g.setStroke(new BasicStroke(2));
            for(int i = 1; i < means.size() && i < max; i++){
                double mean = means.get(i) / maxmean;
                double stdev = stdevs.get(i) / maxmean;
                
                Point2D.Double p1 = new Point2D.Double(px, pymean);
                Point2D.Double p2 = new Point2D.Double(px + step, mean);
                Point2D.Double p1s1 = new Point2D.Double(px, pymean + pystdev);
                Point2D.Double p2s1 = new Point2D.Double(px + step, mean + stdev);
                Point2D.Double p1s2 = new Point2D.Double(px, pymean - pystdev);
                Point2D.Double p2s2 = new Point2D.Double(px + step, mean - stdev);
                
                scale.transform(p1, p1);
                scale.transform(p2, p2);
                scale.transform(p1s1, p1s1);
                scale.transform(p2s1, p2s1);
                scale.transform(p1s2, p1s2);
                scale.transform(p2s2, p2s2);

                g.setColor(Color.blue);
                g.draw(new Line2D.Double(p1, p2));
                g.setColor(Color.red);
                g.draw(new Line2D.Double(p1s1, p2s1));
                g.draw(new Line2D.Double(p1s2, p2s2));

                pymean = mean;
                pystdev = stdev;
                px += step;
            }
        }
        
        g.scale(1, -1);
        g.translate(0, -h);
    }

    public void update(double mean, double stdev){
        means.add(mean);
        stdevs.add(stdev);
        
        if(mean + stdev > maxmean) maxmean = mean + stdev;
        
        repaint();
    }
    
    public void reset(){
        means.clear();
        stdevs.clear();
        
        maxmean = 0;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        slider_max = new javax.swing.JSlider();
        label_max = new javax.swing.JLabel();

        jLabel1.setText("Numero di dati massimo");

        slider_max.setMaximum(1000);
        slider_max.setMinimum(5);
        slider_max.setValue(100);
        slider_max.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slider_maxStateChanged(evt);
            }
        });

        label_max.setText("100");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slider_max, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_max)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_max)
                    .addComponent(slider_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void slider_maxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_maxStateChanged
        int v = slider_max.getValue();
        
        label_max.setText(Integer.toString(v));
        max = v;
    }//GEN-LAST:event_slider_maxStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label_max;
    private javax.swing.JSlider slider_max;
    // End of variables declaration//GEN-END:variables
}
