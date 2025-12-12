# Semana 01 - Introducción al Paradigma Orientado a Objetos

## 📝 Descripción

En esta semana se crean la clase principal y la clase secundaria de la ferretería "Construye Fácil", especializada en herramientas, materiales de construcción, pinturas y artículos eléctricos.

## 🎯 Objetivos Cumplidos

- [x] Implementar clase principal del dominio (Producto)
- [x] Implementar clase secundaria relacionada (Proveedor)
- [x] Crear programa de demostración funcional
- [x] Documentar análisis del dominio ferretero
- [x] Establecer relación entre objetos del negocio

## 📂 Archivos Entregados

- `src/Producto.java` - Clase principal que representa los artículos de la ferretería
- `src/Proveedor.java` - Clase secundaria que representa a los proveedores
- `src/Main.java` - Programa de demostración que muestra el funcionamiento
- `docs/ANALISIS.md` - Análisis completo del dominio ferretero

## 🛠️ Características Implementadas

### Clase Producto (Principal)
- **Atributos:** nombre, categoría, cantidad en stock, precio, disponibilidad
- **Métodos:** impresión de información, cálculo de valor total, getters y setters
- **Relación:** Representa el inventario de la ferretería

### Clase Proveedor (Secundaria)
- **Atributos:** nombre, contacto, producto principal, estado activo
- **Métodos:** visualización de información, verificación de estado, acceso a datos
- **Relación:** Suministra productos a la ferretería

### Programa Main
- Demostración con 2 productos y 2 proveedores
- Llamada a todos los métodos implementados
- Salida clara y organizada en consola

## 🏗️ Contexto del Dominio

**Negocio:** Ferretería Construye Fácil  
**Ubicación:** Bogotá, Localidad de Fontibón  
**Especialidad:** Herramientas, materiales de construcción, pinturas, eléctricos  
**Clientes:** Constructores, maestros de obra y público en general  
**Empleados:** 12 personas

## 📊 Resultados Esperados

Al ejecutar el programa `Main.java`, se mostrará:
1. Información detallada de los productos
2. Cálculo del valor total en inventario
3. Información de los proveedores
4. Estado de las relaciones comerciales
5. Demostración de modificación de precios

## 🔗 Relaciones Establecidas

- **Producto ←→ Proveedor:** Relación de suministro
- **Cada producto** puede ser suministrado por uno o más proveedores
- **Cada proveedor** puede suministrar múltiples productos
- La categorización permite organización por tipo de artículo

## 📈 Aprendizajes Clave

1. Modelado de objetos reales en clases Java
2. Establecimiento de relaciones entre entidades del negocio
3. Implementación de métodos con propósito específico
4. Uso de tipos de datos apropiados para atributos
5. Creación de programas demostrativos funcionales