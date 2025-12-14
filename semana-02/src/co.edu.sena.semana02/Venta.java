package co.edu.sena.semana02;

import java.util.ArrayList;
import java.util.Date;

public class Venta {
    private final int numeroFactura;
    private final Date fecha;
    private Cliente cliente;
    private ArrayList<Producto> productos;
    private ArrayList<Integer> cantidades;
    private double subtotal;
    private double descuento;
    private double total;
    private String metodoPago;
    private boolean facturada;

    public Venta(int numeroFactura, Cliente cliente, String metodoPago) {
        this.numeroFactura = numeroFactura;
        this.fecha = new Date();
        this.cliente = cliente;
        this.metodoPago = metodoPago;
        this.productos = new ArrayList<>();
        this.cantidades = new ArrayList<>();
        this.subtotal = 0.0;
        this.descuento = 0.0;
        this.total = 0.0;
        this.facturada = false;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        if (producto != null && cantidad > 0 && producto.isDisponibleVenta()) {
            if (producto.getCantidadStock() >= cantidad) {
                productos.add(producto);
                cantidades.add(cantidad);
                calcularTotales();

                cliente.agregarCompra(producto.getNombre() + " x" + cantidad + " - Factura #" + numeroFactura);

                System.out.println("Producto agregado: " + producto.getNombre() + " x" + cantidad);
            } else {
                System.out.println("Stock insuficiente de " + producto.getNombre() +
                        ". Stock disponible: " + producto.getCantidadStock());
            }
        }
    }

    private void calcularTotales() {
        subtotal = 0;
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            int cantidad = cantidades.get(i);
            subtotal += producto.getPrecio() * cantidad;
        }

        if (cliente.isClienteFrecuente()) {
            descuento = subtotal * cliente.getDescuento();
        } else {
            descuento = 0.0;
        }

        total = subtotal - descuento;
    }

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
            Producto p = productos.get(i);
            int cantidad = cantidades.get(i);
            double precioUnitario = p.getPrecio();
            double totalProducto = precioUnitario * cantidad;

            System.out.printf("  %-25s %3d x $%8.2f = $%9.2f%n",
                    p.getNombre(), cantidad, precioUnitario, totalProducto);
        }

        System.out.println("-".repeat(50));
        System.out.printf("SUBTOTAL:                    $%9.2f%n", subtotal);

        if (cliente.isClienteFrecuente()) {
            System.out.printf("DESCUENTO (10%%):           -$%9.2f%n", descuento);
        }

        System.out.printf("TOTAL A PAGAR:              $%9.2f%n", total);
        System.out.println("=".repeat(50));
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Producto> getProductos() {
        return new ArrayList<>(productos);
    }

    public ArrayList<Integer> getCantidades() {
        return new ArrayList<>(cantidades);
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

    public void setMetodoPago(String metodoPago) {
        if (metodoPago.equals("efectivo") || metodoPago.equals("tarjeta") ||
                metodoPago.equals("transferencia")) {
            this.metodoPago = metodoPago;
        }
    }
}