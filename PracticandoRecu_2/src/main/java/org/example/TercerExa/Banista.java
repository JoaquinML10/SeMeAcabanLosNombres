package org.example.TercerExa;

public abstract class Banista {
    public Integer numero;
    public String nombre;
    private int edad;
    public TipoUusario tipo;

    public Banista(Integer numero, String nombre, int edad, TipoUusario tipo) {
        this.numero = numero;
        if (edad < 0){
            System.out.println("NO SE PUEDE INSERTAR BAÑISTAS QUE NO HAYAN NACIDO");
            return;
        }else {
            this.nombre = nombre;
        }
        this.edad = edad;
        this.tipo = tipo;
    }

    abstract void pagar();

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public TipoUusario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUusario tipo) {
        this.tipo = tipo;
    }
}
