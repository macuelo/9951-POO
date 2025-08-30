
package modelo;

public class Juego {
    private int id;
    private String titulo;
    private String genero;
    private int descargas;
    private double rating;

    public Juego(int id, String titulo, String genero, int descargas, double rating) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.descargas = descargas;
        this.rating = rating;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public int getDescargas() { return descargas; }
    public double getRating() { return rating; }
    
}