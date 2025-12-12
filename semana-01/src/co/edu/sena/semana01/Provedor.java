public class Proveedor {
    private String nombre;
    private String contacto;
    private String productoPrincipal;
    private boolean activo;

    public Proveedor(String nombre, String contacto, String productoPrincipal, boolean activo) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.productoPrincipal = productoPrincipal;
        this.activo = activo;
    }

    public void mostrarInformacionProveedor() {
        System.out.println("Proveedor: " + nombre);
        System.out.println("Contacto: " + contacto);
        System.out.println("Producto principal: " + productoPrincipal);
        System.out.println("Estado: " + (activo ? "Activo" : "Inactivo"));
    }

    public boolean esProveedorActivo() {
        return activo;
    }

    public String getProductoPrincipal() {
        return productoPrincipal;
    }
}
