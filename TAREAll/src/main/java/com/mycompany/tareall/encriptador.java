
package com.mycompany.tareall;

import java.util.Scanner;


public class encriptador {
    
    private static Scanner entrada=new Scanner(System.in);
  
    public static String Codificador(String palabra,int llave){

        int codificar;       
        String resultado="";
        
        
        for(int i=0; i<palabra.length(); i++){
            codificar=(int)palabra.charAt(i);
            codificar=codificar+llave;
            char caracter=(char)codificar;
            resultado=resultado+caracter;
        }
        
        return resultado;
        
        
    }

  
    public static void main(String[] args) {
        System.out.println("Ingresa una palabra: ");    
        String pal=entrada.nextLine();
        int llave = 9;
                
        
        String res= Codificador(pal,llave);
        System.out.println("Palabra codificada= "+res);
        System.out.println("llave:" + llave);
        
    }
    
}
