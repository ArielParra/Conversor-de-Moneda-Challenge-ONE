import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Api exchangerate = new Api();
        final String america = "USD";
        final String colombia = "COP";
        final String argentina = "ARS";
        final String brazil = "BRL";
        int menu;
        float dinero = 0;
        boolean salir = false;

        while (!salir) { // menu
            System.out.println("---------------------------------");
            System.out.println("Conversor de Moneda Challenge ONE");
            System.out.println("1) Dólar a Peso argentino");
            System.out.println("2) Peso argentino a Dólar");
            System.out.println("3) Dólar a Real brasileño");
            System.out.println("4) Real brasileño a Dólar");
            System.out.println("5) Dólar a Peso colombiano");
            System.out.println("6) Peso colombiano a Dólar");
            System.out.println("7) Salir");
            System.out.println("-------------------------------");
            System.out.println("Opción: ");
            menu = scanner.nextInt();
            scanner.nextLine();
            if (menu >= 1 && menu <= 6) {
                System.out.println("Valor a convertir: ");
                try {
                    dinero = Float.parseFloat(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Error: Ingresa un valor numérico válido.");
                    continue; // Volver al inicio del bucle
                }
            }

            switch (menu) {
                case 1 -> exchangerate.conversionMoneda(america, argentina, dinero);
                case 2 -> exchangerate.conversionMoneda(argentina, america, dinero);
                case 3 -> exchangerate.conversionMoneda(america, brazil, dinero);
                case 4 -> exchangerate.conversionMoneda(brazil, america, dinero);
                case 5 -> exchangerate.conversionMoneda(america, colombia, dinero);
                case 6 -> exchangerate.conversionMoneda(colombia, america, dinero);
                case 7 -> {
                    System.out.println("Gracias por usar el programa");
                    salir = true; // para salir del bucle
                }
                default -> System.out.println("-- Advertencia -- Ingresa un número válido de las opciones.");
            }

            // Preguntar al usuario si quiere volver a realizar una conversión o salir del programa
            if (!salir) {
                System.out.println("¿Quieres realizar otra conversión? (s/n)");
                String respuesta = scanner.nextLine();
                if (respuesta.equalsIgnoreCase("n")) {
                    salir = true; // salir del bucle
                }
            }
        }
        scanner.close();
    }
}
