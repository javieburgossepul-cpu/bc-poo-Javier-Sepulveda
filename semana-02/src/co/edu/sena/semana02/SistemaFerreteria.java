public class SistemaFerreteria {
    private Inventario inventario;

    public SistemaFerreteria() {
        this.inventario = new Inventario();
    }

    // Método para inicializar el sistema con datos de prueba
    public void inicializarSistema() {
        System.out.println("=== INICIALIZANDO SISTEMA FERRETERÍA ===\n");

        // Crear productos
        Producto martillo = new Producto("Martillo de Acero", "Herramientas", 50, 25.99, true);
        Producto cemento = new Producto("Cemento Gris 50kg", "Materiales", 120, 32.50, true);
        Producto pintura = new Producto("Pintura Blanca 4L", "Pinturas", 30, 45.80, true);
        Producto cable = new Producto("Cable Eléctrico 2.5mm", "Eléctricos", 80, 15.75, true);
        Producto tornillos = new Producto("Tornillos 2\" x 100u", "Materiales", 200, 8.25, true);

        // Agregar productos al inventario (COMPOSICIÓN)
        inventario.agregarProducto(martillo);
        inventario.agregarProducto(cemento);
        inventario.agregarProducto(pintura);
        inventario.agregarProducto(cable);
        inventario.agregarProducto(tornillos);

        System.out.println("\nSistema inicializado con " + inventario.getCantidadProductos() + " productos.");
    }

    // Método para simular un proceso de venta completo
    public void simularProcesoVenta() {
        System.out.println("\n\n=== SIMULACIÓN DE PROCESO DE VENTA ===\n");

        // 1. Crear cliente
        Cliente cliente = new Cliente("María González", "constructor", "87654321", "3222222222", true);
        System.out.println("1. Cliente creado: " + cliente.getNombre());

        // 2. Crear venta
        Venta venta = new Venta(2001, cliente, "tarjeta");
        System.out.println("2. Venta creada: #" + venta.getNumeroFactura());

        // 3. Buscar productos en inventario y agregar a venta
        Producto martillo = inventario.buscarProducto("Martillo de Acero");
        Producto cemento = inventario.buscarProducto("Cemento Gris 50kg");
        Producto tornillos = inventario.buscarProducto("Tornillos 2\" x 100u");

        if (martillo != null) {
            venta.agregarProducto(martillo, 3);
            inventario.actualizarStock("Martillo de Acero", 3);
        }

        if (cemento != null) {
            venta.agregarProducto(cemento, 10);
            inventario.actualizarStock("Cemento Gris 50kg", 10);
        }

        if (tornillos != null) {
            venta.agregarProducto(tornillos, 2);
            inventario.actualizarStock("Tornillos 2\" x 100u", 2);
        }

        // 4. Crear factura (AGREGACIÓN con Venta, COMPOSICIÓN con DetalleFactura)
        Factura factura = new Factura(venta);
        System.out.println("3. Factura generada: " + factura.getNumeroFactura());

        // 5. Mostrar factura
        factura.mostrarFacturaCompleta();

        // 6. Mostrar estado del inventario después de la venta
        inventario.mostrarReporteInventario();

        // 7. Cambiar estado de la factura a pagada
        factura.cambiarEstado("pagada");

        System.out.println("\n✓ Proceso de venta simulado exitosamente!");
    }

    // Método principal para ejecutar el sistema
    public void ejecutar() {
        inicializarSistema();
        simularProcesoVenta();
    }

    // GETTER
    public Inventario getInventario() {
        return inventario;
    }
}
