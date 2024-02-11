package SERVICES.servicios;

import java.util.List;

public interface ServiceCrudGenerico <T>{
    List<T> listar();

    T busqueda(int id);

    void crear(T ejemplo);

    void editar(T ejemplo);

    void eliminar(int id);

}
