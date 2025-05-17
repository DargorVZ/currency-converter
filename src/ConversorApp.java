import java.util.Scanner;

public class ConversorApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CurrencyApi convertidor = new CurrencyApi();
        boolean menu = true;

        while (menu) {
            System.out.println("************************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println("""
                    
                    1) Dólar ==> Peso Argentino
                    2) Peso Argentino ==> Dólar
                    3) Dólar ==> Real Brasileño
                    4) Real Brasileño ==> Dólar
                    5) Dólar ==> Peso Colombiano
                    6) Peso Colombiano ==> Dólar
                    7) Salir
                    """);
            System.out.println("************************************************");
            System.out.print("Elija una opción válida: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Ingrese un número del 1 al 7.\n");
                scanner.next();
                continue;
            }

            int opcionElegida = scanner.nextInt();

            if (opcionElegida == 7) {
                System.out.println("Gracias por usar el Conversor de Monedas");
                break;
            }

            System.out.print("Ingrese el valor que desea convertir: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Entrada inválida. Debe ingresar un número decimal.\n");
                scanner.next();
                continue;
            }

            double cantidad = scanner.nextDouble();
            String monedaInicial = "", monedaFinal = "";

            switch (opcionElegida) {
                case 1 -> { monedaInicial = "USD"; monedaFinal = "ARS"; }
                case 2 -> { monedaInicial = "ARS"; monedaFinal = "USD"; }
                case 3 -> { monedaInicial = "USD"; monedaFinal = "BRL"; }
                case 4 -> { monedaInicial = "BRL"; monedaFinal = "USD"; }
                case 5 -> { monedaInicial = "USD"; monedaFinal = "COP"; }
                case 6 -> { monedaInicial = "COP"; monedaFinal = "USD"; }
                default -> {
                    System.out.println("Opción inválida.\n");
                    continue;
                }
            }

            try {
                Conversion conversion = convertidor.convertirMoneda(monedaInicial, monedaFinal);
                double resultado = cantidad * conversion.conversion_rate();
                System.out.printf("El valor %.2f [%s] corresponde al valor final de %.2f [%s]%n%n",
                        cantidad, monedaInicial, resultado, monedaFinal);
            } catch (RuntimeException e) {
                System.out.println(" Ocurrió un error: " + e.getMessage() + "\n");
            }
        }
        scanner.close();
    }
}
