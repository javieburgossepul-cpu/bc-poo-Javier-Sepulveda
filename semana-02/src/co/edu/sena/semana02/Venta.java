import java.util.ArrayList;
import java.util.Date;

public class Venta {
    private int numeroFactura;
    private Date fecha;
    private Cliente cliente;
    private ArrayList<Producto> productos;
    private ArrayList<Integer> cantidades;
    private double subtotal;
    private double descuento;
    private double total;
    private String metodoPago; // "efectivo", "tarjeta", "transferencia"
    private boolean facturada;

    public Venta(int numeroFactura, Cliente cliente, String metodoPago) {
        this.numeroFactura = numeroFactura;
        this.fecha = new Date(); // Fecha actual
        this.cliente = cliente;
        this.metodoPago = metodoPago;
        this.productos = new ArrayList<>();
        this.cantidades = new ArrayList<>();
        this.subtotal = 0.0;
        this.descuento = 0.0;
        this.total = 0.0;
        this.facturada = false;
    }

    // MÉTODO DE NEGOCIO: Agregar producto a la venta
    public void agregarProducto(Producto producto, int cantidad) {
        if (producto != null && cantidad > 0 && producto.isDisponibleVenta()) {
            // Verificar stock disponible
            if (producto.getCantidadStock() >= cantidad) {
                productos.add(producto);
                cantidades.add(cantidad);
                calcularTotales();

                // Registrar en historial del cliente
                cliente.agregarCompra(producto.getNombre() + " x" + cantidad + " - Factura #" + numeroFactura);

                System.out.println("Producto agregado: " + producto.getNombre() + " x" + cantidad);
            } else {
                System.out.println("Stock insuficiente de " + producto.getNombre() +
                        ". Stock disponible: " + producto.getCantidadStock());
            }
        }
    }

    // MÉTODO DE NEGOCIO: Calcular totales de la venta
    private void calcularTotales() {
        subtotal = 0;

        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            int cantidad = cantidades.get(i);
            subtotal += producto.getPrecio() * cantidad;
        }

        // Aplicar descuento si el cliente es frecuente
        if (cliente.isClienteFrecuente()) {
            descuento = subtotal * cliente.getDescuento();
        } else {
            descuento = 0.0;
        }

        total = subtotal - descuento;
    }

    // MÉTODO DE NEGOCIO: Generar factura
    public void generarFactura() {
        if (productos.isEmpty()) {
            System.out.println("No se puede generar factura sin productos.");
            return;
        }

        facturada = true;
        System.out.println("\n" + "=".repeat(50));
        System.out.println("         CONSTRUYE FÁCIL - FACTURA");
        System.out.println("=".repeat(50));
        System.out.println("Factura #: " + numeroFactura);
        System.out.println("Fecha: " + fecha);
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Documento: " + cliente.getDocumento());
        System.out.println("Tipo cliente: " + cliente.getTipoCliente());
        System.out.println("Método de pago: " + metodoPago);
        System.out.println("-".repeat(50));

        System.out.println("PRODUCTOS:");
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            int cantidad = cantidades.get(i);
            double precioUnitario = producto.getPrecio();
            double totalProducto = precioUnitario * cantidad;

            System.out.printf("  %-25s %3d x $%8.2f = $%9.2f%n",
                    producto.getNombre(), cantidad, precioUnitario, totalProducto);
        }

        System.out.println("-".repeat(50));
        System.out.printf("SUBTOTAL:                    $%9.2f%n", subtotal);

        if (cliente.isClienteFrecuente()) {
            System.out.printf("DESCUENTO (10%%):           -$%9.2f%n", descuento);
        }

        System.out.printf("TOTAL A PAGAR:              $%9.2f%n", total);
        System.out.println("=".repeat(50));
    }

    // MÉTODO DE NEGOCIO: Mostrar resumen de venta
    public void mostrarResumen() {
        System.out.println("=== RESUMEN VENTA #" + numeroFactura + " ===");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Fecha: " + fecha);
        System.out.println("Total productos: " + productos.size());
        System.out.println("Subtotal: $" + String.format("%.2f", subtotal));
        System.out.println("Descuento: $" + String.format("%.2f", descuento));
        System.out.println("Total: $" + String.format("%.2f", total));
        System.out.println("Facturada: " + (facturada ? "SÍ" : "NO"));
    }

    // GETTERS
    public int getNumeroFactura() {
        return numeroFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public double getTotal() {
        return total;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public boolean isFacturada() {
        return facturada;
    }

    public ArrayList<Producto> getProductos() {
        return new ArrayList<>(productos);
    }

    public int getCantidadTotalProductos() {
        int total = 0;
        for (Integer cantidad : cantidades) {
            total += cantidad;
        }
        return total;
    }

    // SETTERS con validaciones
    public void setMetodoPago(String metodoPago) {
        if (metodoPago != null && (metodoPago.equals("efectivo") ||
                metodoPago.equals("tarjeta") ||
                metodoPago.equals("transferencia"))) {
            this.metodoPago = metodoPago;
        }
    }

    public void setFacturada(boolean facturada) {
        this.facturada = facturada;
    }
}