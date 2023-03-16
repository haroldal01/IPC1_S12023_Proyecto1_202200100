
package Ventanas.usuarios.Admin;
import java.util.*;

public class BaseDeDatos
{
    
    public List <Region> regiones;
    public List <Departamento> departamentos;
    public List <Municipio> municipios;
    
    public BaseDeDatos(){
        this.regiones = new ArrayList();
        this.departamentos = new ArrayList();
        this.municipios = new ArrayList();
    }
    
    public void eliminarR(int a){
        regiones.remove(a);
    }
    public void eliminarD(int a){
        departamentos.remove(a);
    }
    public void eliminarM(int a){
        municipios.remove(a);
    }
    
    public Region imprimirR (int a){
     return regiones.get(a);
    }
    public Departamento imprimirD(int a){
        return departamentos.get(a);
    }
    public Municipio imprimirM(int a){
        return municipios.get(a);
    }
    
    public int tamañoR(){
        return regiones.size();
    }
    public int tamañoD(){
        return departamentos.size();
    }
    public int tamañoM(){
        return municipios.size();
    }
    public int buscarReg(String codigo){
    int n=-1;     
    for(int i = 0; i<regiones.size();i++){
        if(regiones.get(i).getCodigo().equalsIgnoreCase(codigo)){
            n=1;
        }
    }       
    return n;            
    }
    
    public int buscarDep(String nombre, String region){
    int n=-1;     
    for(int i = 0; i<departamentos.size();i++){
        
        if(region.equalsIgnoreCase(departamentos.get(i).getcRegion())){
            if(departamentos.get(i).getNombre().equalsIgnoreCase(nombre)){
            n=1;
            }
        }
    }       
    return n;            
    }
    public int buscarMun(String nombre, String depa){
    int n=-1;     
    for(int i = 0; i<municipios.size();i++){
        if(municipios.get(i).getDepartamento().equalsIgnoreCase(depa)){
            if(municipios.get(i).getNombre().equalsIgnoreCase(nombre)){
            n=1;
            }
        }
    }       
    return n;            
    }
    
    public boolean insRegion (Region region){
        regiones.add(region);
        return true;
    }
    public boolean insDepartamento(Departamento departamento){
        
        if(buscarDep(departamento.getNombre(),departamento.getcRegion())==-1){
            departamentos.add(departamento);
            return true;
        }else{
            return false;
        }
    }
    public boolean insMunicipio (Municipio municipio){
        if(buscarMun(municipio.getNombre(),municipio.getDepartamento())==-1){
            municipios.add(municipio);
            return true;
        }else{
            return false;
        }
    }
    
    
    
    
    
    
    
    
    
}
