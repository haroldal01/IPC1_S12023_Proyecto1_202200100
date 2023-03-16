
package Ventanas.usuarios.DatosFacturas;
import Ventanas.usuarios.InicioSesion.*;

public class Logics
{
    
    private static BaseDeDatos facturadao = new BaseDeDatos(); 
    
    public static boolean insertar(Factura cliente){
        return facturadao.insertar(cliente); 
    }
   
    public static String Imprimir (int a){
         return facturadao.imprimir(a);
     }
   public static int tamaño(){
       return facturadao.tamaño();
   }
   public static Factura completa (int a){
       return facturadao.completa(a);
   }
    
    public static int buscar(String correo, String codigo){
       return facturadao.buscar(codigo, correo);
   }
    
    public static void eliminar(int a){
         facturadao.eliminar(a);
    }
   
}
