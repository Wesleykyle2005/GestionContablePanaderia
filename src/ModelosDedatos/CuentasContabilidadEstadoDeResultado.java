package ModelosDedatos;

public class CuentasContabilidadEstadoDeResultado {

        // Ingresos
        private String[][] ingresos;

        // Costo de Ventas
        private String[][] costoVentas;

        // Gastos Operativos
        private String[][] gastosOperativos;

        // Utilidad Bruta
        private String[][] utilidadBruta;

        // Gastos Financieros
        private String[][] gastosFinancieros;

        // Impuestos
        private String[][] impuestos;

        // Utilidad Neta
        private String[][] utilidadNeta;

        // Constructor
        public CuentasContabilidadEstadoDeResultado() {
                this.ingresos = new String[][] {
                                { "Ventas", "50000" }
                };

                this.costoVentas = new String[][] {
                                { "Costo de ventas", "20000" }
                };

                this.gastosOperativos = new String[][] {
                                { "Gastos de administración", "13000" },
                                { "Gastos de venta", "1500" }
                };

                this.utilidadBruta = new String[][] {
                                { "Utilidad bruta", "0" }
                };

                this.gastosFinancieros = new String[][] {
                                { "Intereses pagados", "1000" },
                                { "Pago de dividendos", "500" }
                };

                this.impuestos = new String[][] {
                                { "Impuestos sobre la renta", "2500" }
                };

                this.utilidadNeta = new String[][] {
                                { "Utilidad neta", "0" }
                };
        }

        // Getters
        public String[][] getIngresos() {
                return ingresos;
        }

        public String[][] getCostoVentas() {
                return costoVentas;
        }

        public String[][] getGastosOperativos() {
                return gastosOperativos;
        }

        public String[][] getUtilidadBruta() {
                return utilidadBruta;
        }

        public String[][] getGastosFinancieros() {
                return gastosFinancieros;
        }

        public String[][] getImpuestos() {
                return impuestos;
        }

        public String[][] getUtilidadNeta() {
                return utilidadNeta;
        }

        // Setters
        public void setIngresos(String[][] ingresos) {
                this.ingresos = ingresos;
        }

        public void setCostoVentas(String[][] costoVentas) {
                this.costoVentas = costoVentas;
        }

        public void setGastosOperativos(String[][] gastosOperativos) {
                this.gastosOperativos = gastosOperativos;
        }

        public void setUtilidadBruta(String[][] utilidadBruta) {
                this.utilidadBruta = utilidadBruta;
        }

        public void setGastosFinancieros(String[][] gastosFinancieros) {
                this.gastosFinancieros = gastosFinancieros;
        }

        public void setImpuestos(String[][] impuestos) {
                this.impuestos = impuestos;
        }

        public void setUtilidadNeta(String[][] utilidadNeta) {
                this.utilidadNeta = utilidadNeta;
        }

        /**
         * Método para actualizar el valor de una cuenta específica
         * 
         * @return
         */
        public void updateAccountValue(String[][] accounts, String accountName, String newValue) {
                for (int i = 0; i < accounts.length; i++) {
                        if (accounts[i][0].equals(accountName)) {
                                accounts[i][1] = newValue;
                                break;
                        }
                }
        }
}
