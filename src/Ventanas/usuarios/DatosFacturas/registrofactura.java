
package Ventanas.usuarios.DatosFacturas;

import Ventanas.usuarios.InicioSesion.opcionescliente;
import Ventanas.usuarios.InicioSesion.opcionescliente;
import Ventanas.usuarios.Cotizacion.cotizacioncliente;
import Ventanas.usuarios.DatosFacturas.Factura;
import Ventanas.usuarios.DatosFacturas.Factura;
import Ventanas.usuarios.DatosFacturas.Logics;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.UUID;
import javax.swing.table.DefaultTableModel;

public class registrofactura extends javax.swing.JFrame {
 
     public registrofactura() {
        initComponents(); 
        this.setLocationRelativeTo(null); 
    }
    
     public void botones(boolean valor){
         atras.setEnabled(valor);
         cerrar.setEnabled(!valor);
     }
     public void iniciar(boolean valor){
         botones(valor);
         
     }
     
     public void inicio(){
         iniciarFactura();
     }
    
     public void iniciarFactura(){
        System.out.println(correo);
        String[] columnas = {"Alias de facturacion"};
            DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

            for(int i = 0;i<Logics.tamaño();i++)
            {
                
                if(Logics.completa(i).getUsuario().equalsIgnoreCase(correo)){
                    
                Object[] fila = 
                {Logics.completa(i).getCodigo()};
                modelo.addRow(fila);
                }
             }
             jTable1.setModel(modelo);
    }
     
    public String Tarjeta(){
    int row = jTable1.getSelectedRow();
    int column = 0; // seleccionamos la segunda columna
    String value = "vacio";
    if(row!=-1){
       String a = jTable1.getModel().getValueAt(row, column).toString();  
        if(!a.isEmpty()){
            value = a;
            
        }else{
            System.out.println("Datos vacios");
            value="vacio";  
        }
    }else{
        value = "vacio";
    }
    return value;
    }
     
