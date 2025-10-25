
package main;

import dao.UsuarioDAO;
import modelo.Usuario;
import dao.JuegoDAO;
import modelo.Juego;
import dao.ResenaDAO;
import modelo.Resena;

public class main {

    public static void main(String[] args) {
        
           try {
            UsuarioDAO dao = new UsuarioDAO();

            // Crear usuario
            Usuario nuevo = new Usuario("Carlos", "carlos@mail.com", "clave123");
            dao.registrarUsuario(nuevo);
            System.out.println("✅ Usuario registrado");

            // Listar usuarios
            for (Usuario u : dao.listarUsuarios()) {
                System.out.println(u.getId() + " - " + u.getNombre() + " - " + u.getCorreo());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
           
            try {
            JuegoDAO juegoDAO = new JuegoDAO();

            // Insertar juegos
            juegoDAO.agregarJuego(new Juego("Minecraft", "Sandbox", 4.8, 1000000));
            juegoDAO.agregarJuego(new Juego("GTA V", "Acción", 4.7, 950000));

            // Listar juegos
            for (Juego j : juegoDAO.listarJuegos()) {
                System.out.println(j.getId() + " - " + j.getNombre() +
                                   " (" + j.getGenero() + ") - " +
                                   j.getRating() + "⭐ - " +
                                   j.getDescargas() + " descargas");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
           
          try {
            ResenaDAO reseñaDAO = new ResenaDAO();

            // Insertar reseñas de prueba (asegúrate que existan usuario=1 y juego=1 en la BD)
            reseñaDAO.agregarReseña(new Resena(1, 1, "Muy divertido, 10/10", 5));
            reseñaDAO.agregarReseña(new Resena(2, 1, "Está bueno pero caro", 4));
            reseñaDAO.agregarReseña(new Resena(3, 1, "No me gustó tanto", 2));

            // Listar reseñas del juego con id=1
            System.out.println("📌 Reseñas del juego 1:");
            for (Resena r : reseñaDAO.listarReseñasPorJuego(1)) {
                System.out.println("Usuario " + r.getIdUsuario() +
                                   " → " + r.getComentario() +
                                   " (" + r.getRating() + "⭐)");
            }

            // Mostrar promedio de rating
            double promedio = reseñaDAO.promedioRating(1);
            System.out.println("⭐ Promedio rating juego 1: " + promedio);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }   
            
            
           
}

        
        
// falta hacer menu para todas las opciones del programa 