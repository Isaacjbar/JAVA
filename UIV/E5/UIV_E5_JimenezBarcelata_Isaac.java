package E5;
public class UIV_E5_JimenezBarcelata_Isaac { 

    public static void main(String[] args) {

        // Crear y llenar la cola de productos para Erick
        Queue<Producto> cosasErick = new Queue<>();
        Producto producto1 = new Producto("Chips jalapeño", 20.0);
        Producto producto2 = new Producto("Ameyal Fresa Kiwi", 21.0);

        cosasErick.offer(producto1);
        cosasErick.offer(producto2);

        Cliente erick = new Cliente("Erick", cosasErick);
        erick.setTiempo(5); // Establece el tiempo de atención para Erick

        // Crear y llenar la cola de productos para Vanessa
        Queue<Producto> cosasVane = new Queue<>();
        Producto producto1Vane = new Producto("Cheetos", 20.0);
        Producto producto2Vane = new Producto("Coca", 15.0);

        cosasVane.offer(producto1Vane);
        cosasVane.offer(producto2Vane);

        Cliente vane = new Cliente("Vanessa", cosasVane);
        vane.setTiempo(5);

        // Crear y llenar la cola de productos para Pablo
        Queue<Producto> cosasPablo = new Queue<>();
        Producto producto1Pablo = new Producto("1 / 2 kilo de huevo", 100.0);
        Producto producto2Pablo = new Producto("1 / 4 de jamón", 21.0);
        Producto producto3Pablo = new Producto("Jarrito tutifruti", 18.0);

        cosasPablo.offer(producto1Pablo);
        cosasPablo.offer(producto2Pablo);
        cosasPablo.offer(producto3Pablo);

        Cliente pablo = new Cliente("Pablo", cosasPablo);
        pablo.setTiempo(10);

        // Cola de clientes para el proceso de pago
        Queue<Cliente> filaPago = new Queue<>();
        filaPago.offer(erick);
        filaPago.offer(vane);
        filaPago.offer(pablo);

        // Procesar las compras
        while (!filaPago.isEmpty()) {
            Cliente clienteActual = filaPago.peek();
            System.out.println("Atendiendo: " + clienteActual.getNombre());
            try {
                // Simula el proceso de cobro
                Thread.sleep(clienteActual.getTiempo() * 1000);

                // Calcula el total a pagar
                Queue<Producto> productos = clienteActual.getCarrito();
                double total = 0;

                while (!productos.isEmpty()) {
                    total += productos.poll().getPrecio();
                }
                System.out.println("Se cobró la cantidad de " + total);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Ya se atendió a " + filaPago.poll().getNombre());
        }
    }
}
