package SERVICES.servicios.implementaciones;

import REPOSITORY.interfaz.ModelCrudGenerico;
import REPOSITORY.modelos.Alumno;
import REPOSITORY.modelos.Curso;
import REPOSITORY.modelos.Periodo;
import SERVICES.Exceptions.NullExceptions;
import SERVICES.servicios.ServiceCrudGenerico;

public class ServicePeriodoImplement implements ServiceCrudGenerico<Periodo> {
    private final ModelCrudGenerico crudRepositoryPeriodo;

    public ServicePeriodoImplement(ModelCrudGenerico crudRepositoryPeriodo){
        this.crudRepositoryPeriodo = crudRepositoryPeriodo;
    }

    @Override
    public List<Curso> void listar(){
        return this.crudRepositoryCurso.listar();
    }

    @Override
    public Curso busqueda(String nombre) throws NullExceptions{

        Alumno alumno = this.crudRepositoryCurso.busqueda(nombre);
        if(Curso!= null){
            return Curso;
        }
        else{
            throw new NullExceptions("No se encontro Curso");
        }   
    }


    @Override
    public void crear(Curso curso){
        this.crudRepositoryCurso.crear(curso);
    }

    @Override
    public void editar(Curso curso){
        this.crudRepositoryCurso.editar(curso);
    }

    @Override
    public void eliminar(String nombre){
        //se debe eliminar con un string
        this.crudRepositoryCurso.eliminar(0);
    }
}
