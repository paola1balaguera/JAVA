package SERVICES.servicios.implementaciones;

import SERVICES.Exceptions.NullExceptions;
import SERVICES.servicios.ServiceCrudGenerico;
import REPOSITORY.modelos.Alumno;

import java.util.List;

import REPOSITORY.interfaz.ModelCrudGenerico;

public class ServiceAlumnoImplement implements ServiceCrudGenerico<Alumno> {

    //modelCrudGenerico es la interfaz que se declara en Repository
    private final ModelCrudGenerico crudRepositoryAlmuno;

    public ServiceAlumnoImplement(ModelCrudGenerico crudRepositoryAlmuno){
        this.crudRepositoryAlmuno = crudRepositoryAlmuno;
    }

    @Override
    public List<Alumno> listar(){
        return this.crudRepositoryAlmuno.listar();
    }

    @Override
    public Alumno busqueda(int id) throws NullExceptions{

        Alumno alumno = this.crudRepositoryAlmuno.busqueda(id);
        if(alumno!= null){
            return alumno;
        }
        else{
            throw new NullExceptions("No se encontro Alumno");
        }   
    }

    @Override
    public void crear(Alumno alumno){
        this.crudRepositoryAlmuno.crear(alumno);
    }

    @Override
    public void editar(Alumno alumno){
        this.crudRepositoryAlmuno.editar(alumno);
    }

    @Override
    public void eliminar(int id){
        this.crudRepositoryAlmuno.eliminar(id);
    }

}
