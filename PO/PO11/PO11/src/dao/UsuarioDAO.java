package dao;

import model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioDAO implements DAO<Usuario> {
    private List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void insertar(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public void actualizar(Usuario usuario) {
        eliminar(usuario.getId());
        usuarios.add(usuario);
    }

    @Override
    public void eliminar(int id) {
        usuarios = usuarios.stream()
                .filter(u -> !u.getId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public Usuario buscarPorId(int id) {
        return usuarios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Usuario> listar() {
        return new ArrayList<>(usuarios);
    }
}