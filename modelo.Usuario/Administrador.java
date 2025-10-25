package modelo.Usuario;

public class Administrador extends UsuarioBase {
    private int nivelPermisos;

    public Administrador(int id, String nombre, String correo, String password, int nivelPermisos) {
        super(id, nombre, correo, password);
        this.nivelPermisos = nivelPermisos;
    }

    @Override
    public void mostrarPerfil() {
        System.out.println("🛡️ Administrador: " + nombre + 
                          " | Permisos: " + nivelPermisos);
    }

    public void gestionarJuegos() {
        System.out.println("🔧 Gestionando catálogo de juegos...");
    }
}
