# Mejoras - Semana 03

## Encapsulacion Aplicada

### Clase: ImproveProducto.java

Atributos completamente encapsulados:
- codigoProducto
- nombre
- categoria
- cantidadStock
- precio
- disponibleVenta
- proveedor
- garantiaMeses

Validaciones agregadas:
- Metodo toString() para mostrar informacion basica
- Metodo mostrarInformacionCompleta() para datos detallados
- Metodo calcularValorTotalStock() retorna valor total en inventario
- Validaciones en setters para precios positivos y stock valido

### Clase: ImproveCliente.java

Atributos completamente encapsulados:
- codigoCliente - Codigo unico
- nombreCompleto - Nombre del cliente
- tipoCliente - constructor, maestro, particular, empresa
- documento - NIT o cedula
- telefono - Contacto telefonico
- email - Correo electronico
- clienteFrecuente - Estatus de cliente frecuente
- descuento - Porcentaje de descuento aplicable
- direccion - Direccion para entregas
- fechaRegistro - Fecha de registro en el sistema

Validaciones agregadas:
- Metodo calcularDescuentoAplicable(double monto) calcula descuento
- Metodo mostrarInformacionCliente() imprime informacion completa
- Validacion de formato de email y telefono
- Control de descuentos segun tipo de cliente

### Clase: ImproveVenta.java

Atributos completamente encapsulados:
- numeroFactura - Numero unico de factura
- fechaVenta - Fecha de realizacion
- cliente - Cliente asociado
- productos - Lista de productos vendidos
- cantidades - Cantidades por producto
- subtotal - Total antes de descuentos
- descuentoAplicado - Descuento aplicado
- iva - IVA calculado (19%)
- total - Total a pagar
- metodoPago - Efectivo, tarjeta, transferencia
- vendedor - Nombre del vendedor
- estado - Pagada, pendiente, anulada

Validaciones agregadas:
- Metodo calcularTotales() calcula subtotal, IVA y total
- Metodo generarFactura() imprime factura completa
- Metodo validarStockDisponible() verifica disponibilidad
- Control de estados y transiciones validas

### Clase: ImproveInventario.java

Atributos completamente encapsulados:
- productos - Map de productos organizados por codigo
- categorias - Set de categorias disponibles
- valorTotalInventario - Valor total calculado
- stockMinimo - Stock minimo configurado
- stockMaximo - Stock maximo configurado
- alertasActivas - Lista de alertas de stock

Validaciones agregadas:
- Metodo agregarProducto(ProductoMejorado producto) con validaciones
- Metodo actualizarStock(String codigo, int cantidad) con controles
- Metodo generarReporteInventario() para analisis
- Alertas automaticas de stock bajo

## Constructores Sobrecargados

### Clase: ImproveProducto.java

1. Constructor 1: Constructor por defecto
2. Constructor 2: Constructor con parametros basicos
3. Constructor 3: Constructor completo con todos los parametros

### Clase: ImproveCliente.java

1. Constructor 1: Constructor por defecto
2. Constructor 2: Constructor con parametros basicos
3. Constructor 3: Constructor completo con todos los parametros

### Clase: ImproveVenta.java

1. Constructor 1: Constructor por defecto
2. Constructor 2: Constructor con cliente y metodo de pago
3. Constructor 3: Constructor completo

### Clase: ImproveInventario.java

1. Constructor 1: Constructor por defecto
2. Constructor 2: Constructor con limites de stock personalizados
