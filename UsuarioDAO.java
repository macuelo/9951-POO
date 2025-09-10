package dao;

import modelo.Usuario;
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO() throws SQLException {
        conn = ConexionBD.getConnection();
    }

    public void registrarUsuario(Usuario u) throws SQLException {
        String sql = "INSERT INTO usuarios (nombre, correo, password) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, u.getNombre());
        stmt.setString(2, u.getCorreo());
        stmt.setString(3, u.getPassword());
        stmt.executeUpdate();
    }

    public List<Usuario> listarUsuarios() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Usuario u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setNombre(rs.getString("nombre"));
            u.setCorreo(rs.getString("correo"));
            u.setPassword(rs.getString("password"));
            lista.add(u);
        }
        return lista;
    }
}