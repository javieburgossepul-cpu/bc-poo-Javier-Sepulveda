import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String tipoCliente; // "constructor", "maestro", "particular"
    private String telefono;
    private boolean clienteFrecuente;
    private double descuento;
    private ArrayList<String> comprasRecientes;

    public Cliente(String nombre, String tipoCliente, String telefono, boolean clienteFrecuente) {
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
        this.telefono = telefono;
        this.clienteFrecuente = clienteFrecuente;
        this.descuento = clienteFrecuente ? 0.10 : 0.0; // 10% descuento si es frecuente
        this.comprasRecientes = new ArrayList<>();
    }

    public void agregarCompra(String producto) {
        comprasRecientes.add(producto);
        if (comprasRecientes.size() > 5) {
            comprasRecientes.remove(0); // Mantener solo las 5 más recientes
        }
    }

    public double calcularPrecioConDescuento(double precioOriginal) {
        return precioOriginal * (1 - descuento);
    }

    public void mostrarHistorialCompras() {
        System.out.println("Historial de compras de " + nombre + ":");
        if (comprasRecientes.isEmpty()) {
            System.out.println("  No hay compras registradas.");
        } else {
            for (String compra : comprasRecientes) {
                System.out.println("  - " + compra);
            }
        }
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        if (tipoCliente.equals("constructor") || tipoCliente.equals("maestro") ||
                tipoCliente.equals("particular")) {
            this.tipoCliente = tipoCliente;
        }
    }

    public boolean isClienteFrecuente() {
        return clienteFrecuente;
    }

    public void setClienteFrecuente(boolean clienteFrecuente) {
        this.clienteFrecuente = clienteFrecuente;
        this.descuento = clienteFrecuente ? 0.10 : 0.0;
    }

    public double getDescuento() {
        return descuento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono != null && telefono.matches("\\d{10}")) {
            this.telefono = telefono;
        }
    }
}