package model;

public class Reseña implements Entidad {
    private static int contadorId = 1;
    private Integer id;
    private Usuario usuario;
    private Juego juego;
    private Integer puntuacion;
    private String comentario;

    public Reseña(Usuario usuario, Juego juego, Integer puntuacion, String comentario) {
        this.id = contadorId++;
        this.usuario = usuario;
        this.juego = juego;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
    }

    @Override
    public Integer getId() {
        return id;
    }

    // getters y setters
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Juego getJuego() { return juego; }
    public void setJuego(Juego juego) { this.juego = juego; }
    public Integer getPuntuacion() { return puntuacion; }
    public void setPuntuacion(Integer puntuacion) { this.puntuacion = puntuacion; }
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
}