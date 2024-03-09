package Bussines;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacionTipo {
    static final String AVISO_RED = "\033[31m";
    static final String resetColor = "\u001B[0m";

    // Método main para probar los métodos
    public static void main(String[] args) {
        ValidacionTipo validador = new ValidacionTipo();
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }

    // Método para validar si una cadena contiene solo texto
    public boolean esSoloTexto(String texto) {
        return texto.matches("[a-zA-Z]+");
    }

    // Método para validar si una cadena contiene solo números
    public boolean esSoloNumerosEnteros(String texto) {
        // Expresión regular para validar solo números enteros
        Pattern patron = Pattern.compile("\\d+");
        Matcher matcher = patron.matcher(texto);
        return matcher.matches();
    }

    public static boolean contieneNumerosAlInicio(String texto) {
        // Patrón para verificar si el texto contiene números al inicio
        Pattern patron = Pattern.compile("^\\d.*");
        Matcher matcher = patron.matcher(texto);
        return matcher.matches();
    }
    public static boolean contieneNumerosSeguidos(String texto) {
        // Patrón para verificar si el texto completo tiene 3 números seguidos
        Pattern patron = Pattern.compile("\\d{5}");
        Matcher matcher = patron.matcher(texto);
        return matcher.find();
    }
    public static boolean caracteresEspecialesSeguidos(String texto) {
        // Patrón para verificar si el texto contiene más de un carácter especial seguido
        Pattern patron = Pattern.compile("[^a-zA-Z0-9\\s]{2,}");
        Matcher matcher = patron.matcher(texto);
        return matcher.find();
    }
    public static boolean caracteresEspecialesInicioFin(String texto) {
        // Patrón para verificar si el texto contiene caracteres especiales al inicio o al final
        Pattern patron = Pattern.compile("^[^a-zA-Z0-9]|[^a-zA-Z0-9]$");
        Matcher matcher = patron.matcher(texto);
        return matcher.find();
    }


    // Método para pedir una entrada de texto y manejar excepciones
    public String pedirEntradaTexto(Scanner scanner) {
        String entrada;
        do {
            System.out.print("Ingrese el texto: ");
            entrada = scanner.nextLine();
            try {
                if (contieneNumerosAlInicio(entrada)) {
                    throw new IllegalArgumentException(AVISO_RED + "Entrada invalida. " +
                            "¡(No puede contener números al inicio)!." + resetColor);
                }
                if (contieneNumerosSeguidos(entrada)) {
                    throw new IllegalArgumentException(AVISO_RED + "Entrada invalida. " +
                            "¡(En el texto, no puede contener mas de 4 números seguidos)!." + resetColor);
                }
                if (caracteresEspecialesInicioFin(entrada)) {
                    throw new IllegalArgumentException(AVISO_RED + "Entrada invalida. " +
                            "¡(En el texto, no puede contener caracteres especiales, ni al inicio ni al final)!." + resetColor);
                }
                if (caracteresEspecialesSeguidos(entrada)) {
                    throw new IllegalArgumentException(AVISO_RED + "Entrada invalida. " +
                            "¡(En el texto, no puede contener mas de un carácter especial seguido)!." + resetColor);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        } while (contieneNumerosAlInicio(entrada) || contieneNumerosSeguidos(entrada) ||
        caracteresEspecialesInicioFin(entrada) || caracteresEspecialesSeguidos(entrada) );
        return entrada;
    }

    // Método para pedir una entrada de números y manejar excepciones
    public String pedirEntradaNumeros(Scanner scanner) {
        String entrada;
        do {
            System.out.print("Ingrese su opción: ");
            entrada = scanner.nextLine();
            try {
                if (!esSoloNumerosEnteros(entrada)) {
                    throw new IllegalArgumentException(AVISO_RED + "La entrada contiene caracteres no válidos. " +
                            "Solo se permiten números enteros." + resetColor);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        } while (!esSoloNumerosEnteros(entrada));
        return entrada;
    }
}
