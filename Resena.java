package modelo;

public class Resena {
    
    private int id;
    private int idUsuario;
    private int idJuego;
    private String comentario;
    private int rating;

    public Resena() {}

    public Resena(int idUsuario, int idJuego, String comentario, int rating) {
        this.idUsuario = idUsuario;
        this.idJuego = idJuego;
        this.comentario = comentario;
        this.rating = rating;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public int getIdJuego() { return idJuego; }
    public void setIdJuego(int idJuego) { this.idJuego = idJuego; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }



}