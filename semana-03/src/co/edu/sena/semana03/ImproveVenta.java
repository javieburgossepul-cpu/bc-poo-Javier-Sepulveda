package co.edu.sena.semana03;

import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

public class ImproveVenta {
    private final int numeroFactura;
    private final Date fecha;
    private ImproveCliente cliente;
    private ArrayList<ImproveProducto> productos;
    private ArrayList<Integer> cantidades;
    private double subtotal;
    private double descuento;
    private double total;
    private String metodoPago;
    private boolean facturada;
    private String direccionEntrega;

    // CONSTRUCTORES con validaciones
    public ImproveVenta(int numeroFactura, ImproveCliente cliente, String metodoPago, String direccionEntrega) {
        validarNumeroFactura(numeroFactura);
        this.numeroFactura = numeroFactura;
        this.fecha = new Date();
        setCliente(cliente);
        setMetodoPago(metodoPago);
        setDireccionEntrega(direccionEntrega);
        this.productos = new ArrayList<>();
        this.cantidades = new ArrayList<>();
        this.subtotal = 0.0;
        this.descuento = 0.0;
        this.total = 0.0;
        this.facturada = false;
        System.out.println("✓ Venta creada: #" + numeroFactura);
    }

    public ImproveVenta(int numeroFactura, ImproveCliente cliente, String metodoPago) {
        this(numeroFactura, cliente, metodoPago, "Retiro en tienda");
    }

    // MÉTODOS AUXILIARES PRIVADOS para validaciones
    private void validarNumeroFactura(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("El número de factura debe ser mayor a 0");
        }
        if (numero > 999999) {
            throw new IllegalArgumentException("El número de factura no puede exceder 999,999");
        }
    }

    private boolean validarDireccionEntrega(String direccion) {
        if (direccion == null || direccion.trim().isEmpty()) {
            throw new IllegalArgumentException("La dirección de entrega no puede ser nula o vacía");
        }
        if (direccion.length() < 10 || direccion.length() > 200) {
            throw new IllegalArgumentException("La dirección debe tener entre 10 y 200 caracteres");
        }
        // Validar formato básico de dirección
        String regex = "^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s#\\-.,;:()ºª]+$";
        if (!Pattern.matches(regex, direccion)) {
            throw new IllegalArgumentException("La dirección contiene caracteres no permitidos");
        }
        return true;
    }

    private boolean validarMetodoPago(String metodo) {
        if (metodo == null || metodo.trim().isEmpty()) {
            throw new IllegalArgumentException("El método de pago no puede ser nulo o vacío");
        }
        String[] metodosValidos = {"efectivo", "tarjeta crédito", "tarjeta débito", "transferencia", "cheque", "pse"};
        for (String metodoValido : metodosValidos) {
            if (metodoValido.equalsIgnoreCase(metodo.trim())) {
                return true;
            }
        }
        throw new IllegalArgumentException("Método de pago no válido. Use: " + String.join(", ", metodosValidos));
    }

    private boolean validarCantidadProducto(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        if (cantidad > 1000) {
            throw new IllegalArgumentException("La cantidad no puede exceder 1,000 unidades por producto");
        }
        return true;
    }

    // MÉTODOS PÚBLICOS con validaciones
    public void agregarProducto(ImproveProducto producto, int cantidad) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        if (!validarCantidadProducto(cantidad)) {
            return;
        }
        if (producto.getCantidadStock() < cantidad) {
            throw new IllegalArgumentException("Stock insuficiente de " + producto.getNombre() +
                    ". Disponible: " + producto.getCantidadStock() +
                    ", Solicitado: " + cantidad);
        }

        productos.add(producto);
        cantidades.add(cantidad);
        calcularTotales();

        if (cliente != null) {
            cliente.agregarCompra(producto.getNombre() + " x" + cantidad + " - Factura #" + numeroFactura);
        }

        System.out.println("✓ Producto agregado: " + producto.getNombre() + " x" + cantidad);
    }

    private void calcularTotales() {
        subtotal = 0;
        for (int i = 0; i < productos.size(); i++) {
            ImproveProducto producto = productos.get(i);
            int cantidad = cantidades.get(i);
            subtotal += producto.getPrecio() * cantidad;
        }

        if (cliente != null && cliente.isClienteFrecuente()) {
            descuento = subtotal * cliente.getDescuento();
        } else {
            descuento = 0.0;
        }

        total = subtotal - descuento;

        // Validar que el total sea positivo
        if (total < 0) {
            throw new IllegalStateException("El total de la venta no puede ser negativo");
        }
    }

    // GETTERS
    public int getNumeroFactura() {
        return numeroFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public ImproveCliente getCliente() {
        return cliente;
    }

    public ArrayList<ImproveProducto> getProductos() {
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

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public boolean isFacturada() {
        return facturada;
    }

    // SETTERS con validaciones
    public void setCliente(ImproveCliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo");
        }
        this.cliente = cliente;
    }

    public void setMetodoPago(String metodoPago) {
        if (validarMetodoPago(metodoPago)) {
            this.metodoPago = metodoPago.toLowerCase();
        }
    }

    public void setDireccionEntrega(String direccionEntrega) {
        if (validarDireccionEntrega(direccionEntrega)) {
            this.direccionEntrega = direccionEntrega.trim();
        }
    }

    public void setFacturada(boolean facturada) {
        if (productos.isEmpty() && facturada) {
            throw new IllegalStateException("No se puede facturar una venta sin productos");
        }
        this.facturada = facturada;
    }

    // MÉTODO para generar factura
    public void generarFactura() {
        if (productos.isEmpty()) {
            throw new IllegalStateException("No se puede generar factura sin productos");
        }

        facturada = true;
        System.out.println("\n" + "=".repeat(60));
        System.out.println("         FACTURA ELECTRÓNICA #" + numeroFactura);
        System.out.println("=".repeat(60));
        System.out.println("Fecha: " + fecha);

        if (cliente != null) {
            System.out.println("Cliente: " + cliente.getNombre());
            System.out.println("Documento: " + cliente.getDocumento());
        }

        System.out.println("Método de pago: " + metodoPago);
        System.out.println("Dirección entrega: " + direccionEntrega);
        System.out.println("-".repeat(60));

        System.out.println("PRODUCTOS:");
        for (int i = 0; i < productos.size(); i++) {
            ImproveProducto producto = productos.get(i);
            int cantidad = cantidades.get(i);
            double precio = producto.getPrecio();
            double totalProducto = precio * cantidad;

            System.out.printf("  %-25s %4d x $%8.2f = $%9.2f%n",
                    producto.getNombre(), cantidad, precio, totalProducto);
        }

        System.out.println("-".repeat(60));
        System.out.printf("SUBTOTAL:                    $%9.2f%n", subtotal);

        if (descuento > 0) {
            System.out.printf("DESCUENTO (%2.0f%%)            -$%9.2f%n",
                    (cliente.getDescuento() * 100), descuento);
        }

        System.out.printf("TOTAL A PAGAR:              $%9.2f%n", total);
        System.out.println("=".repeat(60));
        System.out.println("✓ FACTURA GENERADA EXITOSAMENTE");
    }
}