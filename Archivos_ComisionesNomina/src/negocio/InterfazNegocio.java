
package negocio;

public interface InterfazNegocio {
    public void agregar(String nombre, double enero, double febrero, double marzo, double total, double promedio, String nombreArchivo);
    public void numMaxMes(int mes, String nombreArchivo);
    public void numMinMes(int mes, String nombreArchivo);
    public void numMaxTotal(String nombreArchivo);   
    public void listar(String nombreArchivo);
    public void buscar(String nombreArchivo, String buscar);
    public void editarNom(String nombre,String nuevo, String nombreArchivo);
    public void editCantidad(double cantidad,double nuevo,int opc, String nombreArchivo);
    public void iniciarArchivo(String nombreArchivo);
}
