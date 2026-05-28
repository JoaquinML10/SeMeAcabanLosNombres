package org.example.UsoDeListas;

import java.util.HashMap;
import java.util.Map;

public class MapaPractica {
    static void main(String[] args) {
        Map<String, String> mapa = new HashMap<>();

        // MÉTODO PARA AÑADIR / ACTUALIZAR: .put()
        mapa.put("1234ABC", "Ticket Activo");
        mapa.put("5678XYZ", "Ticket Pagado");

        // MÉTODO PARA ELIMINAR: .remove()
        mapa.remove("1234ABC"); // Borra la pareja entera pasándole la clave primaria
    }
}
