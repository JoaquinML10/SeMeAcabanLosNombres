package org.example.TercerExa;

import java.time.LocalDate;

public class Invitado extends Banista {
    private LocalDate fechaVisita;

    public Invitado(Integer numero, String nombre, int edad, TipoUusario tipo) {
        super(numero, nombre, edad, tipo);
        this.fechaVisita = LocalDate.now();
    }

    public LocalDate getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(LocalDate fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    @Override
    void pagar() {
        System.out.println(TipoUusario.INVITADO + "(abono de tipo adulto) pagando " + TipoUusario.INVITADO.getEdad());
    }
}
