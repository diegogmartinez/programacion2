
package com.mycompany.ejercicio1;


public class ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
        int[] arreglo = { 1,2,3,4,5};
    
        int puntos = 0;
        
        System.out.println("matris dada:");

            for(int i=0; i<arreglo.length; i++)
            {
                System.out.println("\n"+arreglo[i]);
                        
                if ((arreglo[i] % 2) != 0)
                {
                    if (arreglo[i] == 5)
                    {
                        puntos += 5;
                    }
                    else
                    {
                        puntos += 3;
                    }
                }
                else
                {
                    puntos++;
                }

            }

            System.out.println("\npunteo total: "+puntos);
    
    }
    
}
