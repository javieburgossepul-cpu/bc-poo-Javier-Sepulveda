package co.edu.sena.semana05;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

    // CONSTRUCTOR
    public Inventario() {
        this.productos = new ArrayList<>();
    }

    // === EJERCICIO 3: MÉTODOS POLIMÓRFICOS ===

    // MÉTODO 1: Agregar cualquier producto (acepta clase padre)
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        System.out.println("✅ Producto agregado: " + producto.getNombre());
    }

    // MÉTODO 2: Calcular valor total del inventario (polimórfico)
    public double calcularValorTotalInventario() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.calcularValorTotal(); // Llamada polimórfica
        }
        return total;
    }

    // MÉTODO 3: Mostrar todos los productos (polimórfico)
    public void mostrarTodosProductos() {
        System.out.println("\n📋 INVENTARIO COMPLETO:");
        System.out.println("-".repeat(50));
        for (Producto producto : productos) {
            producto.mostrarDetalles(); // Llamada polimórfica
            System.out.println();
        }
    }

    // MÉTODO 4: Buscar productos por categoría (polimórfico)
    public List<Producto> buscarPorCategoria(String categoria) {
        List<Producto> resultados = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                resultados.add(producto);
            }
        }
        return resultados;
    }

    // MÉTODO 5: Actualizar precios con descuento (polimórfico)
    public void aplicarDescuentoGeneral(double porcentaje) {
        System.out.println("\n🎯 APLICANDO DESCUENTO DEL " + porcentaje + "% A TODO EL INVENTARIO:");
        for (Producto producto : productos) {
            System.out.print("  " + producto.getNombre() + ": ");
            producto.aplicarDescuento(porcentaje); // Llamada polimórfica
        }
    }

    // === MÉTODOS DE BÚSQUEDA SOBRECARGADOS (Ejercicio 1) ===
    // MÉTODO 1: Buscar por código
    public Producto buscarProducto(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    // MÉTODO 2 SOBRECARGADO: Buscar por nombre (puede haber varios)
    public List<Producto> buscarProducto(String nombre, boolean porNombre) {
        List<Producto> resultados = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    // MÉTODO 3 SOBRECARGADO: Buscar por rango de precios
    public List<Producto> buscarProducto(double precioMin, double precioMax) {
        List<Producto> resultados = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getPrecio() >= precioMin && p.getPrecio() <= precioMax) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    // GETTER
    public List<Producto> getProductos() { return productos; }
    public int getCantidadProductos() { return productos.size(); }
}