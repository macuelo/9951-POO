package dao;

import java.util.List;

public interface DAO<T> {
    void insertar(T obj);
    void actualizar(T obj);
    void eliminar(int id);
    T buscarPorId(int id);
    List<T> listar();
}