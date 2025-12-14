package co.edu.sena.semana01;

// Proveedor.java
public class Proveedor {
    private String nombre;
    private String productoPrincipal;
    private boolean activo;

    // Constructor
    public Proveedor(String nombre, String productoPrincipal, boolean activo) {
        this.nombre = nombre;
        this.productoPrincipal = productoPrincipal;
        this.activo = activo;
    }

    // MÉTODOS QUE NECESITA Main.java
    public void mostrarinformacionProveedor() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Producto Principal: " + productoPrincipal);
        System.out.println("Activo: " + activo);
    }

    public boolean esProveedorActivo() {
        return activo;
    }

    public String getProductoPrincipal() {
        return productoPrincipal;
    }

    // Getters y Setters adicionales
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}