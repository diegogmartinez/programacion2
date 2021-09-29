
package datos;

import dominio.mdVendedor;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;
import java.io.*;
import java.util.*;

public class AccesoDatosImpl implements AccesoDatos{
    
    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }
    
    @Override
    public List<mdVendedor> listar(String nombreArchivo) throws LecturaDatosEx {
          List<mdVendedor> vendedor = new ArrayList();
        try {
           BufferedReader entrada = null; 
            File archivo = new File(nombreArchivo);
           
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null){
                mdVendedor vend = new mdVendedor();
                String[]datosVend=linea.split("\\|");
                vend.nombre=datosVend[0];
                vend.enero=Double.valueOf(datosVend[1]);
                vend.febrero=Double.valueOf(datosVend[2]);
                vend.marzo=Double.valueOf(datosVend[3]);
                vend.total=Double.valueOf(datosVend[4]);
                vend.promedio=Double.valueOf(datosVend[5]);               
                vendedor.add(vend);
                linea = entrada.readLine();
                      
            }   
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) { 
            ex.printStackTrace(System.out);
        }
        return vendedor;
    }
    
    
    @Override
    public void escribir(String nombre, double enero, double febrero, double marzo, double total, double promedio, String nombreArchivo,boolean anexar) throws EscrituraDatosEx{
        PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(nombre+"|"+enero+"|"
                    +febrero+"|"+marzo+"|"
                    +total+"|"+promedio);
            salida.close();
            System.out.println("Se ha escrito el registro en el archivo");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
    }
    
    @Override
    public void Rescribir(List<mdVendedor> lista, String nombreArchivo)throws EscrituraDatosEx{
        
        PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo));
            for(mdVendedor e: lista){
                salida.println(e.nombre+"|"+e.enero+"|"+e.febrero+"|"+e.marzo+"|"+e.total+"|"+e.promedio);
            }
            salida.close();
            System.out.println("Se ha reescrito el registro en el archivo");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
    }
    
    @Override
    public void buscar(String nombreArchivo,String buscar){
        List<mdVendedor> vendedor = new ArrayList();
        double enero;
        double febrero;
        double marzo;
        String persona="";
        String mes="";
        double cantidad=Double.valueOf(buscar);
        
        try {
           BufferedReader entrada = null; 
            File archivo = new File(nombreArchivo);
           
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null){
                mdVendedor vend = new mdVendedor();
                String[]datosVend=linea.split("\\|");
                vend.nombre=datosVend[0];
                vend.enero=Double.valueOf(datosVend[1]);
                vend.febrero=Double.valueOf(datosVend[2]);
                vend.marzo=Double.valueOf(datosVend[3]);                               
                vendedor.add(vend);
                linea = entrada.readLine();
                      
            }   
            
            for(mdVendedor e: vendedor){
                enero=e.enero;
                febrero=e.febrero;
                marzo=e.marzo;
                if(cantidad==enero){
                    mes="Enero";
                    persona=e.nombre;
                    System.out.println(""+persona+" vendió Q."+cantidad+" "+"en el mes de "+mes);
                }else if(cantidad==febrero){
                    mes="Febrero";
                    persona=e.nombre;
                    System.out.println(""+persona+" vendió Q."+cantidad+" "+"en el mes de "+mes);
                }else if(cantidad==marzo){
                    mes="Marzo";
                    persona=e.nombre;
                    System.out.println(""+persona+" vendió Q."+cantidad+" "+"en el mes de "+mes);
                }
            
            } 
            
            entrada.close();
        } catch (FileNotFoundException ex) {
             ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

public void crear(String nombreArchivo){
    PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
          } catch (IOException ex) {
              ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
}
   
@Override
public void borrar(String nombreArchivo) throws AccesoDatosEx{
    File archivo = new File(nombreArchivo);
    archivo.delete();
    System.out.println("Se ha borrado el archivo");
}
    

}


