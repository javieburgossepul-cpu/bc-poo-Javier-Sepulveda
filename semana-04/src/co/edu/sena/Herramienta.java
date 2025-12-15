package co.edu.sena;

/**
 * Subclase 2: Herramienta
 * Hereda de Producto y agrega características específicas de herramientas
 */
public class Herramienta extends Producto {

    // Atributos específicos de herramientas
    private String tipoHerramienta;
    private String garantia;
    private String materialConstruccion;
    private boolean requiereElectricidad;

    // Constructor
    public Herramienta(String codigo, String nombre, String marca,
                       double precio, int stock, String categoria,
                       String tipoHerramienta, String garantia,
                       String materialConstruccion, boolean requiereElectricidad) {
        // Llamar al constructor de la clase padre
        super(codigo, nombre, marca, precio, stock, categoria);

        // Inicializar atributos específicos
        this.tipoHerramienta = tipoHerramienta;
        this.garantia = garantia;
        this.materialConstruccion = materialConstruccion;
        this.requiereElectricidad = requiereElectricidad;
    }

    // Método específico 1: Aplicar descuento por temporada
    public void aplicarDescuentoTemporada(double porcentaje) {
        if (porcentaje > 0 && porcentaje <= 30) {
            double precioOriginal = getPrecio();
            double nuevoPrecio = precioOriginal * (1 - porcentaje / 100);
            setPrecio(nuevoPrecio);
            System.out.println("🎯 Descuento aplicado: " + nombre);
            System.out.println("   Precio original: $" + precioOriginal);
            System.out.println("   Precio con " + porcentaje + "% descuento: $" + nuevoPrecio);
        } else {
            System.out.println("❌ Porcentaje de descuento no válido (0-30%)");
        }
    }

    // Método específico 2: Verificar si necesita mantenimiento
    public String necesitaMantenimiento() {
        if (tipoHerramienta.equalsIgnoreCase("eléctrica")) {
            return "🔌 Requiere mantenimiento eléctrico cada 6 meses";
        } else if (tipoHerramienta.equalsIgnoreCase("manual") &&
                (materialConstruccion.equalsIgnoreCase("acero") ||
                        materialConstruccion.equalsIgnoreCase("metal"))) {
            return "🛠️ Requiere lubricación y limpieza periódica";
        } else {
            return "✅ Mantenimiento básico según uso";
        }
    }

    // Sobrescribir método del padre
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion(); // Llamar método del padre
        System.out.println("  Tipo de herramienta: " + tipoHerramienta);
        System.out.println("  Garantía: " + garantia);
        System.out.println("  Material: " + materialConstruccion);
        System.out.println("  Requiere electricidad: " + (requiereElectricidad ? "Sí" : "No"));
        System.out.println("  " + necesitaMantenimiento());

        // Mostrar advertencia si es eléctrica y no hay stock
        if (requiereElectricidad && getStock() == 0) {
            System.out.println("  ⚠️  ¡AGOTADO! Producto muy solicitado");
        }
    }

    // Sobrescribir método de disponibilidad para herramientas eléctricas
    @Override
    public boolean verificarDisponibilidad(int cantidad) {
        boolean disponible = super.verificarDisponibilidad(cantidad);

        if (requiereElectricidad && disponible) {
            System.out.println("  🔌 Recuerde: Esta herramienta requiere conexión eléctrica");
        }

        return disponible;
    }

    // GETTERS Y SETTERS específicos
    public String getTipoHerramienta() { return tipoHerramienta; }
    public void setTipoHerramienta(String tipoHerramienta) { this.tipoHerramienta = tipoHerramienta; }

    public String getGarantia() { return garantia; }
    public void setGarantia(String garantia) { this.garantia = garantia; }

    public String getMaterialConstruccion() { return materialConstruccion; }
    public void setMaterialConstruccion(String materialConstruccion) { this.materialConstruccion = materialConstruccion; }

    public boolean isRequiereElectricidad() { return requiereElectricidad; }
    public void setRequiereElectricidad(boolean requiereElectricidad) { this.requiereElectricidad = requiereElectricidad; }
}