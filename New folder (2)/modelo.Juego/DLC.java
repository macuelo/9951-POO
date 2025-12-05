/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Juego;

/**
 *
 * @author bassf
 */
public class DLC extends JuegoBase {
    private int idJuegoPrincipal; 
    private double precio;

    public DLC(int id, String nombre, String genero, double rating, int descargas,
               int idJuegoPrincipal, double precio) {
        super(id, nombre, genero, rating, descargas);
        this.idJuegoPrincipal = idJuegoPrincipal;
        this.precio = precio;
    }

    @Override
    public boolean esGratis() {
        return precio == 0;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("[DLC] " + nombre + " → para juego ID " + idJuegoPrincipal +
                           " | $" + precio + " | ⭐" + rating);
    }

    // Getters específicos
    public int getIdJuegoPrincipal() { return idJuegoPrincipal; }
    public double getPrecio() { return precio; }
}