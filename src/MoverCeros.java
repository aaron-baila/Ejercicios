import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MoverCeros {

    /**
     * Solicita al usuario una lista de elementos separados por espacios y mueve todos los ceros
     * al final de la lista, manteniendo el orden de los demás elementos.
     *
     * @param entrada Una instancia de {@link Scanner} para leer la entrada del usuario.
     */
    public void ejecutar(Scanner entrada) {
        System.out.println("""
                Introduce una lista de elementos separados por espacios:
                Ejemplo: moveZeros([false,1,0,1,2,0,1,3,"a"])""");
        String texto = entrada.nextLine();
         texto = entrada.nextLine();

        // Separamos los miembros del array mediante espacios
        String[] listaDeEntrada = texto.split(" ");
        List<Object> lista = new ArrayList<>();

        for (String elemento : listaDeEntrada) {
            if (elemento.equals("0")) {
                lista.add(0);
            } else if (elemento.equals("false")) {
                lista.add(false);
            } else if (elemento.equals("true")) {
                lista.add(true);
            } else {
                try {
                    // Intentamos parsear a entero
                    lista.add(Integer.parseInt(elemento));
                } catch (NumberFormatException e) {
                    // Si no es un número, lo agregamos como String
                    lista.add(elemento);
                }
            }
        }

        moverCeros(lista);
    }

    /**
     * Mueve todos los ceros en la lista al final, manteniendo el orden de los demás elementos.
     *
     * @param lista La lista de elementos a procesar.
     * @return Una cadena con los elementos de la lista separados por comas.
     */
    private String moverCeros(List<Object> lista) {
        int contadorCeros = 0;
        List<Object> resultado = new ArrayList<>();

        // Recorrer la lista y mover todos los elementos diferentes de cero a la nueva lista
        for (Object elemento : lista) {
            if (elemento.equals(0)) {
                contadorCeros++;
            } else {
                // Añadimos el elemento no-cero
                resultado.add(elemento);
            }
        }

        // Agregar los ceros al final de la lista
        for (int i = 0; i < contadorCeros; i++) {
            resultado.add(0);
        }

        // Convertimos la lista a un string y separamos los elementos por comas
        StringBuilder sb = new StringBuilder();
        for (Object elemento : resultado) {
            sb.append(elemento).append(",");
        }

        // Eliminamos la última coma
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }

        String resultadoStr = sb.toString();
        System.out.println(resultadoStr);
        return resultadoStr;
    }
}
