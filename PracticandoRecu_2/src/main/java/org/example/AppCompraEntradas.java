package org.example;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class AppCompraEntradas {
    static Scanner teclado = new Scanner(System.in);
    static Queue<Usuario> colairtual = new LinkedList<>();
    static void main(String[] args) {
        TicketMutxa.insertarEvento("Paellas", LocalDate.of(2025, 4, 16), 20, "festival");

        TicketMutxa.insertarEvento("Concierto Estopa", LocalDate.of(2025, 4, 21), 40, "concierto");
        // crear usuarios
        TicketMutxa.generarUsarios(4);

        Set<Usuario> listaUsuariosRegistrados = TicketMutxa.getUsuariosRegisatrados();
        Usuario usuario = new Usuario();
        usuario.autenticarse(listaUsuariosRegistrados);

        TicketMutxa.verEvento();
        System.out.println("Espera tu turno");
        for (Usuario usuario1 : listaUsuariosRegistrados) {
            if (!Usuario.comprador.equals(usuario1)) {
                colairtual.offer(usuario1);
            }
        }
        colairtual.offer(Usuario.comprador);
        while (!colairtual.isEmpty()) {
            System.out.println("Estas en la posicion " + colairtual.size() + " de la cola virtual");
            colairtual.poll();
        }
        System.out.println("¡Es tu turno!");
        System.out.println("Cuantas entradas quieres? (maximo 7): ");
        int entradas = 0;
        do {
            entradas = teclado.nextInt();
            usuario.anyadirAlCarrito(TicketMutxa.eventoElejido, entradas);
        } while (entradas > 7 || entradas < 1);
        Usuario.comprador.verCarrito(entradas);
        verMenu();
    }
    static public void verMenu(){
        while (true){
            System.out.println("[1]. Añadir entradas");
            System.out.println("[2]. Eliminar entradas");
            System.out.println("[3]. Pagar y finalizar entradas");
            int op = teclado.nextInt();
            switch (op){
                case 1:
                    System.out.println("Cuantas quieres añadir");
                    int aniadirEntradas = teclado.nextInt();
                    Usuario.comprador.setCarritoCompra(TicketMutxa.eventoElejido,aniadirEntradas);
                    break;
                case 2:
                    System.out.println("Cuantas quieres eliminar");
                    int eliminarEntradas = teclado.nextInt();
                    Usuario.comprador.setCarritoCompra(TicketMutxa.eventoElejido,-eliminarEntradas);
                    break;
                case 3:
                    System.out.println("Elige un metodo de pago");
                    System.out.println("PAYPAL (gastos de gestion asociados: 0.5€).");
                    System.out.println("BIZUM (gastos de gestion asociados: 1€).");
                    System.out.println("APPLEPAY (gastos de gestion asociados: 1.5€).");
                    Usuario.comprador.pagar();
                    return;
                default:
                    break;
            }
        }

    }
}
