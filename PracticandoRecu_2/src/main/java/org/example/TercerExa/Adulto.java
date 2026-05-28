package org.example.TercerExa;

public class Adulto extends Banista{

    public Adulto(Integer numero, String nombre, int edad, TipoUusario tipo) {
        super(numero, nombre, edad, tipo);
    }

    @Override
    void pagar() {
        System.out.println(TipoUusario.ADULTO + "(abono de tipo adulto) pagando " + TipoUusario.ADULTO.getEdad());
    }
}
