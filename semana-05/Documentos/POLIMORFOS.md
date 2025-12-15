# 📊 **POLIMORFISMO - Ferretería "Construye Fácil"**

## **1. SOBRECARGA**
**Métodos:**
- `buscarProducto(String codigo)` - Por código único
- `buscarProducto(String nombre, boolean porNombre)` - Por nombre
- `buscarProducto(double precioMin, double precioMax)` - Por rango de precios

**Justificación:**
Permite diferentes formas de buscar productos según la necesidad del cliente: código para búsqueda rápida, nombre para productos conocidos, rango de precios para clientes con presupuesto. Los vendedores atienden consultas variadas en una ferretería.

---

## **2. SOBRESCRITURA**
**Métodos con @Override:**
- `mostrarDetalles()` - Información específica por tipo de producto
- `calcularValorTotal()` - Cálculo según características del producto
- `getTipoProducto()` - Descripción específica del producto

**Tabla Comparativa:**

| Método | Producto (Padre) | MaterialConstrucción | Herramienta |
|--------|------------------|----------------------|-------------|
| `mostrarDetalles()` | Info básica | + unidad medida/tipo | + garantía/tipo herramienta |
| `calcularValorTotal()` | Precio × stock | Precio × stock | (Precio × stock) × 1.05 si eléctrica |
| `getTipoProducto()` | Tipo genérico | "Material - [tipo]" | "Herramienta [Manual/Eléctrica]" |

Cada tipo de producto muestra información relevante para su categoría en la ferretería.

---

## **3. POLIMORFISMO DINÁMICO**
**Ejemplo:** Inventario que almacena `Producto` (clase padre) con materiales y herramientas. Al llamar `mostrarDetalles()` para cada producto, Java decide en tiempo de ejecución si mostrar detalles de material o herramienta.

**Funcionamiento:**
1. **Compilación:** Verifica que todos los productos tengan los métodos requeridos
2. **Ejecución:** JVM identifica si es material o herramienta y ejecuta la versión correcta

Permite gestionar un inventario diverso con un solo sistema, mostrando información apropiada para cada tipo.

---

## **4. BENEFICIOS**
**Ventajas con polimorfismo:**
- ✅ Inventario unificado de todos como `Producto`
- ✅ Fácil agregar nuevos tipos (pinturas, eléctricos)
- ✅ Mantenimiento centralizado
- ✅ Información específica para cada categoría
- ✅ Flexibilidad para productos con múltiples usos

**Dificultades sin polimorfismo:**
- ❌ Inventarios separados para cada tipo
- ❌ Código duplicado para operaciones similares
- ❌ Modificaciones manuales en múltiples lugares
- ❌ Rigidez para nuevos productos
- ❌ Procesamiento complejo de ventas mixtas