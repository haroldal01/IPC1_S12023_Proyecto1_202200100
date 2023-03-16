
package Ventanas.usuarios.Cotizacion;

import Ventanas.usuarios.InicioSesion.opcionescliente;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import Ventanas.usuarios.DatosFacturas.Logics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class verenvios extends javax.swing.JFrame {

    /**
     * Creates new form verenvios
     */
    public verenvios() {
        initComponents();
    }
    
    public void iniciarEnvio(){
        System.out.println(correo);
        String[] columnas = {"Codigo","Tipo servicio","Destinatario","Total de envio","Tipo pago"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for(int i = 0;i<Logic.tamaño();i++)
        {
            if(Logic.completa(i).getUsuario().equalsIgnoreCase(correo)){

                String tipo = Logic.completa(i).getTipoPago();
                if(tipo.equalsIgnoreCase("efectivo")){
                    tipo = "Cobro contra entrega";
                }else{
                    tipo= "Cobro desde mi cuenta";
                }

            Object[] fila = 
            {Logic.completa(i).getCodigo(),
            Logic.completa(i).gettipoEnvio(), 
            Logic.completa(i).gesDestinatario(),
            Logic.completa(i).getPrecioCotizacion(), 
            Logic.completa(i).getTipoPago()};
            modelo.addRow(fila);
            }
         }
         jTable1.setModel(modelo);
    }
    
    public void descargarFactura(String codigo){
        
        FileWriter factura;
        
        try
        {
            factura = new FileWriter("factura.html");
            factura.write("<html><head><title>FACTURA</title></head><body> \n");
            setNo();
            factura.write("<h1> FACTURA No. "+noFactura+"</h1>");
            
            for(int i = 0;i<Logic.tamaño();i++){
                Cotizacion temporal = Logic.completa(i);
        
                if(temporal.getCodigo().equals(codigo))
                {
                    String alias = Logic.completa(i).getAlias();
                    // datos de facturacion
                    for(int j = 0; j<Logics.tamaño();j++){
                        if(Logics.completa(j).getCodigo().equals(alias)){
                            String nit = Logics.completa(j).getNit();
                            String nombre = Logics.completa(j).getNombrecom();
                            String direccion = Logics.completa(j).getDireccion();
                            factura.write("<h2> Datos personales</h2>");
                            factura.write("<p>NIT: "+nit+"</p>");
                            factura.write("<p>NOMBRE: "+nombre+"</p>");
                            factura.write("<p>DIRECCION: "+direccion+"</p>");   
                        } 
                    }
                    
                    factura.write("<h2>Datos de compra</h2>");
                    factura.write("<p> Codigo paquete "+codigo+"</p>");
                    
                    String origenDEP = temporal.getOrigenD();
                    String origenMUN = temporal.getOrigenM();
                    factura.write("<h3>ORIGEN</h3>");
                    factura.write("<p>Departamento "+origenDEP+"/p");
                    factura.write("<p>Municipio "+origenMUN+"</p");
                    
                    String destinoDEP = temporal.getDestinoD();
                    String destinoMUN = temporal.getDestinoM();
                    factura.write("<h3>DESTINO</h3>");
                    factura.write("<p>Departamento "+destinoDEP+"/p");
                    factura.write("<p>Municipio "+destinoMUN+"</p");
                    
                    String pago = temporal.getTipoPago();
                    if(pago.equalsIgnoreCase("efectivo")){
                        pago = "Cobro contra entrega";
                    }else{
                        pago = "Cobro desde mi cuenta";
                    }
                    String tamaño = temporal.getTipoPaquete();
                    double cant = temporal.getCantidadPaquetes();
                    factura.write("<h3>Datos de cotizacion</h3");
                    factura.write("<p>Tipo de pago "+pago+"/p");
                    factura.write("<p>Tamaño del paquete "+tamaño+"</p");
                    factura.write("<p>Numero de paquetes "+cant+"/p");
                    double total = temporal.getPrecioCotizacion();
                    factura.write("<h2>Total a pagar "+total+"/h2");
                   
                }
                
            }
            
            factura.write("</body></html>");
            factura.close();
            System.out.println("Arcivo creado y escrito");
            
            
        } catch(IOException ex){
            Logger.getLogger(verenvios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
    public String Envios(){
        
        int row = jTable1.getSelectedRow();
        int column = 0;
        String value = "vacio";
        if(row!=-1){
            
            String a = jTable1.getModel().getValueAt(row, column).toString();
            
            if(!a.isEmpty()){
                value = a;
                System.out.println("eleccion ");
            }else{
                System.out.println("Datos vacios");
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "No selecciono datos");
        }
       return value; 
    }
    
   
    public void descargarGuia(String codigo){
        
        FileWriter factura = null;
        
        try
        {
            factura = new FileWriter("guia.html");
            factura.write("<html><head><title>GUIA</title></head><body> \\n");
            setNo();
            factura.write("<h1>ORDEN DE GUIA</h1>");
            
            for(int i = 0;i<Logic.tamaño();i++){
                Cotizacion temporal = Logic.completa(i);
        
                if(temporal.getCodigo().equals(codigo))
                {
                    factura.write("<h2>Datos de compra</h2>");
                    factura.write("<p> Codigo paquete "+codigo+"</p>");
                    
                    String origenDEP = temporal.getOrigenD();
                    String origenMUN = temporal.getOrigenM();
                    factura.write("<h3>ORIGEN</h3>");
                    factura.write("<p>Departamento "+origenDEP+"/p");
                    factura.write("<p>Municipio "+origenMUN+"</p");
                    
                    String destinoDEP = temporal.getDestinoD();
                    String destinoMUN = temporal.getDestinoM();
                    factura.write("<h3>DESTINO</h3>");
                    factura.write("<p>Departamento "+destinoDEP+"/p");
                    factura.write("<p>Municipio "+destinoMUN+"</p");
                    
                    String pago = temporal.getTipoPago();
                    if(pago.equalsIgnoreCase("efectivo")){
                        pago = "Cobro contra entrega";
                    }else{
                        pago = "Cobro desde mi cuenta";
                    }
                    String tamaño = temporal.getTipoPaquete();
                    double cant = temporal.getCantidadPaquetes();
                    String fecha = temporal.getFecha();
                    factura.write("<h3>Datos de cotizacion</h3");
                    factura.write("<p>Tipo de pago "+pago+"/p");
                    factura.write("<p>Tamaño del paquete "+tamaño+"</p");
                    factura.write("<p>Numero de paquetes "+cant+"/p");
                    factura.write("<h2>Fecha de envio "+fecha+"/h2");
                    double total = temporal.getPrecioCotizacion();
                    factura.write("<h2>Total a pagar "+total+"/h2");
                }
                
            }
            factura.write("<img src='barcode.jpg'>");
            factura.write("</body></html>");
            factura.close();
            System.out.println("Arcivo creado y escrito");
            
        } catch(IOException error){
            error.printStackTrace();
        } 
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        ATRAS = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnFactura = new javax.swing.JButton();
        label1 = new java.awt.Label();
        btnGuia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ATRAS.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ATRAS.setText("Atrás");
        ATRAS.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ATRASActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String []
            {
                "Codigo", "Servicio", "Destinatario", "Total envio", "Tipo  pago"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnFactura.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnFactura.setText("FACTURA");
        btnFactura.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnFacturaActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label1.setText("Seleccione una compra");

        btnGuia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnGuia.setText("GUIA");
        btnGuia.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnGuiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(63, 63, 63)
                            .addComponent(btnFactura)
                            .addGap(69, 69, 69)
                            .addComponent(btnGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ATRAS))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFactura)
                        .addComponent(btnGuia)))
                .addGap(18, 18, 18)
                .addComponent(ATRAS)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ATRASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ATRASActionPerformed
       opcionescliente o = new opcionescliente(); 
        o.setVisible(true);
        o.setRol(rol);
        o.setCorreoU(correo);
        o.nombre();
        this.dispose();
    }//GEN-LAST:event_ATRASActionPerformed

    private void btnGuiaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnGuiaActionPerformed
    {//GEN-HEADEREND:event_btnGuiaActionPerformed
        if(Logic.tamaño()>0){
            System.out.println("BTON GUIA");
            String txtCodigo = Envios();
            if(!txtCodigo.equalsIgnoreCase("VACIO")){
                descargarGuia(txtCodigo);
            }
            
        }else{
            System.out.println("tamño guia "+Logic.tamaño());
        }
        
    }//GEN-LAST:event_btnGuiaActionPerformed

    private void btnFacturaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnFacturaActionPerformed
    {//GEN-HEADEREND:event_btnFacturaActionPerformed
        
        if(Logic.tamaño()>0){
            System.out.println("BTON FACUTRA");
            String txtCodigo = Envios();
            if(!txtCodigo.equalsIgnoreCase("VACIO")){
                descargarFactura(txtCodigo);
            }
            
        }else{
            System.out.println("tamño factura "+Logic.tamaño());
        }
        
        
    }//GEN-LAST:event_btnFacturaActionPerformed
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
    private int noFactura = 0;
    
    public void setNo(){
        this.noFactura+=1;
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
            java.util.logging.Logger.getLogger(verenvios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(verenvios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(verenvios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(verenvios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new verenvios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ATRAS;
    private javax.swing.JButton btnFactura;
    private javax.swing.JButton btnGuia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
