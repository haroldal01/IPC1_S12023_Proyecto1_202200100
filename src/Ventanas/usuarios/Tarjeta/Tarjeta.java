
package Ventanas.usuarios.Tarjeta;


public class Tarjeta {
    private String nombretar; 
    private String numerotar;
    private String fechatar; 
    private String usuario;
    
    public Tarjeta(String nombretar, String numerotar, String fechatar, String usuario2) {
        this.nombretar = nombretar;
        this.numerotar = numerotar;
        this.fechatar = fechatar;
        this.usuario = usuario2;
    }

    @Override
    public String toString()
    {
        return "Tarjeta{" + "nombretar=" + nombretar + ", numerotar=" + numerotar + ", fechatar=" + fechatar + '}';
    }

    public String getUsuario(){
        return usuario;
    }
    public void setUsuario(String usuario2){
        this.usuario = usuario2;
    }
    
    
    public String getNombretar() {
        return nombretar;
    }

    public void setNombretar(String nombretar) {
        this.nombretar = nombretar;
    }

    public String getNumerotar() {
        return numerotar;
    }

    public void setNumerotar(String numerotar) {
        this.numerotar = numerotar;
    }

    public String getFechatar() {
        return fechatar;
    }

    public void setFechatar(String fechatar) {
        this.fechatar = fechatar;
    }
    
    
}
