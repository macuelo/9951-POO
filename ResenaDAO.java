
package dao;

import modelo.Resena;
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ResenaDAO {
    
    private Connection conn;

    public ResenaDAO() throws SQLException {
        conn = ConexionBD.getConnection();
    }

    // Insertar reseña
    public void agregarReseña(Resena r) throws SQLException {
        String sql = "INSERT INTO reseñas (id_usuario, id_juego, comentario, rating) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, r.getIdUsuario());
        stmt.setInt(2, r.getIdJuego());
        stmt.setString(3, r.getComentario());
        stmt.setInt(4, r.getRating());
        stmt.executeUpdate();
    }

    // Listar reseñas de un juego
    public List<Resena> listarReseñasPorJuego(int idJuego) throws SQLException {
        List<Resena> lista = new ArrayList<>();
        String sql = "SELECT * FROM reseñas WHERE id_juego = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idJuego);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Resena r = new Resena();
            r.setId(rs.getInt("id"));
            r.setIdUsuario(rs.getInt("id_usuario"));
            r.setIdJuego(rs.getInt("id_juego"));
            r.setComentario(rs.getString("comentario"));
            r.setRating(rs.getInt("rating"));
            lista.add(r);
        }
        return lista;
    }

    // Calcular promedio de rating de un juego
    public double promedioRating(int idJuego) throws SQLException {
        String sql = "SELECT AVG(rating) AS promedio FROM reseñas WHERE id_juego = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idJuego);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getDouble("promedio");
        }
        return 0;
    }
    
}
