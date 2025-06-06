package utilidades;

import java.util.Scanner;

public class InputHelper {
    private static Scanner scanner = new Scanner(System.in);

    public static int pegaInt(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. " + mensagem);
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static String pegaString(String mensagem) {
        System.out.print(mensagem);
        return scanner.next();
    }
}