import java.util.Scanner;

public class SumaDeDigitos {

    public void ejecutar(Scanner entrada) {
        System.out.println("""
                Bienvenido al programa de suma de dígitos
                
                Este programa calcula la suma de los dígitos de todos los números
                desde 1 hasta N.
                
                Ejemplo:
                # N = 4
                1 + 2 + 3 + 4 = 10
                
                Introduzca 0 en cualquier momento para salir.
                """
        );
        try {
            boolean continuar = true;
            while (continuar) {
                System.out.println("Ingrese un número entero N y presione Enter (0 para salir): ");
                int n = entrada.nextInt();
                if (n == 0) {
                    continuar = false;
                } else if (n < 0) {
                    System.out.println("Por favor, ingrese un número mayor o igual a 0.");
                } else {
                    int suma = calcularSumaDigitos(n);
                    System.out.println("La suma de los dígitos de los números de 1 a " + n + " es: " + suma);
                }
            }
        } catch (Exception e) {
            System.err.println("Ingrese un valor válido.");
            entrada.nextLine(); // Limpiar el buffer del scanner
        }
    }

    public int calcularSumaDigitos(int N) {
        int total = 0;
        for (int i = 1; i <= N; i++) {
            total += sumarDigitos(i); // Sumar los dígitos de cada número
        }
        return total;
    }

    //Este metodo es necesario para cuando lso numeros son mayores de 9
    // ya que por ejemplo el 11 sumara 2 (1 + 1) y no 11
    public int sumarDigitos(int numero) {
        int sumaDigitos = 0;
        while (numero > 0) {
            // con esto lo que hacemos es dividir el numero por 10 y que nos de el resto
            // asi sacamos el numero de la derecha
            sumaDigitos += numero % 10;
            // a continuacion dividimos por 10 asi ese numero que acabamos de sumar desaparece
            numero /= 10;
        }
        return sumaDigitos;
    }


}
