import java.util.Scanner;

public class Main {
    private static final CalculoImc calculoImc = new CalculoImc();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("Bienvenidos al examen");
        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("""
                        Marque número de opción y presione Enter:
                        1 - Cálculo IMC
                        0 - Salir
                        """);
                System.out.print("Seleccione una opción: ");
                int opcion = entrada.nextInt();

                switch (opcion) {
                    case 1 -> calculoImc.ejecutar(entrada);
                    case 0 -> {
                        System.out.println("Saliendo del programa. ¡Gracias!");
                        continuar = false;
                    }
                    default -> System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.err.println("Introduzca un número válido.");
                entrada.nextLine(); // Para limpiar el buffer y no de problemas de entrada.
            }
        }
    }
}
