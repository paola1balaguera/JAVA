package SERVICES.servicios;

import java.util.List;

public interface ServiceCrudGenericoString <T>{
    List<T> listar();

    T busqueda(String nombre);

    void crear(T ejemplo);

    void editar(T ejemplo);

    void eliminar(String nombre);
}
