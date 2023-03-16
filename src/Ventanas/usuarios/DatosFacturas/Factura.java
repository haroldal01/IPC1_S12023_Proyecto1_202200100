
package Ventanas.usuarios.DatosFacturas;


public class Factura {
    String nombrecom; 
    String Direccion; 
    String nit; 
    String usuario;
    String codigo;
    
    public Factura(String nombrecom, String Direccion, String nit, 
            String usuario, String codigo) {
        this.nombrecom = nombrecom;
        this.Direccion = Direccion;
        this.nit = nit;
        this.usuario=usuario;
        this.codigo = codigo;
    }

    public String getNombrecom() {
        return nombrecom;
    }

    public void setNombrecom(String nombrecom) {
        this.nombrecom = nombrecom;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    public String getUsuario(){
        return usuario;
    }
    public void setUsuario(String correo){
        this.usuario=correo;
    }
    
    public String getCodigo(){
        return codigo;
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    
    
}
