package modelo.Resena;

    
public class Resena {
    private int id;
    private int idUsuario;
    private int idJuego;
    private String comentario;
    private int rating;
    private String tipo; // "normal", "verificada", "streamer", etc.
    private boolean contieneSpoiler;

     public Resena() {}
    
    // Constructor
    public Resena(int idUsuario, int idJuego, String comentario, int rating, String tipo) {
        this.idUsuario = idUsuario;
        this.idJuego = idJuego;
        this.comentario = comentario;
        this.rating = rating;
        this.tipo = tipo;
        this.contieneSpoiler = false;
    }

    // Getters y setters
    

     public boolean esVerificada() {
        return "verificada".equalsIgnoreCase(tipo);
    }

}