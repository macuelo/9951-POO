
package modelo;

public class Biblioteca {
    private int id;
    private int idUsuario;
    private int idJuego;

    public Biblioteca() {}

    public Biblioteca(int idUsuario, int idJuego) {
        this.idUsuario = idUsuario;
        this.idJuego = idJuego;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public int getIdJuego() { return idJuego; }
    public void setIdJuego(int idJuego) { this.idJuego = idJuego; }
}