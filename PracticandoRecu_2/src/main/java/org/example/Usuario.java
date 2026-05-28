package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Usuario implements Acciones {
    static Scanner teclado = new Scanner(System.in);
    static Usuario comprador = null;
    private String nombre_usuario;
    private String contrasenia;
    private Map<Evento, Integer> carritoCompra;

    public Usuario(String nombre_usuario, String contrasenia) {
        this.nombre_usuario = nombre_usuario;
        this.contrasenia = contrasenia;
        this.carritoCompra = new HashMap<>();
    }

    public Usuario() {
        this.nombre_usuario = nombre_usuario;
        this.contrasenia = contrasenia;
        this.carritoCompra = new HashMap<>();
    }

    @Override
    public void pagar() {
        boolean valido = true;
        do {


        String op = teclado.next().toUpperCase();
        switch (op.toUpperCase()){
            case "PAYPAL":
            case "APPLEPAY":
            case "BIZUM":
                valido = true;
                System.out.println("Realizando pago con " + MetodoPago.valueOf(op).name() + "(+ " + MetodoPago.valueOf(op).getPrecio() + "€ de gastos de gestion)");
                break;
            default:
                System.out.println("Metodo de pago no valido");
                valido = false;
        }
        }while (!valido);
        System.out.println("MUCHAS GRACIAS DISFRUTA DEL EVENTO");
    }

    @Override
    public boolean autenticarse(Set<Usuario> usuariosRegistrados) {
        Scanner teclado = new Scanner(System.in);
        boolean valido = true;
        do {
            System.out.println("Inicica Sesion");
            System.out.println("Usuario: ");
            String nombre = teclado.next();
            System.out.println("Contraseña");
            String contrasenia = teclado.next();


            for (Usuario usuario1 : usuariosRegistrados){
                if (nombre.equals(usuario1.getNombre_usuario()) && contrasenia.equals(usuario1.getContrasenia())){
                    comprador = usuario1;
                    valido = true;
                    break;
                } else {
                    valido = false;
                }
            }
            if (valido){
                System.out.println("BIENVENIDO: " + comprador.getNombre_usuario());
            }else {
                System.out.println("Contraseña o nombre son incorrectas");
            }

        }while (!valido);
        return valido;
    }
    public void verCarrito(int cantidad){
        System.out.println("Carrito: " + cantidad + " entradas para Paellas. Importe total: 100");
    }

    public void anyadirAlCarrito(Evento evento, Integer cantidad){
        if (cantidad > 7 || cantidad < 1){
            System.out.println("Cantidad de entradas incorrectas");
        }else {

            carritoCompra.put(evento,cantidad);
        }
    }
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Map<Evento, Integer> getCarritoCompra() {
        return carritoCompra;
    }

    public void setCarritoCompra(Evento evento, int cantidad) {
        int entradasAcuatles = 0;
        if (carritoCompra.containsKey(evento)){
            entradasAcuatles = carritoCompra.get(evento);
            System.out.println("hola");
        }
        entradasAcuatles += cantidad;
        if (entradasAcuatles < 8 && entradasAcuatles > 0){
            carritoCompra.put(evento,entradasAcuatles);
            this.carritoCompra = carritoCompra;
        }else {
            System.out.println("Supera el limite de entradas");
        }

    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre_usuario='" + nombre_usuario + '\'' +
                ", contraseña='" + contrasenia + '\'' +
                ", carritoCompra=" + carritoCompra +
                '}';
    }


}
