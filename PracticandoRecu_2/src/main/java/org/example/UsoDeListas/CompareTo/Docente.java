package org.example.UsoDeListas.CompareTo;

import java.util.Objects;

// REQUISITO EXAMEN 1: Obligatorio poner 'implements Comparable<Docente>'
public class Docente implements Comparable<Docente> {

    // Atributos básicos del simulacro
    private String dni;
    private Integer diasHuelga;


    // Constructor completo
    public Docente(String dni, Integer diasHuelga) {
        this.dni = dni;
        this.diasHuelga = diasHuelga;

    }

    // =====================================================================
    // EL MÉTODO MÁGICO: compareTo()
    // =====================================================================
    // Sirve para que las colecciones como TreeSet o métodos como Collections.sort()
    // sepan cómo ordenar de forma automática tus objetos.
    @Override
    public int compareTo(Docente otro) {
        // CASO A: Ordenar de MAYOR a MENOR (como pide el simulacro de Conselleria)
        // Para ordenar de mayor a menor, comparas "otro" contra "this" (al revés del orden normal).
        int resultadoComparacion = otro.diasHuelga.compareTo(this.diasHuelga);

        /* * CASO B (Por si acaso): Si en el examen te piden de MENOR a MAYOR:
         * int resultadoComparacion = this.diasHuelga.compareTo(otro.diasHuelga);
         */

        // 🚨 EL SALVAVIDAS DEL EXAMEN (Desempate por DNI):
        // Si dos profesores tienen los mismos días de huelga, 'resultadoComparacion' será 0.
        // Si dejas que devuelva 0, el TreeSet pensará que son la misma persona y BORRARÁ al segundo.
        if (resultadoComparacion == 0) {
            // Desempatamos usando el DNI (que al ser String también tiene su propio compareTo)
            return this.dni.compareTo(otro.dni);
        }

        return resultadoComparacion;
    }

    // =====================================================================
    // REQUISITO EXAMEN 2: Métodos equals y hashCode por DNI
    // =====================================================================
    // Tu simulacro pide explícitamente tener esto para que estructuras como HashSet
    // o métodos como .contains() sepan cuándo un DNI está duplicado.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Docente other = (Docente) obj;
        return Objects.equals(dni, other.dni); // Dos docentes son iguales si su DNI es igual
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    // Getters y Setters necesarios
    public String getDni() { return dni; }
    public Integer getDiasHuelga() { return diasHuelga; }


    // toString rápido para ver los resultados bonitos por pantalla
    @Override
    public String toString() {
        return "DNI: " + dni + " | Días: " + diasHuelga;
    }
}
