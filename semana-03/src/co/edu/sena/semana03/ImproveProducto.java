package co.edu.sena.semana03;

public class ImproveProducto {
    // Atributos
    private String nombre;
    private String categoria;
    private double precio;
    private int cantidadStock;

    // Constructor
    public ImproveProducto(String nombre, String categoria, double precio, int cantidadStock) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
    }

    // MÉTODO QUE FALTA - AÑADE ESTE MÉTODO
    public double calcularValorTotalStock() {
        return this.precio * this.cantidadStock;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - $%.2f - Stock: %d",
                nombre, categoria, precio, cantidadStock);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ImproveProducto that = (ImproveProducto) obj;
        return nombre.equalsIgnoreCase(that.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.toLowerCase().hashCode();
    }
}