package dao;

import model.Reseña;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReseñaDAO implements DAO<Reseña> {
    private List<Reseña> reseñas = new ArrayList<>();

    @Override
    public void insertar(Reseña reseña) {
        reseñas.add(reseña);
    }

    @Override
    public void actualizar(Reseña reseña) {
        eliminar(reseña.getId());
        reseñas.add(reseña);
    }

    @Override
    public void eliminar(int id) {
        reseñas = reseñas.stream()
                .filter(r -> !r.getId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public Reseña buscarPorId(int id) {
        return reseñas.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Reseña> listar() {
        return new ArrayList<>(reseñas);
    }
}