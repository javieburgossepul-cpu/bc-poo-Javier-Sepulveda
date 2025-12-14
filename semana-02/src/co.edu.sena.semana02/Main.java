package co.edu.sena.semana02;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SEMANA 2 - RELACIONES ENTRE OBJETOS ===\n");
        System.out.println("Ferretería: CONSTRUYE FÁCIL\n");

        // Crear sistema de ferretería
        SistemaFerreteria sistema = new SistemaFerreteria();

        // Ejecutar sistema completo
        sistema.ejecutar();

        System.out.println("\n=== DEMOSTRACIÓN DE RELACIONES ===");
        System.out.println("\n1. COMPOSICIÓN:");
        System.out.println("   - Inventario contiene Productos");
        System.out.println("   - Factura contiene DetalleFactura (clase interna)");
        System.out.println("   - Los detalles no existen sin la factura");

        System.out.println("\n2. AGREGACIÓN:");
        System.out.println("   - Factura usa Venta (pueden existir separadamente)");
        System.out.println("   - Venta usa Cliente y Producto");
        System.out.println("   - Las clases pueden existir independientemente");

        System.out.println("\n3. ASOCIACIÓN:");
        System.out.println("   - Cliente realiza Ventas");
        System.out.println("   - Producto está en Inventario");
        System.out.println("   - Relaciones de uso entre objetos");

        System.out.println("\n=== FIN DE LA SEMANA 2 ===");
    }
}