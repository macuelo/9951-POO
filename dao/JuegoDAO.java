
package dao;

import modelo.Juego.Juego;
import util.ConexionBD;
import java.sql.*;        
import java.util.*;      

public class JuegoDAO {
    private Connection conn;

    public JuegoDAO() throws SQLException {
        conn = ConexionBD.getConnection();
    }

    public void agregarJuego(Juego j) throws SQLException {
        String sql = "INSERT INTO juegos (nombre, genero, rating, descargas) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, j.getNombre());
            stmt.setString(2, j.getGenero());
            stmt.setDouble(3, j.getRating());
            stmt.setInt(4, j.getDescargas()); 
            stmt.executeUpdate();
        }
    }

    public List<Juego> listarJuegos() throws SQLException {
        List<Juego> lista = new ArrayList<>();
        String sql = "SELECT * FROM juegos";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Juego j = new Juego();
                j.setId(rs.getInt("id"));          
                j.setNombre(rs.getString("nombre"));
                j.setGenero(rs.getString("genero"));
                j.setRating(rs.getDouble("rating"));
                j.setDescargas(rs.getInt("descargas"));
                lista.add(j);
            }
        }
        return lista;
    }
}