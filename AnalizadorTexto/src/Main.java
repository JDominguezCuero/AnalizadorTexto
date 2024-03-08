import Bussines.TextAnalyzer;
import Bussines.ValidacionTipo;
import Interfaces.ITextAnalyzerInterface;

import java.util.Scanner;

public class Main {
    static ValidacionTipo valT = new ValidacionTipo();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("Ingresa el texto:");
            String texto = scanner.nextLine();

            ITextAnalyzerInterface analyzer = new TextAnalyzer();
            analyzer.analyze(texto);

            System.out.println("###################################################");
            System.out.println("#   Si deseas analizar otro texto, inserte (s),   #");
            System.out.println("#   o inserte cualquier tecla para salir.         #");
            System.out.println("###################################################");
            opcion = scanner.nextLine();

        } while (opcion.equalsIgnoreCase("s"));

        System.out.println("Fin del programa.");

    }
}