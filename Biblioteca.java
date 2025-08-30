
package modelo;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private int idUsuario;
    private List<Juego> juegos;

    public Biblioteca(int idUsuario) {
        this.idUsuario = idUsuario;
        this.juegos = new ArrayList<>();
    }

    public void agregarJuego(Juego juego) {
        juegos.add(juego);
    }

    public List<Juego> getJuegos() {
        return juegos;
    }
}