package SERVICES.servicios.implementaciones;

import SERVICES.Exceptions.NullExceptions;
import SERVICES.servicios.ServiceCrudGenericoString;
import REPOSITORY.interfaz.ModelCrudGenericoString;
import REPOSITORY.modelos.Alumno;
import REPOSITORY.modelos.Asignatura;
import REPOSITORY.modelos.Curso;

public class ServiceCursoImplement implements ServiceCrudGenericoString<Curso> {
    
    private final ModelCrudGenericoString crudRepositoryCurso;

    public ServiceCursoImplement(ModelCrudGenericoString crudRepositoryCurso){
        this.crudRepositoryCurso = crudRepositoryCurso;
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
