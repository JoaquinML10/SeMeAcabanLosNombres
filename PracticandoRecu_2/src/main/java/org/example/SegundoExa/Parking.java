package org.example.SegundoExa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Parking {
    static Random aleaotorio = new Random();
    private String ciudad;
    private int plazas_totales;
    private double precio_minuto;
    private List<Ticket> clientesActuales;

    public Parking(String ciudad, int plazas_totales, double precio_minuto) {
        this.ciudad = ciudad;
        this.plazas_totales = plazas_totales;
        this.precio_minuto = precio_minuto;
        this.clientesActuales = new ArrayList<>();
    }

    public void generarClientesAleatorios(){
        String letras = "BCDFGHJKLMNPQRSTVWXYZ";
        String numeros = "0123456789";


        while (clientesActuales.size() < 3){
            boolean valido = true;
            String num = "";
            String tree = "";
            String matricula = "";
            while (num.length() < 4) {
                num += numeros.charAt(aleaotorio.nextInt(0, numeros.length()));
            }
            while (tree.length() < 3) {
                tree += letras.charAt(aleaotorio.nextInt(0, letras.length()));
            }
            matricula = num + tree;

            for (Ticket t:clientesActuales){
                if (!t.getMatricula().equals(matricula)){
                    valido = true;
                    break;
                }else {
                    valido = false;
                }
            }
            if (valido){
                int minutos = aleaotorio.nextInt(0,150);
                Ticket ticket = new Ticket(matricula,minutos, Estado.RECOGIDO);
                clientesActuales.add(ticket);
            }
        }
    }
    public void mostrarClientesActuales(){
        System.out.println("*** PARKING MUTXAMEL ***");
        int contador = 0;
        for (Ticket ticket : clientesActuales){
            System.out.println(++contador + ". Matricula: " + ticket.getMatricula() + " - Minutos: " + ticket.getMinutos() + " - estado: " + ticket.getEstado());
        }
    }
    public void anyadirClientes(Ticket ticket){
        clientesActuales.add(ticket);
    }
    public Ticket validarTicket(String matricula){

        for (Ticket ticket : clientesActuales){
            if (ticket.getMatricula().equals(matricula)){
                return ticket;
            }
        }
        return null;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getPlazas_totales() {
        return plazas_totales;
    }

    public void setPlazas_totales(int plazas_totales) {
        this.plazas_totales = plazas_totales;
    }

    public double getPrecio_minuto() {
        return precio_minuto;
    }

    public void setPrecio_minuto(double precio_minuto) {
        this.precio_minuto = precio_minuto;
    }

    public List<Ticket> getClientesActuales() {
        return clientesActuales;
    }

    public void setClientesActuales(List<Ticket> clientesActuales) {
        this.clientesActuales = clientesActuales;
    }
}
