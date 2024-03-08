package Bussines;

import Interfaces.ITextAnalyzerInterface;

public class TextAnalyzer implements ITextAnalyzerInterface {
    @Override
    public void analyze(String texto) {
        int totalPalabras = contarPalabras(texto);
        double longitudMedia = calcularLongitudMedia(texto, totalPalabras);
        int duracionPalabras = contarPalabrasConGuion(texto);
        int oraciones = contarOraciones(texto);
        String palabraMasLarga = encontrarPalabraMasLarga(texto);

        System.out.println("Número total de palabras: " + totalPalabras);
        System.out.println("Longitud media de las palabras: " + longitudMedia);
        System.out.println("Número de composición de palabras: " + duracionPalabras);
        System.out.println("Número de oraciones: " + oraciones);
        System.out.println("Palabra más larga: " + palabraMasLarga);
        System.out.println();
    }


    private static int contarPalabras(String texto) {
        //Expresión regular que separa cada palabra y la asigna en un array
        String[] palabras = texto.split("\\s+");
        return palabras.length;
    }

    private static double calcularLongitudMedia(String texto, int totalPalabras) {
        //Elimina todos los espacios en blanco y cuenta el resultado final
        int longitudTotal = texto.replaceAll("[^a-zA-Z]", "").length();
        return (double) longitudTotal / totalPalabras;
    }

    private static int contarPalabrasConGuion(String texto) {
        String[] palabras = texto.split("\\s+");
        int contador = 0;
        for (String palabra : palabras) {
            if (palabra.contains("-")) {
                contador++;
            }
        }
        return contador;
    }

    private static int contarOraciones(String texto) {
        return texto.split("\\.").length;
    }

    private static String encontrarPalabraMasLarga(String texto) {
        String[] palabras = texto.split("\\s+");
        String palabraMasLarga = "";
        for (String palabra : palabras) {
            if (palabra.length() > palabraMasLarga.length()) {
                palabraMasLarga = palabra;
            }
        }
        return palabraMasLarga;
    }
}