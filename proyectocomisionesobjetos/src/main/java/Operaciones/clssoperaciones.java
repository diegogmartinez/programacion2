/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Modelos.clssmodelo;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class clssoperaciones {
    private Scanner entrada=new Scanner(System.in); 
    public List<clssmodelo> lista=new ArrayList<clssmodelo>();
    
        
    
   
   public  void IngresarInformacion(){
       clssmodelo modelovendedor= new clssmodelo();
        for (clssmodelo l: lista) {            
        System.out.println("Ingrese nombre:");
        modelovendedor.nombre= entrada.nextLine();
        System.out.println("Ingrese Enero: ");
        modelovendedor.enero = entrada.nextDouble();
        System.out.println("Ingrese Febrero: ");
        modelovendedor.febrero = entrada.nextDouble();
        System.out.println("Ingrese Marzo: ");
        modelovendedor.marzo = entrada.nextDouble();
        modelovendedor.total = modelovendedor.enero + modelovendedor.febrero + modelovendedor.marzo;
        modelovendedor.promedio = modelovendedor.total / 3;
        lista.add(modelovendedor);
        }                      
        
    }   
   
   public  void OrdenarDatos(){
       System.out.println("NOMBRE\t\tENERO\t\tFEBRERO\t\tMARZO\t\tTOTAL\t\tPROMEDIO");
        for(clssmodelo e:lista){
            System.out.print(e.nombre+"\t\tQ."+e.enero+"\t\tQ."+e.febrero+"\t\tQ."+e.marzo+"\t\tQ."+e.total+"\t\tQ."+e.promedio);
            System.out.print("\n");         
        } 
        
        
    }
   
   
    
    public  void ventaMax(){
        double mayor=0;
        double num=0;
        double enero=0;
        double febrero=0;
        double marzo=0;
        
        for(clssmodelo e: lista){
          if(enero> num && enero > febrero && enero > marzo){
              mayor=enero;
          }
           else
              if(febrero > num && febrero > marzo && febrero > enero ){
          mayor=febrero;
        }
          else
              if (marzo > num && marzo > febrero && marzo > enero){
                  mayor=marzo;
              }    
        
        }
        
      
    } 
    
   
   public void volvermenu(){
        System.out.println("\n\nPARA VOLVER AL MENÚ INGRESE LA PALABRA 'MN' : ");    
        String palabra=entrada.nextLine();
        
        if(palabra.contains("MN")){
            menu();            
        }
    }
   public void VentaMesMAX(){
        System.out.println("\n\t\t\t¿Que mes desea consultar?");
        System.out.println("\n\n\t1. ENERO");
        System.out.println("\n\n\t2. FEBRERO");
        System.out.println("\n\n\t3. MARZO");
        String opn=entrada.nextLine();
        opn=entrada.nextLine();
        double num=0;
        double mayor=0;
        String mes="";
        try{
            
            int opcion=Integer.parseInt(opn);            
            for (clssmodelo e: lista) {
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
            
            System.out.println("LA VENTA MAXIMA DEL MES DE "+mes+" es de Q."+mayor+".00");
            
        }catch(Exception e){
            System.out.println(""+e.getMessage());
        }
                
    }
    
    public void VentaMesMIN(){
        System.out.println("\n\t\t\t¿Que mes desea consultar?");
        System.out.println("\n\n\t1. ENERO");
        System.out.println("\n\n\t2. FEBRERO");
        System.out.println("\n\n\t3. MARZO");
        String opn=entrada.nextLine();
        opn=entrada.nextLine();
        double num=0;
        double menor=0;
        String mes="";
        try{
            
            int opcion=Integer.parseInt(opn);
            for(clssmodelo e: lista){
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

            for (clssmodelo e: lista) {
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
            
            System.out.println("LA VENTA MINIMA DEL MES DE "+mes+" es de Q."+menor+".00");
            
        }catch(Exception e){
            System.out.println(""+e.getMessage());
        }
        
    }
    
    public void BuscarXCantidad(){
        System.out.println("INGRESE CANTIDAD A BUSCAR: ");
        double cantidad=entrada.nextInt();  
        double enero;
        double febrero;
        double marzo;
        String persona="";
        String mes="";
        
        for(clssmodelo e: lista){
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
        
    }
    
    public void EditarNom(){        
        
        System.out.println("Ingrese el nombre de la persona que desea editar: ");
        String nom=entrada.nextLine();
        String nombre=entrada.nextLine();
        System.out.println("Ingrese el nuevo Nombre: ");
        String newNom=entrada.nextLine();
        
        for(clssmodelo e: lista){
            String buscador=e.nombre;
            if(nombre.equalsIgnoreCase(buscador)){
                e.nombre=newNom;
            }
        }                        
        
        System.out.println("POR FAVOR ACTUALIZAR DATOS");
    }
    
    public void EditarCant(){
        System.out.println("\t\t\tIngrese la cantidad a modificar");
        double cantidad =entrada.nextInt();
        System.out.println("\t\t\tIngrese la nueva cantidad");
        double newcantidad =entrada.nextInt();
        System.out.println("\t\t\t¿De que mes desea modificar el dato?");
        System.out.println("\n\n\t\t1. ENERO");
        System.out.println("\n\n\t\t2. FEBRERO");
        System.out.println("\n\n\t\t3. MARZO");
        int mesopc=entrada.nextInt();
        double buscador=0;
        
        for(clssmodelo e: lista){
           
            switch(mesopc){
                case 1 -> {
                    buscador=e.enero;
                    if(cantidad==buscador){
                        e.enero=newcantidad;
                    }
                }
                case 2 -> {
                    buscador=e.febrero;
                    if(cantidad==buscador){
                        e.febrero=newcantidad;
                    }
                }
                case 3 -> {
                    buscador=e.marzo;
                    if(cantidad==buscador){
                        e.febrero=newcantidad;
                    }
                }
            }
            
            
        }
                       
             
        System.out.println("Actualice datos\n\n\n");
        
    }
   public void menu(){
        System.out.print("\n\t\t\t\tSeleccione Opcion");
        System.out.println("\n\t\t1. INGRESAR DATOS ");
        System.out.println("\n\t\t2. VENTA MAXIMA POR MES");
        System.out.println("\n\t\t3. VENTA MINIMA POR MES");
        System.out.println("\n\t\t4. VENTA MAXIMA TOTAL");
        System.out.println("\n\t\t5. MOSTRAR DATOS");
        System.out.println("\n\t\t6. BUSCAR CANTIDAD");
        System.out.println("\n\t\t7. EDITAR");               
        String op=entrada.nextLine();

        try{
            
            int opcion=Integer.parseInt(op);
            
            switch(opcion){
            case 1:
                IngresarInformacion();
                volvermenu();
                break;
            case 2:
                VentaMesMAX();
                volvermenu();
                break;
            case 3:
                VentaMesMIN();
                volvermenu();
                break;
            case 4:
                ventaMax();
                volvermenu();
                break;
            case 5:
                OrdenarDatos();
                volvermenu();
                break;
            case 6:
                ventaMax();
                volvermenu();
                break;
           case 7:
                System.out.println("Ingrese el numero de la opcion a editar");
                System.out.println("\n\t1. NOMBRE");
                System.out.println("\n\t2. CANTIDAD");
                int can=entrada.nextInt();
                
                switch(can){
                    case 1:
                        EditarNom();
                       volvermenu();
                        break;
                    case 2:
                        EditarCant();
                        volvermenu();
                        break;
                }
               
                break;                                           
        }
        }catch (Exception e){
            System.out.println(""+e);
        }
               

    }
    
}
