
package Nomina;

import Datos.ClsUsuario;
import Datos.ClsVendedor;
import java.util.ArrayList;
import java.util.List;
import modelos.mdUsuario;
import modelos.mdVendedor;

public class ClsOperaciones {
    
    private final ClsVendedor datos;
    
    public ClsOperaciones(){
        this.datos = new ClsVendedor(); //poner * en el import datos.*
    }
    
    
    public String numMaxMes(int Mes){
        double num=0;
        double mayor=0;
        String mes="";
        

        List<mdVendedor> vendedor = datos.listar();
        int opcion=Mes;            
        for (mdVendedor e: vendedor) {
            if(opcion==1){ 
                mes="Enero";
                num=e.getEnero();
                if(num>mayor){
                    mayor=num;
                }
            }else if(opcion==2){
                mes="Febrero";
                num=e.getFebrero();
                if(num>mayor){
                    mayor=num;
                }
            }else if(opcion==3){
                mes="Marzo";
                num=e.getMarzo();
                if(num>mayor){
                    mayor=num;
                }
            }else{
                System.out.println("OPCION INCORRECTA");
            }                                
        }            

        String valor="LA VENTA MAXIMA DEL MES DE "+mes+" es de Q."+mayor;
       
        return valor;

    }

    public ArrayList<String> buscar(Double cantidad){
        
        List<mdVendedor> lista = datos.listar();
        ArrayList<String> lst = new ArrayList<String>();
        String mes="";
        String persona="";
        for(mdVendedor e: lista){
            double enero=e.getEnero();
            double febrero=e.getFebrero();
            double marzo=e.getMarzo();
            if(cantidad==enero){
                mes="Enero";
                persona=e.getNombre();
                lst.add(persona+" vendió Q."+cantidad+" "+"en el mes de "+mes);
            }else if(cantidad==febrero){
                mes="Febrero";
                persona=e.getNombre();
                lst.add(persona+" vendió Q."+cantidad+" "+"en el mes de "+mes);
            }else if(cantidad==marzo){
                mes="Marzo";
                persona=e.getNombre();
                lst.add(persona+" vendió Q."+cantidad+" "+"en el mes de "+mes);
            }
            
        }  
        return lst;
    }
        
    public String numMinMes(int Mes){
        double num=0;
        double menor=0;
        String mes="";
        
        
        List<mdVendedor> vendedor = datos.listar();
        int opcion=Mes;
        for(mdVendedor e: vendedor){
            if(opcion==1){
                menor=e.getEnero();
            }else if(opcion==2){
                menor=e.getFebrero();
            }else if(opcion==3){
                menor=e.getMarzo();
            }else{
                System.out.println("Opcion incorrecta");
            }
        }

        for (mdVendedor e: vendedor) {
            if(opcion==1){ 
                mes="Enero";
                num=e.getEnero();
                if(num<menor){
                    menor=num;
                }
            }else if(opcion==2){
                mes="Febrero";
                num=e.getFebrero();
                if(num<menor){
                    menor=num;
                }
            }else if(opcion==3){
                mes="Marzo";
                num=e.getMarzo();
                if(num<menor){
                    menor=num;
                }
            }

        }            

        String res="LA VENTA MINIMA DEL MES DE "+mes+" es de Q."+menor;

        return res;
        
    }

    public String numMaxTotal(){
        double mayor=0;
        double num=0;
        double enero=0;
        double febrero=0;
        double marzo=0;
        
        
            
        List<mdVendedor> vendedor = datos.listar();            
        for(mdVendedor e: vendedor){

            enero=e.getEnero();
            febrero=e.getFebrero();
            marzo=e.getMarzo();
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

        String res="LA VENTA MAXIMA FUE DE: Q."+mayor;                
        
        return res;
        
    }        
    
    public void listar() {
        
        try {
            List<mdVendedor> vendedor = datos.listar();
            for(mdVendedor e : vendedor){
                System.out.println("Vendedor= "+e);
            }
        } catch (Exception e) {
            System.out.println("Error de acceso a datos");            
        }
        
    }    
           
    
    public void editCantidad(int Id,double newcantidad, int mesopc){
       
       datos.modCant(Id, newcantidad, mesopc);
        System.out.println("Actualice Datos");
        
    }

    
    
    
}
