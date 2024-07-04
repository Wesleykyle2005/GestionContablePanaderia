package MetodosUtiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MetodosUtiles {

    /**
     * Este metodo se utiliza para validar numeros enteros, tambien usa limitaciones
     * de valores y que se pida el numero hasta que logre obtener datos validos
     * 
     * @return Un numero entero
     */
    public static int validateIntInput(String message, int min, int max, Scanner scanner) {
        int input = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(message);
            try {
                input = scanner.nextInt();
                if (input >= min && input <= max) {
                    isValid = true;
                } else {
                    System.out.println("Error: Ingrese un número entre " + min + " y " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero válido.");
                scanner.next();
            }
        }
        return input;
    }

    /**
     * Este metodo se utiliza para validar numeros doubles, tambien usa limitaciones
     * de valores y que se pida el numero hasta que logre obtener datos validos
     * 
     * @return Un numero double
     */
    public static double validateDoubleInput(String message, double min, double max, Scanner scanner) {
        double input = 0.0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(message);
            try {
                input = scanner.nextDouble();
                if (input >= min && input <= max) {
                    isValid = true;
                } else {
                    System.out.println("Error: Ingrese un número entre " + min + " y " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número decimal válido.");
                scanner.next();
            }
        }
        return input;
    }

    /**
     * Este metodo se utiliza para validar strings, tambien usa limitaciones
     * de valores y que se pida el dato hasta que logre obtener datos validos
     * 
     * @return Una string
     */
    public static String validateStringInput(String message, int minLength, int maxLength, Scanner scanner) {
        String input = "";
        boolean isValid = false;

        while (!isValid) {
            System.out.print(message);
            input = scanner.next();
            if (input.length() >= minLength && input.length() <= maxLength) {
                isValid = true;
            } else {
                System.out.println("Error: Ingrese un texto con una longitud entre " + minLength + " y " + maxLength
                        + " caracteres.");
            }
        }
        return input;
    }

    /**
     * Este metodo construye y devuelve el mensaje de bienvenida al iniciar el
     * programa
     * 
     * @return Devuelve el mensaje de bienvenida
     */
    public static String MensajeBienvenida() {
        String Pan = "                                                                                        \r\n"
                +
                "                                                                                       \r\n" +
                "                ░░                                                                     \r\n" +
                "                                                                                       \r\n" +
                "                                      ██████                                           \r\n" +
                "                          ██      ████████████                                         \r\n" +
                "        ░░                  ██████████████████                                  ░░     \r\n" +
                "                            ██████████████████  ▓▓▓▓▓▓▓▓▓▓▓▓                           \r\n" +
                "                          ██████████████████▓▓▓▓▓▓░░░░░░▓▓▓▓▓▓                         \r\n" +
                "                        ██████████████░░░░░░░░░░░░░░░░░░░░▓▓▓▓▓▓                       \r\n" +
                "                        ████████████░░░░░░░░░░░░░░░░░░░░░░░░▓▓▓▓                       \r\n" +
                "                      ██████████░░░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓▓▓                       \r\n" +
                "                      ██████▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓▓▓▓▓                       \r\n" +
                "                      ████  ▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓                           \r\n" +
                "                              ▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓▒▒  ▒▒                     \r\n" +
                "                              ▓▓░░████░░░░░░░░░░░░████░░░░██▒▒  ▒▒                     \r\n" +
                "                              ▓▓░░████░░░░░░░░░░░░████░░░░██                           \r\n" +
                "                              ▓▓▒▒▒▒░░░░██░░░░██░░░░▒▒▒▒██▓▓                           \r\n" +
                "                            ▓▓▓▓░░░░░░░░░░████░░░░░░░░░░██▓▓                           \r\n" +
                "                            ▓▓▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓                           \r\n" +
                "                            ▓▓▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓                           \r\n" +
                "                            ▓▓▓▓░░░░░░░░░░░░░░░░░░░░░░░░▓▓▓▓                           \r\n" +
                "                            ▓▓▓▓▓▓▓▓░░░░░░░░░░░░░░░░░░▓▓▓▓▓▓                           \r\n" +
                "                              ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓                           \r\n" +
                "                                                                                       \r\n" +
                "                                                                                       \r\n" +
                "                                                                                       \r\n" +
                "                                                                                       \r\n" +
                "  ░░                                              ░░          ░░        ░░            \r\n";

        String panaderia = "                             _           _       \r\n" +
                "                            | |         (_)      \r\n" +
                " _ __   __ _ _ __   __ _  __| | ___ _ __ _  __ _ \r\n" +
                "| '_ \\ / _` | '_ \\ / _` |/ _` |/ _ \\ '__| |/ _` |\r\n" +
                "| |_) | (_| | | | | (_| | (_| |  __/ |  | | (_| |\r\n" +
                "| .__/ \\__,_|_| |_|\\__,_|\\__,_|\\___|_|  |_|\\__,_|\r\n" +
                "| |                                              \r\n" +
                "|_|                                              \r\n\r\n" + //
                "";
        String MensajeBienvenida = "Bienvenido al sistema de gestion contable de la panaderia \n" +
                "Bendición de Dios \r\n";
        String Opciones = "\n° Seleccione una opción:\r\n" +
                "|---------------------------------------|\r\n" +
                "|1. Leer datos desde archivos           |\r\n" +
                "|2. Guardar datos en archivos           |\r\n" +
                "|3. Registrar ventas                    |\r\n" +
                "|4. Añadir inventario                   |\r\n" +
                "|5. Añadir empleados                    |\r\n" +
                "|6. Salir                               |\r\n" +
                "|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|" +
                "\r\n";
        String mensaje = Pan + panaderia + MensajeBienvenida + Opciones;
        return mensaje;
    }

    /**
     * Este metodo se usa para escribir el balance general y el estado de resultado
     * en archivos de texto plano
     * 
     * @return
     */
    public static void escribirDatosEnArchivo(String filePath, List<String[]> datos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] dato : datos) {
                writer.write(dato[0] + dato[2] + dato[1]);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Este metodo se usa para escribir leer el balance general y el estado de
     * resultado en archivos de texto plano
     * 
     * @return Devuelve los datos de los archivos de texto plano
     */
    public static List<String[]> leerDatosDesdeArchivo(String filePath) {
        List<String[]> datos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts;
                if (line.contains("-----")) {
                    parts = line.split("-----");
                    if (parts.length >= 2) {
                        parts = new String[] { parts[0], parts[1], "-----" };
                        datos.add(parts);
                    }
                }
            }
        } catch (java.io.FileNotFoundException e) {
            System.err.println("Error: Archivo no encontrado - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de entrada/salida al leer archivo: " + e.getMessage());
        }
        return datos;
    }
}