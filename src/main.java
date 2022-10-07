
import clases.Personas;

import java.util.Scanner;

public class main {
    static Scanner in = new Scanner(System.in);
    private static Personas personas = new Personas();
    private static String nombre, dni;
    private static Integer edad;
    public static void main(String[] args){
        int opcion = 3;
        mostrarInfo();
        while (opcion != 0) {
            opcion = leerOpcion(3);
            switch(opcion) {
                case 0:
                    System.out.println("Hasta la proxima");
                    System.exit(0);
                case 1:
//                    TODO: Arreglar esta zona ----------------
                    System.out.println("Introduce el dni a buscar");
                    String dniBusqueda = in.nextLine();
                    personas.buscarPersona(dniBusqueda);
                    System.out.println("***************** Dejando de leer *****************");
                    opcion = 3;
                case 2:
                    System.out.println("Nombre: ");
                    nombre = in.nextLine();
                    System.out.println("Dni: ");
                    dni = in.nextLine();
                    System.out.println("Edad: ");
                    edad = in.nextInt();
                    Personas personas = new Personas(nombre,dni,edad);
                    personas.insertarDatos();
                    System.out.println("***************** Datos insertados *****************");
                    opcion = 3;
                case 3:
                    mostrarInfo();
                    break;
            }
        }
    }

    private static int leerOpcion(int max) {
        boolean terminar = false;
        int n = 0;
        while (!terminar) {
            try {
                n = in.nextInt();
                in.nextLine();
                if (n>=max || n<0) {
                    throw new Exception();
                }
                terminar = true;
            } catch (Exception e) {
                System.out.println("Opción incorrecta! elije de nuevo");
            }
        }
        return n;
    }

    private static void mostrarInfo() {
        System.out.println("Elige una de estas opciones");
        System.out.println("1 - Buscar persona");
        System.out.println("2 - Insertar datos");
        System.out.println("0 - Salir");
    }


}