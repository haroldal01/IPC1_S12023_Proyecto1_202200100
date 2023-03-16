
package Ventanas.usuarios.InicioSesion;
import java.util.*;
public class BaseDeDatos
{

    public List <UsuariosModelo> Database;

    public BaseDeDatos()
    {
        this.Database = new ArrayList();
    }
    
    public UsuariosModelo completa (int a)
    {
        return Database.get(a);
    }
    
    
    public int buscar(String correo2){ // busca si ese usuario ya existe haciendo uso de su correo
            int n = -1; 
            for(int i=0;i<Database.size();i++){
               if(Database.get(i).getCorreo().equals(correo2)){
                 n=1;
               }          
            }                             
            return n; 
        }
    
    public  boolean insertar(UsuariosModelo correo){
        if(buscar(correo.getCorreo())==-1){
          Database.add(correo);
          return true;
        }else{
            return false; 
        }
        
    }
    
    public  UsuariosModelo obtener(String correo){

            return Database.get(buscar(correo));    
    }
    
    
    
    public void imprimir(int a){
        System.out.println(Database.get(a).toString());
    }
    public int tamaño(){
        int tamaño1 = Database.size();
        return tamaño1;
    }
    public String getcontraseña(int a){
        String hola = Database.get(a).getContraseña();
        return hola;
    }
    public String getcorreo(int a){
        String hola = Database.get(a).getCorreo();
        return hola;
    }
    
    public String getrol(int a){
        String hola = Database.get(a).getRol(); 
        return hola; 
    }
    
    
}


