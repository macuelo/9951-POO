package service;

import dao.UsuarioDAO;
import model.Usuario;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ServicioUsuario {
    private UsuarioDAO usuarioDAO;

    public ServicioUsuario(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public void registrarUsuario(Usuario usuario) {
        usuarioDAO.insertar(usuario);
    }

    public List<Usuario> buscarUsuarios(Predicate<Usuario> filtro) {
        List<Usuario> todos = usuarioDAO.listar();
        return todos.stream().filter(filtro).collect(Collectors.toList());
    }

    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listar();
    }

    public void actualizarUsuario(Usuario usuario) {
        usuarioDAO.actualizar(usuario);
    }

    public void eliminarUsuario(int id) {
        usuarioDAO.eliminar(id);
    }

    public Usuario obtenerUsuario(int id) {
        return usuarioDAO.buscarPorId(id);
    }
}