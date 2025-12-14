package co.edu.sena.semana03;

import java.util.ArrayList;
import java.util.Date;
import java.util.List; // ← USAR List en lugar de ArrayList en la declaración

public class ImproveFactura {
    // ATRIBUTOS PRIVADOS - AÑADIR final donde corresponda
    private final ImproveVenta venta;                    // ← FINAL
    private final List<DetalleFactura> detalles;  // ← USAR List interface
    private final Date fechaEmision;              // ← FINAL
    private String estado;                        // Cambia, NO final
    private final String numeroFactura;           // ← FINAL

    // CLASE INTERNA - CORREGIR: puede ser static si no necesita acceder a Factura.this
    public static class DetalleFactura {          // ← AÑADIR static
        // ATRIBUTOS PRIVADOS - AÑADIR final
        private final ImproveProducto producto;          // ← FINAL
        private int cantidad;
        private final double precioUnitario;      // ← FINAL
        private final double subtotal;            // ← FINAL

        // CONSTRUCTOR
        public DetalleFactura(ImproveProducto producto, int cantidad) {
            // VALIDACIONES EN CONSTRUCTOR, no en setters separados
            if (producto == null) {
                throw new IllegalArgumentException("Producto no puede ser nulo");
            }
            if (cantidad <= 0 || cantidad > 1000) {
                throw new IllegalArgumentException("Cantidad debe ser entre 1 y 1000");
            }

            this.producto = producto;
            this.cantidad = cantidad;
            this.precioUnitario = producto.getPrecio();
            this.subtotal = precioUnitario * cantidad;
        }

        // GETTERS
        public ImproveProducto getProducto() { return producto; }
        public int getCantidad() { return cantidad; }
        public double getPrecioUnitario() { return precioUnitario; }
        public double getSubtotal() { return subtotal; }

        // SETTER - Solo para cantidad, producto es final
        public void setCantidad(int cantidad) {
            if (cantidad > 0 && cantidad <= 1000) {
                this.cantidad = cantidad;
            } else {
                throw new IllegalArgumentException("Cantidad debe ser entre 1 y 1000");
            }
        }

        // MÉTODO PARA MOSTRAR DETALLE
        public void mostrarDetalle() {
            System.out.printf("  %-20s x%3d @ $%7.2f = $%9.2f%n",
                    producto.getNombre(),
                    cantidad,
                    precioUnitario,
                    subtotal);
        }
    }

    // CONSTRUCTOR
    public ImproveFactura(ImproveVenta venta) {
        if (venta == null || venta.getProductos().isEmpty()) {
            throw new IllegalArgumentException("No se puede crear factura sin venta válida");
        }

        this.venta = venta;
        this.detalles = new ArrayList<>();
        this.fechaEmision = new Date();
        this.estado = "generada";
        this.numeroFactura = "FAC-" + venta.getNumeroFactura();

        // Crear detalles de forma más limpia
        List<ImproveProducto> productosVenta = venta.getProductos();
        List<Integer> cantidadesVenta = venta.getCantidades();

        for (int i = 0; i < productosVenta.size(); i++) {
            detalles.add(new DetalleFactura(
                    productosVenta.get(i),
                    cantidadesVenta.get(i)
            ));
        }
    }

    // ELIMINAR setProducto() y setters innecesarios si los campos son final
    // ELIMINAR métodos no usados que menciona el reporte

    // ... resto del código igual ...

    // GETTERS - getDetalles() ya está bien (devuelve copia)
    public List<DetalleFactura> getDetalles() {
        return new ArrayList<>(detalles); // Buena práctica: devolver copia defensiva
    }

    // MÉTODO CALCULAR TOTAL MÁS EFICIENTE
    private double calcularTotalProductos() {
        return detalles.stream()
                .mapToDouble(DetalleFactura::getSubtotal)
                .sum();
    }
}
