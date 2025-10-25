
package modelo.Usuario;

import modelo.Usuario.UsuarioBase;


public class Jugador extends UsuarioBase {
    public Jugador(int id, String nombre, String correo, String password) {
        super(id, nombre, correo, password);
    }

    @Override
    public void mostrarPerfil() {
        System.out.println("🎮 Jugador: " + nombre + " | Correo: " + correo);
    }
}