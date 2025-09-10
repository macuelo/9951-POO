
package modelo;

public class Juego {
    private int id;
    private String titulo;
    private String genero;
    private double rating;
    private int descargas;

    public Juego() {}

    public Juego(String titulo, String genero, double rating, int descargas) {
        this.titulo = titulo;
        this.genero = genero;
        this.rating = rating;
        this.descargas = descargas;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return titulo; }
    public void setNombre(String nombre) { this.titulo = nombre; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public int getDescargas() { return descargas; }
    public void setDescargas(int descargas) { this.descargas = descargas; }
}