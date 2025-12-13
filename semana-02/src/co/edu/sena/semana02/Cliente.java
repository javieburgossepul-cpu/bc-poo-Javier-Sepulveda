import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String tipoCliente; // "constructor", "maestro", "particular"
    private String documento;
    private String telefono;
    private boolean clienteFrecuente;
    private double descuento;
    private ArrayList<String> historialCompras;

    public Cliente(String nombre, String tipoCliente, String documento, String telefono, boolean clienteFrecuente) {
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
        this.documento = documento;
        this.telefono = telefono;
        this.clienteFrecuente = clienteFrecuente;
        this.descuento = clienteFrecuente ? 0.10 : 0.0; // 10% descuento si es frecuente
        this.historialCompras = new ArrayList<>();
    }

    // MÉTODO DE NEGOCIO: Calcular precio con descuento
    public double calcularPrecioConDescuento(double precioOriginal) {
        return precioOriginal * (1 - descuento);
    }

    // MÉTODO DE NEGOCIO: Agregar compra al historial
    public void agregarCompra(String descripcionCompra) {
        if (historialCompras.size() >= 10) {
            historialCompras.remove(0); // Mantener solo las últimas 10 compras
        }
        historialCompras.add(descripcionCompra);
    }

    // MÉTODO DE NEGOCIO: Mostrar historial de compras
    public void mostrarHistorialCompras() {
        System.out.println("=== HISTORIAL DE COMPRAS - " + nombre.toUpperCase() + " ===");
        System.out.println("Tipo de cliente: " + tipoCliente);
        System.out.println("Documento: " + documento);
        System.out.println("Cliente frecuente: " + (clienteFrecuente ? "SÍ (10% descuento)" : "NO"));

        if (historialCompras.isEmpty()) {
            System.out.println("No hay compras registradas.");
        } else {
            System.out.println("Últimas compras:");
            for (int i = 0; i < historialCompras.size(); i++) {
                System.out.println((i + 1) + ". " + historialCompras.get(i));
            }
        }
        System.out.println("Total de compras registradas: " + historialCompras.size());
    }

    // GETTERS
    public String getNombre() {
        return nombre;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public boolean isClienteFrecuente() {
        return clienteFrecuente;
    }

    public double getDescuento() {
        return descuento;
    }

    public ArrayList<String> getHistorialCompras() {
        return new ArrayList<>(historialCompras);
    }

    // SETTERS con validaciones
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }

    public void setTipoCliente(String tipoCliente) {
        if (tipoCliente != null && (tipoCliente.equals("constructor") ||
                tipoCliente.equals("maestro") ||
                tipoCliente.equals("particular"))) {
            this.tipoCliente = tipoCliente;
        }
    }

    public void setTelefono(String telefono) {
        if (telefono != null && telefono.matches("\\d{10}")) {
            this.telefono = telefono;
        }
    }

    public void setClienteFrecuente(boolean clienteFrecuente) {
        this.clienteFrecuente = clienteFrecuente;
        this.descuento = clienteFrecuente ? 0.10 : 0.0;
    }
}