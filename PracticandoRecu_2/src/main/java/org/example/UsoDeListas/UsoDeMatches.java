package org.example.UsoDeListas;

public class UsoDeMatches {
    static void main(String[] args) {
        String telefonoGuiones = "666-555-444";
        boolean esTelefonoGuionesValido = telefonoGuiones.matches("\\d{3}-\\d{3}-\\d{3}");
        System.out.println("Teléfono con guiones válido: " + esTelefonoGuionesValido);


        // =====================================================================
        // 2. MATRÍCULA: Formato de tu examen (ej: 1234BCD)
        // =====================================================================
        String matricula = "4839KLP";
        boolean esMatriculaValida = matricula.matches("\\d{4}[A-Z]{3}");
        System.out.println("Matrícula válida: " + esMatriculaValida);


        // =====================================================================
        // 3. DNI ESPAÑOL: 8 números y 1 letra (ej: 12345678Z)
        // =====================================================================
        String dni = "12345678Z";
        boolean esDniValido = dni.matches("\\d{8}[A-Z]");
        System.out.println("DNI válido: " + esDniValido);


        // =====================================================================
        // 4. TELÉFONO MÓVIL: 9 números seguidos (ej: 612345678)
        // =====================================================================
        String celular = "612345678";
        boolean esCelularValido = celular.matches("\\d{9}");
        System.out.println("Teléfono móvil válido: " + esCelularValido);


        // =====================================================================
        // 5. FECHA ESTÁNDAR: Día/Mes/Año (ej: 28/05/2026)
        // =====================================================================
        String fecha = "28/05/2026";
        boolean esFechaValida = fecha.matches("\\d{2}/\\d{2}/\\d{4}");
        System.out.println("Fecha válida: " + esFechaValida);


        // =====================================================================
        // 6. CÓDIGO DE PARKING: Letra, guion y 4 números (ej: P-1234)
        // =====================================================================
        String codigoParking = "P-8524";
        boolean esCodigoValido = codigoParking.matches("[A-Z]-\\d{4}");
        System.out.println("Código de parking válido: " + esCodigoValido);


        // =====================================================================
        // 7. EXTRA: Teléfono con puntos (ej: 666.555.444)
        // Recuerda usar '\\.' para que Java entienda que es un punto de texto real
        // =====================================================================
        String telefonoPuntos = "666.555.444";
        boolean esTelefonoPuntosValido = telefonoPuntos.matches("\\d{3}\\.\\d{3}\\.\\d{3}");
        System.out.println("Teléfono con puntos válido: " + esTelefonoPuntosValido);
    }
}
