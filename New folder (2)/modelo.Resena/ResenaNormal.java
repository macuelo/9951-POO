/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Resena;


public class ResenaNormal extends ResenaBase {
    public ResenaNormal(int idUsuario, int idJuego, String comentario, int rating) {
        super(idUsuario, idJuego, comentario, rating);
    }

    @Override
    public String getTipo() { return "Normal"; }

    @Override
    public boolean esVerificada() { return false; }
}