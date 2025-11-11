import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Cocinero extends Thread {
    private final List<Pedido> pedidos;
    private final Object lock;
    private final String logFile;
    private final String nombre;

    public Cocinero(String nombre, List<Pedido> pedidos, Object lock, String logFile) {
        this.nombre = nombre;
        this.pedidos = pedidos;
        this.lock = lock;
        this.logFile = logFile;
    }

    @Override
    public void run() {
        while (true) {
            Pedido pedido = null;

            synchronized (lock) {
                if (!pedidos.isEmpty()) {
                    pedido = pedidos.remove(0);
                } else {
                    break;
                }
            }

            if (pedido != null) {
                prepararPedido(pedido);
            }

            synchronized (lock) {
                registrarLog(pedido);
            }   
        }
    }

    private void prepararPedido(Pedido pedido) {
        System.out.println("[" + nombre + "] recibe " + pedido);
        System.out.println("[" + nombre + "] está preparando " + pedido);
        try {
            Thread.sleep(1000 + (long) (Math.random() * 2000)); // Simula tiempo de preparación
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[" + nombre + "] ha terminado " + pedido);
    }

    private void registrarLog(Pedido pedido) {
        try (FileWriter fw = new FileWriter(logFile, true)) {
            fw.write("[" + nombre + "] ha preparado " + pedido + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}