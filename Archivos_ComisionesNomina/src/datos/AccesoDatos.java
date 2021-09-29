
package datos;

import dominio.mdVendedor;
import excepciones.*;
import java.util.*;


public interface AccesoDatos {
    boolean existe(String nombreArchivo) throws AccesoDatosEx;
    public List<mdVendedor> listar(String nombreArchivo) throws LecturaDatosEx;
    void escribir(String nombre, double enero, double febrero, double marzo, double total, double promedio, String nombreArchivo,boolean anexar) throws EscrituraDatosEx;
    public void Rescribir(List<mdVendedor> lista, String nombreArchivo)throws EscrituraDatosEx;
    public void buscar(String nombreArchivo,String buscar) throws LecturaDatosEx;
    public void crear(String nombreArchivo) throws AccesoDatosEx;
    public void borrar(String nombreArchivo) throws AccesoDatosEx;
   
}
