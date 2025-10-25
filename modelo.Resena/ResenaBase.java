/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Resena;

/**
 *
 * @author bassf
 */
public abstract class ResenaBase {
    protected int id;
    protected int idUsuario;
    protected int idJuego;
    protected String comentario;
    protected int rating;

    public ResenaBase(int idUsuario, int idJuego, String comentario, int rating) {
        this.idUsuario = idUsuario;
        this.idJuego = idJuego;
        this.comentario = comentario;
        this.rating = rating;
    }

    // Getters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdUsuario() { return idUsuario; }
    public int getIdJuego() { return idJuego; }
    public String getComentario() { return comentario; }
    public int getRating() { return rating; }

    public abstract String getTipo();
    public abstract boolean esVerificada();
}
