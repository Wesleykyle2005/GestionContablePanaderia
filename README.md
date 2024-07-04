
# Sistema Contable - Aplicación Java

Este proyecto implementa un sistema contable básico en Java, que incluye un balance general y un estado de resultados. La aplicación permite gestionar diversas operaciones financieras y contables simuladas.

## Características del Proyecto

### Funcionalidades Implementadas

1. **Gestión del Balance General:**
   - Registro y actualización de activos circulantes y no circulantes.
   - Gestión de pasivos a corto plazo, incluyendo sueldos por pagar y otros compromisos financieros.
   - Control de capital contribuido y ganado.

2. **Estado de Resultados:**
   - Registro de ingresos por ventas y otros conceptos.
   - Manejo de costos de ventas, gastos operativos, financieros e impuestos.
   - Cálculo de utilidad bruta y utilidad neta.

3. **Operaciones de Negocio Simuladas:**
   - Venta de productos (actualización de efectivo, inventario, ingresos y costos de ventas).
   - Compra de inventario (ajuste de inventario y efectivo).
   - Contratación de empleados (aumento de sueldos por pagar y reducción de efectivo).

4. **Persistencia de Datos:**
   - Guardado de datos del balance general y estado de resultados en archivos de texto.
   - Lectura y actualización de datos desde archivos para mantener la integridad de los estados financieros.

### Estructura del Proyecto

- **Clase Principal (`App`):** Contiene la lógica principal de la aplicación, gestionando la interacción con el usuario a través de la consola.
- **Modelos de Datos:**
  - `CuentasContabilidadBalanceGeneral`: Define la estructura y operaciones del balance general.
  - `CuentasContabilidadEstadoDeResultado`: Define la estructura y operaciones del estado de resultados.
- **Utilidades (`MetodosUtiles`):** Proporciona métodos auxiliares para validación de entrada de usuario, escritura y lectura de archivos.

