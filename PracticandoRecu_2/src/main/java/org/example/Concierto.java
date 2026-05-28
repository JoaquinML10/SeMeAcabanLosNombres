package org.example;

import java.time.LocalDate;

public class Concierto extends Evento{
    private String artista;
    public Concierto(String nombre, LocalDate fecha, double precio) {
        super(nombre, fecha, precio);
        this.artista = artista;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtistas(String artistas) {
        this.artista = artistas;
    }
}
