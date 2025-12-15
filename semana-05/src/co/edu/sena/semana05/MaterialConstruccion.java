package co.edu.sena.semana05;

import co.edu.sena.Producto;

/**
 * Subclase 1: MaterialConstruccion
 * Hereda de Producto y agrega características específicas de materiales
 */
public class MaterialConstruccion extends Producto {

    // Atributos específicos de materiales de construcción
    private String unidadMedida;  // Ej: kg, m3, unidad
    private String tipoMaterial;  // Ej: Cemento, Arena, Ladrillo
    private boolean esPesado;
    private String usoRecomendado; // Ej: Estructural, Acabados

    // Constructor
    public MaterialConstruccion(String codigo, String nombre, String marca,
                                double precio, int stock, String categoria,
                                String unidadMedida, String tipoMaterial,
                                boolean esPesado, String usoRecomendado) {
        // Llamar al constructor de la clase padre
        super(codigo, nombre, marca, precio, stock, categoria);

        // Inicializar atributos específicos
        this.unidadMedida = unidadMedida;
        this.tipoMaterial = tipoMaterial;
        this.esPesado = esPesado;
        this.usoRecomendado = usoRecomendado;
    }

    // Método específico 1: Calcular peso estimado
    public double calcularPesoEstimado() {
        double pesoPorUnidad = 0;

        switch (tipoMaterial.toLowerCase()) {
            case "cemento":
                pesoPorUnidad = 50; // kg por bulto
                break;
            case "arena":
                pesoPorUnidad = 1600; // kg por m3
                break;
            case "ladrillo":
                pesoPorUnidad = 2.5; // kg por unidad
                break;
            case "grava":
                pesoPorUnidad = 1800; // kg por m3
                break;
            default:
                pesoPorUnidad = 1; // kg por defecto
        }

        return stock * pesoPorUnidad;
    }

    // Método específico 2: Verificar si requiere equipo especial para manejo
    public String requerimientosManejo() {
        if (esPesado) {
            return "⚠️ Requiere equipo especial: montacargas o carretilla";
        } else {
            return "✅ Puede manipularse manualmente";
        }
    }

    // Sobrescribir método del padre
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion(); // Llamar método del padre
        System.out.println("  Unidad de medida: " + unidadMedida);
        System.out.println("  Tipo de material: " + tipoMaterial);
        System.out.println("  Uso recomendado: " + usoRecomendado);
        System.out.println("  Es pesado: " + (esPesado ? "Sí" : "No"));
        System.out.println("  Peso estimado total: " + calcularPesoEstimado() + " kg");
        System.out.println("  " + requerimientosManejo());
    }

    // GETTERS Y SETTERS específicos
    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida; }

    public String getTipoMaterial() { return tipoMaterial; }
    public void setTipoMaterial(String tipoMaterial) { this.tipoMaterial = tipoMaterial; }

    public boolean isEsPesado() { return esPesado; }
    public void setEsPesado(boolean esPesado) { this.esPesado = esPesado; }

    public String getUsoRecomendado() { return usoRecomendado; }
    public void setUsoRecomendado(String usoRecomendado) { this.usoRecomendado = usoRecomendado; }
}