     public boolean administrar(){
        
        if(Logics.tamaño()>0){
            return true;
        }else{
            return false;
        }
           
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        atras = new javax.swing.JButton();
        txtnombre = new javax.swing.JTextField();
        label = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnit = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        codigoTxt = new javax.swing.JLabel();
        ingresoCodigo = new javax.swing.JTextField();
        cerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        txtmodificar = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar Datos");

        atras.setText("Atrás");
        atras.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                atrasActionPerformed(evt);
            }
        });

        label.setText("Nombre completo: ");

        jLabel2.setText("Dirección: ");

        jLabel3.setText("NIT: ");

        txtnit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtnitActionPerformed(evt);
            }
        });

        btnguardar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnguardarActionPerformed(evt);
            }
        });

        codigoTxt.setText("Alias de Facturacion:");

        ingresoCodigo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ingresoCodigoActionPerformed(evt);
            }
        });

        cerrar.setText("Cerrar");
        cerrar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cerrarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Title 1"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnModificarActionPerformed(evt);
            }
        });

        txtmodificar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(atras)
                        .addGap(183, 183, 183)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnguardar))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(cerrar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                                            .addComponent(txtdireccion)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtnit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(ingresoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel2)
                                            .addComponent(label)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnModificar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnEliminar))
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(30, 30, 30)))))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(txtmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminar)
                        .addComponent(btnModificar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ingresoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atras)
                    .addComponent(btnguardar)
                    .addComponent(cerrar))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        opcionescliente o = new opcionescliente(); 
        o.setVisible(true);
        o.setRol(rol);
        o.setCorreoU(correo);
        o.nombre();
        this.dispose();
    }//GEN-LAST:event_atrasActionPerformed

    private void txtnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnitActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
      
        if(modificar==false){
          txtmodificar.setText("");
          jTable1.setEnabled(true);
          String nombre = txtnombre.getText(); 
          String direc = txtdireccion.getText(); 
          String nit = txtnit.getText(); 
          String codigo = ingresoCodigo.getText();

          if(!txtnombre.getText().isEmpty() && !txtdireccion.getText().isEmpty() &&
                  !txtnit.getText().isEmpty() && !ingresoCodigo.getText().isEmpty()){

              Factura temporal = new Factura (nombre,direc,nit,correo, codigo);

              if(Logics.insertar(temporal)){
                  JOptionPane.showMessageDialog(this, "Datos registrados");
                  txtnombre.setText("");
                  txtdireccion.setText("");
                  txtnit.setText("");
                  ingresoCodigo.setText("");
                  System.out.println(correo);
                  iniciarFactura();

              }else{
                  JOptionPane.showMessageDialog(this, "Datos ya existentes");
              }

          }else{
              JOptionPane.showMessageDialog(this, "Hay campos vacios"); 
          }
        }else{
            
            btnguardar.setText("ACTUALIZAR");
            
            String nom = txtnombre.getText();
            String alias = ingresoCodigo.getText();
            String direccion = txtdireccion.getText();
            String nits = txtnit.getText();

              if(!nom.isEmpty() && !alias.isEmpty() && !direccion.isEmpty()&& !nits.isEmpty()){

                    String no= Tarjeta();
                    if(!no.equalsIgnoreCase("vacio"))
                    {
                        for(int i =0;i< Logics.tamaño();i++){
                            if(Logics.completa(i).getCodigo().equalsIgnoreCase(no))
                            {

                               if(Logics.buscar(correo,alias)==-1){

                                   Logics.completa(i).setCodigo(alias);
                                   Logics.completa(i).setNombrecom(nom);
                                   Logics.completa(i).setNit(nits);
                                   Logics.completa(i).setDireccion(direccion);
                                   
                                   btnguardar.setText("Guardar");
                                   setModificar(false);
                                   
                                   txtnombre.setText("");
                                   txtdireccion.setText("");
                                   ingresoCodigo.setText("");
                                   txtnit.setText("");
                                   txtmodificar.setText("");
                                   jTable1.setEnabled(true);
                                   iniciarFactura();
                                   
                               }else{
                                   JOptionPane.showMessageDialog(this, "Registro existente");
                                   
                                   txtnombre.setText("");
                                   txtdireccion.setText("");
                                   ingresoCodigo.setText("");
                                   txtnit.setText("");
                                   
                               }

                            }
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, "Seleccione un registro");
                    }
            
        }else{
                  JOptionPane.showMessageDialog(this, "Hay campos vacios");
              }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void ingresoCodigoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ingresoCodigoActionPerformed
    {//GEN-HEADEREND:event_ingresoCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingresoCodigoActionPerformed

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cerrarActionPerformed
    {//GEN-HEADEREND:event_cerrarActionPerformed
        cotizacioncliente o = new cotizacioncliente();
        this.dispose();
    }//GEN-LAST:event_cerrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnModificarActionPerformed
    {//GEN-HEADEREND:event_btnModificarActionPerformed
       
        if(administrar())
           {
            String nombre = Tarjeta();
            if(!nombre.equalsIgnoreCase("vacio")){
                setModificar(true);
                txtmodificar.setText("Esta modificando el registro: "+nombre);
                jTable1.setEnabled(false);
                btnguardar.setText("ACTUALIZAR");
            
            }else{
                JOptionPane.showMessageDialog(this, "Seleccione registro");
            }
               
               
           }else{
               JOptionPane.showMessageDialog(this, "No hay registros");
               setModificar(false);
           }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnEliminarActionPerformed
    {//GEN-HEADEREND:event_btnEliminarActionPerformed
        
        if(administrar())
           {
            
            String no= Tarjeta();
            
            if(!no.equalsIgnoreCase("vacio")){
                for(int i =0;i< Logics.tamaño();i++){
                if(Logics.completa(i).getCodigo().equalsIgnoreCase(no)){
                    System.out.println("Alias eliminado "+Logics.completa(i).getCodigo());
                    Logics.eliminar(i);
                }
            }
            iniciarFactura();
            }else{
                JOptionPane.showMessageDialog(this,"Seleccione una fila para eliminar");
            }
            
           }else{
               JOptionPane.showMessageDialog(this, "No hay registros");
           }
        
    }//GEN-LAST:event_btnEliminarActionPerformed
    // -------------------------------------------------------------------------
    private String correo;
    
    public void setCorreoU(String correo){
        this.correo = correo;
    }
    // -------------------------------------------------------------------------
    private boolean valor;
    
    public void setValor(boolean valor){
        this.valor = valor;
    }
    // -------------------------------------------------------------------------
     private String rol;
    public void setRol(String rol){
        this.rol = rol;
    }
    // -------------------------------------------------------------------------
     private boolean modificar = false;
    public void setModificar(boolean valor){
        this.modificar = valor;
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
            java.util.logging.Logger.getLogger(registrofactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registrofactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registrofactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registrofactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrofactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atras;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton cerrar;
    private javax.swing.JLabel codigoTxt;
    private javax.swing.JTextField ingresoCodigo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label;
    private javax.swing.JTextField txtdireccion;
    private java.awt.Label txtmodificar;
    private javax.swing.JTextField txtnit;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
