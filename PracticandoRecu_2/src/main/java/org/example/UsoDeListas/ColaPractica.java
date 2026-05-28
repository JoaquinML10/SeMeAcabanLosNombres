package org.example.UsoDeListas;

import java.util.LinkedList;
import java.util.Queue;

public class ColaPractica {
    static void main(String[] args) {
        Queue<String> cola = new LinkedList<>();

        // MÉTODOS PARA AÑADIR (Al final de la cola):
        cola.add("Cliente 1");   // Lanza excepción si la cola está llena
        cola.offer("Cliente 2"); // RECOMENDADO: Devuelve false si está llena

        // MÉTODOS PARA ELIMINAR / EXTRAER (El primero de la cola):
        String primero1 = cola.remove(); // Saca al Cliente 1 (da error si está vacía)
        String primero2 = cola.poll();   // RECOMENDADO: Saca al Cliente 2 (devuelve null si está vacía)
    }
}
