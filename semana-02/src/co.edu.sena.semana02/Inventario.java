package co.edu.sena.semana02;

import java.util.ArrayList;

public class Inventario {
    private final ArrayList<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        if (producto != null && !productos.contains(producto)) {
            productos.add(producto);
        }
    }

    public Producto buscarProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public void mostrarReporteInventario() {
        System.out.println("\n=== REPORTE DE INVENTARIO ===");
        System.out.println("Total de productos: " + productos.size());

        java.util.HashMap<String, Integer> categorias = new java.util.HashMap<>();
        for (Producto producto : productos) {
            String categoria = producto.getCategoria();
            categorias.put(categoria, categorias.getOrDefault(categoria, 0) + 1);
        }

        for (String categoria : categorias.keySet()) {
            System.out.println(categoria + ": " + categorias.get(categoria) + " productos");
        }
    }

    public ArrayList<Producto> getProductos() {
        return new ArrayList<>(productos);
    }

    public int getCantidadProductos() {
        return productos.size();
    }
}
