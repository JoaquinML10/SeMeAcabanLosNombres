package org.example.TercerExa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContenidoVisto {
    static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Map<String, Integer> listaSerie = new HashMap<>();
        String salida = "";
        int minutos = 0;
        do {
            System.out.println("Introduce el nombre de tu serie... (o 'salir' para terminar)");
            salida = teclado.nextLine();
            if (salida.toUpperCase().equals("SALIDA")){
                break;
            }else {
                System.out.println("Minutos: ");
                minutos = teclado.nextInt();
            }
            listaSerie.put(salida,minutos);
            teclado.nextLine();
        }while (true);
        System.out.println("Las series que has visto mas de 30 minutos son");
        for (Map.Entry<String,Integer> mapita : listaSerie.entrySet()){
            if (mapita.getValue() > 30){
                System.out.println(mapita.getKey() + " con " + mapita.getValue() + " minutos");
            }
        }
    }
}
