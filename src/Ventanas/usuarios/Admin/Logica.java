
package Ventanas.usuarios.Admin;

import Ventanas.usuarios.Admin.BaseDeDatos;
import java.util.*;
public class Logica
{
    
     public static void Ingresar (){
          Logica.insRegion();
          Logica.insDepartamento();
          Logica.insMunicipio();
      }
     private static BaseDeDatos Pais = new BaseDeDatos();
     
     public static void eliminarR(int a){
          Pais.eliminarR(a);
     }
     
     public static void eliminarD(int a){
         Pais.eliminarD(a);
     }
     public static void eliminarM(int a){
         Pais.eliminarM(a);
     }
     
     public static int buscarR(String codigo){
         return Pais.buscarReg(codigo);
         
     }
     
     public static Region imprimirR (int a){
         return Pais.imprimirR(a);
     }
     public static Departamento imprimirD(int a){
         return Pais.imprimirD(a);
     }
     public static Municipio imprimirM(int a){
         return Pais.imprimirM(a);
     }
     public static int tamañoR(){
         return Pais.tamañoR();
     }
     public static int tamañoD(){
         return Pais.tamañoD();
     }
     public static int tamañoM(){
         return Pais.tamañoM();
     }
     
    public static void insRegion (){
       
        Region []temporal = new Region [6];
        temporal [0] = new Region("M","Metropolitana",35,25);
        temporal [1] = new Region("NT","Norte",68.5,45.55);
        temporal [2] = new Region("NO", "Nororiente",58.68,35.48);
        temporal [3] = new Region("SO","Suroriente",38.68,32.48);
        temporal [4] = new Region("SOC", "Suroccidente",34,29);
        temporal [5] = new Region("NOC","Noroccidente",44.5,40);
        
        for(int a =0; a<6; a++){
            Pais.insRegion(temporal[a]);
        }
        
    }
    public static void insDepartamento(){
        Departamento [] departamentos = new Departamento[6];
        departamentos[0] = new Departamento("Guatemala", "Metropolitana", "M");
        departamentos[1] = new Departamento("Baja Verapaz", "Norcentral", "NT");
        departamentos[2] = new Departamento("El Progreso", "Nororiental", "NO");
        departamentos[3] = new Departamento("Escuintla", "Surcentral", "SO");
        departamentos[4] = new Departamento("Huehuetenango", "Noroccidental", "NOC");
        departamentos[5] = new Departamento("Retalhuleu", "Suroccidental", "SOC");
        
        for(int a =0; a<departamentos.length; a++){
            Pais.insDepartamento(departamentos[a]);
        }
    }
    public static void insMunicipio(){
        Municipio [] municipios = new Municipio[6];
        
        municipios[0] = new Municipio("Mixco", "Guatemala");
        municipios[1] = new Municipio("Escuintla", "Escuintla");
        municipios[2] = new Municipio("Huehuetenango", "Huehuetenango");
        municipios[3] = new Municipio("Retalhuleu", "Retalhuleu");
        municipios[4] = new Municipio("Rabinal","Baja Verapaz");
        municipios[5] = new Municipio("Sanarate", "El Progreso");
        
        for(int a =0; a<municipios.length; a++){
            Pais.insMunicipio(municipios[a]);
        }
    }
    
    public static void insertarD(Departamento dep){
        Pais.insDepartamento(dep);
    }
    
    public static void insertarM(Municipio mun){
        Pais.insMunicipio(mun);
    }
    
}
