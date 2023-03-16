
package Ventanas.usuarios.Admin;

import Ventanas.usuarios.InicioSesion.PaginaPrincipal;
import Ventanas.usuarios.Admin.RegionesPrecio;

public class opciones2 extends javax.swing.JFrame {

  
    public opciones2() {
        initComponents();
         this.setLocationRelativeTo(null); 
    }
    
    public void nombre(String a){
        usuario.setText(a);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        btnkiosco = new javax.swing.JButton();
        txtregip = new javax.swing.JButton();
        btnreportes = new javax.swing.JButton();
        btnatras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        usuario = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnkiosco.setText("Manejo de kioscos");
        btnkiosco.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnkioscoActionPerformed(evt);
            }
        });

        txtregip.setText("Manejo de regiones y precios ");
        txtregip.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtregipActionPerformed(evt);
            }
        });

        btnreportes.setText("Reportes");
        btnreportes.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnreportesActionPerformed(evt);
            }
        });

        btnatras.setText("LOG OUT");
        btnatras.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnatrasActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("ADMINISTRADOR");

        usuario.setAlignment(java.awt.Label.RIGHT);
        usuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnreportes, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                    .addComponent(txtregip, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                    .addComponent(btnkiosco, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnatras, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addComponent(btnkiosco, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtregip, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnreportes, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnatras)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnkioscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkioscoActionPerformed
       
        manejokioscos abrirkiosco = new manejokioscos();
        abrirkiosco.setVisible(true);
        abrirkiosco.setCorreoU(correo);
        abrirkiosco.iniciarkiosko(); 
        this.dispose();
    }//GEN-LAST:event_btnkioscoActionPerformed

    private void txtregipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtregipActionPerformed
        RegionesPrecio regiones = new RegionesPrecio();
        regiones.setVisible(true);
        regiones.setCorreoU(correo);
        regiones.iniciarRegiones();
        this.dispose();
    }//GEN-LAST:event_txtregipActionPerformed

    private void btnreportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreportesActionPerformed
        reportes rep = new reportes();
        rep.setVisible(true);
        rep.setCorreoU(correo);
        rep.iniciarReportes();
        this.dispose();
    }//GEN-LAST:event_btnreportesActionPerformed

    private void btnatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatrasActionPerformed
      PaginaPrincipal volver = new PaginaPrincipal(); 
      volver.setVisible(true); 
      this.dispose();
    }//GEN-LAST:event_btnatrasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(opciones2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(opciones2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(opciones2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(opciones2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new opciones2().setVisible(true);
            }
        });
    }
    // -------------------------------------------------------------------------
    private String correo;
    
    public void setCorreoU(String correo){
        this.correo = correo;
    }
    // -------------------------------------------------------------------------
    private String rol;
    public void setRol(String rol){
        this.rol = rol;
    }
    // -------------------------------------------------------------------------
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnatras;
    private javax.swing.JButton btnkiosco;
    private javax.swing.JButton btnreportes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton txtregip;
    private java.awt.Label usuario;
    // End of variables declaration//GEN-END:variables
}
