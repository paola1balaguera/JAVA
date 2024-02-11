package SERVICES.servicios.implementaciones;

import SERVICES.Exceptions.NullExceptions;
import SERVICES.servicios.ServiceCrudGenerico;
import REPOSITORY.modelos.Asignatura;

import java.util.List;
import REPOSITORY.interfaz.ModelCrudGenericoString;


public class ServiceAsignaturaImplement implements ServiceCrudGenericoString<Asignatura>{
    
    private final ModelCrudGenericoString crudRepositoryAsignatura;

    public ServiceAsignaturaImplement(ModelCrudGenericoString crudRepositoryAsignatura){
        this.crudRepositoryAsignatura = crudRepositoryAsignatura;
    }

    @Override
    public List<Asignatura> void listar(){
        return this.crudRepositoryAsignatura.listar();
    }

    @Override
    public Asignatura busqueda(String nombre) throws NullExceptions{

        Alumno alumno = this.crudRepositoryAsignatura.busqueda(id);
        if(asignatura!= null){
            return asignatura;
        }
        else{
            throw new NullExceptions("No se encontro Asignatura");
        }   
    }


    @Override
    public void crear(Asignatura asignatura){
        this.crudRepositoryAsignatura.crear(asignatura);
    }

    @Override
    public void editar(Asignatura asignatura){
        this.crudRepositoryAsignatura.editar(asignatura);
    }

    @Override
    public void eliminar(String nombre){
        //se debe eliminar con un string
        this.crudRepositoryAsignatura.eliminar(0);;
    }



}
