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
            System.out.println("Elija una opción válida:");
            int opcionElegida = scanner.nextInt();

            if (opcionElegida == 7){
                System.out.println("Gracias por usar el Conversor de Monedas");
                menu = false;
                continue;
            }

            System.out.println("Ingrese el valor que desea convertir:");
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
                    System.out.println("Opción inválida.");
                    continue;
                }
            }

            Monedas conversion = convertidor.convertirMoneda(monedaInicial, monedaFinal);
            double resultado = cantidad * conversion.conversion_rate();

            System.out.printf("El valor %.2f [%s] corresponde al valor final de ==> %.2f [%s]",
                    cantidad, monedaInicial, resultado, monedaFinal);
            System.out.println("************************************************");
        }
        scanner.close();
    }
}
