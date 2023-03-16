
package Ventanas.usuarios.Cotizacion;

import java.util.*;
public class BaseDeDatos
{

    List<Cotizacion> Database;
    public BaseDeDatos()
    {
        this.Database = new ArrayList();
    }
   
   public String imprimir(int a){
        return Database.get(a).toString();
    }
    
     public int buscar(String codigo, String correo2){ // busca si ese usuario ya existe haciendo uso de su correo
            int n = -1; 
            for(int i=0;i<Database.size();i++){
                
                if(Database.get(i).getUsuario().equalsIgnoreCase(correo2)){
                    if(Database.get(i).getCodigo().equals(codigo)){
                        n=i;
                    }
                }
                     
            }                             
            return n; 
        }
    
    public  Cotizacion descargaVerificar(String codigo, String correo){
        
        return Database.get(buscar(codigo, correo));
        
    }
    
    public boolean insertar(Cotizacion cliente){
        Database.add(cliente);
        return true;
    }
    
    public int tamaño (){
        return Database.size();
    }
    
    public Cotizacion completa(int a){
        return Database.get(a);
    }
    
}
