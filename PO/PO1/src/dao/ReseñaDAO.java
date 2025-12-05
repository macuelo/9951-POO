package dao;

import db.ConexionBD;
import model.Reseña;
import model.Usuario;
import model.Juego;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReseñaDAO implements DAO<Reseña> {
    private Connection conn;

    public ReseñaDAO() {
        this.conn = ConexionBD.getInstance().getConnection();
    }

    @Override
    public void insertar(Reseña reseña) {
        String sql = "INSERT INTO reseñas (id_usuario, id_juego, puntuacion, comentario) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, reseña.getUsuario().getId());
            stmt.setInt(2, reseña.getJuego().getId());
            stmt.setInt(3, reseña.getPuntuacion());
            stmt.setString(4, reseña.getComentario());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                reseña.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Reseña reseña) {
        String sql = "UPDATE reseñas SET id_usuario = ?, id_juego = ?, puntuacion = ?, comentario = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, reseña.getUsuario().getId());
            stmt.setInt(2, reseña.getJuego().getId());
            stmt.setInt(3, reseña.getPuntuacion());
            stmt.setString(4, reseña.getComentario());
            stmt.setInt(5, reseña.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM reseñas WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Reseña buscarPorId(int id) {
        String sql = "SELECT * FROM reseñas WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Reseña r = new Reseña();
                r.setId(rs.getInt("id"));
                r.setPuntuacion(rs.getInt("puntuacion"));
                r.setComentario(rs.getString("comentario"));

                // Obtener usuario y juego
                UsuarioDAO uDAO = new UsuarioDAO();
                JuegoDAO jDAO = new JuegoDAO();
                r.setUsuario(uDAO.buscarPorId(rs.getInt("id_usuario")));
                r.setJuego(jDAO.buscarPorId(rs.getInt("id_juego")));

                return r;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Reseña> listar() {
        String sql = "SELECT * FROM reseñas";
        List<Reseña> reseñas = new ArrayList<>();
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Reseña r = new Reseña();
                r.setId(rs.getInt("id"));
                r.setPuntuacion(rs.getInt("puntuacion"));
                r.setComentario(rs.getString("comentario"));

                UsuarioDAO uDAO = new UsuarioDAO();
                JuegoDAO jDAO = new JuegoDAO();
                r.setUsuario(uDAO.buscarPorId(rs.getInt("id_usuario")));
                r.setJuego(jDAO.buscarPorId(rs.getInt("id_juego")));

                reseñas.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reseñas;
    }
}