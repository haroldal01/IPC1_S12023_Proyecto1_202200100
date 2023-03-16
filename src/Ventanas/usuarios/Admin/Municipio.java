
package Ventanas.usuarios.Admin;

import Ventanas.usuarios.Admin.Departamento;


public class Municipio {
    
    String nombre;
    String cDepartamento;
    
    public Municipio (String nombre, String departamento){
        
        this.nombre = nombre;
        this.cDepartamento = departamento;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getDepartamento(){
        return cDepartamento;
    }
    
    public void setDepartamento(String departamento){
        this.cDepartamento = departamento;
    }
    
    
   
}
