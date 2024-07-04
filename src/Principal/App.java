package Principal;

import ModelosDedatos.CuentasContabilidadBalanceGeneral;
import ModelosDedatos.CuentasContabilidadEstadoDeResultado;
import MetodosUtiles.MetodosUtiles;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        CuentasContabilidadBalanceGeneral balanceGeneral = new CuentasContabilidadBalanceGeneral();
        CuentasContabilidadEstadoDeResultado estadoDeResultado = new CuentasContabilidadEstadoDeResultado();

        System.out.println(MetodosUtiles.MensajeBienvenida());

        while (true) {

            int opcion = MetodosUtiles.validateIntInput("Opción: ", 1, 6, scanner);

            switch (opcion) {
                case 1:
                    leerDatosDesdeArchivos(balanceGeneral, estadoDeResultado);
                    break;
                case 2:
                    guardarDatosEnArchivos(balanceGeneral, estadoDeResultado);
                    break;
                case 3:
                    balanceGeneral.venderPan(
                            MetodosUtiles.validateDoubleInput("Ingrese el monto de la venta ", 1, 1000, scanner),
                            MetodosUtiles.validateDoubleInput("Ingrese el costo del inventario ", 1, 1000, scanner),
                            estadoDeResultado);
                    break;
                case 4:
                    balanceGeneral.añadirInventario(
                            MetodosUtiles.validateDoubleInput("Ingrese el valor del inventario ", 1, 1000, scanner));
                    break;
                case 5:
                    balanceGeneral.añadirEmpleado(
                            MetodosUtiles.validateIntInput("Ingrese el numero de empleados ", 1, 100, scanner));
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    /**
     * Método para guardar datos en archivos
     * 
     * @param balanceGeneral    Objeto de balance general con datos a guardar
     * @param estadoDeResultado Objeto de estado de resultado con datos a guardar
     */
    private static void guardarDatosEnArchivos(CuentasContabilidadBalanceGeneral balanceGeneral,
            CuentasContabilidadEstadoDeResultado estadoDeResultado) {
        String userHome = System.getProperty("user.home");
        String desktopPath = userHome + "/Desktop";
        String filePathBalanceGeneral = desktopPath + "/balance_general.txt";
        String filePathEstadoResultado = desktopPath + "/estado_resultado.txt";

        List<String[]> datosBalanceGeneral = new ArrayList<>();
        List<String[]> datosEstadoResultado = new ArrayList<>();

        // Agregar encabezados y datos del balance general
        datosBalanceGeneral.add(new String[] { "Activo", "", "" });
        agregarDatos(datosBalanceGeneral, balanceGeneral.getActivoCirculante(), "-----");
        agregarDatos(datosBalanceGeneral, balanceGeneral.getActivoNoCirculante(), "-----");
        datosBalanceGeneral.add(new String[] { "Pasivo", "", "" });
        agregarDatos(datosBalanceGeneral, balanceGeneral.getPasivoCortoPlazo(), "-----");
        datosBalanceGeneral.add(new String[] { "Capital", "", "" });
        agregarDatos(datosBalanceGeneral, balanceGeneral.getCapitalContribuido(), "-----");
        agregarDatos(datosBalanceGeneral, balanceGeneral.getCapitalGanado(), "-----");

        // Agregar encabezados y datos del estado de resultado
        datosEstadoResultado.add(new String[] { "Ingresos", "", "" });
        agregarDatos(datosEstadoResultado, estadoDeResultado.getIngresos(), "-----");
        datosEstadoResultado.add(new String[] { "Costo de Ventas", "", "" });
        agregarDatos(datosEstadoResultado, estadoDeResultado.getCostoVentas(), "-----");
        datosEstadoResultado.add(new String[] { "Gastos Operativos", "", "" });
        agregarDatos(datosEstadoResultado, estadoDeResultado.getGastosOperativos(), "-----");
        datosEstadoResultado.add(new String[] { "Utilidad Bruta", "", "" });
        agregarDatos(datosEstadoResultado, estadoDeResultado.getUtilidadBruta(), "-----");
        datosEstadoResultado.add(new String[] { "Gastos Financieros", "", "" });
        agregarDatos(datosEstadoResultado, estadoDeResultado.getGastosFinancieros(), "-----");
        datosEstadoResultado.add(new String[] { "Impuestos", "", "" });
        agregarDatos(datosEstadoResultado, estadoDeResultado.getImpuestos(), "-----");
        datosEstadoResultado.add(new String[] { "Utilidad Neta", "", "" });
        agregarDatos(datosEstadoResultado, estadoDeResultado.getUtilidadNeta(), "-----");

        // Escribir datos en los archivos
        MetodosUtiles.escribirDatosEnArchivo(filePathBalanceGeneral, datosBalanceGeneral);
        MetodosUtiles.escribirDatosEnArchivo(filePathEstadoResultado, datosEstadoResultado);
        System.out.println("Datos guardados en " + filePathBalanceGeneral + " y " + filePathEstadoResultado);
    }

    /**
     * Método para agregar datos a la lista
     * 
     * @param datos     Lista a la que se agregan los datos
     * @param cuentas   Array de cuentas a agregar
     * @param separador Separador entre el nombre de la cuenta y el valor
     */
    private static void agregarDatos(List<String[]> datos, String[][] cuentas, String separador) {
        for (String[] cuenta : cuentas) {
            datos.add(new String[] { cuenta[0], cuenta[1], separador });
        }
    }

    /**
     * Método para leer datos desde archivos y actualizar los objetos de cuentas
     * 
     * @param balanceGeneral    Objeto de balance general a actualizar
     * @param estadoDeResultado Objeto de estado de resultado a actualizar
     */
    private static void leerDatosDesdeArchivos(CuentasContabilidadBalanceGeneral balanceGeneral,
            CuentasContabilidadEstadoDeResultado estadoDeResultado) {

        String userHome = System.getProperty("user.home");
        String desktopPath = userHome + "/Desktop";
        String filePathBalanceGeneral = desktopPath + "/balance_general.txt";
        String filePathEstadoResultado = desktopPath + "/estado_resultado.txt";

        List<String[]> datosBalanceGeneral = MetodosUtiles.leerDatosDesdeArchivo(filePathBalanceGeneral);
        for (String[] dato : datosBalanceGeneral) {
            System.out.println(dato[0] + "-----" + dato[1]);
        }

        List<String[]> datosEstadoResultado = MetodosUtiles.leerDatosDesdeArchivo(filePathEstadoResultado);

        System.out.println("Datos leídos desde " + filePathBalanceGeneral + ":");
        actualizarCuentasBalanceGeneral(balanceGeneral, datosBalanceGeneral);

        System.out.println("Datos leídos desde " + filePathEstadoResultado + ":");
        actualizarCuentasEstadoResultado(estadoDeResultado, datosEstadoResultado);

    }

    /**
     * Método para actualizar las cuentas desde los datos leídos (Balance General)
     * 
     * @param balanceGeneral Objeto de balance general a actualizar
     * @param datos          Lista de datos leídos desde el archivo
     */
    private static void actualizarCuentasBalanceGeneral(CuentasContabilidadBalanceGeneral balanceGeneral,
            List<String[]> datos) {
        String tipoCuenta = "";

        for (String[] dato : datos) {
            tipoCuenta = dato[0];

            switch (tipoCuenta) {

                // Activos
                case "Efectivo":
                    balanceGeneral.updateAccountValue(balanceGeneral.getActivoCirculante(), dato[0], dato[1]);
                    break;
                case "Bancos":
                    balanceGeneral.updateAccountValue(balanceGeneral.getActivoCirculante(), dato[0], dato[1]);
                    break;
                case "Cuentas por cobrar":
                    balanceGeneral.updateAccountValue(balanceGeneral.getActivoCirculante(), dato[0], dato[1]);
                    break;
                case "Inventarios":
                    balanceGeneral.updateAccountValue(balanceGeneral.getActivoCirculante(), dato[0], dato[1]);
                    break;
                case "Equipo de entrega":
                    balanceGeneral.updateAccountValue(balanceGeneral.getActivoNoCirculante(), dato[0], dato[1]);
                    break;
                case "Maquinaria":
                    balanceGeneral.updateAccountValue(balanceGeneral.getActivoNoCirculante(), dato[0], dato[1]);
                    break;
                // Pasivos
                case "Proveedores":
                    balanceGeneral.updateAccountValue(balanceGeneral.getPasivoCortoPlazo(), dato[0], dato[1]);
                    break;
                case "Préstamos bancarios con vencimiento menor a un año":
                    balanceGeneral.updateAccountValue(balanceGeneral.getPasivoCortoPlazo(), dato[0], dato[1]);
                    break;
                case "Dividendos por pagar":
                    balanceGeneral.updateAccountValue(balanceGeneral.getPasivoCortoPlazo(), dato[0], dato[1]);
                    break;
                case "Impuestos por pagar":
                    balanceGeneral.updateAccountValue(balanceGeneral.getPasivoCortoPlazo(), dato[0], dato[1]);
                    break;
                case "Anticipo de Clientes":
                    balanceGeneral.updateAccountValue(balanceGeneral.getPasivoCortoPlazo(), dato[0], dato[1]);
                    break;
                case "Sueldos por pagar":
                    balanceGeneral.updateAccountValue(balanceGeneral.getPasivoCortoPlazo(), dato[0], dato[1]);
                    break;
                // Capital
                case "Capital social":
                    balanceGeneral.updateAccountValue(balanceGeneral.getCapitalContribuido(), dato[0], dato[1]);
                    break;
                case "Utilidades":
                    balanceGeneral.updateAccountValue(balanceGeneral.getCapitalGanado(), dato[0], dato[1]);
                    break;
                case "Pérdidas retenidas":
                    balanceGeneral.updateAccountValue(balanceGeneral.getCapitalGanado(), dato[0], dato[1]);
                    break;
                default:
                    System.err.println("Error");
            }

        }
    }

    /**
     * Método para actualizar las cuentas desde los datos leídos (Estado de
     * Resultado)
     * 
     * @param estadoDeResultado Objeto de estado de resultado a actualizar
     * @param datos             Lista de datos leídos desde el archivo
     */
    private static void actualizarCuentasEstadoResultado(CuentasContabilidadEstadoDeResultado estadoDeResultado,
            List<String[]> datos) {
        String tipoCuenta = "";
        for (String[] dato : datos) {

            tipoCuenta = dato[0];
            switch (tipoCuenta) {
                case "Ventas":
                    estadoDeResultado.updateAccountValue(estadoDeResultado.getIngresos(), dato[0], dato[1]);
                    break;
                case "Costo de ventas":
                    estadoDeResultado.updateAccountValue(estadoDeResultado.getCostoVentas(), dato[0], dato[1]);
                    break;
                case "Gastos de administración":
                    estadoDeResultado.updateAccountValue(estadoDeResultado.getGastosOperativos(), dato[0], dato[1]);
                    break;
                case "Gastos de venta":
                    estadoDeResultado.updateAccountValue(estadoDeResultado.getGastosOperativos(), dato[0], dato[1]);
                    break;
                case "Utilidad bruta":
                    estadoDeResultado.updateAccountValue(estadoDeResultado.getUtilidadBruta(), dato[0], dato[1]);
                    break;
                case "Intereses pagados":
                    estadoDeResultado.updateAccountValue(estadoDeResultado.getGastosFinancieros(), dato[0], dato[1]);
                    break;
                case "Pago de dividendos":
                    estadoDeResultado.updateAccountValue(estadoDeResultado.getGastosFinancieros(), dato[0], dato[1]);
                    break;
                case "Impuestos sobre la renta":
                    estadoDeResultado.updateAccountValue(estadoDeResultado.getImpuestos(), dato[0], dato[1]);
                    break;
                case "Utilidad neta":
                    estadoDeResultado.updateAccountValue(estadoDeResultado.getUtilidadNeta(), dato[0], dato[1]);
                    break;
            }
        }
    }
}
