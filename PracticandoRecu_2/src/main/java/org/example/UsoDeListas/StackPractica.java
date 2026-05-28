package org.example.UsoDeListas;

import java.util.Stack;

public class StackPractica {
    static void main(String[] args) {
        Stack<String> pila = new Stack<>();

        // MÉTODO PARA AÑADIR (Apilar arriba): .push()
        pila.push("Plato Sucio 1");
        pila.push("Plato Sucio 2"); // Este queda arriba del todo

        // MÉTODO PARA ELIMINAR / EXTRAER (Desapilar el de arriba): .pop()
        String quitado = pila.pop(); // Saca y elimina "Plato Sucio 2"

        // Extra (Echar un vistazo sin borrar): .peek()
        String arriba = pila.peek(); // Te dice cuál está arriba ("Plato Sucio 1") sin borrarlo
    }
}
