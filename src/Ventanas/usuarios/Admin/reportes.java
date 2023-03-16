
package Ventanas.usuarios.Admin;

import javax.swing.table.DefaultTableModel;
import Ventanas.usuarios.Cotizacion.Logic;
import Ventanas.usuarios.InicioSesion.UsuariosModelo;
import Ventanas.usuarios.InicioSesion.Logicas;

public class reportes extends javax.swing.JFrame
{

    /**
     * Creates new form reportes
     */
    public reportes()
    {
        initComponents();
        this.setLocationRelativeTo(null); 
    }
    
    
    public void iniciarReportes(){
        
        iniciarRegiones();
        iniciarUsuario();
        cotizaciones();
        
    }
    
    public void cotizaciones(){
        
        int pk = 0;
        int it = 0;
        for(int a = 0; a<Logic.tamaño();a++){
            
            pk+=Logic.completa(a).getCantidadPaquetes();
            it+=Logic.completa(a).getPrecioCotizacion();
            
        }
        System.out.println(pk);
        System.out.println(it);
        txtEnvios.setText(""+pk);
        txtTotal.setText(""+it);
        
    }
    
    
     public void iniciarRegiones(){
        System.out.println("Oprimido");
        String[] columnas = {"Nombre Region","Envios"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
       
            String [][] datos = ordenarRegion();
            int x = datos.length;
        
            for(int a = 0; a<x;a++){

                    Object[] fila = {datos[a][0], datos[a][1]};
                    modelo.addRow(fila);  
            }
        
        tablaRegion.setModel(modelo);
        tablaRegion.setEnabled(false);
    }
   
     
     public void iniciarUsuario()
     {
        System.out.println("Oprimido");
        Ventanas.usuarios.Admin.Logica.Ingresar();
        String[] columnas = {"Correo Usuario","Envios"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
  
        if(Logicas.tamaño()>0){
            String [][] datos = ordenarUsuario();
            int x = datos.length;
            int y = x-6;
            if(x>6){
                y=x-6;
            }else{
                y=0;
            }
             
            for( int a = y; a<x;a++){

                    Object[] fila = {datos[a][0], datos[a][1]};
                    modelo.addRow(fila);  
            }
        }
        
        tablaUsuario.setModel(modelo);
        tablaUsuario.setEnabled(false);
         
     }
     
     public String [][] ordenarUsuario()
     {
        Ventanas.usuarios.Admin.Logica.Ingresar();
        int x = Logicas.tamaño();
        String [] [] datos = new String[x][2];
        
        for(int a = 0; a<x;a++)
        {
            int envios = 0;
            //cantidad de cotizaciones
            int c = Logic.tamaño();
            String zzz = Logicas.completa(a).getCorreo();
            for(int j = 0; j<c;j++)
            {
               String user = Logic.completa(j).getUsuario();         
                if(user.equalsIgnoreCase(zzz))
                {
                    envios++;
                }    
            }  
            datos[a][0] = zzz;
            datos[a][1] = String.valueOf(envios);
        }
         System.out.println("Ordenando");
        datos=ordenar(datos);
        
        return datos;
     }
    
        
     public String [][] ordenarRegion()
     {
        Ventanas.usuarios.Admin.Logica.Ingresar();
        int r = Logica.tamañoR();
        String [] [] datos = new String[r][2];
        
        for(int a = 0; a<r;a++){
            int envios = 0;
            //cantidad de cotizaciones
            String rs = Logica.imprimirR(a).getNombreregion();
            int c = Logic.tamaño();
            for(int j = 0; j<c;j++)
            {
                //departamento de origen
                String dep = Logic.completa(j).getOrigenD();
                String reg ="Vacio";
                int d = Logica.tamañoD();
                //Obteniendo la region de envio 22 departamentos
                for( int k = 0;k<d;k++)
                {
                    String ds = Logica.imprimirD(k).getNombre();
                    if(dep.equalsIgnoreCase(ds))
                    {
                        reg = Logica.imprimirD(k).getcRegion();
                        System.out.println(reg);
                        k=d;
                    }
                }
                //comparando regiones
                
                if(reg.equalsIgnoreCase(rs))
                {
                    envios++;
                }    
            }
            datos[a][0] = rs;
            datos[a][1] = String.valueOf(envios);
        }
         System.out.println("ORDENANDO");
        datos=ordenar(datos);
       
        return datos;
     }
     
     public String [][] ordenar(String [][] datos){
         System.out.println("Ordenando");
        for (int i = 0; i < datos.length-1; i++) {
            for (int j = 0; j < datos.length-i-1; j++) {
                
                int anterior = Integer.parseInt(datos[j][1]);
                int siguiente = Integer.parseInt(datos[j+1][1]);
                
                if (anterior > siguiente) {
                    String utemp = datos[j][0];
                    String etemp = datos[j][1];
                    
                    datos[j][0] = datos[j+1][0];
                    datos[j][1] = datos[j+1][1];

                    datos[j+1][0] = utemp;
                    datos[j+1][1] = etemp;
           
                }
            }
        }
        return datos;
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

        atras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRegion = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaUsuario = new javax.swing.JTable();
        txtEnvios = new java.awt.Label();
        jLabel3 = new javax.swing.JLabel();
        txtTotal = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        atras.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        atras.setText("Atras");
        atras.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                atrasActionPerformed(evt);
            }
        });

        jLabel1.setText("Paquetes enviados");

        tablaRegion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tablaRegion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(tablaRegion);

        tablaUsuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tablaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane2.setViewportView(tablaUsuario);

        txtEnvios.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel3.setText("Ingresos totales");

        txtTotal.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(txtEnvios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(atras))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(40, 100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEnvios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(92, 92, 92)
                        .addComponent(atras))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_atrasActionPerformed
    {//GEN-HEADEREND:event_atrasActionPerformed
        opciones2 atrask = new opciones2();
        atrask.setCorreoU(correo);
        atrask.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_atrasActionPerformed

    // -------------------------------------------------------------------------
    private String correo;
    
    public void setCorreoU(String correo){
        this.correo = correo;
    }
    // -------------------------------------------------------------------------
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new reportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaRegion;
    private javax.swing.JTable tablaUsuario;
    private java.awt.Label txtEnvios;
    private java.awt.Label txtTotal;
    // End of variables declaration//GEN-END:variables
}
