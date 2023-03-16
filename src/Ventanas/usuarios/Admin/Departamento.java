

package Ventanas.usuarios.Admin;

public class Departamento {
    
    String nombre;
    String region;
    String cRegion;
    
    public Departamento (String nombre, String regino, String region){
        
        this.nombre = nombre;
        this.region = region;
        this.cRegion = region;
        
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getRegion(){
        return region;
    }
    
    public void setCodigo(String region){
        this.region = region;
    }
    
    public String getcRegion(){
        return cRegion;
    }
    
    public void setcRegion(String region){
        this.cRegion = region;
    }
    
    
}
