package org.example;

public class Alumno {
    private int nia;
    private String nombre;

    public Alumno(int nia, String nombre) {
        this.nia = nia;
        this.nombre = nombre;
    }

    public static void obtenerDescripcion(Alumno alumno) {
        System.out.println("Alumno: " + alumno.getNombre() + ", NIA: " +
                alumno.getNia());
    }

    public int getNia() {
        return nia;
    }

    public void setNia(int nia) {
        this.nia = nia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nia=" + nia +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
