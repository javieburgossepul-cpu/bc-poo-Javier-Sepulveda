package co.edu.sena.semana04;

public class Main {
    public static void main(String[] args) {
        System.out.println("FERRETERÍA CONSTRUYE FÁCIL\n");

        // 1. Crear un material
        MaterialConstruccion cemento = new MaterialConstruccion(
                "CEM-001", "Cemento", "Argos",
                30000.0, 100, "Materiales",
                "bulto", "Cemento", true, "Construcción"
        );

        // 2. Crear una herramienta
        Herramienta martillo = new Herramienta(
                "MAR-001", "Martillo", "Stanley",
                40000.0, 30, "Herramientas",
                "Manual", "1 año", "Acero", false
        );

        // 3. Mostrar información
        System.out.println("=== PRODUCTO 1 ===");
        cemento.mostrarInformacion();

        System.out.println("\n=== PRODUCTO 2 ===");
        martillo.mostrarInformacion();

        // 4. Calcular valores
        System.out.println("\n=== VALORES ===");
        System.out.println("Valor cemento: $" + cemento.calcularValorInventario());
        System.out.println("Valor martillo: $" + martillo.calcularValorInventario());

        // 5. Verificar disponibilidad
        System.out.println("\n=== DISPONIBILIDAD ===");
        System.out.println("¿Hay 50 bultos de cemento? " + cemento.verificarDisponibilidad(50));
        System.out.println("¿Hay 40 martillos? " + martillo.verificarDisponibilidad(40));
    }
}