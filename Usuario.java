
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    //ATRIBUTOS
    private int id;
    private String nombre;
    private String correo;
    private String password;

    public Usuario(int id, String nombre, String correo, String password) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getPassword() { return password; }
    
    private Connection conn;
    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    //METODOS
    
        public void registrarUsuario(Usuario u) throws SQLException {
        String sql = "INSERT INTO usuarios (nombre, correo, password) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, u.getNombre());
        stmt.setString(2, u.getCorreo());
        stmt.setString(3, u.getPassword());
        stmt.executeUpdate();
    }

    public List<Usuario> obtenerUsuarios() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Usuario u = new Usuario(
                rs.getInt("id_usuario"),
                rs.getString("nombre"),
                rs.getString("correo"),
                rs.getString("password")
            );
            lista.add(u);
        }
        return lista;
    }
}

}