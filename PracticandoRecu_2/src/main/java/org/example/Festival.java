package org.example;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Festival extends Evento {

    private Set<String> listaArtistas;

    public Festival(String nombre, LocalDate fecha, double precio) {
        super(nombre, fecha, precio);
        this.listaArtistas = new HashSet<>();
    }

    public void setListaArtistas(){

    }
}
