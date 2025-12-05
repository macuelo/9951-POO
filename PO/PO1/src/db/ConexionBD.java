
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static ConexionBD instancia;
    private Connection conexion;
    private static final String URL = "jdbc:mysql://localhost:3306/launcher";
    private static final String USER = "root";
    private static final String PASS = "Imqg1901imqg#"; // Cambia por la tuya

    private ConexionBD() {
        try {
            this.conexion = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar a la base de datos", e);
        }
    }

    public static ConexionBD getInstance() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    public Connection getConnection() {
        return conexion;
    }

    public void desconectar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                instancia = null; // Permitir crear nueva instancia después de cerrar
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}