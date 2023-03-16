
package Ventanas.usuarios.Cotizacion;
import Ventanas.usuarios.InicioSesion.opcionescliente;
import Ventanas.usuarios.Tarjeta.registrotarjetas;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import Ventanas.usuarios.Admin.Logica;
import javax.swing.JOptionPane;
import java.util.UUID;
import javax.swing.table.DefaultTableModel;
import Ventanas.usuarios.DatosFacturas.Logics;
import Ventanas.usuarios.DatosFacturas.registrofactura;
import javax.swing.JRadioButton;

public class cotizacioncliente extends javax.swing.JFrame {

    
    
    DefaultComboBoxModel origenD = new DefaultComboBoxModel();
    DefaultComboBoxModel origenM = new DefaultComboBoxModel();
    DefaultComboBoxModel destinoD = new DefaultComboBoxModel();
    DefaultComboBoxModel destinoM = new DefaultComboBoxModel();
    DefaultComboBoxModel refers = new DefaultComboBoxModel();
    
    public  void iniciar(){
        System.out.println(correo);
        referencias(1);
        radios();
        origenD();
        destinoD();
        envio("");
        inicioCotizar();
        valor(true);
        radios();
        btnValidar.setEnabled(false);
        btnEnviar.setEnabled(false);
        
    }
    //// COMBOBOX --------------------------------------------------------------       
    // PARA ORIGEN DE PAQUETE --------------------------------------------------
    public void origenD()
    {
        Set<String>nombresRegion = new HashSet<>();
        for(int a = 0; a<Logica.tamañoD();a++){
            String nombre = Logica.imprimirD(a).getNombre();
            if(!nombresRegion.contains(nombre)){
                origenD.addElement(nombre);
                nombresRegion.add(nombre);
            }            
        }
    }
    public void origenM(String dep){
        origenM.removeAllElements();
        Set<String>nombresRegion = new HashSet<>();
        for(int a = 0; a<Logica.tamañoM();a++){
            
            String nombre = Logica.imprimirM(a).getNombre();
            String parent = Logica.imprimirM(a).getDepartamento();
            if(parent.equalsIgnoreCase(dep)){
                if(!nombresRegion.contains(nombre))
                {
                    origenM.addElement(nombre);
                    nombresRegion.add(nombre);
                } 
            }             
        }
    }
    // PARA DESTINO DE PAQUETE -------------------------------------------------
  public void destinoD()
    {
        Set<String>nombresRegion = new HashSet<>();
        for(int a = 0; a<Logica.tamañoD();a++){
            String nombre = Logica.imprimirD(a).getNombre();
            if(!nombresRegion.contains(nombre)){
                destinoD.addElement(nombre);
                nombresRegion.add(nombre);
            }            
        }
    }
    public void destinoM(String dep){
        destinoM.removeAllElements();
        Set<String>nombresRegion = new HashSet<>();
        for(int a = 0; a<Logica.tamañoM();a++){
            
            String nombre = Logica.imprimirM(a).getNombre();
            String parent = Logica.imprimirM(a).getDepartamento();
            if(parent.equalsIgnoreCase(dep)){
                if(!nombresRegion.contains(nombre))
                {
                    destinoM.addElement(nombre);
                    nombresRegion.add(nombre);
                } 
            }           
        }
    }
    // PARA DATOS DE FACTURACION -----------------------------------------------
    // Si no hay datos ingresados para emitir la factura, ----------------------
    // el programa nos pide ingresar los datos ---------------------------------
    // 0 - AGREGAR DATOS +++ 1 - SOLO MOSTRAR DATOS
    public boolean referencias (int abrir)
    {
        boolean si= false;
        
        if(abrir==0)
        {
            int ventana;
            ventana=JOptionPane.showConfirmDialog(this, "Desea agregar sus datos de facturacion");
            
            if(ventana==JOptionPane.NO_OPTION)
            {
                JOptionPane.showMessageDialog(this, "No agrego datos de facturacion");

            }else if(ventana==JOptionPane.YES_OPTION)
            {
                registrofactura o = new registrofactura(); 
                o.setVisible(true);
                o.setCorreoU(correo);
                o.botones(false);
                
            }else{
                JOptionPane.showMessageDialog(this, "No agrego datos de facturacion");
            }
            si=false;
            
        }else
        {           
             Set<String>nombresRegion = new HashSet<>();
             refers.removeAllElements();
                for(int a = 0; a<Logics.tamaño();a++)
                {
                    String nombre = Logics.completa(a).getCodigo();
                    String parent = Logics.completa(a).getUsuario();
                    if(parent.equalsIgnoreCase(correo))
                    {
                        if(!nombresRegion.contains(nombre))
                        {
                            refers.addElement(nombre);
                            nombresRegion.add(nombre);
                        } 
                    }
                }
            si= true;
        }    
        return si;
    }
    // Agregar o mostrar tarjetas ----------------------------------------------
    // 0-Mostrar AGREGAR TARJETAS +++ 1-Solo mostrar tarjetas
    public void pagoTarjeta (int abrir)
    {
        registrotarjetas o = new registrotarjetas(); 
       
        if(abrir==0)
        {
            int ventana;
            ventana=JOptionPane.showConfirmDialog(this, "Desea agregar tarjeta de credito/debito");

            if(ventana==JOptionPane.NO_OPTION)
            {
                JOptionPane.showMessageDialog(this, "No agrego tarjeta nueva");
            }else if(ventana==JOptionPane.YES_OPTION)
            {
                System.out.println("Agregando tarjetas");
                o.setVisible(true);
                o.setCorreoU(correo);
                o.boton(true);
                o.iniciarTarjeta();
                o.cambio();

            }else{
                JOptionPane.showMessageDialog(this, "No agrego tarjetas nuevas");

            }
            
        }else
        {           
            o.setVisible(true);
            o.setCorreoU(correo);
            o.iniciarTarjeta();
            o.boton(false);
        }    
    }
    //// -----------------------------------------------------------------------
    //// ENVIO, PRECIO DE ENVIO ------------------------------------------------
    // Segun la seleccion sea ESTANDAR o ESPECIAL devuelve un valor ------------
    public int envio(String opcion){
     int x = 0;
        switch (opcion){
            case "Estandar":
                showTxt.setText("Entrega de 3 a 5 días habiles");
                x= 1;
                break;
            case "Especial":
                showTxt.setText("Entrega inmediata 1 o 2 días habiles");
                x=2;
                break;
        }
        return x;
    }
    // PARA PRECIO DE ENVIO (ESTANDAR o ESPECIAL) ------------------------------
    // Me devuelve el precio de envio del paquete dependiendo si ---------------
    // Es ESTANDAR o ESPECIAL, tomando en cuenta el departamento destino -------
    public double precio (int eleccion, String departamento){
     double precioEnvio =0;
     String region = "";   
        // Buscamos la region de destino del paquete ---------------------------
        for(int a = 0; a<Logica.tamañoD();a++){
            if(departamento.equalsIgnoreCase(Logica.imprimirD(a).getNombre())){
                region = Logica.imprimirD(a).getRegion();
            }
        }
        // ---------------------------------------------------------------------
        // Segun la region de destino aplicamos el precio ----------------------
        // Invocamos METODO ENVIO() para realizar la asignacion de -------------
        // Precio envio, a su vez asiganmanos la region destino ----------------
        for(int a = 0; a<Logica.tamañoR();a++)
        {
            if(region.equalsIgnoreCase(Logica.imprimirR(a).getNombreregion()))
            {
                String reg = Logica.imprimirR(a).getNombreregion();
                setDestinoR(reg);
                switch(eleccion)
                {
                    case 1:
                            precioEnvio = Logica.imprimirR(a).getPrecioEstandar();
                            showPrecio.setText("El precio estandar es Q."+precioEnvio);
                        break;
                    case 2:
                        precioEnvio = Logica.imprimirR(a).getPrecioEspecial();
                        showPrecio.setText("El precio especial es Q."+precioEnvio);
                        break;
                }
            }
        }
        return precioEnvio;
    }
    //// -----------------------------------------------------------------------
    ////////////////////////////////////////////////////////////////////////////
    //// METODOS UTILIZADOS PARA FUNCIONAMIENTO --------------------------------
    // Utilizado al presionar el BOTON COTIZAR,  -------------------------------
    // Recolecta la informacion de los combobox DESTINO
    public void Cotizar(){
        String dep = destinoDEP.getSelectedItem().toString();
        destinoM(dep);
        System.out.println("COTIZAR M: "+municipio.getSelectedItem().toString());
        String opcion = btnEnvio.getSelectedItem().toString();
        int eleccion = envio(opcion);
        String dpt = destinoD.getSelectedItem().toString();
        double x =precio(eleccion, dpt);
        setPrecioCotizar(x);
    }
    // ASIGNA UN VALOR A LOS RDADIOBUTON ---------------------------------------
    public void radios(){
        tipoCompra.add(rdTarjeta);
        tipoCompra.add(rdEntrega);
        rdTarjeta.setActionCommand("Efectivo");
        rdEntrega.setActionCommand("Tarjeta");
    }
    // RECOLECTA DATOS ---------------------------------------------------------
    // Revisa que no hayan datos vacios al realizar alguna cotizacion
    public boolean accionEnvio(){
        boolean vacio = false;
        double precio = precioEnvio;
        
        if(!ingresoPaquetes.getText().isEmpty() &&
               !ingresarPeso.getText().isEmpty() && 
                !btnEnvio.getSelectedItem().toString().equalsIgnoreCase("Seleccionar"))
        {
            // DEFINE el precio de cotizacion con el tamaño y cantidad
            // de paquetes hace uso del -METODO COTIZAR y PRECIO- indirectamente
            String cantidad = ingresoPaquetes.getText();
            double cant = Double.parseDouble(cantidad);
            String pesototal = ingresarPeso.getText();
            double peso = Double.parseDouble(pesototal);
            double precioTotal = (precio *cant *peso);
            
            precioServicio.setText("Envio paquetes Q."+precioTotal);
            setPrecioCotizar(precioTotal);
            if(codigoUnico.equals("")){
                setCodigo();
            }
            String cd = codigoUnico;
            Codigotxt.setText("REF: "+cd);
            vacio=true;
            System.out.println("cotizar a "+correo);
        }else
        {
            JOptionPane.showMessageDialog(this, "Hay campos vacios");
        }
        return vacio;
    }
    // Seleccione el tipo de envio ---------------------------------------------
    // muesta la informacion actualizada a ESTANDAR o ESPECIAL
    public void inicioCotizar(){
        String opcion = btnEnvio.getSelectedItem().toString();
        int eleccion = envio(opcion);
        String dpt = destinoD.getSelectedItem().toString();
        double x =precio(eleccion, dpt);
        setPrecioEnvio(x);
        btnEnvio.setEditable(false);
    }
    // Define el tamaño del paquete --------------------------------------------
    public void tamañoPaquetes(){
        String a = ingresoPaquetes.getText();
        double paquetes = Double.parseDouble(a);
        String tipoPaquete = "No especificado";
        if(paquetes>=1 && paquetes<=10){
            tipoPaquete = "Pequeño";
        }else if(paquetes >10 && paquetes <=50){
            tipoPaquete= "Mediano";
        }else if(paquetes>50){
            tipoPaquete = "Grande";
        }else{
            tipoPaquete="No especificado";
        }
        setTipoPaquete(tipoPaquete);
    }
    // Valor agregado al servicio ----------------------------------------------
    // Usado si y solo si el radiobuton de pago_contra_entrega esta seleccionado
    public String agregado (){
        String tipo = "";
        //Comprobando que haya seleccionado una opcion
        if(rdEntrega.isSelected() || rdTarjeta.isSelected())
        {   // Comprobando que no hayan datos vacios
            if(accionEnvio())
            {       
                boolean s1, s2;
                if(rdTarjeta.isSelected())
                {
                    
                    //Comprobando tarjetas
                    s1=true;
                    if(Logics.tamaño()==0){
                        s2=false;
                        JOptionPane.showMessageDialog(this, "Agregue datos de facturacion");
                        System.out.println("No puede facturar");
                    }else{
                        s2=referencias(1);
                    }
                    if(s1==true && s2==true){
                        tipo = "TARJETA";
                        setPago(tipo);
                        btnValidar.setEnabled(true);
                        mastr.setEnabled(true);
                        setAñadir(0);
                        JOptionPane.showMessageDialog(this, "Valide su tarjeta");
                    }
                    
                }else
                {   
                    s1=true;
                    setAñadir(5);
                    //comprobando datos de facturacion
                    if(Logics.tamaño()==0)
                    {
                       s2= false;
                       JOptionPane.showMessageDialog(this, "Agregue datos de facturacion");
                        System.out.println("No puede facturar");
                    }else{
                       s2=referencias(1);
                    }
                    if(s1==true && s2==true){
                        tipo = "EFECTIVO";
                        setPago(tipo);
                    }
                }
            } 
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione tipo de pago");
        }
        
    return tipo;
    }
    // Crea una cotizacion -----------------------------------------------------
    public Cotizacion datos(){
        //Extrae toda la informacion asignada durante la ejecucion
                tamañoPaquetes();
                String origend= departamento.getSelectedItem().toString();
                String origenm = municipio.getSelectedItem().toString();
                String destinod = destinoDEP.getSelectedItem().toString();
                String destinom = destinoMUN.getSelectedItem().toString();
                String tipoenvio = btnEnvio.getSelectedItem().toString();
                String cp = ingresoPaquetes.getText();
                double cantidadpk = Double.parseDouble(cp);
                String pp = ingresarPeso.getText();
                double pesopk = Double.parseDouble(pp);
                String codigo = codigoUnico;   
                String destinatarios = destinatario.getText();
                String tipoPagos=tipoPago;
                String aliasFactura=datosFactura.getSelectedItem().toString();
                String fechas=fecha.getText();
                double precioTotal = precioCotizar+Añadido;
                txtPrecioFinal.setText("Q."+precioTotal);
                System.out.println("ORIGENM "+origenm);
                Cotizacion tmporal = new Cotizacion(correo,origend,origenm,
                        destinod,destinom,destinoR,tipoenvio,precioEnvio,
                        cantidadpk,pesopk,tipoPk,precioTotal,codigo, destinatarios,
                         tipoPagos, aliasFactura, fechas );
                
                return tmporal;
    }
    // -------------------------------------------------------------------------
    public void RealizarPago(){
        System.out.println("RP M: "+municipio.getSelectedItem().toString());
        if(accionEnvio()) // Comprueba que no haya datos vacios
        {   
                // INSERTA LA INFORMACION Y LA GUARDA EN LA BASE_DE_DATOS
                if(Logic.insertar(datos()))
                {
                   valor(false); // Nada puede ser editado
                   mastr.setEnabled(false);
                   JOptionPane.showMessageDialog(this, "Cotizacion Registrada");
                }else
                {
                    JOptionPane.showMessageDialog(this, "Algo ocurrió mal");
                }
        }else{
            JOptionPane.showMessageDialog(this, "Algo ocurrió mal");
        }
    }
    // Define todos los atributos como TRUE/FALSE isEditable -------------------
    public void valor(boolean values){
                ingresoPaquetes.setEditable(values);
                ingresarPeso.setEditable(values);
                btnCotizar.setEnabled(values);
                btnGuardar.setEnabled(values);
                rdEntrega.setEnabled(values);
                rdTarjeta.setEnabled(values);
                departamento.setEnabled(values);
                municipio.setEnabled(values);
                destinoDEP.setEnabled(values);
                destinoMUN.setEnabled(values);
                btnEnvio.setEnabled(values);
                datosFactura.setEnabled(values);
                agregarDatos.setEnabled(values);
                btnValidar.setEnabled(values);
                mas.setEnabled(values);
                btnEnviar.setEnabled(values);
                destinatario.setEnabled(values);
                fecha.setEnabled(values);
                descargar.setEnabled(!values);
                guia.setEnabled(!values);
                
    }
    // -------------------------------------------------------------------------
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    /** ////////////////////////////////////////////////////////////////////////
     * /////////////////////////////////////////////////////////////////////////
     * Creates new form cotizacioncliente //////////////////////////////////////
     */ ////////////////////////////////////////////////////////////////////////
    public cotizacioncliente() {
        initComponents();
    }
    ////////////////////////////////////////////////////////////////////////////
    // -------------------------------------------------------------------------
    /** ////////////////////////////////////////////////////////////////////////
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *//////////////////////////////////////////////////////////////////////////
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        tipoCompra = new javax.swing.ButtonGroup();
        atras = new javax.swing.JButton();
        departamento = new javax.swing.JComboBox<>();
        label1 = new java.awt.Label();
        municipio = new javax.swing.JComboBox<>();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        destinoDEP = new javax.swing.JComboBox<>();
        destinoMUN = new javax.swing.JComboBox<>();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        label7 = new java.awt.Label();
        label8 = new java.awt.Label();
        ingresoPaquetes = new javax.swing.JTextField();
        label9 = new java.awt.Label();
        ingresarPeso = new javax.swing.JTextField();
        btnCotizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnEnvio = new javax.swing.JComboBox<>();
        precioServicio = new java.awt.Label();
        label11 = new java.awt.Label();
        showTxt = new javax.swing.JLabel();
        showPrecio = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        Codigotxt = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        label10 = new java.awt.Label();
        label12 = new java.awt.Label();
        rdEntrega = new javax.swing.JRadioButton();
        rdTarjeta = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        datosFactura = new javax.swing.JComboBox<>();
        label13 = new java.awt.Label();
        descargar = new javax.swing.JButton();
        guia = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        txtPrecioFinal = new javax.swing.JLabel();
        agregarDatos = new javax.swing.JButton();
        btnValidar = new javax.swing.JButton();
        txtTarjeta = new javax.swing.JLabel();
        mas = new javax.swing.JButton();
        mastr = new javax.swing.JButton();
        btnEnviar = new javax.swing.JButton();
        label14 = new java.awt.Label();
        destinatario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cotizacion");

