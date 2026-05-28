package org.example.TercerExa;

import java.util.Random;

public class Ninio extends Banista{
    static Random aleatorio = new Random();
    private String telefono;

    public Ninio(Integer numero, String nombre, int edad, TipoUusario tipo, String telefono) {
        super(numero, nombre, edad, tipo);
        this.telefono = telefono;
    }


    @Override
    void pagar() {
        System.out.println(TipoUusario.NINIO + "(abono de tipo adulto) pagando " + TipoUusario.NINIO.getEdad());
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
