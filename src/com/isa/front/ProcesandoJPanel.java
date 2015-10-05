/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isa.front;

import com.isa.common.FrontCommon;
import com.isa.common.ICommon;
import javax.swing.JTextField;

/**
 *
 * @author JMiraballes
 */
public class ProcesandoJPanel extends javax.swing.JPanel implements ICommon {

    /**
     * Creates new form ProcesandoJPanel
     */
    public ProcesandoJPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        numeroDocumento = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Procesando Firma"));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Se está procesando la firma del documento...");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setText("Documento:");

        numeroDocumento.setEnabled(false);
        numeroDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroDocumentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(numeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(214, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void numeroDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroDocumentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField numeroDocumento;
    // End of variables declaration//GEN-END:variables

    
    public JTextField getTipoText() {
        return numeroDocumento;
    }

    public void setTipoText(JTextField tipoText) {
        this.numeroDocumento = tipoText;
    }

    public JTextField getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(JTextField numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    
    @Override
    public void setFrontPanelSize() {
        setSize(FrontCommon.SIZE_WIDTH, FrontCommon.SIZE_HEIGHT);
    }
    
}