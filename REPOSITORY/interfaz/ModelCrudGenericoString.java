package REPOSITORY.interfaz;

import java.util.List;

public interface ModelCrudGenericoString <T> {
    
    List<T> listar();

    T busqueda(String T);

    void crear(T ejemplo);

    void editar(T ejemplo);

    void eliminar(int id);
    
}
