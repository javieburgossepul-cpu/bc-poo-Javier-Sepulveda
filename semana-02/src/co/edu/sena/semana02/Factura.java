import java.util.ArrayList;
import java.util.Date;

public class Factura {
    // RELACIÓN DE AGREGACIÓN con Venta
    private Venta venta;

    // RELACIÓN DE COMPOSICIÓN con DetalleFactura
    private ArrayList<DetalleFactura> detalles;
    private Date fechaEmision;
    private String estado; // "generada", "pagada", "anulada"
    private String numeroFactura;

    // Clase interna DetalleFactura (COMPOSICIÓN)
    public class DetalleFactura {
        private Producto producto;
        private int cantidad;
        private double precioUnitario;
        private double subtotal;

        public DetalleFactura(Producto producto, int cantidad) {
            this.producto = producto;
            this.cantidad = cantidad;
            this.precioUnitario = producto.getPrecio();
            this.subtotal = precioUnitario * cantidad;
        }

        // GETTERS
        public Producto getProducto() {
            return producto;
        }

        public int getCantidad() {
            return cantidad;
        }

        public double getPrecioUnitario() {
            return precioUnitario;
        }

        public double getSubtotal() {
            return subtotal;
        }

        public void mostrarDetalle() {
            System.out.printf("  %-25s %4d x $%8.2f = $%9.2f%n",
                    producto.getNombre(), cantidad, precioUnitario, subtotal);
        }
    }

    // Constructor de Factura - CORREGIDO
    public Factura(Venta venta) {
        this.venta = venta;
        this.detalles = new ArrayList<>();
        this.fechaEmision = new Date();
        this.estado = "generada";
        this.numeroFactura = "FAC-" + venta.getNumeroFactura();

        // Necesitamos acceder a los productos y cantidades de la venta
        // Si Venta no tiene getCantidades(), usamos una alternativa
        ArrayList<Producto> productosVenta = venta.getProductos();

        // Para las cantidades, necesitamos un método en Venta o una solución alternativa
        // Por ahora, asumiremos que cada producto tiene cantidad 1
        // Más adelante actualizaremos Venta para incluir getCantidades()
        for (Producto producto : productosVenta) {
            detalles.add(new DetalleFactura(producto, 1)); // Cantidad temporal
        }
    }

    // Método para mostrar factura completa
    public void mostrarFacturaCompleta() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("              FACTURA ELECTRÓNICA");
        System.out.println("=".repeat(60));
        System.out.println("Número: " + numeroFactura);
        System.out.println("Fecha: " + fechaEmision);
        System.out.println("Estado: " + estado.toUpperCase());
        System.out.println("-".repeat(60));

        System.out.println("DATOS DEL CLIENTE:");
        System.out.println("  Nombre: " + venta.getCliente().getNombre());
        System.out.println("  Documento: " + venta.getCliente().getDocumento());
        System.out.println("  Tipo: " + venta.getCliente().getTipoCliente());
        System.out.println("  Cliente frecuente: " +
                (venta.getCliente().isClienteFrecuente() ? "SÍ" : "NO"));

        System.out.println("-".repeat(60));
        System.out.println("DETALLE DE PRODUCTOS:");

        double totalProductos = 0;
        for (DetalleFactura detalle : detalles) {
            detalle.mostrarDetalle();
            totalProductos += detalle.getSubtotal();
        }

        System.out.println("-".repeat(60));
        System.out.printf("SUBTOTAL PRODUCTOS:          $%9.2f%n", totalProductos);

        if (venta.getCliente().isClienteFrecuente()) {
            double descuento = totalProductos * venta.getCliente().getDescuento();
            System.out.printf("DESCUENTO (%2.0f%%)            -$%9.2f%n",
                    venta.getCliente().getDescuento() * 100, descuento);
        }

        System.out.printf("TOTAL A PAGAR:               $%9.2f%n", venta.getTotal());
        System.out.println("-".repeat(60));
        System.out.println("Método de pago: " + venta.getMetodoPago());
        System.out.println("=".repeat(60));
    }

    // Método para cambiar estado de la factura
    public void cambiarEstado(String nuevoEstado) {
        if (nuevoEstado.equals("pagada") || nuevoEstado.equals("anulada")) {
            this.estado = nuevoEstado;
            System.out.println("✓ Estado de factura " + numeroFactura + " cambiado a: " + nuevoEstado);
        }
    }

    // Método para calcular total de la factura
    public double calcularTotalFactura() {
        double total = 0;
        for (DetalleFactura detalle : detalles) {
            total += detalle.getSubtotal();
        }

        if (venta.getCliente().isClienteFrecuente()) {
            total *= (1 - venta.getCliente().getDescuento());
        }

        return total;
    }

    // GETTERS
    public String getNumeroFactura() {
        return numeroFactura;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public String getEstado() {
        return estado;
    }

    public Venta getVenta() {
        return venta;
    }

    public ArrayList<DetalleFactura> getDetalles() {
        return new ArrayList<>(detalles);
    }
}  // ← Asegúrate de que aquí cierra la clase correctamente
