
package dao;

import modelo.Resena;
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResenaDAO {
    
    public void registrarReseña(Resena reseña) {
    String sql = "INSERT INTO Reseñas (UsuarioID, JuegoID, Calificacion, Comentario) VALUES (?, ?, ?, ?)";
    try (Connection conn = conexionBD.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, reseña.getUsuario().getId());
        stmt.setInt(2, reseña.getJuego().getId());
        stmt.setInt(3, reseña.getCalificacion());
        stmt.setString(4, reseña.getComentario());
        
        stmt.executeUpdate();
        System.out.println("Reseña registrada correctamente.");
    } catch (SQLException e) {
        System.out.println("Error al registrar reseña: " + e.getMessage());
    }
    
}
