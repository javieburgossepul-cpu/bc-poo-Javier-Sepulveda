package co.edu.sena.semana01;

// Main.java
public class Main {
    public static void main(String[] args) {
        // Crear objetos Proveedor
        Proveedor proveedor1 = new Proveedor("Distribuidora XYZ", "Tornillos", true);
        Proveedor proveedor2 = new Proveedor("Materiales ABC", "Pintura", false);

        System.out.println("=== Proveedor 1 ===");
        proveedor1.mostrarinformacionProveedor();
        System.out.println("¿Está activo? " + proveedor1.esProveedorActivo());
        System.out.println("Producto principal: " + proveedor1.getProductoPrincipal());

        System.out.println("\n=== Proveedor 2 ===");
        proveedor2.mostrarinformacionProveedor();
        System.out.println("¿Está activo? " + proveedor2.esProveedorActivo());
        System.out.println("Producto principal: " + proveedor2.getProductoPrincipal());
    }
}