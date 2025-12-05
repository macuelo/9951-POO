package model;

import java.util.List;

public class Usuario implements Entidad {
    private Integer id;
    private String nombre;
    private String email;
    private List<Reseña> reseñas;

    public Usuario() {}

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

     @Override
    public Integer getId() {
        return id;
    }

    // getters y setters

    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Reseña> getReseñas() { return reseñas; }
    public void setReseñas(List<Reseña> reseñas) { this.reseñas = reseñas; }
}