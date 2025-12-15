package co.edu.sena.semana05;

public class Herramienta extends Producto {
    private String tipoHerramienta; // Manual, Eléctrica, Medición
    private String garantia;        // 1 año, 2 años, etc.
    private boolean requiereElectricidad;

    // CONSTRUCTOR
    public Herramienta(String codigo, String nombre, String marca,
                       double precio, int stock, String categoria,
                       String tipoHerramienta, String garantia,
                       boolean requiereElectricidad) {
        super(codigo, nombre, marca, precio, stock, categoria);
        this.tipoHerramienta = tipoHerramienta;
        this.garantia = garantia;
        this.requiereElectricidad = requiereElectricidad;
    }

    // === EJERCICIO 2: SOBRESCRITURA DE MÉTODOS CON @Override ===
    @Override
    public void mostrarDetalles() {
        System.out.println("🔧 HERRAMIENTA");
        System.out.println("  Código: " + codigo);
        System.out.println("  Nombre: " + nombre);
        System.out.println("  Tipo: " + tipoHerramienta);
        System.out.println("  Garantía: " + garantia);
        System.out.println("  Requiere electricidad: " + (requiereElectricidad ? "Sí" : "No"));
        System.out.println("  Precio: $" + precio);
        System.out.println("  Stock: " + stock + " unidades");
        System.out.println("  Valor total: $" + calcularValorTotal());
    }

    @Override
    public double calcularValorTotal() {
        // Para herramientas eléctricas, agregar un 5% por costo de mantenimiento
        double valorBase = precio * stock;
        if (requiereElectricidad) {
            return valorBase * 1.05;
        }
        return valorBase;
    }

    @Override
    public String getTipoProducto() {
        return "Herramienta " + (requiereElectricidad ? "Eléctrica" : "Manual");
    }

    // === SOBRECARGA ADICIONAL (Ejercicio 1) ===
    // MÉTODO 1: Aplicar descuento por temporada
    public void aplicarDescuentoTemporada(double porcentaje) {
        if (porcentaje > 0 && porcentaje <= 30) {
            aplicarDescuento(porcentaje);
            System.out.println("✅ Descuento de temporada aplicado");
        }
    }

    // MÉTODO 2 SOBRECARGADO: Aplicar descuento por temporada con límite
    public void aplicarDescuentoTemporada(double porcentaje, double precioMinimo) {
        if (precio >= precioMinimo && porcentaje > 0 && porcentaje <= 30) {
            aplicarDescuento(porcentaje);
            System.out.println("✅ Descuento de temporada aplicado (precio mínimo cumplido)");
        }
    }

    // SOBRESCRITURA adicional
    @Override
    public boolean estaDisponible(int cantidad) {
        boolean disponible = super.estaDisponible(cantidad);
        if (requiereElectricidad && disponible) {
            System.out.println("⚠️  Recuerde: Esta herramienta requiere conexión eléctrica");
        }
        return disponible;
    }

    // GETTERS específicos
    public String getTipoHerramienta() { return tipoHerramienta; }
    public String getGarantia() { return garantia; }
    public boolean isRequiereElectricidad() { return requiereElectricidad; }

    @Override
    public String toString() {
        String electrico = requiereElectricidad ? "Eléctrica" : "Manual";
        return super.toString() + " - " + tipoHerramienta + " (" + electrico + ")";
    }
}