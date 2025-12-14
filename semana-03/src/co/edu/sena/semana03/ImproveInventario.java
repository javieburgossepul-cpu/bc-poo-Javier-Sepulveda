package co.edu.sena.semana03;

import java.util.ArrayList;
import java.util.HashMap;

public class ImproveInventario {
    // ATRIBUTO PRIVADO FINAL
    private final ArrayList<ImproveProducto> productos;

    // CONSTRUCTOR
    public ImproveInventario() {
        this.productos = new ArrayList<>();
    }

    // MÉTODOS PÚBLICOS
    public void agregarProducto(ImproveProducto producto) {
        if (producto != null && !productos.contains(producto)) {
            productos.add(producto);
            System.out.println("✓ Producto agregado al inventario: " + producto.getNombre());
        }
    }

    public ImproveProducto buscarProducto(String nombre) {
        for (ImproveProducto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public ArrayList<ImproveProducto> listarProductosPorCategoria(String categoria) {
        ArrayList<ImproveProducto> resultados = new ArrayList<>();
        for (ImproveProducto producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                resultados.add(producto);
            }
        }
        return resultados;
    }

    public boolean actualizarStock(String nombreProducto, int cantidadVendida) {
        ImproveProducto producto = buscarProducto(nombreProducto);
        if (producto != null && producto.getCantidadStock() >= cantidadVendida) {
            producto.setCantidadStock(producto.getCantidadStock() - cantidadVendida);
            System.out.println("✓ Stock actualizado: " + producto.getNombre() +
                    " - Nuevo stock: " + producto.getCantidadStock());
            return true;
        }
        return false;
    }

    public void mostrarReporteInventario() {
        System.out.println("\n=== REPORTE DE INVENTARIO ===");
        System.out.println("Total de productos: " + productos.size());

        double valorTotal = calcularValorTotalInventario();
        System.out.printf("Valor total del inventario: $%.2f%n", valorTotal);

        System.out.println("\nProductos por categoría:");
        System.out.println("-".repeat(40));

        HashMap<String, Integer> contadorCategorias = contarProductosPorCategoria();
        HashMap<String, Double> valorPorCategoria = calcularValorPorCategoria();

        for (String categoria : contadorCategorias.keySet()) {
            System.out.printf("%-15s: %2d productos - Valor: $%8.2f%n",
                    categoria, contadorCategorias.get(categoria), valorPorCategoria.get(categoria));
        }
    }

    // MÉTODOS AUXILIARES PRIVADOS
    private double calcularValorTotalInventario() {
        double total = 0;
        for (ImproveProducto producto : productos) {
            total += producto.calcularValorTotalStock();
        }
        return total;
    }

    private HashMap<String, Integer> contarProductosPorCategoria() {
        HashMap<String, Integer> contador = new HashMap<>();
        for (ImproveProducto producto : productos) {
            String categoria = producto.getCategoria();
            contador.put(categoria, contador.getOrDefault(categoria, 0) + 1);
        }
        return contador;
    }

    private HashMap<String, Double> calcularValorPorCategoria() {
        HashMap<String, Double> valores = new HashMap<>();
        for (ImproveProducto producto : productos) {
            String categoria = producto.getCategoria();
            double valorActual = valores.getOrDefault(categoria, 0.0);
            valores.put(categoria, valorActual + producto.calcularValorTotalStock());
        }
        return valores;
    }

    // GETTERS
    public ArrayList<ImproveProducto> getProductos() {
        return new ArrayList<>(productos);
    }

    public int getCantidadProductos() {
        return productos.size();
    }
}