
package Ventanas.usuarios.Admin;


public class Kiosco {
    
     private String codigo;
    private String nombre;
    private String codigoRegion;

    public Kiosco(String codigo, String nombre, String codigoRegion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.codigoRegion = codigoRegion;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo() {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoRegion() {
        return codigoRegion;
    }

    public void setCodigoRegion() {
        this.codigoRegion = codigoRegion;
    }

    @Override
    public String toString() {
        return "Kiosco{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", codigoRegion=" + codigoRegion +
                '}';
    }
    
    
    
}
