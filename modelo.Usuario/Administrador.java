package modelo.Usuario;

public class Administrador extends Usuario {
    private int nivelPermisos;

    public Administrador(int id, String nombre, String correo, String password, int nivelPermisos) {
        super(id, nombre, correo, password);
        this.nivelPermisos = nivelPermisos;
    }

    @Override
    public void mostrarPerfil() {
        System.out.println("🛡️ Admin: " + nombre + " | Permisos: " + nivelPermisos);
    }

    public void gestionarJuegos() {
        System.out.println("🔧 Gestionando catálogo...");
    }
}
