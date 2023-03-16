
package Ventanas.usuarios.Tarjeta;

import java.util.*;
public class BaseDeDatos
{

    List<Tarjeta> Database;
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
    
     public int buscar(String numero2, String correo2){ // busca si ese usuario ya existe haciendo uso de su correo
            int n = -1; 
            for(int i=0;i<Database.size();i++){
                
                if(Database.get(i).getUsuario().equalsIgnoreCase(correo2)){
                    if(Database.get(i).getNumerotar().equals(numero2)){
                        n=1;
                    }
                }
                     
            }                             
            return n; 
        }
    
    public  boolean insertar(Tarjeta numero){
        if(buscar(numero.getNumerotar(),numero.getUsuario())==-1){
          Database.add(numero);
          return true;
        }else{
            return false; 
        }
        
    }
    
    public  Tarjeta obtener(String numero, String Usuario){

            return Database.get(buscar(numero, Usuario));    
    }
    
    public int tamaño (){
        return Database.size();
    }
    
    public Tarjeta completa(int a){
        return Database.get(a);
    }
    
}
