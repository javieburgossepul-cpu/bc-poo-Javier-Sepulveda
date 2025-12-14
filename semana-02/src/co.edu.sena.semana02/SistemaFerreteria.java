package co.edu.sena.semana02;

public class SistemaFerreteria {
    private Inventario inventario;

    public SistemaFerreteria() {
        this.inventario = new Inventario();
    }

    public void inicializarSistema() {
        System.out.println("=== INICIALIZANDO SISTEMA FERRETERÍA ===\n");

        Producto martillo = new Producto("Martillo de Acero", "Herramientas", 50, 25.99, true);
        Producto cemento = new Producto("Cemento Gris 50kg", "Materiales", 120, 32.50, true);
        Producto pintura = new Producto("Pintura Blanca 4L", "Pinturas", 30, 45.80, true);
        Producto cable = new Producto("Cable Eléctrico 2.5mm", "Eléctricos", 80, 15.75, true);
        Producto tornillos = new Producto("Tornillos 2\" x 100u", "Materiales", 200, 8.25, true);

        inventario.agregarProducto(martillo);
        inventario.agregarProducto(cemento);
        inventario.agregarProducto(pintura);
        inventario.agregarProducto(cable);
        inventario.agregarProducto(tornillos);

        System.out.println("\nSistema inicializado con " + inventario.getCantidadProductos() + " productos.");
    }

    public void simularProcesoVenta() {
        System.out.println("\n\n=== SIMULACIÓN DE PROCESO DE VENTA ===\n");

        Cliente cliente = new Cliente("María González", "constructor", "87654321", "3222222222", true);
        System.out.println("1. Cliente creado: " + cliente.getNombre());

        Venta venta = new Venta(2001, cliente, "tarjeta");
        System.out.println("2. Venta creada: #" + venta.getNumeroFactura());

        Producto martillo = inventario.buscarProducto("Martillo de Acero");
        Producto cemento = inventario.buscarProducto("Cemento Gris 50kg");
        Producto tornillos = inventario.buscarProducto("Tornillos 2\" x 100u");

        if (martillo != null) {
            venta.agregarProducto(martillo, 3);
        }

        if (cemento != null) {
            venta.agregarProducto(cemento, 10);
        }

        if (tornillos != null) {
            venta.agregarProducto(tornillos, 2);
        }

        System.out.println("3. Generando factura desde venta...");
        venta.generarFactura();

        inventario.mostrarReporteInventario();

        System.out.println("\n✓ Proceso de venta simulado exitosamente!");
    }

    public void ejecutar() {
        inicializarSistema();
        simularProcesoVenta();
    }
}
