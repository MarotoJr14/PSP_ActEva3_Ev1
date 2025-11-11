import java.util.ArrayList;
import java.util.List;

public class Cocina {
    public static void main(String[] args) {
        Object lock = new Object();
        String logFile = "log_pedidos.txt";
        
        List<String> platos = List.of("Paella", "Tortilla de patatas", "Gazpacho", "Ensalada mixta",
            "Croquetas", "Pimientos de Padrón", "Bocadillo de jamón", "Pan con tomate", "Lentejas", "Arroz a la cubana",
            "Pollo al ajillo", "Sopa de ajo", "Calamares a la romana", "Merluza a la plancha", "Huevos rotos",
            "Patatas bravas", "Fabada asturiana", "Cocido madrileño", "Tostada con aceite y tomate", "Churros con chocolate");

        List<Pedido> pedidos = new ArrayList<>();
        int numPedidos = 10 + (int)(Math.random() * 10); // Entre 10 y 20 pedidos
        for (int i = 1; i <= numPedidos; i++) {
            pedidos.add(new Pedido(i, platos.get((int) (Math.random() * platos.size()))));
        }

        List<Cocinero> cocineros = new ArrayList<>();
        int numCocineros = 3 + (int) (Math.random() * 3); // Entre 3 y 5 cocineros
        for (int i = 1; i <= numCocineros; i++) {
            Cocinero cocinero = new Cocinero("Cocinero " + i, pedidos, lock, logFile);
            cocinero.start();
            cocineros.add(cocinero);
        }

        for (Cocinero cocinero : cocineros) {
            try {
                cocinero.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Todos los pedidos han sido procesados.");
    }
}