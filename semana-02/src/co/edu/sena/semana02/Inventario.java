import java.util.ArrayList;

public class Inventario {
    // RELACIÓN DE COMPOSICIÓN: El inventario contiene productos
    private ArrayList<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    // Método para agregar producto (composición)
    public void agregarProducto(Producto producto) {
        if (producto != null && !productos.contains(producto)) {
            productos.add(producto);
            System.out.println("✓ Producto agregado al inventario: " + producto.getNombre());
        }
    }

    // Método para buscar producto por nombre
    public Producto buscarProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    // Método para listar productos por categoría
    public ArrayList<Producto> listarProductosPorCategoria(String categoria) {
        ArrayList<Producto> resultados = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                resultados.add(producto);
            }
        }
        return resultados;
    }

    // Método para actualizar stock después de una venta
    public boolean actualizarStock(String nombreProducto, int cantidadVendida) {
        Producto producto = buscarProducto(nombreProducto);
        if (producto != null && producto.getCantidadStock() >= cantidadVendida) {
            producto.setCantidadStock(producto.getCantidadStock() - cantidadVendida);
            System.out.println("✓ Stock actualizado: " + producto.getNombre() +
                    " - Nuevo stock: " + producto.getCantidadStock());
            return true;
        }
        return false;
    }

    // Método para mostrar reporte de inventario
    public void mostrarReporteInventario() {
        System.out.println("\n=== REPORTE DE INVENTARIO ===");
        System.out.println("Total de productos: " + productos.size());

        // Calcular valor total del inventario
        double valorTotal = 0;
        for (Producto producto : productos) {
            valorTotal += producto.calcularValorTotalStock();
        }
        System.out.printf("Valor total del inventario: $%.2f%n", valorTotal);

        // Mostrar productos por categoría
        System.out.println("\nProductos por categoría:");
        System.out.println("-".repeat(40));

        ArrayList<String> categorias = new ArrayList<>();
        for (Producto producto : productos) {
            if (!categorias.contains(producto.getCategoria())) {
                categorias.add(producto.getCategoria());
            }
        }

        for (String categoria : categorias) {
            int contador = 0;
            double valorCategoria = 0;

            for (Producto producto : productos) {
                if (producto.getCategoria().equals(categoria)) {
                    contador++;
                    valorCategoria += producto.calcularValorTotalStock();
                }
            }

            System.out.printf("%-15s: %2d productos - Valor: $%8.2f%n",
                    categoria, contador, valorCategoria);
        }
    }

    // GETTERS
    public ArrayList<Producto> getProductos() {
        return new ArrayList<>(productos); // Devuelve copia para proteger encapsulamiento
    }

    public int getCantidadProductos() {
        return productos.size();
    }
}