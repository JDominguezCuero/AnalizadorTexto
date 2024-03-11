import Bussines.TextAnalyzer;
import Bussines.ValidacionTipo;
import Interfaces.ITextAnalyzerInterface;

import java.util.Scanner;

public class Main {
    static ValidacionTipo valT = new ValidacionTipo();
    static final String AVISO_RED = "\033[31m";
    static final String resetColor = "\u001B[0m";
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ITextAnalyzerInterface analyzer = new TextAnalyzer();
        String texto;
        int opcion = 0;

        do {
            try {
                System.out.println("--------------------------");
                System.out.println("   1. Ingresar texto ");
                System.out.println("   2. Salir ");
                System.out.println("--------------------------");
                opcion = Integer.parseInt(valT.pedirEntradaNumeros(scanner));

                switch (opcion) {
                    case 1:
                        System.out.println();
                        texto = valT.pedirEntradaTexto(scanner);
                        analyzer.analyze(texto);
                        break;
                    case 2:
                        System.out.println("Fin del programa...");
                        break;
                    default:
                        System.out.println();
                        System.out.println(AVISO_RED + "Opción inválida. Inténtalo de nuevo." + resetColor);
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(AVISO_RED + "El formato ingresado no es válido." + resetColor);
            }
        } while (opcion != 2);
    }
}