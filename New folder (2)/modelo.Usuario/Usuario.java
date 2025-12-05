/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Usuario;

/**
 *
 * @author bassf
 */
public abstract class Usuario implements UsuarioInterfaz {
    protected int id;
    protected String nombre;
    protected String correo;
    protected String password;

    public Usuario(int id, String nombre, String correo, String password) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    // Getters (sin setters si prefieres inmutabilidad parcial)
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}