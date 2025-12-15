package co.edu.sena;


public class Producto {

    // ATRIBUTOS PROTECTED (compartidos con subclases)
    protected String codigo;
    protected String nombre;
    protected String marca;
    protected double precio;
    protected int stock;
    protected String categoria;

    // CONSTRUCTOR COMPLETO
    public Producto(String codigo, String nombre, String marca,
                    double precio, int stock, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    // MÉTODO 1: Calcular valor total del inventario (puede ser heredado)
    public double calcularValorInventario() {
        return precio * stock;
    }

    // MÉTODO 2: Verificar disponibilidad (puede ser heredado)
    public boolean verificarDisponibilidad(int cantidad) {
        return stock >= cantidad;
    }

    // MÉTODO 3: Mostrar información básica (para herencia)
    public void mostrarInformacion() {
        System.out.println("📋 INFORMACIÓN DEL PRODUCTO:");
        System.out.println("  Código: " + codigo);
        System.out.println("  Nombre: " + nombre);
        System.out.println("  Marca: " + marca);
        System.out.println("  Precio: $" + precio);
        System.out.println("  Stock: " + stock + " unidades");
        System.out.println("  Categoría: " + categoria);
        System.out.println("  Valor en inventario: $" + calcularValorInventario());
    }

    // Método para actualizar stock
    public void actualizarStock(int cantidad) {
        if (stock + cantidad >= 0) {
            stock += cantidad;
            System.out.println("✅ Stock actualizado: " + nombre +
                    " - Nuevo stock: " + stock);
        } else {
            System.out.println("❌ Error: No se puede reducir el stock por debajo de 0");
        }
    }

    // GETTERS Y SETTERS
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) {
        if (precio > 0) this.precio = precio;
    }

    public int getStock() { return stock; }
    public void setStock(int stock) {
        if (stock >= 0) this.stock = stock;
    }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    @Override
    public String toString() {
        return nombre + " [" + codigo + "] - $" + precio + " - Stock: " + stock;
    }
}