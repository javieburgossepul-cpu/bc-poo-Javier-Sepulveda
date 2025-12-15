package co.edu.sena.semana05;

public abstract class Producto {
    protected String codigo;
    protected String nombre;
    protected String marca;
    protected double precio;
    protected int stock;
    protected String categoria;

    // CONSTRUCTOR
    public Producto(String codigo, String nombre, String marca,
                    double precio, int stock, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    // === EJERCICIO 1: SOBRECARGA DE MÉTODOS ===
    // MÉTODO 1 SOBRECARGADO: Aplicar descuento por porcentaje
    public void aplicarDescuento(double porcentaje) {
        if (porcentaje > 0 && porcentaje <= 50) {
            double descuento = this.precio * (porcentaje / 100);
            this.precio -= descuento;
            System.out.println("Descuento del " + porcentaje + "% aplicado");
        }
    }

    // MÉTODO 2 SOBRECARGADO: Aplicar descuento por monto fijo
    public void aplicarDescuento(int montoFijo) {
        if (montoFijo > 0 && montoFijo < this.precio) {
            this.precio -= montoFijo;
            System.out.println("Descuento de $" + montoFijo + " aplicado");
        }
    }

    // MÉTODO 3 SOBRECARGADO: Actualizar stock básico
    public void actualizarStock(int cantidad) {
        if (this.stock + cantidad >= 0) {
            this.stock += cantidad;
        }
    }

    // MÉTODO 4 SOBRECARGADO: Actualizar stock con motivo
    public void actualizarStock(int cantidad, String motivo) {
        if (this.stock + cantidad >= 0) {
            this.stock += cantidad;
            System.out.println("Stock actualizado por: " + motivo);
        }
    }

    // === MÉTODOS ABSTRACTOS PARA SOBRESCRITURA ===
    public abstract void mostrarDetalles();
    public abstract double calcularValorTotal();
    public abstract String getTipoProducto();

    // === MÉTODOS COMUNES ===
    public double calcularValorInventario() {
        return this.precio * this.stock;
    }

    public boolean estaDisponible(int cantidad) {
        return this.stock >= cantidad;
    }

    // GETTERS y SETTERS
    public String getCodigo() { return this.codigo; }
    public String getNombre() { return this.nombre; }
    public String getMarca() { return this.marca; }
    public double getPrecio() { return this.precio; }
    public int getStock() { return this.stock; }
    public String getCategoria() { return this.categoria; }

    public void setPrecio(double precio) {
        if (precio > 0) this.precio = precio;
    }

    public void setStock(int stock) {
        if (stock >= 0) this.stock = stock;
    }

    @Override
    public String toString() {
        return this.nombre + " [" + this.codigo + "] - $" + this.precio + " - Stock: " + this.stock;
    }
}