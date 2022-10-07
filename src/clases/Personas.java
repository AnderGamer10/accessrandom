package clases;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.file.Path;

public class Personas {
    private String dni, nombre;
    private int edad;
    private Path path = Path.of("src/info/datos.txt");

    public Personas(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }
    public Personas() {

    }

    public void insertarDatos(){
        try{
            RandomAccessFile accederFichero  = new RandomAccessFile(new File(path.toUri()), "rws");
//            Nombre: 22 bytes      Edad: 2 bytes       Dni: 8 bytes
            accederFichero.seek(accederFichero.length());
            accederFichero.write(String.format("%1$-" + 22 + "s", (getNombre())).getBytes(),0,22);
            accederFichero.write(" ".getBytes());
            accederFichero.write(String.format("%1$-" + 3 + "s", (getEdad())).getBytes(),0,3);
            accederFichero.write(" ".getBytes());
            accederFichero.write(String.format("%1$-" + 9 + "s", (getDni())).getBytes(),0,9);
            accederFichero.write(String.format("\n").getBytes(), 0,1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void buscarPersona(String dniBusqueda){

    }

    public void imprimirDatosInsertados(){
        System.out.println("Nombre: " + nombre + " Dni: " + dni + " Edad: " + edad);
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
