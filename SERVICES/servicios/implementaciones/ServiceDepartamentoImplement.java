package SERVICES.servicios.implementaciones;

import REPOSITORY.interfaz.ModelCrudGenericoString;
import REPOSITORY.modelos.Alumno;
import REPOSITORY.modelos.Curso;
import SERVICES.Exceptions.NullExceptions;
import SERVICES.Exceptions.TipoDatoErroneo;
import SERVICES.servicios.ServiceCrudGenericoString;

public class ServiceDepartamentoImplement implements ServiceCrudGenericoString<Departamento> {
    private final ModelCrudGenericoString crudRepositoryDepartamento;

    ServiceDepartamentoImplement(ModelCrudGenericoString crudRepositoryDepartamento){
        this.crudRepositoryDepartamento = crudRepositoryDepartamento;
    }

    @Override
    public List<Departamento> void listar(){
        return this.crudRepositoryDepartamento.listar();
    }

    @Override
    public Departamento busqueda(String nombre) throws NullExceptions, TipoDatoErroneo{

        Departamento departamento = this.crudRepositoryDepartamento.busqueda(nombre);

        if(departamento == null){
            throw new NullExceptions("No se encontro Departamento");
        }

        if(!departamento.matches("[a-zA-Z]+")){
            throw new TipoDatoErroneo("Tipo de dato erroneo");
        }
        
        else{
            return departamento;
        }
    }


    @Override
    public void crear(Departamento departamento){
        this.crudRepositoryDepartamento.crear(departamento);
    }

    @Override
    public void editar(Departamento departamento){
        this.crudRepositoryDepartamento.editar(departamento);
    }

    @Override
    public void eliminar(String nombre){
        this.crudRepositoryDepartamento.eliminar(nombre);
    }
}
