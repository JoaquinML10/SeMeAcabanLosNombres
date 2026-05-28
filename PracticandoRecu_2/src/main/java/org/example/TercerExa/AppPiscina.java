package org.example.TercerExa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class AppPiscina {
    static Scanner teclado = new Scanner(System.in);
    private static Collection<Banista> listaBanista = new ArrayList<>();
    private static Integer numero = listaBanista.size();

    static void main(String[] args) {
        listaBanista.add(new Adulto(1,"patricia",20,TipoUusario.ADULTO));
        listaBanista.add(new Adulto(2,"pablo",30,TipoUusario.ADULTO));
        listaBanista.add(new Ninio(3,"pepe",12,TipoUusario.NINIO,"34565432"));
        listaBanista.add(new Ninio(4,"carla",8,TipoUusario.NINIO,"8569512"));
        listaBanista.add(new Invitado(5,"Fran",40,TipoUusario.INVITADO));
        listaBanista.add(new Invitado(6,"Marta",12,TipoUusario.INVITADO));
        altaUsuario();
        mostrarInvitados();
        eliminarInvitados();

    }

    static public void cobrar(Banista banista){
        banista.pagar();
    }
    static public void altaUsuario(){
        System.out.println("Alta Uusario...");
        System.out.println("    1. Adulto");
        System.out.println("    2. Niño <=16 años");
        System.out.println("    3. Invitados (pase diario)");
        System.out.println("------------------------------");
        System.out.println("Elige un tipo");
        int op = teclado.nextInt();
        System.out.println("Introduce el nombre del nuevo bañista");
        String nombre = teclado.next();
        System.out.println("Introduce la edad:");
        int edad = teclado.nextInt();
        Banista banista;
        switch (op){
            case 1:
                numero++;
                banista= new Adulto(numero,nombre,edad,TipoUusario.ADULTO);

                break;
            case 2:
                System.out.println("Introduce el numero del niño");
                String telefono = teclado.next();
                    if (edad > 16){
                        throw new LimiteDeEdad("ERROR AL CREAR Al niño, Edad " + edad + " no permitida");
                    }

                numero++;
                banista = new Ninio(numero,nombre,edad,TipoUusario.NINIO, telefono);

                break;
            case 3:

                numero++;
                banista = new Invitado(numero,nombre,edad,TipoUusario.INVITADO);

                break;
            default:
                System.out.println("Opcion no valida");
                return;
        }
        listaBanista.add(banista);
        cobrar(banista);
    }
    static public void mostrarInvitados(){
        for (Banista b : listaBanista) {
            if (b instanceof Invitado) {
                System.out.println("Numero: " + b.getNumero() + " Nombre: " + b.getNombre() + " edad: " + b.getEdad());
            }
        }
    }
    static public void eliminarInvitados(){

        Iterator<Banista> it = listaBanista.iterator();
        while (it.hasNext()){
            if (it.next().tipo.equals(TipoUusario.INVITADO)){
                it.remove();
            }

        }
        for (Banista b : listaBanista) {
            System.out.println("Numero: " + b.getNumero() + " Nombre: " + b.getNombre() + " edad: " + b.getEdad());
        }

    }

}
