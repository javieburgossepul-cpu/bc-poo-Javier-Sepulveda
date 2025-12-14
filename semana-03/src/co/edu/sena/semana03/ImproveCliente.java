package co.edu.sena.semana03;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class ImproveCliente {
    private String nombre;
    private String tipoCliente;
    private String documento;
    private String telefono;
    private String email;
    private boolean clienteFrecuente;
    private double descuento;
    private ArrayList<String> historialCompras;

    // CONSTRUCTORES con validaciones
    public ImproveCliente(String nombre, String tipoCliente, String documento,
                          String telefono, String email, boolean clienteFrecuente) {
        setNombre(nombre);
        setTipoCliente(tipoCliente);
        setDocumento(documento);
        setTelefono(telefono);
        setEmail(email);
        setClienteFrecuente(clienteFrecuente);
        this.historialCompras = new ArrayList<>();
        System.out.println("✓ Cliente creado: " + nombre);
    }

    public ImproveCliente(String nombre, String documento, String telefono, String email) {
        this(nombre, "particular", documento, telefono, email, false);
    }

    // MÉTODOS AUXILIARES PRIVADOS para validaciones
    private boolean validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        if (nombre.length() < 3 || nombre.length() > 100) {
            throw new IllegalArgumentException("El nombre debe tener entre 3 y 100 caracteres");
        }
        // Validar que solo contenga letras y espacios
        if (!Pattern.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$", nombre.trim())) {
            throw new IllegalArgumentException("El nombre solo puede contener letras y espacios");
        }
        return true;
    }

    private boolean validarTipoCliente(String tipoCliente) {
        if (tipoCliente == null || tipoCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de cliente no puede ser nulo o vacío");
        }
        String[] tiposValidos = {"constructor", "maestro", "particular", "empresa", "gobierno"};
        for (String tipoValido : tiposValidos) {
            if (tipoValido.equalsIgnoreCase(tipoCliente.trim())) {
                return true;
            }
        }
        throw new IllegalArgumentException("Tipo de cliente no válido. Use: " + String.join(", ", tiposValidos));
    }

    private boolean validarDocumento(String documento) {
        if (documento == null || documento.trim().isEmpty()) {
            throw new IllegalArgumentException("El documento no puede ser nulo o vacío");
        }
        // Validar formato según tipo de documento
        documento = documento.trim();

        // Cédula colombiana (8-10 dígitos)
        if (Pattern.matches("^\\d{8,10}$", documento)) {
            return true;
        }
        // NIT colombiano (9-10 dígitos con guión)
        if (Pattern.matches("^\\d{9,10}-\\d$", documento)) {
            return true;
        }
        // Pasaporte (letras y números)
        if (Pattern.matches("^[A-Z0-9]{6,12}$", documento.toUpperCase())) {
            return true;
        }

        throw new IllegalArgumentException("Formato de documento inválido. Use: Cédula (8-10 dígitos), NIT (XXXXXXX-X) o Pasaporte");
    }

    private boolean validarTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new IllegalArgumentException("El teléfono no puede ser nulo o vacío");
        }
        telefono = telefono.trim();

        // Teléfono colombiano: 10 dígitos, empezando por 3
        if (!Pattern.matches("^3\\d{9}$", telefono)) {
            throw new IllegalArgumentException("Formato de teléfono inválido. Use 10 dígitos empezando con 3 (ej: 3112223333)");
        }
        return true;
    }

    private boolean validarEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El email no puede ser nulo o vacío");
        }
        email = email.trim().toLowerCase();

        // Expresión regular para validar email
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (!Pattern.matches(regex, email)) {
            throw new IllegalArgumentException("Formato de email inválido. Use: usuario@dominio.com");
        }

        // Validar dominios comunes
        String[] dominiosValidos = {".com", ".co", ".org", ".net", ".edu", ".gov"};
        boolean dominioValido = false;
        for (String dominio : dominiosValidos) {
            if (email.endsWith(dominio)) {
                dominioValido = true;
                break;
            }
        }

        if (!dominioValido) {
            throw new IllegalArgumentException("Dominio de email no válido. Use dominios como: .com, .co, .org, etc.");
        }

        return true;
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

    public String getEmail() {
        return email;
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
        if (validarNombre(nombre)) {
            this.nombre = nombre.trim();
        }
    }

    public void setTipoCliente(String tipoCliente) {
        if (validarTipoCliente(tipoCliente)) {
            this.tipoCliente = tipoCliente.toLowerCase();
        }
    }

    public void setDocumento(String documento) {
        if (validarDocumento(documento)) {
            this.documento = documento.trim();
        }
    }

    public void setTelefono(String telefono) {
        if (validarTelefono(telefono)) {
            this.telefono = telefono.trim();
        }
    }

    public void setEmail(String email) {
        if (validarEmail(email)) {
            this.email = email.trim().toLowerCase();
        }
    }

    public void setClienteFrecuente(boolean clienteFrecuente) {
        this.clienteFrecuente = clienteFrecuente;
        this.descuento = clienteFrecuente ? 0.10 : 0.0;
    }

    // MÉTODOS de negocio
    public void mostrarInformacion() {
        System.out.println("=== INFORMACIÓN DEL CLIENTE ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Tipo: " + tipoCliente);
        System.out.println("Documento: " + documento);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Email: " + email);
        System.out.println("Cliente frecuente: " + (clienteFrecuente ? "Sí (" + (descuento*100) + "% descuento)" : "No"));
        System.out.println("Compras registradas: " + historialCompras.size());
    }

    public void agregarCompra(String compra) {
        historialCompras.add(compra);
    }
}