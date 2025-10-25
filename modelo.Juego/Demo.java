package modelo.Juego;

public class Demo extends JuegoBase {
    private int duracionMinutos;

    public Demo(int id, String nombre, String genero, double rating, int descargas, int duracionMinutos) {
        super(id, nombre, genero, rating, descargas);
        this.duracionMinutos = duracionMinutos;
    }

    @Override
    public boolean esGratis() {
        return true; // Las demos siempre son gratis
    }

    public int getDuracionMinutos() { return duracionMinutos; }
}