        atras.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        atras.setText("Atrás");
        atras.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                atrasActionPerformed(evt);
            }
        });

        departamento.setModel(origenD);
        departamento.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                departamentoActionPerformed(evt);
            }
        });

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label1.setText("PAQUETES");

        municipio.setModel(origenM);
        municipio.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                municipioActionPerformed(evt);
            }
        });

        label2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label2.setText("ORIGEN");

        label3.setText("DEPARTAMENTO");

        label4.setText("MUNICIPIO");

        destinoDEP.setModel(destinoD);
        destinoDEP.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                destinoDEPActionPerformed(evt);
            }
        });

        destinoMUN.setModel(destinoM);

        label5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label5.setText("DESTINO");

        label6.setText("DEPARTAMENTO");

        label7.setText("MUNICIPIO");

        label8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label8.setText("Numero de paquetes a enviar");

        label9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label9.setText("Peso total de los paquetes");

        ingresarPeso.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ingresarPesoActionPerformed(evt);
            }
        });

        btnCotizar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnCotizar.setText("Cotizar");
        btnCotizar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCotizarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Total del servicio");

        btnEnvio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEnvio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Estandar", "Especial" }));
        btnEnvio.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnEnvioActionPerformed(evt);
            }
        });

        precioServicio.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        label11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label11.setText("Tipo de envio");

        showTxt.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        showPrecio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        btnGuardar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnGuardar.setText("REALIZAR PAGO");
        btnGuardar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnGuardarActionPerformed(evt);
            }
        });

        Codigotxt.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        label10.setAlignment(java.awt.Label.CENTER);
        label10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label10.setText("COMPRA");

        label12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label12.setText("Tipo de pago");

        rdEntrega.setText("Cobro contra entrega");
        rdEntrega.setActionCommand("");
        rdEntrega.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rdEntregaActionPerformed(evt);
            }
        });

        rdTarjeta.setText("Cobro a mi cuenta");
        rdTarjeta.setActionCommand("");
        rdTarjeta.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rdTarjetaActionPerformed(evt);
            }
        });

        jLabel2.setText("Cobro adicional de Q.5");

        jLabel3.setText("Pago con tarjeta de credito/debito");

        datosFactura.setModel(refers);
        datosFactura.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                datosFacturaActionPerformed(evt);
            }
        });

        label13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label13.setText("Datos de facturacion");

        descargar.setText("Descargar factura");
        descargar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                descargarActionPerformed(evt);
            }
        });

        guia.setText("Descargar guia");
        guia.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                guiaActionPerformed(evt);
            }
        });

        cancelar.setText("Nuevo Envio");
        cancelar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cancelarActionPerformed(evt);
            }
        });

        txtPrecioFinal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        agregarDatos.setText("Refrescar");
        agregarDatos.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                agregarDatosActionPerformed(evt);
            }
        });

        btnValidar.setText("Validar Tarjeta");
        btnValidar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnValidarActionPerformed(evt);
            }
        });

        txtTarjeta.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtTarjeta.setText(cvvTarjeta);

        mas.setText("+");
        mas.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                masActionPerformed(evt);
            }
        });

        mastr.setText("+");
        mastr.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mastrActionPerformed(evt);
            }
        });

        btnEnviar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEnviar.setText("ENVIAR");
        btnEnviar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnEnviarActionPerformed(evt);
            }
        });

        label14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label14.setText("Destinatario");

        destinatario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("FECHA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(departamento, 0, 123, Short.MAX_VALUE)
                                        .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(destinoDEP, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(label5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                        .addComponent(label2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(destinatario, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)))))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(municipio, 0, 151, Short.MAX_VALUE)
                                    .addComponent(destinoMUN, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ingresoPaquetes)
                                    .addComponent(ingresarPeso))
                                .addGap(18, 18, 18))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(219, 219, 219)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(showTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(showPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 28, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCotizar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(precioServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(51, 51, 51)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(rdEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                                .addComponent(rdTarjeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(80, 80, 80)
                                            .addComponent(jLabel2))
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(81, 81, 81)
                                            .addComponent(jLabel3)))
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(agregarDatos)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(mas)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(datosFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(84, 84, 84)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(108, 108, 108)
                                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtPrecioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(descargar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(guia, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGap(6, 6, 6)
                                                            .addComponent(txtTarjeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(mastr)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(btnValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(btnEnviar))))))))
                                .addContainerGap())))
                    .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Codigotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(label10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdEntrega)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(rdTarjeta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(datosFactura)
                                    .addComponent(mas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addComponent(agregarDatos))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnValidar)
                            .addComponent(mastr)
                            .addComponent(btnEnviar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTarjeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descargar)
                            .addComponent(guia))
                        .addGap(24, 24, 24)
                        .addComponent(cancelar))
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(municipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(destinoMUN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(destinoDEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ingresoPaquetes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(showTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ingresarPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(showPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addComponent(fecha))
                            .addComponent(destinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(precioServicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCotizar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(Codigotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(atras)
                        .addGap(35, 35, 35))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //// BOTONES ---------------------------------------------------------------
    //BOTON REGRESAR A PAGINA ANTERIOS
    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        opcionescliente o = new opcionescliente(); 
        o.setVisible(true);
        o.setRol(rol);
        o.nombre();
        o.setCorreoU(correo);
        this.dispose();
    }//GEN-LAST:event_atrasActionPerformed
    // COMBOBOX QUE UTILIZA LOS DEPARTAMENTOS DE ORIGEN 
    // Llama a METODO ORIGENM() para mostrar los municipios del departamento
    private void departamentoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_departamentoActionPerformed
    {//GEN-HEADEREND:event_departamentoActionPerformed
       String dep = departamento.getSelectedItem().toString();
        origenM(dep);
    }//GEN-LAST:event_departamentoActionPerformed
    // BOTON SIN UTILIZAR
    private void municipioActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_municipioActionPerformed
    {//GEN-HEADEREND:event_municipioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_municipioActionPerformed
    // COMBOBOX QUE LLAMA A COTIZAR() PARA CONOCER EL PRECIO DE ENVIO
    // Se actualiza constantemente segun sea el departameno de destino
    private void destinoDEPActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_destinoDEPActionPerformed
    {//GEN-HEADEREND:event_destinoDEPActionPerformed
        Cotizar();
    }//GEN-LAST:event_destinoDEPActionPerformed
    private void btnCotizarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCotizarActionPerformed
    {//GEN-HEADEREND:event_btnCotizarActionPerformed
        accionEnvio(); // AL PRESIONAR EL BOTON DE COTIZAR
    }//GEN-LAST:event_btnCotizarActionPerformed
    private void btnEnvioActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnEnvioActionPerformed
    {//GEN-HEADEREND:event_btnEnvioActionPerformed
        inicioCotizar(); // Actualiza la informacion ESTANDAR o ESPECIAL
    }//GEN-LAST:event_btnEnvioActionPerformed
    // INFORMACION DEL TAMAÑO DE EL PAQUETE
    // A la vez asigna el TIPO_DE_PAQUETE a la cotizacion actual
    private void ingresarPesoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ingresarPesoActionPerformed
    {//GEN-HEADEREND:event_ingresarPesoActionPerformed
        tamañoPaquetes();
    }//GEN-LAST:event_ingresarPesoActionPerformed
    // BOTON QUE GUARDA LA INFORMACION DE LA COTIZACION Y COMPRA
    // Unicamente es valido cuando no hay campos vacios y
    // El usuario tiene metodos de pago, informacion de facturacion
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnGuardarActionPerformed
    {//GEN-HEADEREND:event_btnGuardarActionPerformed
        String tipo = agregado();
        if(tipo.equalsIgnoreCase("efectivo"))
        {   
            System.out.println("aaa"+tipoPago);
            RealizarPago();
            btnGuardar.setEnabled(false);
        }else if(tipo.equalsIgnoreCase("tarjeta"))
        {
            mastr.setEnabled(true);
            System.out.println("aaa "+tipoPago);
            btnGuardar.setEnabled(false);
            valor(false);
            btnValidar.setEnabled(true);
            txtTarjeta.setEnabled(true);
            descargar.setEnabled(false);
            guia.setEnabled(false);
            if(Ventanas.usuarios.Tarjeta.Logic.tamaño()==0){
            }else{
                btnValidar.setEnabled(true);
            }
               
        }
            
    }//GEN-LAST:event_btnGuardarActionPerformed

    // BOTON QUE DESCARGA LA INFORMACION
    private void descargarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_descargarActionPerformed
    {//GEN-HEADEREND:event_descargarActionPerformed
        verenvios o = new verenvios();
        if(Logic.tamaño()>0){
            System.out.println("BTON FACUTRA");
            String txtCodigo = codigoUnico;
            if(!txtCodigo.equalsIgnoreCase("VACIO")){
                o.descargarFactura(txtCodigo);
            }
            
        }else{
            System.out.println("tamño factura "+Logic.tamaño());
        }
        
        
    }//GEN-LAST:event_descargarActionPerformed

    private void guiaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_guiaActionPerformed
    {//GEN-HEADEREND:event_guiaActionPerformed
       verenvios o = new verenvios();
        if(Logic.tamaño()>0){
            System.out.println("BTON FACUTRA");
            String txtCodigo = codigoUnico;
            if(!txtCodigo.equalsIgnoreCase("VACIO")){
                o.descargarGuia(txtCodigo);
            }
            
        }else{
            System.out.println("tamño factura "+Logic.tamaño());
        }
    }//GEN-LAST:event_guiaActionPerformed
   
    
    private void datosFacturaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_datosFacturaActionPerformed
    {//GEN-HEADEREND:event_datosFacturaActionPerformed
    
    }//GEN-LAST:event_datosFacturaActionPerformed

    private void rdEntregaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_rdEntregaActionPerformed
    {//GEN-HEADEREND:event_rdEntregaActionPerformed

    }//GEN-LAST:event_rdEntregaActionPerformed

    private void rdTarjetaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_rdTarjetaActionPerformed
    {//GEN-HEADEREND:event_rdTarjetaActionPerformed

    }//GEN-LAST:event_rdTarjetaActionPerformed
    // borra la informacion y abre uno nuevo
    private void cancelarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cancelarActionPerformed
    {//GEN-HEADEREND:event_cancelarActionPerformed
        cotizacioncliente O = new cotizacioncliente();
        O.setVisible(true);
        O.setCorreoU(correo);
        O.iniciar();
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void btnValidarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnValidarActionPerformed
    {//GEN-HEADEREND:event_btnValidarActionPerformed

        mastr.setEnabled(true);
        rdTarjeta.setEnabled(true);
        rdEntrega.setEnabled(false);
        if(rdTarjeta.isSelected())
        {
            if(Ventanas.usuarios.Tarjeta.Logic.tamaño()==0)
            {
            JOptionPane.showMessageDialog(this, "Agregue tarjeta");
            mastr.setEnabled(true);
            }else{
                pagoTarjeta(1);
                btnEnviar.setEnabled(true);
                btnValidar.setEnabled(false);
            }
        }else
        {
            JOptionPane.showMessageDialog(this, "Opcion no admitida");
        }
        rdTarjeta.setEnabled(false);
        
        
    }//GEN-LAST:event_btnValidarActionPerformed

    private void agregarDatosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_agregarDatosActionPerformed
    {//GEN-HEADEREND:event_agregarDatosActionPerformed
        referencias(1);
    }//GEN-LAST:event_agregarDatosActionPerformed

    private void masActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_masActionPerformed
    {//GEN-HEADEREND:event_masActionPerformed
        referencias(0);
    }//GEN-LAST:event_masActionPerformed

    private void mastrActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mastrActionPerformed
    {//GEN-HEADEREND:event_mastrActionPerformed
        pagoTarjeta(0);
        
    }//GEN-LAST:event_mastrActionPerformed
    // guardando cotizacion con tarjeta
    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnEnviarActionPerformed
    {//GEN-HEADEREND:event_btnEnviarActionPerformed
        btnValidar.setEnabled(false);
        
       String xCVV = Ventanas.usuarios.Tarjeta.registrotarjetas.getCVV(); 
       String xTar = Ventanas.usuarios.Tarjeta.registrotarjetas.getTar();
        
       if(xTar.equals("vacio" )|| xCVV.equals("vacio")){
           btnValidar.setEnabled(true);
           JOptionPane.showMessageDialog(this, "Falta de validacion");
       }else{
           String tarjetacvv = (xTar + " .CVV-"+xCVV);
           txtTarjeta.setText(tarjetacvv);
           RealizarPago();
       }
       
        
    }//GEN-LAST:event_btnEnviarActionPerformed
    // -------------------------------------------------------------------------
    private String correo;
    
    public void setCorreoU(String correo){
        this.correo = correo;
    }
    // -------------------------------------------------------------------------
    private double precioCotizar;
    private String destinoR;
    private String tipoPk;
    private double precioEnvio;
    private String codigoUnico = "";
    private String tipoPago = "";
    private double Añadido =0;
    private String cvvTarjeta="";
    
    public void setPrecioCotizar(double precio){
        this.precioCotizar = precio;
    }
    public void setDestinoR(String destinoR){
        this.destinoR = destinoR;
    }
    public void setTipoPaquete(String tipoPk){
        this.tipoPk = tipoPk;
    }
    public void setPrecioEnvio(double precioEnvio){
        this.precioEnvio = precioEnvio;
    }
    public void setCodigo(){
        this.codigoUnico = UUID.randomUUID().toString().substring(0,5);
    }
    public void setPago(String tipoPago){
        this.tipoPago = tipoPago;
    }
    public void setAñadir(double cant){
        this.Añadido = cant;
    }
    public void setCVV(String cvv){
        this.cvvTarjeta = cvv;
    }
    //--------------------------------------------------------------------------
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
            java.util.logging.Logger.getLogger(cotizacioncliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cotizacioncliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cotizacioncliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cotizacioncliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cotizacioncliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Codigotxt;
    private javax.swing.JButton agregarDatos;
    private javax.swing.JButton atras;
    private javax.swing.JButton btnCotizar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JComboBox<String> btnEnvio;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnValidar;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> datosFactura;
    private javax.swing.JComboBox<String> departamento;
    private javax.swing.JButton descargar;
    private javax.swing.JTextField destinatario;
    private javax.swing.JComboBox<String> destinoDEP;
    private javax.swing.JComboBox<String> destinoMUN;
    private javax.swing.JTextField fecha;
    private javax.swing.JButton guia;
    private javax.swing.JTextField ingresarPeso;
    private javax.swing.JTextField ingresoPaquetes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private java.awt.Label label1;
    private java.awt.Label label10;
    private java.awt.Label label11;
    private java.awt.Label label12;
    private java.awt.Label label13;
    private java.awt.Label label14;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private javax.swing.JButton mas;
    private javax.swing.JButton mastr;
    private javax.swing.JComboBox<String> municipio;
    private java.awt.Label precioServicio;
    private javax.swing.JRadioButton rdEntrega;
    private javax.swing.JRadioButton rdTarjeta;
    private javax.swing.JLabel showPrecio;
    private javax.swing.JLabel showTxt;
    private javax.swing.ButtonGroup tipoCompra;
    private javax.swing.JLabel txtPrecioFinal;
    private javax.swing.JLabel txtTarjeta;
    // End of variables declaration//GEN-END:variables
}
