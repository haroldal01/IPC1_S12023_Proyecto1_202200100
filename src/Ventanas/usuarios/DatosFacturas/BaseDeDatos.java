
package Ventanas.usuarios.DatosFacturas;
import java.util.*;

public class BaseDeDatos
{

    List<Factura> Database;
    public BaseDeDatos()
    {
        this.Database = new ArrayList();
    }
    
    public String imprimir(int a){
        return Database.get(a).toString();
    }
    
    public void eliminar(int a){
        Database.remove(a);
    }
    
    
    public  int buscar(String correo2, String codigo){
        
        int n = -1; 
            for(int i=0;i<Database.size();i++){
                
                if(Database.get(i).getUsuario().equalsIgnoreCase(correo2)){
                    if(Database.get(i).getCodigo().equalsIgnoreCase(codigo)){
                        n=1;
                    }
                }
                     
            }   
        return n;
    }
    
    public  boolean insertar(Factura cliente){
        if(buscar(cliente.getUsuario(),cliente.getCodigo())==-1){
          Database.add(cliente);
          return true;
        }else{
            return false; 
        }
        
    }
    
    
     public int tamaño (){
        return Database.size();
    }
    
     public Factura completa(int a){
        return Database.get(a);
    }
    
}
