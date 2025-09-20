
package modelo;



public class Usuario {
    private int id;
    private String nombre;
    private String correo;
    private String password;

    public Usuario() {}

    public Usuario(String nombre, String correo, String password) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public abstract class usuario{
    protected String nombre;
    protected String correo;

    public usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }

    
    public abstract void mostrarPerfil();
}
    
    public class Administrador extends usuario {
    private int permisos;

    public Administrador(String nombre, String correo, int permisos) {
        super(nombre, correo);
        this.permisos = permisos;
    }

    @Override
    public void mostrarPerfil() {
        System.out.println("Administrador: " + nombre + ", correo: " + correo +
                           ", nivel permisos: " + permisos);
    }
    
    }   
}