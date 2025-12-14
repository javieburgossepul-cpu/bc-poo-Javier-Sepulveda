package co.edu.sena.semana02;

public class Producto {
    private String nombre;
    private String categoria;
    private int cantidadStock;
    private double precio;
    private boolean disponibleVenta;

    public Producto(String nombre, String categoria, int cantidadStock,
                    double precio, boolean disponibleVenta) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidadStock = cantidadStock;
        this.precio = precio;
        this.disponibleVenta = disponibleVenta;
    }

    public void imprimirInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Categoría: " + categoria);
        System.out.println("Stock: " + cantidadStock + " unidades");
        System.out.println("Precio: $" + precio);
        System.out.println("Disponible para venta: " + (disponibleVenta ? "Sí" : "No"));
    }

    public double calcularValorTotalStock() {
        return cantidadStock * precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isDisponibleVenta() {
        return disponibleVenta;
    }

    public void setPrecio(double nuevoPrecio) {
        if (nuevoPrecio > 0) {
            this.precio = nuevoPrecio;
        }
    }

    public void setCantidadStock(int cantidadStock) {
        if (cantidadStock >= 0) {
            this.cantidadStock = cantidadStock;
        }
    }
}