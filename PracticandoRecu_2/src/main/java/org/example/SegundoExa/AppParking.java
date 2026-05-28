package org.example.SegundoExa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AppParking {
    static Parking parking = new Parking("Mutxamel Centro",1000,0.025);
    static Scanner teclado = new Scanner(System.in);

    static void main(String[] args) {
        parking.generarClientesAleatorios();
        parking.mostrarClientesActuales();
        app1();
        parking.mostrarClientesActuales();
        app2();
        parking.mostrarClientesActuales();
        app3();
    }
    static public void app1(){
        System.out.println("App Acceso");
        int plazas = parking.getPlazas_totales();
        int ocupadas = parking.getClientesActuales().size();

        if (ocupadas < plazas){
            System.out.println("LIBRE ( "+ (plazas - ocupadas) +" plazas libres).");
        }else {
            System.out.println("COMPLETO");
        }
        Ticket ticket = new Ticket("",1,Estado.PENDIENTE);
        ticket.generar();
        parking.anyadirClientes(ticket);
        ticket.recoger();
        System.out.println("BIENVENIDO");

    }
    static public void app2(){
        System.out.println("PAGO TICKETS");
        System.out.println("Introduce tu matricula");
        String matricula = teclado.next();
        System.out.println("Validando...");
        Ticket ticket = parking.validarTicket(matricula);
        if (ticket == null){
            System.out.println("El ticket no es valido");
        }else {
            System.out.println("Minutos: " + ticket.getMinutos() + " - Precio por minuto: 0.025€");
            System.out.println("Importe a pagar: " + (ticket.getMinutos() * 0.025));
        }
        ticket.pagar();
        System.out.println("Buen Viaje");
    }
    static public void app3(){
        List<Ticket> listaOrdenada = new ArrayList<>(parking.getClientesActuales());
        listaOrdenada.sort(Comparator.comparing(Ticket::getMinutos));
        int contador = 0;
        System.out.println("*** APP PARA TRABAJADORES ***");
        for (Ticket ticket : listaOrdenada){
            System.out.println(++contador + ". Matricula: " + ticket.getMatricula() + " - Minutos: " + ticket.getMinutos() + " - estado: " + ticket.getEstado());
        }
        Acciones acciones = new Acciones() {
            @Override
            public void generar() {

            }

            @Override
            public void recoger() {

            }

            @Override
            public void pagar() {
                System.out.print("Introduce los minutos de estancia reales: ");
                int minutosReales = teclado.nextInt();
                System.out.println("Minutos: " + minutosReales + " - Precio por minuto: 0.025€");
                System.out.println("Importe a pagar: " + (minutosReales * 0.025));
                System.out.println("Pagando...");
                System.out.println("Pago realizado el cliente puede abandonar el parking");
            }
        };
        acciones.pagar();

    }
}
