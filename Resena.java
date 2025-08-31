
package modelo;


public class Resena {
  
    private int id;
    private int idUsuario;
    private int idJuego;
    private String comentario;
    private int puntuacion;

    public Resena(int id, int idUsuario, int idJuego, String comentario, int puntuacion) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idJuego = idJuego;
        this.comentario = comentario;
        this.puntuacion = puntuacion;
    }

    public int getId() { return id; }
    public int getIdUsuario() { return idUsuario; }
    public int getIdJuego() { return idJuego; }
    public String getComentario() { return comentario; }
    public int getPuntuacion() { return puntuacion; }
    
}
