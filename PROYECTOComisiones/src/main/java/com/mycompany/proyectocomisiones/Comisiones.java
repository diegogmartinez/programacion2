
package com.mycompany.proyectocomisiones;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Comisiones {
    private static Scanner entrada=new Scanner(System.in);
    
    private static String[][] comisiones=new String[3][6];     
    private static final int NOMBRE=0;
    private static final int ENERO=1;
    private static final int FEBRERO=2;
    private static final int MARZO=3;
    private static final int TOTAL=4;
    private static final int PROMEDIO=5;
    private static int nom=0;
    private static int fila=0;

    

   public static void LimpiarPantalla(){
       try{           
           Robot presrobt=new Robot();
           presrobt.keyPress(KeyEvent.VK_CONTROL);
           presrobt.keyPress(KeyEvent.VK_L);
           presrobt.keyRelease(KeyEvent.VK_CONTROL);
           presrobt.keyRelease(KeyEvent.VK_CONTROL);
           
       }catch(Exception e){
           System.out.println(""+e.getMessage());
       }
              
   } 
   
   public static void IngresarInformacion(){
        for (int i = 0; i < 3; i++) {            
        System.out.println("Ingrese nombre "+(++nom)+":");
        comisiones[i][NOMBRE]=entrada.nextLine();
        System.out.println("Ingrese Enero: ");
        comisiones[i][ENERO]=entrada.nextLine();
        System.out.println("Ingrese Febrero: ");
        comisiones[i][FEBRERO]=entrada.nextLine();
        System.out.println("Ingrese Marzo: ");
        comisiones[i][MARZO]=entrada.nextLine();
        }                      
        
        VolverMenu();
        
    }   
   
   public static void OrdenarDatos(){
        System.out.println("NOMBRE\t\tFEBRERO\t\tENERO\t\tMARZO\t\tTOTAL\t\tPROMEDIO");
        for(int x =0; x<comisiones.length;x++ ){
            System.out.print(comisiones[x][NOMBRE]+"\t\tQ."+comisiones[x][ENERO]+".00\t\tQ."+comisiones[x][FEBRERO]+".00\t\tQ."+comisiones[x][MARZO]+".00\t\tQ."+comisiones[x][TOTAL]+".00\t\tQ."+comisiones[x][PROMEDIO]);
            System.out.print("\n");         
        }
        
        VolverMenu();
        
    }
   
   public static void MostrarDatos(){
        int suma=0;
        double promedio;
        DecimalFormat format = new DecimalFormat("#.00");
        String matriz[][]=new String [3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j <4 ; j++) {
                
                suma+=Integer.parseInt(comisiones[i][j]);
                matriz[i][0]=Integer.toString(suma); 
                comisiones[i][TOTAL]=matriz[i][0];
                
            }
            promedio=suma/3;
            matriz[i][1]=String.valueOf(format.format(promedio));
            comisiones[i][PROMEDIO]=matriz[i][1];
            suma=0;
        }                
        
        OrdenarDatos();
    }
    
    public static void ventaMax(){
        int mayor=0;
        int num=0;        
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 4; j++) {                
                num=Integer.parseInt(comisiones[i][j]);
                if(num>mayor){
                    mayor=num;                    
                }                                
            }
        }
        
        System.out.println("LA VENTA MAXIMA EN LOS TRES MESES FUE DE: Q."+mayor+".00\n\n");
        VolverMenu();
    }
    
    public static void VentaMesMAX(){
        System.out.println("\n\t\t\t¿Que mes desea consultar?");
        System.out.println("\n\n\t1. ENERO");
        System.out.println("\n\n\t2. FEBRERO");
        System.out.println("\n\n\t3. MARZO");
        String opn=entrada.nextLine();
        int num=0;
        int mayor=0;
        String mes="";
        try{
            
            int opcion=Integer.parseInt(opn);            
            for (int i = 0; i < 3; i++) {
                if(opcion==1){ 
                    mes="Enero";
                    num=Integer.parseInt(comisiones[i][opcion]);
                    if(num>mayor){
                        mayor=num;
                    }
                }else if(opcion==2){
                    mes="Febrero";
                    num=Integer.parseInt(comisiones[i][opcion]);
                    if(num>mayor){
                        mayor=num;
                    }
                }else if(opcion==3){
                    mes="Marzo";
                    num=Integer.parseInt(comisiones[i][opcion]);
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
        
        VolverMenu();
        
    }
    
    public static void VentaMesMIN(){
        System.out.println("\n\t\t\t¿Que mes desea consultar?");
        System.out.println("\n\n\t1. ENERO");
        System.out.println("\n\n\t2. FEBRERO");
        System.out.println("\n\n\t3. MARZO");
        String opn=entrada.nextLine();
        int num=0;
        int menor=0;
        String mes="";
        try{
            
            int opcion=Integer.parseInt(opn);            
            for (int i = 1; i < 3; i++) {
                if(opcion==1){ 
                    mes="Enero";
                    menor=Integer.parseInt(comisiones[0][opcion]);
                    num=Integer.parseInt(comisiones[i][opcion]);
                    if(num<menor){
                        menor=num;
                    }
                }else if(opcion==2){
                    mes="Febrero";
                    menor=Integer.parseInt(comisiones[0][opcion]);
                    num=Integer.parseInt(comisiones[i][opcion]);
                    if(num<menor){
                        menor=num;
                    }
                }else if(opcion==3){
                    mes="Marzo";
                    menor=Integer.parseInt(comisiones[0][opcion]);
                    num=Integer.parseInt(comisiones[i][opcion]);
                    if(num<menor){
                        menor=num;
                    }
                }else{
                    System.out.println("OPCION INCORRECTA");
                }                                
            }            
            
            System.out.println("LA VENTA MINIMA DEL MES DE "+mes+" es de Q."+menor+".00");
        }catch(Exception e){
            System.out.println(""+e.getMessage());
        }
        
        VolverMenu();
    }
    
    public static void BuscarCantidad(){
        System.out.println("INGRESE CANTIDAD A BUSCAR: ");
        int cantidad=entrada.nextInt();  
        int buscador;
        String Persona="";
        String mes="";
        
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 4; j++) {
                buscador=Integer.parseInt(comisiones[i][j]);
                if(cantidad==buscador){
                    Persona=comisiones[i][0];
                    if(j==1){
                        mes="ENERO";
                    }else if(j==2){
                        mes="FEBRERO";
                    }else{
                        mes="MARZO";
                    }                    
                }                                                
            }                        
        }                
        
        System.out.println(""+Persona+" vendió Q."+cantidad+".00 "+"en el mes de "+mes);
        
        VolverMenu();
    }
    
    public static void EditarCantidad(){
        System.out.println("\t\t\tIngrese la cantidad a modificar");
        int cantidad =entrada.nextInt();
        System.out.println("\t\t\tIngrese la nueva cantidad");
        int newcantidad =entrada.nextInt();
        System.out.println("\t\t\t¿De que mes desea modificar el dato?");
        System.out.println("\n\n\t\t1. ENERO");
        System.out.println("\n\n\t\t2. FEBRERO");
        System.out.println("\n\n\t\t3. MARZO");
        int mesopc=entrada.nextInt();
        int buscador=0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 4; j++) {  
                buscador=Integer.parseInt(comisiones[i][j]);                
                switch(mesopc){
                case 1:       
                    if(cantidad==buscador){
                        comisiones[i][j]=String.valueOf(newcantidad);
                    }
                    break;
                case 2:
                    if(cantidad==buscador){
                        comisiones[i][j]=String.valueOf(newcantidad);
                    }
                    break;
                case 3:
                    if(cantidad==buscador){
                        comisiones[i][j]=String.valueOf(newcantidad);
                    }
                    break;
                }
            }
        }
             
        System.out.println("\n\n\n");
        MostrarDatos();        
        
    }    
   
   public static void VolverMenu(){
        System.out.println("\n\nPARA VOLVER AL MENÚ INGRESE LA PALABRA 'MN' : ");    
        String palabra=entrada.nextLine();
        
        if(palabra.contains("MN")){            
            LimpiarPantalla();
            Menu();            
        }
    }

   public static void Menu(){
        System.out.print("\n\t\t\t\tSeleccione una Opcion");
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
                break;
            case 2:
                VentaMesMAX();
                break;
            case 3:
                VentaMesMIN();
                break;
            case 4:
                ventaMax();
                break;
            case 5:
                MostrarDatos();
                break;
            case 6:
                BuscarCantidad();
                break;
            case 7:
                EditarCantidad();
                break;                                            
        }
        }catch (Exception e){
            System.out.println(""+e);
        }
               

    }
    public static void main(String[] args) {
        Menu();
    }
    
}
