
package Ventanas.usuarios.InicioSesion;
import Ventanas.usuarios.Admin.elegirkiosco;
import Ventanas.usuarios.InicioSesion.RegistrarUsuarios;
import Ventanas.usuarios.InicioSesion.Logicas;
import Ventanas.usuarios.Admin.Logica;
import Ventanas.usuarios.Admin.opciones2;

import javax.swing.*;
import java.awt.*;


public class PaginaPrincipal extends javax.swing.JFrame
{

    /**
     * Creates new form PaginaPrincipal
     */
    public PaginaPrincipal()
    {
        initComponents();
        this.setLocationRelativeTo(null); 
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

        label1 = new java.awt.Label();
        BotonRegistrarUsuarios = new javax.swing.JButton();
        BotonLogin = new javax.swing.JButton();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        InsertarContraseña = new javax.swing.JPasswordField();
        InsertarCorreoElectronico = new javax.swing.JTextField();
        checkmostrar = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("USAC-Delivery");
        setResizable(false);

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Dialog", 0, 70)); // NOI18N
        label1.setText("USAC-Delivery");

        BotonRegistrarUsuarios.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BotonRegistrarUsuarios.setText("CREAR CUENTA");
        BotonRegistrarUsuarios.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BotonRegistrarUsuariosActionPerformed(evt);
            }
        });

        BotonLogin.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BotonLogin.setText("INICIAR SESIÓN");
        BotonLogin.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BotonLoginActionPerformed(evt);
            }
        });

        label3.setAlignment(java.awt.Label.CENTER);
        label3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        label3.setText("SERVICIO DE PAQUETERÍA");

        label4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label4.setText("Correo electrónico");

        label5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label5.setText("Contraseña");

        InsertarContraseña.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        InsertarCorreoElectronico.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        checkmostrar.setText("Mostrar");
        checkmostrar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                checkmostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BotonRegistrarUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addComponent(BotonLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
                    .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(label4, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(InsertarCorreoElectronico)
                    .addComponent(label5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(InsertarContraseña))
                .addGap(18, 18, 18)
                .addComponent(checkmostrar)
                .addGap(219, 219, 219))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InsertarCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InsertarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkmostrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(BotonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BotonRegistrarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonLoginActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BotonLoginActionPerformed
    {//GEN-HEADEREND:event_BotonLoginActionPerformed
       if(Ventanas.usuarios.Admin.Logica.tamañoR()>0){
           
       }else{
           Ventanas.usuarios.Admin.Logica.Ingresar();
       }
        //ASIGANCION VARIABLES -------------------------------------------------
        int a = 0, b = 0;
        String contraseña = InsertarContraseña.getText();
        String correo = InsertarCorreoElectronico.getText();
        if(contraseña.isEmpty()){ a = 1; }
        if(correo.isEmpty()){ b = 1; } 
        // VERIFICANDO CASILLAS VACIAS -----------------------------------------
        if(a!=1 && b!=1){
            // ACCESO LOGIN ADMIN ----------------------------------------------
             if(correo.equalsIgnoreCase("ipc1_202200100@ipc1delivery.com")&& 
                    contraseña.equals("202200100"))
            {
                // ABRIENDO PAGINA ADMIN -----------------------------------
                opciones2 admin = new opciones2();
                this.dispose();
                admin.nombre(correo);
                admin.setVisible(true);
                admin.setCorreoU(correo);
                
                
            }else
            {
                // ACCESO LOGIN USUARIOS----------------------------------------
                int login = Logicas.login(contraseña, correo); 
                Ventanas.usuarios.Admin.Logica.Ingresar();
                if(login >=0){
                    switch(Logicas.getrol(login)){
                        
                        case "Usuario Individual":
                            System.out.println("individual ");
                            opcionescliente cliente = new opcionescliente(); 
                            cliente.setVisible(true);
                            cliente.setCorreoU(correo);
                            String rol = "Usuario individual";
                            cliente.setRol(rol);
                            cliente.nombre();
                            this.dispose(); 
                            break; 
                            
                        case "Usuario Empresarial": 
                            System.out.println("empresarial");
                            opcionescliente empresarial = new opcionescliente(); 
                            empresarial.setVisible(true);
                            empresarial.setCorreoU(correo);
                            String rols = "Usuario empresarial";
                            empresarial.setRol(rols);
                            empresarial.nombre();
                            this.dispose(); 
                            
                            break; 
                            
                        case "Kiosko": 
                            System.out.println("kiosco");
                            elegirkiosco dis = new elegirkiosco(); 
                            dis.iniciar();
                            dis.setCorreoU(correo);
                            dis.setVisible(true); 
                            this.dispose();
                            break; 
                        
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Credenciales incorrectas");
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Hay campos vacios");
        }
        // ---------------------------------------------------------------------
    }//GEN-LAST:event_BotonLoginActionPerformed
    private void BotonRegistrarUsuariosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BotonRegistrarUsuariosActionPerformed
    {//GEN-HEADEREND:event_BotonRegistrarUsuariosActionPerformed
        RegistrarUsuarios RegistrarUsuarios = new RegistrarUsuarios(this, true);
        RegistrarUsuarios.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BotonRegistrarUsuariosActionPerformed

    private void checkmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkmostrarActionPerformed
         if(checkmostrar.isSelected()){
            InsertarContraseña.setEchoChar((char)0);
        }else{
            InsertarContraseña.setEchoChar('*');     
        }
    }//GEN-LAST:event_checkmostrarActionPerformed

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
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new PaginaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonLogin;
    private javax.swing.JButton BotonRegistrarUsuarios;
    private javax.swing.JPasswordField InsertarContraseña;
    private javax.swing.JTextField InsertarCorreoElectronico;
    private javax.swing.JCheckBox checkmostrar;
    private java.awt.Label label1;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    // End of variables declaration//GEN-END:variables
}
