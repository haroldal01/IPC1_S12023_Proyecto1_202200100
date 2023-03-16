
package Ventanas.usuarios.InicioSesion;
import Ventanas.usuarios.InicioSesion.UsuariosModelo;
import Ventanas.usuarios.InicioSesion.Logicas;
import javax.swing.*;
import java.awt.*;
public class RegistrarUsuarios extends javax.swing.JDialog
{

    public RegistrarUsuarios(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    RegistrarUsuarios()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

        CorreoTexto = new java.awt.Label();
        CorreoIngresar = new javax.swing.JTextField();
        NombreTexto = new java.awt.Label();
        NombreIngresar = new javax.swing.JTextField();
        ApellidoTexto = new java.awt.Label();
        ApellidoIngresar = new javax.swing.JTextField();
        Contraseña2Texto = new java.awt.Label();
        ContraseñaIngresar = new javax.swing.JTextField();
        ContraseñaTexto = new java.awt.Label();
        Contraseña2Ingresar = new javax.swing.JTextField();
        RolSeleccion = new javax.swing.JComboBox<>();
        RolTexto = new java.awt.Label();
        SexoSeleccion = new javax.swing.JComboBox<>();
        Dtexto = new java.awt.Label();
        Dingresar = new javax.swing.JTextField();
        SexoTexto = new java.awt.Label();
        RegistrarBoton = new javax.swing.JButton();
        FechaTexto = new java.awt.Label();
        FechaIngresar = new javax.swing.JFormattedTextField();
        NacionalidadTexto = new java.awt.Label();
        AliasTexto = new java.awt.Label();
        AliasIngresar = new javax.swing.JTextField();
        TelefonoTexto = new java.awt.Label();
        TelefonoIngresar = new javax.swing.JTextField();
        fotografia = new javax.swing.JLabel();
        SubirBoton = new javax.swing.JButton();
        NacionalidadIngresar = new javax.swing.JComboBox<>();
        BotonCerrar = new javax.swing.JButton();

        setTitle("Registro de Usuarios");
        setResizable(false);

        CorreoTexto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        CorreoTexto.setText("Correo Electronico");

        CorreoIngresar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        NombreTexto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        NombreTexto.setText("Nombre");

        NombreIngresar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        ApellidoTexto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ApellidoTexto.setText("Apellido");

        ApellidoIngresar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        Contraseña2Texto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Contraseña2Texto.setText("Reingresar Contraseña");

        ContraseñaIngresar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        ContraseñaTexto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ContraseñaTexto.setText("Contraseña");

        Contraseña2Ingresar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        RolSeleccion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        RolSeleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuario Individual", "Usuario Empresarial", "Kiosko" }));

        RolTexto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        RolTexto.setText("Rol");

        SexoSeleccion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        SexoSeleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "F", "M" }));

        Dtexto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Dtexto.setText("DPI");

        Dingresar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        SexoTexto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        SexoTexto.setText("Sexo");

        RegistrarBoton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        RegistrarBoton.setText("REGISTRAR");
        RegistrarBoton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                RegistrarBotonActionPerformed(evt);
            }
        });

        FechaTexto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        FechaTexto.setText("Fecha de nacimiento");

        FechaIngresar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        FechaIngresar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                FechaIngresarActionPerformed(evt);
            }
        });

        NacionalidadTexto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        NacionalidadTexto.setText("Nacionalidad");

        AliasTexto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        AliasTexto.setText("Sobronombre (alias)");

        AliasIngresar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        TelefonoTexto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        TelefonoTexto.setText("Telefono");

        TelefonoIngresar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        fotografia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        fotografia.setText("Fotografia");

        SubirBoton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        SubirBoton.setText("Subir");

        NacionalidadIngresar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        NacionalidadIngresar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guatemalteca ", "Argentina", "Española", "Estadounidense", "Somalí" }));

        BotonCerrar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BotonCerrar.setText("Volver a Pagina Principal");
        BotonCerrar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BotonCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Dingresar)
                        .addComponent(Dtexto, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CorreoTexto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CorreoIngresar, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(NombreIngresar, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(NombreTexto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ContraseñaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(ContraseñaIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(85, 85, 85)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ApellidoIngresar)
                                            .addComponent(ApellidoTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Contraseña2Texto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Contraseña2Ingresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(FechaTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SexoSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SexoTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FechaIngresar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(RolTexto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RolSeleccion, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(245, 245, 245)
                        .addComponent(RegistrarBoton)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(BotonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AliasTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(NacionalidadTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AliasIngresar)
                            .addComponent(TelefonoTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TelefonoIngresar)
                            .addComponent(NacionalidadIngresar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SubirBoton)
                .addGap(40, 40, 40)
                .addComponent(fotografia, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fotografia, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubirBoton))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CorreoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CorreoIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(NombreTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ApellidoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(FechaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(NacionalidadTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NombreIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ApellidoIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(FechaIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(NacionalidadIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ContraseñaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Contraseña2Texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AliasTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SexoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AliasIngresar)
                            .addComponent(ContraseñaIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Contraseña2Ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SexoSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addComponent(Dtexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TelefonoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Dingresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TelefonoIngresar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(RolTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RegistrarBoton)
                            .addComponent(BotonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RolSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FechaIngresarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_FechaIngresarActionPerformed
    {//GEN-HEADEREND:event_FechaIngresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaIngresarActionPerformed
    //int contador = 0;
    private void RegistrarBotonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_RegistrarBotonActionPerformed
    {//GEN-HEADEREND:event_RegistrarBotonActionPerformed
        if(!CorreoIngresar.getText().isEmpty() && 
                !NombreIngresar.getText().isEmpty() &&
                !ApellidoIngresar.getText().isEmpty() && 
                !AliasIngresar.getText().isEmpty() &&
                !TelefonoIngresar.getText().isEmpty() &&
                !Dingresar.getText().isEmpty() &&
                !FechaIngresar.getText().isEmpty() &&
                !ContraseñaIngresar.getText().isEmpty() &&
                !Contraseña2Ingresar.getText().isEmpty())
        {
            if(ContraseñaIngresar.getText().equals(Contraseña2Ingresar.getText()) && validarContraseña(ContraseñaIngresar.getText()))
            {
               UsuariosModelo temporal = new UsuariosModelo (CorreoIngresar.getText(),
                        NombreIngresar.getText(),ApellidoIngresar.getText(),
                        ContraseñaIngresar.getText(), Dingresar.getText(),(String)
                        SexoSeleccion.getSelectedItem().toString(),(String) NacionalidadIngresar.getSelectedItem().toString(),
                        AliasIngresar.getText(), TelefonoIngresar.getText(),
                        RolSeleccion.getSelectedItem().toString());
                
                if(Logicas.insertar(temporal)){
                 JOptionPane.showMessageDialog(this,"Usuario registrado");
                 NombreIngresar.setText(""); 
                 ApellidoIngresar.setText("");
                 ContraseñaIngresar.setText("");
                 Contraseña2Ingresar.setText("");
                 Dingresar.setText("");
                 AliasIngresar.setText("");
                 TelefonoIngresar.setText("");  
                 CorreoIngresar.setText("");
                 FechaIngresar.setText("");
                 
            }else{
               JOptionPane.showMessageDialog(this,"usuario existente");
            }
                 
            }else
            {
                JOptionPane.showMessageDialog(this,"Contraseñas Diferentes o no cumple con los requisitos");
            }
            
        }else
        {
            JOptionPane.showMessageDialog(this,"Hay campos vacios");
        }  
    }//GEN-LAST:event_RegistrarBotonActionPerformed
    private boolean validarContraseña(String contraseña) {
        boolean tieneNumeros = false;
        boolean tieneCaracteresEspeciales = false;
        boolean tieneMayusculas = false;
        boolean tieneMinusculas = false;
        
            for (int i = 0; i < contraseña.length(); i++) {
                char c = contraseña.charAt(i);
            if (Character.isDigit(c)) {
            tieneNumeros = true;
            
            }else if (Character.isUpperCase(c)) {
            tieneMayusculas = true;
            
            }else if (Character.isLowerCase(c)) {
            tieneMinusculas = true;
            
            } else {
            tieneCaracteresEspeciales = true;
        }
    }
    return tieneNumeros && tieneCaracteresEspeciales && tieneMayusculas && tieneMinusculas;
}

    private void BotonCerrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BotonCerrarActionPerformed
    {//GEN-HEADEREND:event_BotonCerrarActionPerformed
        this.dispose();
        
        PaginaPrincipal regresar = new PaginaPrincipal();
        regresar.setVisible(true);
    }//GEN-LAST:event_BotonCerrarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(RegistrarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(RegistrarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(RegistrarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                RegistrarUsuarios dialog = new RegistrarUsuarios(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter()
                {
                    
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e)
                    {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AliasIngresar;
    private java.awt.Label AliasTexto;
    private javax.swing.JTextField ApellidoIngresar;
    private java.awt.Label ApellidoTexto;
    private javax.swing.JButton BotonCerrar;
    private javax.swing.JTextField Contraseña2Ingresar;
    private java.awt.Label Contraseña2Texto;
    private javax.swing.JTextField ContraseñaIngresar;
    private java.awt.Label ContraseñaTexto;
    private javax.swing.JTextField CorreoIngresar;
    private java.awt.Label CorreoTexto;
    private javax.swing.JTextField Dingresar;
    private java.awt.Label Dtexto;
    private javax.swing.JFormattedTextField FechaIngresar;
    private java.awt.Label FechaTexto;
    private javax.swing.JComboBox<String> NacionalidadIngresar;
    private java.awt.Label NacionalidadTexto;
    private javax.swing.JTextField NombreIngresar;
    private java.awt.Label NombreTexto;
    private javax.swing.JButton RegistrarBoton;
    private javax.swing.JComboBox<String> RolSeleccion;
    private java.awt.Label RolTexto;
    private javax.swing.JComboBox<String> SexoSeleccion;
    private java.awt.Label SexoTexto;
    private javax.swing.JButton SubirBoton;
    private javax.swing.JTextField TelefonoIngresar;
    private java.awt.Label TelefonoTexto;
    private javax.swing.JLabel fotografia;
    // End of variables declaration//GEN-END:variables
}
