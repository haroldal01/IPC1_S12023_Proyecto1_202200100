
package Ventanas.usuarios.Admin;


public class Region {
    
   private String nombreregion; 
   private String codigo; 
   public double pEstandar;
   public double pEspecial;
   
   public Region(String nombreregion, String codigo, double per, double pes){
       this.nombreregion = nombreregion; 
        this.codigo =codigo; 
        this.pEspecial = pes;
        this.pEstandar = per;
   }

    public String getNombreregion() {
        return nombreregion;
    }

    public void setNombreregion(String nombreregion) {
        this.nombreregion = nombreregion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
   
    public double getPrecioEspecial(){
        return pEspecial;
    }
    public double getPrecioEstandar(){
        return pEstandar;
    }
    public void setEstandar(double estandar){
        this.pEstandar = estandar;
    }
    public void setEspecial(double especial){
        this.pEspecial = especial;
    }
   
    
}
