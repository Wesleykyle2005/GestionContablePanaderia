package ModelosDedatos;

public class CuentasContabilidadBalanceGeneral {

    private String[][] activoCirculante;

    private String[][] activoNoCirculante;

    private String[][] pasivoCortoPlazo;

    private String[][] capitalContribuido;

    private String[][] capitalGanado;
    private static final double TASA_SUELDO = 150;

    public CuentasContabilidadBalanceGeneral() {
        this.activoCirculante = new String[][] {
                { "Efectivo", "10000" },
                { "Bancos", "15000" },
                { "Cuentas por cobrar", "8000" },
                { "Inventarios", "20000" }
        };

        this.activoNoCirculante = new String[][] {
                { "Equipo de entrega", "12000" },
                { "Maquinaria", "18000" }
        };

        // 83

        this.pasivoCortoPlazo = new String[][] {
                { "Proveedores", "5000" },
                { "Préstamos bancarios con vencimiento menor a un año", "3000" },
                { "Dividendos por pagar", "1000" },
                { "Impuestos por pagar", "2000" },
                { "Anticipo de Clientes", "1500" },
                { "Sueldos por pagar", "2500" }
        };
        // 15

        this.capitalContribuido = new String[][] {
                { "Capital social", "48000" }
        };
        // 48

        this.capitalGanado = new String[][] {
                { "Utilidades", "20000" },
                { "Pérdidas retenidas", "0" }
        };
        // 20
    }

    // Getters
    public String[][] getActivoCirculante() {
        return activoCirculante;
    }

    public String[][] getActivoNoCirculante() {
        return activoNoCirculante;
    }

    public String[][] getPasivoCortoPlazo() {
        return pasivoCortoPlazo;
    }

    public String[][] getCapitalContribuido() {
        return capitalContribuido;
    }

    public String[][] getCapitalGanado() {
        return capitalGanado;
    }

    // Setters
    public void setActivoCirculante(String[][] activoCirculante) {
        this.activoCirculante = activoCirculante;
    }

    public void setActivoNoCirculante(String[][] activoNoCirculante) {
        this.activoNoCirculante = activoNoCirculante;
    }

    public void setPasivoCortoPlazo(String[][] pasivoCortoPlazo) {
        this.pasivoCortoPlazo = pasivoCortoPlazo;
    }

    public void setCapitalContribuido(String[][] capitalContribuido) {
        this.capitalContribuido = capitalContribuido;
    }

    public void setCapitalGanado(String[][] capitalGanado) {
        this.capitalGanado = capitalGanado;
    }

    public void updateAccountValue(String[][] accounts, String accountName, String newValue) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i][0].equals(accountName)) {
                accounts[i][1] = newValue;
                break;
            }
        }
    }

    public void venderPan(double montoVenta, double costoInventario,
            CuentasContabilidadEstadoDeResultado cuentasContabilidadEstadoDeResultado) {
        // Actualizar efectivo
        double efectivo = Double.parseDouble(activoCirculante[0][1]);
        efectivo += montoVenta;
        activoCirculante[0][1] = String.valueOf(efectivo);

        // Actualizar inventario
        double inventario = Double.parseDouble(activoCirculante[3][1]);
        inventario -= costoInventario;
        activoCirculante[3][1] = String.valueOf(inventario);

        // Actualizar ventas
        double ventas = Double.parseDouble(cuentasContabilidadEstadoDeResultado.getIngresos()[0][1]);
        ventas += montoVenta;
        cuentasContabilidadEstadoDeResultado.updateAccountValue(cuentasContabilidadEstadoDeResultado.getIngresos(),
                "Ventas", String.valueOf(ventas));

        // Actualizar costo de ventas
        double costoVentas = Double.parseDouble(cuentasContabilidadEstadoDeResultado.getCostoVentas()[0][1]);
        costoVentas += costoInventario;
        cuentasContabilidadEstadoDeResultado.updateAccountValue(cuentasContabilidadEstadoDeResultado.getCostoVentas(),
                "Costo de ventas", String.valueOf(costoVentas));

        // Actualizar utilidad bruta
        double utilidadBruta = ventas - costoInventario;
        cuentasContabilidadEstadoDeResultado.updateAccountValue(cuentasContabilidadEstadoDeResultado.getUtilidadBruta(),
                "Utilidad bruta", String.valueOf(utilidadBruta));

        // Actualizar utilidad neta
        double utilidadNeta = utilidadBruta; // Asumimos que no hay gastos financieros ni impuestos
        cuentasContabilidadEstadoDeResultado.updateAccountValue(cuentasContabilidadEstadoDeResultado.getUtilidadNeta(),
                "Utilidad neta", String.valueOf(utilidadNeta));
    }

    public void añadirInventario(double montoCompra) {
        // Aumentar inventario
        double inventario = Double.parseDouble(activoCirculante[3][1]);
        inventario += montoCompra;
        activoCirculante[3][1] = String.valueOf(inventario);

        // Reducir efectivo
        double efectivo = Double.parseDouble(activoCirculante[0][1]);
        efectivo -= montoCompra;
        activoCirculante[0][1] = String.valueOf(efectivo);
    }

    public void añadirEmpleado(int numEmpleados) {
        // Calcular el total de sueldos por pagar
        double totalSueldos = numEmpleados * TASA_SUELDO;

        // Aumentar sueldos por pagar
        double sueldosPorPagar = Double.parseDouble(pasivoCortoPlazo[5][1]);
        sueldosPorPagar += totalSueldos;
        pasivoCortoPlazo[5][1] = String.valueOf(sueldosPorPagar);

        // Reducir efectivo (o puede ser otra cuenta de activo)
        double efectivo = Double.parseDouble(activoCirculante[0][1]);
        efectivo -= totalSueldos;
        activoCirculante[0][1] = String.valueOf(efectivo);
    }

}
