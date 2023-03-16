
package Ventanas.usuarios.InicioSesion;
import Ventanas.usuarios.DatosFacturas.registrofactura;
import Ventanas.usuarios.Cotizacion.cotizacioncliente;
import Ventanas.usuarios.Tarjeta.registrotarjetas;
import Ventanas.usuarios.InicioSesion.PaginaPrincipal;
import Ventanas.usuarios.Cotizacion.cotizacioncliente;
import Ventanas.usuarios.Cotizacion.cotizacioncliente;
import Ventanas.usuarios.Cotizacion.verenvios;
import Ventanas.usuarios.Cotizacion.verenvios;

public class opcionescliente extends javax.swing.JFrame {

    
    public opcionescliente() {
        initComponents(); 
        this.setLocationRelativeTo(null); 
    }
    
    public void nombre(){
        usuario.setText(rol);
        System.out.println(correoUsuario);
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        btntarjetas = new javax.swing.JButton();
        BtnRgFactura = new javax.swing.JButton();
        btnCotizacion = new javax.swing.JButton();
        btnenvíos = new javax.swing.JButton();
        VolverAPrinicipal = new javax.swing.JButton();
        usuario = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CLIENTE");

        btntarjetas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btntarjetas.setText("TARJETAS");
        btntarjetas.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btntarjetasActionPerformed(evt);
            }
        });

        BtnRgFactura.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BtnRgFactura.setText("DATOS DE FACTURA");
        BtnRgFactura.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnRgFacturaActionPerformed(evt);
            }
        });

        btnCotizacion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnCotizacion.setText("COTIZACION Y COMPRA");
        btnCotizacion.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCotizacionActionPerformed(evt);
            }
        });

        btnenvíos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnenvíos.setText("VER ENVIOS");
        btnenvíos.setActionCommand("Ver envíos");
        btnenvíos.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnenvíosActionPerformed(evt);
            }
        });

        VolverAPrinicipal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        VolverAPrinicipal.setText("LOG OUT");
        VolverAPrinicipal.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                VolverAPrinicipalActionPerformed(evt);
            }
        });

        usuario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btntarjetas, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(btnCotizacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnenvíos, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(VolverAPrinicipal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnRgFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(VolverAPrinicipal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btntarjetas, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnRgFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnenvíos, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntarjetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntarjetasActionPerformed
       
       registrotarjetas t = new registrotarjetas(); 
       t.setCorreoU(correoUsuario);
       t.setVisible(true);
       t.setRol(rol);
       t.iniciarTarjeta();
       t.boton(true);
       this.dispose();
    }//GEN-LAST:event_btntarjetasActionPerformed

    private void BtnRgFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRgFacturaActionPerformed
       registrofactura o = new registrofactura(); 
       o.setVisible(true);
       o.setRol(rol);
       o.setCorreoU(correoUsuario);
       o.inicio();
       o.botones(true);
       this.dispose();
    }//GEN-LAST:event_BtnRgFacturaActionPerformed

    private void btnCotizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCotizacionActionPerformed
       cotizacioncliente o = new cotizacioncliente(); 
       o.setVisible(true);
       o.iniciar();
       o.setCorreoU(correoUsuario);
       o.setRol(rol);
       this.dispose();
    }//GEN-LAST:event_btnCotizacionActionPerformed

    private void btnenvíosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnenvíosActionPerformed
       verenvios o = new verenvios(); 
       o.setVisible(true);
       o.setCorreoU(correoUsuario);
       o.setRol(rol);
       o.iniciarEnvio();
       this.dispose();
    }//GEN-LAST:event_btnenvíosActionPerformed

    private void VolverAPrinicipalActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_VolverAPrinicipalActionPerformed
    {//GEN-HEADEREND:event_VolverAPrinicipalActionPerformed
        this.dispose();
        PaginaPrincipal regresar = new PaginaPrincipal();
        regresar.setVisible(true);
        
    }//GEN-LAST:event_VolverAPrinicipalActionPerformed
   
    // -------------------------------------------------------------------------
    public String correoUsuario;
    public void setCorreoU(String CorreoU) {
        this.correoUsuario = CorreoU;
    } 
    public String getCorreoU() {
        return correoUsuario;
    }
    // -------------------------------------------------------------------------
    private String rol;
    public void setRol(String rol){
        this.rol = rol;
    }
    // -------------------------------------------------------------------------
    
    
    
    
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
            java.util.logging.Logger.getLogger(opcionescliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(opcionescliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(opcionescliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(opcionescliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
         
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new opcionescliente().setVisible(true);
            }
        });
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRgFactura;
    private javax.swing.JButton VolverAPrinicipal;
    private javax.swing.JButton btnCotizacion;
    private javax.swing.JButton btnenvíos;
    private javax.swing.JButton btntarjetas;
    private java.awt.Label usuario;
    // End of variables declaration//GEN-END:variables
}
