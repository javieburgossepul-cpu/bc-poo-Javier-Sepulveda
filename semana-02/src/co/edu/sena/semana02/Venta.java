import java.util.ArrayList;
import java.util.Date;

public class Venta {
    private int numeroFactura;
    private Date fechaVenta;
    private Cliente cliente;
    private ArrayList<Producto> productos;
    private ArrayList<Integer> cantidades;
    private double totalVenta;
    private String metodoPago; // "efectivo", "tarjeta", "transferencia"

    public Venta(int numeroFactura, Cliente cliente, String metodoPago) {
        this.numeroFactura = numeroFactura;
        this.fechaVenta = new Date(); // Fecha actual
        this.cliente = cliente;
        this.metodoPago = metodoPago;
        this.productos = new ArrayList<>();
        this.cantidades = new ArrayList<>();
        this.totalVenta = 0.0;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        if (producto != null && cantidad > 0 && producto.isDisponibleVenta()) {
            productos.add(producto);
            cantidades.add(cantidad);
            actualizarStock(producto, cantidad);
            calcularTotal();

            // Registrar compra en historial del cliente
            cliente.agregarCompra(producto.getNombre() + " x" + cantidad);
        }
    }

    private void actualizarStock(Producto producto, int cantidad) {
        // Nota: Necesitaríamos un setter para cantidadStock en Producto
        // Por ahora, solo registramos la venta
    }

    public void calcularTotal() {
        totalVenta = 0;
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            int cantidad = cantidades.get(i);
            totalVenta += producto.getPrecio() * cantidad;
        }

        // Aplicar descuento si el cliente es frecuente
        if (cliente.isClienteFrecuente()) {
            totalVenta = cliente.calcularPrecioConDescuento(totalVenta);
        }
    }

    public void imprimirFactura() {
        System.out.println("====================================");
        System.out.println("      CONSTRUYE FÁCIL - FACTURA     ");
        System.out.println("====================================");
        System.out.println("Factura #: " + numeroFactura);
        System.out.println("Fecha: " + fechaVenta);
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Tipo: " + cliente.getTipoCliente());
        System.out.println("Teléfono: " + cliente.getTelefono());
        System.out.println("Método de pago: " + metodoPago);
        System.out.println("------------------------------------");
        System.out.println("PRODUCTOS:");

        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            int cantidad = cantidades.get(i);
            double subtotal = p.getPrecio() * cantidad;
            System.out.printf("  %-20s %3d x $%7.2f = $%8.2f%n",
                    p.getNombre(), cantidad, p.getPrecio(), subtotal);
        }

        System.out.println("------------------------------------");
        if (cliente.isClienteFrecuente()) {
            System.out.printf("Descuento (10%%):           -$%8.2f%n",
                    totalVenta / 0.9 - totalVenta);
        }
        System.out.printf("TOTAL A PAGAR:            $%8.2f%n", totalVenta);
        System.out.println("====================================");
    }

    // Getters y Setters
    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        if (numeroFactura > 0) {
            this.numeroFactura = numeroFactura;
        }
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if (cliente != null) {
            this.cliente = cliente;
            calcularTotal(); // Recalcular con nuevo cliente
        }
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        if (metodoPago.equals("efectivo") || metodoPago.equals("tarjeta") ||
                metodoPago.equals("transferencia")) {
            this.metodoPago = metodoPago;
        }
    }

    public ArrayList<Producto> getProductos() {
        return new ArrayList<>(productos); // Devolver copia para proteger encapsulamiento
    }

    public int getCantidadProductos() {
        return productos.size();
    }
}