public class Pedido {
    private final int id;
    private final String plato;

    public Pedido(int id, String plato) {
        this.id = id;
        this.plato = plato;
    }

    public int getId() {
        return this.id;
    }

    public String getPlato() {
        return this.plato;
    }

    @Override
    public String toString() {
        return "Pedido " + this.getId() + ": " + this.getPlato();
    }
}