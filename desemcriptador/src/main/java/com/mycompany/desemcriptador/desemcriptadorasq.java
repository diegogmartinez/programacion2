
package com.mycompany.desemcriptador;

import java.util.Scanner;


public class desemcriptadorasq {
    
    private static Scanner entrada=new Scanner(System.in);
  
    public static String decodificador(String palabra,int llave){

        int codificar;       
        String resultado="";
        
        
        for(int i=0; i<palabra.length(); i++){
            codificar=(int)palabra.charAt(i);
            codificar=codificar-llave;
            char caracter=(char)codificar;
            resultado=resultado+caracter;
        }
        
        return resultado;
    }
    
    public static void main(String[] args) {
        
       System.out.println("palabra a desemcriptar: ");    
        String pal=entrada.nextLine();
        
        System.out.println("ingrese llave");
        int llave=entrada.nextInt();
        
        String res= decodificador(pal,llave);
        System.out.println("Palabra a codificada= "+res);
    }
        
    
}
