package model;

import java.util.List;

public class Juego implements Entidad {
    private Integer id;
    private String titulo;
    private Double precio;
    private List<Reseña> reseñas;

    public Juego() {}

    public Juego(String titulo, Double precio) {
        this.titulo = titulo;
        this.precio = precio;
    }

     @Override
    public Integer getId() {
        return id;
    }

    // getters y setters
  

    public void setId(Integer id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public List<Reseña> getReseñas() { return reseñas; }
    public void setReseñas(List<Reseña> reseñas) { this.reseñas = reseñas; }
}