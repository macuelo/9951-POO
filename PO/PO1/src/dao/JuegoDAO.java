package dao;

import db.ConexionBD;
import model.Juego;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JuegoDAO implements DAO<Juego> {
    private Connection conn;

    public JuegoDAO() {
        this.conn = ConexionBD.getInstance().getConnection();
    }

    @Override
    public void insertar(Juego juego) {
        String sql = "INSERT INTO juegos (titulo, precio) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, juego.getTitulo());
            stmt.setDouble(2, juego.getPrecio());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                juego.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Juego juego) {
        String sql = "UPDATE juegos SET titulo = ?, precio = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, juego.getTitulo());
            stmt.setDouble(2, juego.getPrecio());
            stmt.setInt(3, juego.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM juegos WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Juego buscarPorId(int id) {
        String sql = "SELECT * FROM juegos WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Juego j = new Juego();
                j.setId(rs.getInt("id"));
                j.setTitulo(rs.getString("titulo"));
                j.setPrecio(rs.getDouble("precio"));
                return j;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Juego> listar() {
        String sql = "SELECT * FROM juegos";
        List<Juego> juegos = new ArrayList<>();
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Juego j = new Juego();
                j.setId(rs.getInt("id"));
                j.setTitulo(rs.getString("titulo"));
                j.setPrecio(rs.getDouble("precio"));
                juegos.add(j);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return juegos;
    }
}