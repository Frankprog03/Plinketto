package f03.plinko.gui;

import f03.plinko.SettingsHolder;
import f03.plinko.SettingsHolder.PlinkettoMode;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author GABRIELE MARIA
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panel = new f03.plinko.gui.GraphicsPanel(this);
        lateralPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        input_nBidoni = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        button_startSim = new javax.swing.JButton();
        slider_genvel = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        button_addBall = new javax.swing.JButton();
        input_nPalline = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        label_nPalline = new javax.swing.JLabel();
        label_variance = new javax.swing.JLabel();
        label_stdev = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        label_cstdev = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        label_mean = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        mpp = new f03.plinko.gui.MeanPlotPanel();
        button_generateFile = new javax.swing.JButton();
        comboBox_fileFormat = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        radio_auto = new javax.swing.JRadioButton();
        radio_manual = new javax.swing.JRadioButton();
        radio_random = new javax.swing.JRadioButton();
        buttonGroup2.add(radio_random);
        radio_physics = new javax.swing.JRadioButton();
        buttonGroup2.add(radio_physics);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        input_nBidoni.setText("15");
        input_nBidoni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_nBidoniActionPerformed(evt);
            }
        });

        jLabel6.setText("50");

        jLabel1.setText("Bidoni");

        button_startSim.setText("Inizia simulazione");
        button_startSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_startSimActionPerformed(evt);
            }
        });

        slider_genvel.setMinimum(1);
        slider_genvel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        slider_genvel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slider_genvelStateChanged(evt);
            }
        });

        jLabel2.setText("Palline");

        button_addBall.setText("Aggiungi una pallina");
        button_addBall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_addBallActionPerformed(evt);
            }
        });

        input_nPalline.setText("100");

        jLabel5.setText("Velocità generazione");

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Dev. standard");

        jLabel11.setText("Dev. st. corretta");

        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("Media");

        label_nPalline.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        label_nPalline.setText("0");

        label_variance.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        label_variance.setText("-");

        label_stdev.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        label_stdev.setForeground(new java.awt.Color(255, 0, 0));
        label_stdev.setText("-");

        jLabel12.setText("Varianza");

        label_cstdev.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        label_cstdev.setText("-");

        jLabel3.setText("N° palline");

        label_mean.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        label_mean.setForeground(new java.awt.Color(0, 0, 255));
        label_mean.setText("-");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(label_variance, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                    .addComponent(label_cstdev, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(label_mean, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_nPalline, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_stdev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(label_nPalline))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_mean)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_stdev)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_cstdev)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(label_variance))
                .addGap(6, 6, 6))
        );

        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        mpp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        button_generateFile.setText("Genera file");
        button_generateFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_generateFileActionPerformed(evt);
            }
        });

        comboBox_fileFormat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".rtf", ".txt" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(input_nBidoni)
                                    .addComponent(input_nPalline, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(slider_genvel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(button_generateFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboBox_fileFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(button_startSim, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(button_addBall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(mpp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input_nBidoni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(input_nPalline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slider_genvel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mpp, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBox_fileFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_generateFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_addBall)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_startSim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
        );

        buttonGroup1.add(radio_auto);
        radio_auto.setText("Automatico");
        radio_auto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_autoActionPerformed(evt);
            }
        });

        buttonGroup1.add(radio_manual);
        radio_manual.setText("Manuale");
        radio_manual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_manualActionPerformed(evt);
            }
        });

        radio_random.setSelected(true);
        radio_random.setText("Modalità casuale");
        radio_random.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_randomActionPerformed(evt);
            }
        });

        radio_physics.setText("Modalità fisica");
        radio_physics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_physicsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radio_manual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radio_auto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radio_random)
                    .addComponent(radio_physics)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio_manual)
                    .addComponent(radio_random))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(radio_auto)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(radio_physics))))
        );

        javax.swing.GroupLayout lateralPanelLayout = new javax.swing.GroupLayout(lateralPanel);
        lateralPanel.setLayout(lateralPanelLayout);
        lateralPanelLayout.setHorizontalGroup(
            lateralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lateralPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(lateralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        lateralPanelLayout.setVerticalGroup(
            lateralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lateralPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lateralPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lateralPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void input_nBidoniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_nBidoniActionPerformed
        
    }//GEN-LAST:event_input_nBidoniActionPerformed

    private void button_addBallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_addBallActionPerformed
        panel.addPallina();
        button_generateFile.setVisible(false);
        comboBox_fileFormat.setVisible(false);
    }//GEN-LAST:event_button_addBallActionPerformed

    private void radio_manualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_manualActionPerformed
        input_nPalline.setVisible(false);
        button_startSim.setVisible(false);
        button_addBall.setVisible(true);
        jLabel2.setVisible(false);
        jLabel5.setVisible(false);
        slider_genvel.setVisible(false);
        jLabel6.setVisible(false);
    }//GEN-LAST:event_radio_manualActionPerformed

    private void radio_autoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_autoActionPerformed
        button_addBall.setVisible(false);
        button_startSim.setVisible(true);
        input_nPalline.setVisible(true);
        jLabel2.setVisible(true);
        jLabel5.setVisible(true);
        slider_genvel.setVisible(true);
        jLabel6.setVisible(true);
    }//GEN-LAST:event_radio_autoActionPerformed

    private void button_startSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_startSimActionPerformed
        int np = Integer.parseInt(input_nPalline.getText());
        int d = slider_genvel.getValue();
        
        panel.setNPalline(np);
        panel.setDelay(d);
    }//GEN-LAST:event_button_startSimActionPerformed

    private void slider_genvelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_genvelStateChanged
        jLabel6.setText(Integer.toString(slider_genvel.getValue()));
        panel.setDelay(slider_genvel.getValue());
    }//GEN-LAST:event_slider_genvelStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int np = Integer.parseInt(input_nBidoni.getText());
        
        np = clampNumeroBidoni(np);
        
        panel.setNumber(np);
        
        panel.setfinito(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void button_generateFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_generateFileActionPerformed
        int b=Integer.parseInt(input_nBidoni.getText());
        int np=Integer.parseInt(input_nPalline.getText());
        int bid[]=panel.getBidoncini();
        double med=panel.getMean();
        double sd=panel.getStdev();
        double csd=panel.getCorstdev();
        
        JFileChooser chooser = new JFileChooser();
        
        chooser.showSaveDialog(this);
        
        File file = chooser.getSelectedFile();
        
        String s = file.getPath() + (String) comboBox_fileFormat.getSelectedItem();
        
        file = new File(s);
        
        FileWriter f = null;
        
        try {
            f = new FileWriter(file);
        } catch (IOException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PrintWriter p = new PrintWriter(f);
        p.printf("Simulazione di un plinko %dX%d con %d palline.\n",b,b,np);
        
        for(int i=0;i<b;i++){
            p.printf("Bidone %d: %d palline.\n",i+1,bid[i]);
        }
        
        p.printf("Media: %f\nDeviazione standard:%f\nDeviazione standard corretta:%f\nVarianza:%f\n",med,sd,csd,sd*sd);
        p.close();
    }//GEN-LAST:event_button_generateFileActionPerformed

    private void radio_randomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_randomActionPerformed
        SettingsHolder.mode = PlinkettoMode.RANDOM;
    }//GEN-LAST:event_radio_randomActionPerformed

    private void radio_physicsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_physicsActionPerformed
        SettingsHolder.mode = PlinkettoMode.PHYSICS;
    }//GEN-LAST:event_radio_physicsActionPerformed
    
    private int clampNumeroBidoni(int np){
        if(np > 30){
            input_nBidoni.setText("30");
            JOptionPane.showMessageDialog(this, "La dimensione massima del plinko è di 30. Verrà inizializzato un plinko con questa dimensione.", "Attenzione.", JOptionPane.WARNING_MESSAGE);
            return 30;
        }
        
        if(np < 3){
            input_nBidoni.setText("3");
            JOptionPane.showMessageDialog(this, "La dimensione minima del plinko è di 3. Verrà inizializzato un plinko con questa dimensione.", "Attenzione.", JOptionPane.WARNING_MESSAGE);
            return 3;
        }
        
        return np;
    }
    
    public void updateCounter(int c){
        label_nPalline.setText(Integer.toString(c));
    }
    
    public void showStats(double m,double s,double c){
        label_mean.setText(Double.toString(Math.round(m*1000)/1000.0));
        label_stdev.setText(Double.toString(Math.round(s*1000)/1000.0));
        label_cstdev.setText(Double.toString(Math.round(c*1000)/1000.0));
        label_variance.setText(Double.toString(Math.round(s*s*1000)/1000.0));
    }
    
    public void showfile(){
        button_generateFile.setVisible(true);
        comboBox_fileFormat.setVisible(true);
    }
    
    public void hidefile(){
        button_generateFile.setVisible(false);
        comboBox_fileFormat.setVisible(false);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            MainJFrame cavva=new MainJFrame();
            
            cavva.setVisible(true);
            
            cavva.button_addBall.setVisible(false);
            cavva.button_startSim.setVisible(false);
            cavva.input_nPalline.setVisible(false);
            cavva.jLabel2.setVisible(false);
            cavva.slider_genvel.setVisible(false);
            cavva.jLabel5.setVisible(false);
            cavva.jLabel6.setVisible(false);
            cavva.button_generateFile.setVisible(false);
            cavva.comboBox_fileFormat.setVisible(false);
            
            SettingsHolder.mainFrame = cavva;
            
            cavva.panel.init();
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton button_addBall;
    private javax.swing.JButton button_generateFile;
    private javax.swing.JButton button_startSim;
    private javax.swing.JComboBox<String> comboBox_fileFormat;
    private javax.swing.JTextField input_nBidoni;
    private javax.swing.JTextField input_nPalline;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel label_cstdev;
    private javax.swing.JLabel label_mean;
    private javax.swing.JLabel label_nPalline;
    private javax.swing.JLabel label_stdev;
    private javax.swing.JLabel label_variance;
    public javax.swing.JPanel lateralPanel;
    public f03.plinko.gui.MeanPlotPanel mpp;
    private f03.plinko.gui.GraphicsPanel panel;
    private javax.swing.JRadioButton radio_auto;
    private javax.swing.JRadioButton radio_manual;
    private javax.swing.JRadioButton radio_physics;
    private javax.swing.JRadioButton radio_random;
    private javax.swing.JSlider slider_genvel;
    // End of variables declaration//GEN-END:variables
}
