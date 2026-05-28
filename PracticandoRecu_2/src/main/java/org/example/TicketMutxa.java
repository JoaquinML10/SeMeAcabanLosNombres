package org.example;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class TicketMutxa {
    static Evento eventoElejido;
    static Scanner teclado = new Scanner(System.in);
    static private Set<Usuario> usuariosRegisatrados = new HashSet<>();
    static private Set<Evento> listaEventos = new HashSet<>();

    public TicketMutxa() {
    }

    static void insertarEvento(String nombre, LocalDate fecha, double precio, String tipo){
        if (tipo.toLowerCase().equals("festival")){
            Festival festival = new Festival(nombre, fecha, precio);
            listaEventos.add(festival);
        } else if (tipo.toLowerCase().equals("concierto")) {
            Concierto concierto = new Concierto(nombre, fecha,precio);
            listaEventos.add(concierto);
        }else {
            System.out.println("El tipo de evento es incorrecto");
        }

    }
    static void generarUsarios(int cantidad){
        Random aleatorio = new Random();
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String contrasenia = "";
        String nombre = "";
        for (int i = 0; i < cantidad; i++) {
            contrasenia = "";
            nombre = "";
            while (nombre.length() < 8){
                char letra = caracteres.charAt(aleatorio.nextInt(0,caracteres.length()));
                if (!nombre.contains(String.valueOf(letra))){
                    nombre+=letra;
                }
            }
            while (contrasenia.length()<8){
                char letra = caracteres.charAt(aleatorio.nextInt(0,caracteres.length()));
                if (!contrasenia.contains(String.valueOf(letra))){
                    contrasenia+=letra;
                }
            }

            Usuario usuario = new Usuario(nombre,contrasenia);
            usuariosRegisatrados.add(usuario);

        }
        for (Usuario usuario : usuariosRegisatrados){
            System.out.println("Chivato de usuarios generados: " + usuario.getNombre_usuario() + " | " + usuario.getContrasenia());
        }
    }

    public static Set<Usuario> getUsuariosRegisatrados() {
        return usuariosRegisatrados;
    }

    static void verEvento(){
        System.out.println("--------------------------------");
        System.out.println("Holaa " + Usuario.comprador.getNombre_usuario() + ". Elige un Evento para iniciar la compra");
        int contador = 0;
        for (Evento evento : listaEventos){
            System.out.println("[" + ++contador + "]."+ evento.getNombre() + evento.getFecha());
        }
        System.out.println("--------------------------------");

        boolean valido = true;
        do {
            System.out.println("Elije un evento: ");
            int numero = teclado.nextInt();
            if (numero > listaEventos.size() || numero <= 0){
                System.out.println("ERROR. Elige una opcion correcta");
                valido = false;
            }else {
                getEvento(numero);
                valido = true;
            }

        }while (!valido);
    }
    static Evento getEvento(int posicion){
        int contador = 0;
        for (Evento evento : listaEventos){
            contador++;
            if (contador == posicion) {
                System.out.println("Estas comprando entradas para el evento: " + evento.getNombre());
                eventoElejido = evento;
            }
        }
        return eventoElejido;
    }

    public static void setUsuariosRegisatrados(Set<Usuario> usuariosRegisatrados) {
        TicketMutxa.usuariosRegisatrados = usuariosRegisatrados;
    }

    public static Set<Evento> getListaEventos() {
        return listaEventos;
    }

    public static void setListaEventos(Set<Evento> listaEventos) {
        TicketMutxa.listaEventos = listaEventos;
    }
}
