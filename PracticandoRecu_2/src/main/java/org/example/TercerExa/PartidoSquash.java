package org.example.TercerExa;

import java.util.Scanner;

public class PartidoSquash {
    static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce los tantos para cada jugador");
        Boolean valido = true;
        String puntos = teclado.next().toUpperCase();
        int jugadora = 0;
        int jugadorb = 0;
        String textofinal = "";
        char letrapunto;
        if (puntos.charAt(puntos.length() -1) != 'F'){

            valido = false;
        }else {
            for (int i = 0; i < puntos.length() - 1; i++) {
                letrapunto = puntos.charAt(i);
                if (letrapunto == 'A') {
                    jugadora++;
                } else if (letrapunto == 'B') {
                    jugadorb++;
                } else if (letrapunto == 'S') {
                    textofinal += jugadora + " - " + jugadorb + " ";
                    jugadora = 0;
                    jugadorb = 0;
                }else {
                    valido = false;
                    break;
                }

            }
        }
        if (valido){
            textofinal += jugadora + " - " + jugadorb + " ";
            System.out.println(textofinal);
        }else {
            System.out.println("FORMATO INCORRECTO");
        }

    }
}
