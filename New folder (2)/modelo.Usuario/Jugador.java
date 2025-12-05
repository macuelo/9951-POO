
package modelo.Usuario;


public class Jugador extends Usuario {
    public Jugador(int id, String nombre, String correo, String password) {
        super(id, nombre, correo, password);
    }

    @Override
    public void mostrarPerfil() {
        System.out.println("🎮 Jugador: " + nombre + " | " + correo);
    }
}

