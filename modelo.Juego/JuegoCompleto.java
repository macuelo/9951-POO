package modelo.Juego;

public class JuegoCompleto extends JuegoBase {
    private double precio;

    public JuegoCompleto(int id, String nombre, String genero, double rating, int descargas, double precio) {
        super(id, nombre, genero, rating, descargas);
        this.precio = precio;
    }

    @Override
    public boolean esGratis() {
        return precio == 0;
    }

    public double getPrecio() { return precio; }
}