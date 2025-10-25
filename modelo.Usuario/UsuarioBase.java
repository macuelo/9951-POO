/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Usuario;

/**
 *
 * @author bassf
 */
public abstract class UsuarioBase implements UsuarioInterfaz {
    protected int id;
    protected String nombre;
    protected String correo;
    protected String password;

    public UsuarioBase(int id, String nombre, String correo, String password) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    // Getters comunes
    public int getId() { return id; }
    public String getPassword() { return password; }

    // Setters si los necesitas
    public void setPassword(String password) { this.password = password; }

    // Comportamiento común por defecto (opcional)
    @Override
    public String getNombre() { return nombre; }
    @Override
    public String getCorreo() { return correo; }
}