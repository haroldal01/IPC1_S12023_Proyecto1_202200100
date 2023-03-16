
package Ventanas.usuarios.Cotizacion;
import Ventanas.usuarios.InicioSesion.*;

public class Logic
{
    
    private static BaseDeDatos clientedao = new BaseDeDatos(); 
    
    public static boolean insertar(Cotizacion cotizacion){
        return clientedao.insertar(cotizacion); 
    }
   
    public static String Imprimir (int a){
         return clientedao.imprimir(a);
     }
   public static int tamaño(){
       return clientedao.tamaño();
   }
   public static Cotizacion completa (int a){
       return clientedao.completa(a);
   }
   public static Cotizacion descargar(String codigo, String correo){
       return clientedao.descargaVerificar(codigo, correo);
   }
   
    
}
