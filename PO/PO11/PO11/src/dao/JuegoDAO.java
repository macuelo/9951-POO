package dao;

import model.Juego;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JuegoDAO implements DAO<Juego> {
    private List<Juego> juegos = new ArrayList<>();

    @Override
    public void insertar(Juego juego) {
        juegos.add(juego);
    }

    @Override
    public void actualizar(Juego juego) {
        eliminar(juego.getId());
        juegos.add(juego);
    }

    @Override
    public void eliminar(int id) {
        juegos = juegos.stream()
                .filter(j -> !j.getId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public Juego buscarPorId(int id) {
        return juegos.stream()
                .filter(j -> j.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Juego> listar() {
        return new ArrayList<>(juegos);
    }
}