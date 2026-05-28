package org.example.SegundoExa;

import java.util.Random;

public class Ticket implements Acciones{
    static Random aleatorio = new Random();
    private String matricula;
    private Integer minutos;
    private Estado estado;

    public Ticket(String matricula, Integer minutos, Estado estado) {
        this.matricula = matricula;
        this.minutos = minutos;
        this.estado = estado;
    }

    @Override
    public void generar() {
        String letras = "BCDFGHJKLMNPQRSTVWXYZ";
        String numeros = "0123456789";
        String let = "";
        String num = "";
        while (let.length() < 3) {
            let += letras.charAt(aleatorio.nextInt(0, letras.length()));
        }
        while (num.length() < 4) {
            num += numeros.charAt(aleatorio.nextInt(0, numeros.length()));
        }

        System.out.println("Leyendo matricula...");
        String matricula = num + let;
        setMatricula(matricula);
        setEstado(Estado.GENERADO);
        System.out.println(getMatricula());
        System.out.println(getEstado());
        System.out.println("Ticket Generado");
    }

    @Override
    public void recoger() {
        System.out.println("Recoja su ticket...");
    }

    @Override
    public void pagar() {
        System.out.println("Pagando...");
        setEstado(Estado.PAGADO);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getMinutos() {
        return minutos;
    }

    public void setMinutos(Integer minutos) {
        this.minutos = minutos;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
