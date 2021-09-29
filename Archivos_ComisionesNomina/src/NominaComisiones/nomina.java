
package NominaComisiones;

import dominio.mdVendedor;
import java.util.Scanner;
import negocio.negocioImpl;
import negocio.InterfazNegocio;

public class nomina {

    private static final Scanner scanner = new Scanner(System.in);
    private static int opcion = -1;
    private static final String nombreArchivo = "C:\\Users\\mjber\\Desktop\\Nueva carpeta\\archivos.txt";
    private static final InterfazNegocio negocioInt = new negocioImpl();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Mientras la opcion elegida sea 0, preguntamos al usuario
        while (opcion != 0) {
            try {
                System.out.println("Elige opcion:\n1.- INICIAR NOMINA"
                        + "\n2.- INGRESAR DATOS\n"
                        + "3.- VENTA MAXIMA POR MES\n"
                        + "4.- VENTA MINIMA POR MES\n"
                        + "5.- VENTA MAXIMA TOTAL\n"
                        + "6.- MOSTRAR DATOS Y ACTUALIZAR\n"
                        + "7.- BUSCAR POR CANTIDAD\n"
                        + "8.- EDITAR\n"
                        + "0.- SALIR");

                opcion = Integer.parseInt(scanner.nextLine());

                //Ejemplo de switch case en Java
                switch (opcion) {
                    case 1:
                        //1. Creamos el objeto que administra el catalogo de personas
                        //La creacion del archivo es opcional, de todas maneras se creara 
                        //al escribir por primera vez en el archivo
                        negocioInt.iniciarArchivo(nombreArchivo);
                        break;
                    case 2:
                        //2. agregar informacion archivo
                        System.out.println("¿Cuantos datos desea ingresar?");
                        int opcion=scanner.nextInt();

                        for (int i = 0; i < opcion; i++) {            
                            System.out.println("Ingrese nombre "+i+":");                            
                            String nombre=scanner.nextLine();
                            nombre=scanner.nextLine();                            
                            System.out.println("Ingrese Enero: ");
                            double enero=scanner.nextDouble();
                            System.out.println("Ingrese Febrero: ");
                            double febrero=scanner.nextDouble();
                            System.out.println("Ingrese Marzo: ");
                            double marzo=scanner.nextDouble();
                            double total=enero+febrero+marzo;
                            double promedio=total/3; 
                            negocioInt.agregar(nombre, enero, febrero, marzo, total, promedio, nombreArchivo);
                            

                        }   
                        break;
                    case 3:
                        System.out.println("\n\t\t\t¿Que mes desea consultar?");
                        System.out.println("\n\n\t1. ENERO");
                        System.out.println("\n\n\t2. FEBRERO");
                        System.out.println("\n\n\t3. MARZO");
                        int opn=scanner.nextInt();
                        opn=scanner.nextInt();
                        negocioInt.numMaxMes(opn, nombreArchivo);
                        break;
                    case 4:
                        System.out.println("\n\t\t\t¿Que mes desea consultar?");
                        System.out.println("\n\n\t1. ENERO");
                        System.out.println("\n\n\t2. FEBRERO");
                        System.out.println("\n\n\t3. MARZO");
                        int opc=scanner.nextInt();
                        opc=scanner.nextInt();  
                        negocioInt.numMinMes(opc, nombreArchivo);
                        break;       
                    case 5:
                        negocioInt.numMaxTotal(nombreArchivo);
                        break;
                    case 6:
                        //3. listar catalogo completo
                        negocioInt.listar(nombreArchivo);
                        break;
                    case 7:
                        //4. Buscar pelicula
                        System.out.println("INGRESE CANTIDAD A BUSCAR: Q.");
                        String buscar=scanner.nextLine();
                        negocioInt.buscar(nombreArchivo, buscar);
                        break;
                    case 8:
                        System.out.println("Ingrese el numero de la opcion a editar");
                        System.out.println("\n\t1. NOMBRE");
                        System.out.println("\n\t2. CANTIDAD");
                        int can=scanner.nextInt();

                        switch(can){
                            case 1:
                                System.out.println("Ingrese el nombre de la persona que desea editar: ");
                                String nom=scanner.nextLine();
                                String nombre=scanner.nextLine();
                                System.out.println("Ingrese el nuevo Nombre: ");
                                String nuevo=scanner.nextLine();
                                negocioInt.editarNom(nombre,nuevo, nombreArchivo);
                                
                                break;
                            case 2:
                                System.out.println("\t\t\tIngrese la cantidad a modificar");
                                double cantidad =scanner.nextInt();
                                System.out.println("\t\t\tIngrese la nueva cantidad");
                                double newcantidad =scanner.nextInt();
                                System.out.println("\t\t\t¿De que mes desea modificar el dato?");
                                System.out.println("\n\n\t\t1. ENERO");
                                System.out.println("\n\n\t\t2. FEBRERO");
                                System.out.println("\n\n\t\t3. MARZO");
                                int mesopc=scanner.nextInt();
                                negocioInt.editCantidad(cantidad, newcantidad, mesopc, nombreArchivo);
                                break;
                        }
                        break;
                    case 0:
                        System.out.println("!Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opcion no reconocida");
                        break;
                }
                System.out.println("\n");

            } catch (Exception e) {
                System.out.println("Error!");
            }
        }

    }
}
