package dao;

import modelo.Usuario.Usuario;
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
    try (Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            Usuario u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setNombre(rs.getString("nombre"));
            u.setCorreo(rs.getString("correo"));
            u.setPassword(rs.getString("password"));
            lista.add(u);
        }
    }
    return lista;
    }
       
    public Usuario autenticarUsuario(String correo, String password) throws SQLException {
    String sql = "SELECT * FROM usuarios WHERE correo = ? AND password = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, correo);
    stmt.setString(2, password); // ¡OJO! Ver nota de seguridad abajo
    ResultSet rs = stmt.executeQuery();
    if (rs.next()) {
        Usuario u = new Usuario();
        u.setId(rs.getInt("id"));
        u.setNombre(rs.getString("nombre"));
        u.setCorreo(rs.getString("correo"));
        u.setPassword(rs.getString("password"));
        return u;
    }
    return null; // Credenciales inválidas
    }
    
    public boolean existeUsuarioPorCorreo(String correo) throws SQLException {
    String sql = "SELECT 1 FROM usuarios WHERE correo = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, correo);
    ResultSet rs = stmt.executeQuery();
    return rs.next();
    }
    
    public Usuario obtenerPorId(int id) throws SQLException {
    String sql = "SELECT * FROM usuarios WHERE id = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setInt(1, id);
    ResultSet rs = stmt.executeQuery();
    if (rs.next()) {
        Usuario u = new Usuario();
        u.setId(rs.getInt("id"));
        u.setNombre(rs.getString("nombre"));
        u.setCorreo(rs.getString("correo"));
        u.setPassword(rs.getString("password"));
        return u;
    }
    return null;
    }
    
    public void actualizarUsuario(Usuario u) throws SQLException {
    String sql = "UPDATE usuarios SET nombre = ?, correo = ?, password = ? WHERE id = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, u.getNombre());
    stmt.setString(2, u.getCorreo());
    stmt.setString(3, u.getPassword());
    stmt.setInt(4, u.getId());
    stmt.executeUpdate();
    }
    
    public void eliminarUsuario(int id) throws SQLException {
    String sql = "DELETE FROM usuarios WHERE id = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setInt(1, id);
    stmt.executeUpdate();
    }
    
    
}