package org.example.TercerExa;

public enum TipoUusario {
    ADULTO(30),NINIO(15),INVITADO(3.5);

    private double edad;

    TipoUusario(double edad) {
        this.edad = edad;
    }

    public double getEdad() {
        return edad;
    }

    public void setEdad(double edad) {
        this.edad = edad;
    }
}
