
package Ventanas.usuarios.Tarjeta;
import Ventanas.usuarios.InicioSesion.*;

public class Logic
{
    
    private static BaseDeDatos tarjetadao = new BaseDeDatos(); 
    
    public static boolean insertar(Tarjeta numero){
        return tarjetadao.insertar(numero); 
    }
    public static String Imprimir (int a){
         return tarjetadao.imprimir(a);
     }
   public static int tamaño(){
       return tarjetadao.tamaño();
   }
   public static Tarjeta completa (int a){
       return tarjetadao.completa(a);
   }   
   
   public static void eliminar (int a){
       tarjetadao.eliminar(a);
   }
    
   public static int buscar(String correo, String numero){
       return tarjetadao.buscar(numero, correo);
   }
   
}
