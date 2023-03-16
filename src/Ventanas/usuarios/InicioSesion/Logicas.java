
package Ventanas.usuarios.InicioSesion;

public class Logicas
{
    
    private static BaseDeDatos usuariodao = new BaseDeDatos(); 
     
     public static void Imprimir (int a){
         usuariodao.imprimir(a);
     }
    
    public static boolean insertar(UsuariosModelo correo){
        return usuariodao.insertar(correo); 
    }
    
    public static UsuariosModelo obtener(String correo){
        return usuariodao.obtener(correo); 
    }
     public static UsuariosModelo completa (int a)
    {
        return usuariodao.completa(a);
    }
    
    
    
    public static int tamaño(){
         int tamaño2 = usuariodao.tamaño();
         return tamaño2;
     }
    public static String getcontraseña(int a){
        String contraseña =usuariodao.getcontraseña(a);
        return contraseña;
    }
    public static String getcorreo(int a){
        String correo = usuariodao.getcorreo(a);
        return correo;
    }
    
    public static String getrol(int a){
        String hola = usuariodao.getrol(a); 
        return hola; 
    }
   
    
    
    
    public static int login(String contraseña, String correo){
        int login = -1;
            if(Logicas.tamaño()>0)
            {
               for(int i = 0; i<Logicas.tamaño();i++)
               {
                   String contraseña2 = Logicas.getcontraseña(i);
                   String correo2 = Logicas.getcorreo(i);
                   if(contraseña.equals(contraseña2) &&
                           correo.equalsIgnoreCase(correo2)){
                       login=i;
                   } 
               }  
            }
            return login;
    }

    public static String getrol(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
