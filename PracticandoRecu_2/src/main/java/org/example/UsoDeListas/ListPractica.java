package org.example.UsoDeListas;

import java.util.ArrayList;
import java.util.List;

public class ListPractica {
    static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("Coche A");
        lista.add("Coche B");
        lista.add("Coche A"); // Permite duplicados sin quejarse

        // MÉTODOS PARA ELIMINAR: .remove()
        lista.remove(1);          // Elimina por posición (borra "Coche B")
        lista.remove("Coche A");  // Elimina la primera coincidencia que encuentre


    }
}
