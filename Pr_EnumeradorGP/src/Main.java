import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Producto> products = new ArrayList<Producto>();

        // Solicitar datos de productos
        for (int i = 0; i < 3; i++) {
            System.out.println("Nombre del producto: ");
            String nombre = sc.next();
            System.out.println("Precio del producto: ");
            double precio = sc.nextDouble();
            System.out.println("Categoria del producto (ELECTRONICA, ROPA, ALIMENTOS):");
            Categoria categoria = Categoria.valueOf(sc.next().toUpperCase());
            products.add(new Producto(nombre, precio, categoria));
        }

        // Imprimir todos los productos
        for (Producto pr : products) {
            System.out.println(pr.getNombre() + ", " + pr.getPrecio() + ", " + pr.getCategoria());
        }

        boolean choose = true;
        while (choose) {
            System.out.println("¿Cuál categoría? (ELECTRONICA, ROPA, ALIMENTOS) o escribe 'salir' para terminar:");
            String cat = sc.next();
            if (cat.equalsIgnoreCase("salir")) {
                choose = false;
                continue;
            }

            try {
                Categoria selectedCategory = Categoria.valueOf(cat.toUpperCase());
                imprimirPorCategoria(products, selectedCategory);
            } catch (IllegalArgumentException e) {
                System.out.println("Categoría no válida. Por favor, intenta de nuevo.");
            }
        }

        sc.close();
    }

    // Método para imprimir productos por categoría
    private static void imprimirPorCategoria(ArrayList<Producto> products, Categoria categoria) {
        System.out.println("Productos en la categoría " + categoria + ":");
        boolean found = false;
        for (Producto pr : products) {
            if (pr.getCategoria() == categoria) {
                System.out.println(pr.getNombre() + ", " + pr.getPrecio());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No se encontraron productos en esta categoría.");
        }
    }
}