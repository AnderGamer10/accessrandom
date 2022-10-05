package clases;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.file.Path;

public class Personas {
    private String dni, nombre;
    private int edad;

    String ruta = "src/info/datos.txt";

    public Personas(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }
    public Personas() {

    }

    public void insertarDatos(){
        try{
            RandomAccessFile accederFichero  = new RandomAccessFile(new File(ruta), "rws");

            accederFichero.write(getNombre().getBytes(),0,22);
            accederFichero.write(getEdad().getBytes(),22,24);
            accederFichero.write(getDni().getBytes(),24,32);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    public void leerDatos(){

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
