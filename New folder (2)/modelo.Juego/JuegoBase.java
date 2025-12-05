package modelo.Juego;

public abstract class JuegoBase implements JuegoInterfaz {
    protected int id;
    protected String nombre;
    protected String genero;
    protected double rating;
    protected int descargas;

    public JuegoBase(int id, String nombre, String genero, double rating, int descargas) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.rating = rating;
        this.descargas = descargas;
    }

    // Getters comunes
    public int getId() { return id; }
    public String getGenero() { return genero; }
    public int getDescargas() { return descargas; }

    @Override
    public String getNombre() { return nombre; }
    @Override
    public double getRating() { return rating; }

    // Método común
    @Override
    public void mostrarInfo() {
        System.out.println("[" + genero + "] " + nombre + " ⭐" + rating + " (" + descargas + " descargas)");
    }
}