package org.example.UsoDeListas;

import java.util.HashSet;
import java.util.Set;

public class SetPractica {
    static void main(String[] args) {
        Set<String> conjunto = new HashSet<>();

        // MÉTODO PARA AÑADIR: .add()
        conjunto.add("Matrícula 1");
        boolean repetido = conjunto.add("Matrícula 1"); // Devuelve FALSE y no lo añade

        // MÉTODO PARA ELIMINAR: .remove()
        conjunto.remove("Matrícula 1"); // Tienes que pasarle el objeto exacto
    }
}
