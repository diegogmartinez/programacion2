
package negocio;

import datos.*;
import dominio.mdVendedor;
import excepciones.*;
import java.util.*;


public class negocioImpl implements InterfazNegocio{ 

   private final AccesoDatos datos;
    
    public negocioImpl(){
        this.datos = new AccesoDatosImpl(); //poner * en el import datos.*
    }
    
    @Override
    public void agregar(String nombre, double enero, double febrero, double marzo, double total, double promedio, String nombreArchivo) {
       mdVendedor vendedor = new mdVendedor();
        boolean anexar = false;
        try {
            anexar = datos.existe(nombreArchivo);//bandera si anexa o no
            datos.escribir(nombre, enero, febrero, marzo, total, promedio, nombreArchivo, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }
    
    @Override
    public void numMaxMes(int Mes, String nombreArchivo){
        double num=0;
        double mayor=0;
        String mes="";
        
        try {
            List<mdVendedor> vendedor = datos.listar(nombreArchivo);
            int opcion=Mes;            
            for (mdVendedor e: vendedor) {
                if(opcion==1){ 
                    mes="Enero";
                    num=e.enero;
                    if(num>mayor){
                        mayor=num;
                    }
                }else if(opcion==2){
                    mes="Febrero";
                    num=e.febrero;
                    if(num>mayor){
                        mayor=num;
                    }
                }else if(opcion==3){
                    mes="Marzo";
                    num=e.marzo;
                    if(num>mayor){
                        mayor=num;
                    }
                }else{
                    System.out.println("OPCION INCORRECTA");
                }                                
            }            
            
            System.out.println("LA VENTA MAXIMA DEL MES DE "+mes+" es de Q."+mayor);
            
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
        
                
    }

    @Override
    public void numMinMes(int Mes, String nombreArchivo){
        double num=0;
        double menor=0;
        String mes="";
        
        try {
            List<mdVendedor> vendedor = datos.listar(nombreArchivo);
            int opcion=Mes;
            for(mdVendedor e: vendedor){
                if(opcion==1){
                    menor=e.enero;
                }else if(opcion==2){
                    menor=e.febrero;
                }else if(opcion==3){ 
                    menor=e.marzo;
                }else{
                    System.out.println("Opcion incorrecta");
                }
            }

            for (mdVendedor e: vendedor) {
                if(opcion==1){ 
                    mes="Enero";
                    num=e.enero;
                    if(num<menor){
                        menor=num;
                    }
                }else if(opcion==2){
                    mes="Febrero";
                    num=e.febrero;
                    if(num<menor){
                        menor=num;
                    }
                }else if(opcion==3){
                    mes="Marzo";
                    num=e.marzo;
                    if(num<menor){
                        menor=num;
                    }
                }
                
            }            
            
            System.out.println("LA VENTA MINIMA DEL MES DE "+mes+" es de Q."+menor);
            
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
        
        
    }

    @Override
    public void numMaxTotal(String nombreArchivo){
        double mayor=0;
        double num=0;
        double enero=0;
        double febrero=0;
        double marzo=0;
        
        try {
            
            List<mdVendedor> vendedor = datos.listar(nombreArchivo);            
            for(mdVendedor e: vendedor){

                enero=e.enero;
                febrero=e.febrero;
                marzo=e.marzo;
                if (enero > num && enero > febrero && enero > marzo)
                {
                    mayor=enero;   

                }else if(febrero > num && febrero > enero && febrero > marzo){

                    mayor=febrero;

                }else if(marzo > num && marzo > enero && marzo > febrero){

                    mayor=marzo;
                }
                num=mayor;

            }       

            System.out.println("LA VENTA MAXIMA EN LOS TRES MESES FUE DE: Q."+mayor+".00\n\n");
        
            
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
        
        
    }
    
    
    
    @Override
    public void listar(String nombreArchivo) {

        try {
            List<mdVendedor> vendedor = datos.listar(nombreArchivo);
            for(mdVendedor e : vendedor){
                System.out.println(e.nombre+"\t\tQ."+e.enero+"\t\tQ."+e.febrero+"\t\tQ."+e.marzo+"\t\tQ."+e.total+"\t\tQ."+e.promedio);
            }
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
        
    }

    @Override
    public void buscar(String nombreArchivo, String buscar) {
        String resultado = null;
        try {
           
            datos.buscar(nombreArchivo, buscar);
            
        } catch (LecturaDatosEx ex) {
            System.out.println("Error ");
            ex.printStackTrace();
        }        
    
    }
    
    
    @Override
    public void editarNom(String nombre,String nuevo, String nombreArchivo){
        String nom=nombre;
        String newNom=nuevo;
        
        try {
            
            List<mdVendedor> vendedor = datos.listar(nombreArchivo);            
             for(mdVendedor e: vendedor){
                String buscador=e.nombre;
                if(nom.equalsIgnoreCase(buscador)){
                    e.nombre=newNom;
                }
            }                        
        
            iniciarArchivo(nombreArchivo);
            datos.Rescribir(vendedor, nombreArchivo);
            
            
        System.out.println("POR FAVOR ACTUALIZAR DATOS");

            
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        } catch (EscrituraDatosEx ex) {        
            System.out.println("Error de acceso a datos");
       }        
        
        
    }
    
    @Override
    public void editCantidad(double cant,double nuevo, int opc, String nombreArchivo){
        double cantidad=cant;
        double newcantidad=nuevo;
        int mesopc=opc;
        double buscador=0;
         
        try {
            
            List<mdVendedor> vendedor = datos.listar(nombreArchivo);            
            for(mdVendedor e: vendedor){
           
                switch(mesopc){
                    case 1:
                        buscador=e.enero;
                        if(cantidad==buscador){
                            e.enero=newcantidad;
                        }
                        break;
                    case 2:
                        buscador=e.febrero;
                        if(cantidad==buscador){
                            e.febrero=newcantidad;
                        }
                        break;
                    case 3:
                        buscador=e.marzo;
                        if(cantidad==buscador){
                            e.febrero=newcantidad;
                        }
                        break;
                    default:
                        System.out.println("Opcion no reconocida");
                        break;
                }


            }                  
        
            iniciarArchivo(nombreArchivo);
            datos.Rescribir(vendedor, nombreArchivo);
            
            
        System.out.println("POR FAVOR ACTUALIZAR DATOS");

            
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        } catch (EscrituraDatosEx ex) {        
            System.out.println("Error de acceso a datos");
       }     
        
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        
        try {
            if(datos.existe(nombreArchivo)){
                datos.borrar(nombreArchivo);
                datos.crear(nombreArchivo);
            } else {
                //crearmos archivo
                datos.crear(nombreArchivo);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }

    }
    
}
