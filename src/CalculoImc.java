import java.util.Scanner;

public class CalculoImc {

    /**
     * Solicita al usuario su peso y altura para calcular el Índice de Masa Corporal (IMC).
     * <p>
     * Este método guía al usuario para que ingrese:
     * - El peso en kilogramos (usando una coma como separador decimal, por ejemplo: 65,30).
     * - La altura en centímetros como un número entero (por ejemplo: 165).
     * <p>
     * A partir de estos datos, se calcula el IMC y se muestra la categoría correspondiente
     * (Infrapeso, Normal, Sobrepeso, Obeso).
     *
     * @param entrada Una instancia de {@link Scanner} para leer la entrada del usuario.
     * @throws java.util.InputMismatchException Si el usuario ingresa datos no válidos (por ejemplo, texto en lugar de números).
     */
    public void ejecutar(Scanner entrada) {
        System.out.println("""
                Bienvenido al calculo de IMC
                
                A continuación pediremos peso en Kg ejemplo 65,30 poner coma y no punto
                Altura en cm ejemplo 165
                tras ello calcularemos su IMC
                
                """
        );
        try {
            boolean continuar = true;
            while (continuar) {
                System.out.println("Introduzca el valor 0 en cualquier momento para salir de calculo IMC");
                System.out.println("Ingrese peso y presione enter:");
                double peso = entrada.nextDouble();
                if (peso == 0) {
                    continuar = false;
                }
                System.out.println("Ingrese altura y presione enter:");
                int altura = entrada.nextInt();
                if (altura == 0) {
                    continuar = false;
                }
                System.out.println(calcularImc(peso, altura));

            }
        } catch (Exception e) {
            System.err.println("Ingrese un valor valido");
        }
    }

    /**
     * Calcula el Índice de Masa Corporal (IMC) basado en el peso y la altura proporcionados.
     *
     * @param peso   El peso del usuario en kilogramos (debe usarse coma como separador decimal).
     * @param altura La altura del usuario en centímetros.
     * @return Una cadena con la categoría correspondiente al IMC calculado:
     * "Infrapeso", "Normal", "Sobrepeso" o "Obeso".
     */
    private String calcularImc(double peso, int altura) {
        double imc = peso / (altura * altura);
        String respuesta = "";

        if (imc <= 18.5) {
            respuesta = "Infrapeso";
        } else if (imc <= 25) {
            respuesta = "Normal";
        } else if (imc <= 30) {
            respuesta = "Sobrepeso";
        } else {
            respuesta = "Obeso";
        }
        return respuesta;
    }
}
