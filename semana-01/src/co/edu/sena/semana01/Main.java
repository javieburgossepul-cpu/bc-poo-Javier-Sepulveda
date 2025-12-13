

public class Main {
    public static void main(String[] args) {
        System.out.println("=== CONSTRUYE FÁCIL - FERRETERÍA ===");
        System.out.println();

        Producto producto1 = new Producto("Martillo de Acero", "Herramientas", 50, 25.99, true);
        Producto producto2 = new Producto("Cemento Gris 50kg", "Materiales", 120, 32.50, true);

        System.out.println("--- Información de Productos ---");
        producto1.imprimirInformacion();
        System.out.println("Valor total en stock: $" + producto1.calcularValorTotalStock());
        System.out.println();

        producto2.imprimirInformacion();
        System.out.println("Valor total en stock: $" + producto2.calcularValorTotalStock());
        System.out.println();

        producto1.setPrecio(27.50);
        System.out.println("Nuevo precio del martillo: $" + producto1.getNombre() + " - $" + 27.50);
        System.out.println();

        Proveedor proveedor1 = new Proveedor("Materiales S.A.", "311-4567890", "Cemento", true);
        Proveedor proveedor2 = new Proveedor("Herramientas Colombianas", "312-9876543", "Herramientas Manuales", false);

        System.out.println("--- Información de Proveedores ---");
        proveedor1.mostrarInformacionProveedor();
        System.out.println("¿Está activo?: " + proveedor1.esProveedorActivo());
        System.out.println("Producto principal: " + proveedor1.getProductoPrincipal());
        System.out.println();

        proveedor2.mostrarInformacionProveedor();
        System.out.println("¿Está activo?: " + proveedor2.esProveedorActivo());
        System.out.println("Producto principal: " + proveedor2.getProductoPrincipal());
        System.out.println();

        System.out.println("=== FIN DEL PROGRAMA ===");
    }
}