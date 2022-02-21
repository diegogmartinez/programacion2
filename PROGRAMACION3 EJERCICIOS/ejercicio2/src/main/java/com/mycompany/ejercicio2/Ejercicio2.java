
package com.mycompany.ejercicio2;

import java.util.Scanner;


public class Ejercicio2 {

    
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        
        System.out.println("ingrese un numero: ");
        int num=entrada.nextInt();
        
        int [] secuencia = { 0, 0, 1 };
       
        int suma = 0;
            System.out.println(secuencia[0] +"\n"+ secuencia[1]+"\n"+ secuencia[2]);

            for (int i=3; i<num; i++)
            {
                suma = secuencia[0] + secuencia[1] + secuencia[2];
                System.out.println(suma);
                secuencia[0] = secuencia[1];
                secuencia[1] = secuencia[2];
                secuencia[2] = suma;
            }
    }
    
}
