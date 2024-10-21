import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Producto> products = new ArrayList<Producto>();

        // Solicitar datos de productos
        for (int i = 0; i < 6; i++) {
            System.out.println("["+(i+1)+"]");
            System.out.println("Nombre del producto: ");
            String nombre = sc.next();
            System.out.println("Precio del producto: ");
            double precio = sc.nextDouble();
            System.out.println("Teclea (1) ELECTRONICA, (2) ROPA, (3) ALIMENTOS: ");
            int nu = sc.nextInt();
            Categoria categoria = Categoria.ELECTRONICA;
            switch (nu) {
                case 1:
                    categoria = Categoria.ELECTRONICA;
                    break;
                case 2:
                    categoria = Categoria.ROPA;
                    break;
                case 3:
                    categoria = Categoria.ALIMENTOS;
                    break;
                default:
                    break;
            }
            products.add(new Producto(nombre, precio, categoria));
        }
        System.out.println("Productos creados");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).toString());
        }
        System.out.println("\n-------------------------------------");
        int ch = 1;
        while(ch==1){
            System.out.println("Buscar por categoria");
            System.out.println("Teclea (1) ELECTRONICA, (2) ROPA, (3) ALIMENTOS: ");
            int nu = sc.nextInt();

            for(Producto p : products){
                Categoria c = p.getCategoria();

                if(c==Categoria.ELECTRONICA&&nu==1){
                    System.out.println(p.toString());
                } else if (c==Categoria.ROPA&&nu==2){
                    System.out.println(p.toString());
                } else if(c==Categoria.ALIMENTOS&&nu==3){
                    System.out.println(p.toString());
                }

            }

            System.out.println("(1) Repetir, (2) Salir");
            ch = sc.nextInt();
        }

    }
}