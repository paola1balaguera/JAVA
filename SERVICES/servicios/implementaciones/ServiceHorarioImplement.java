package SERVICES.servicios.implementaciones;

import SERVICES.Exceptions.NullExceptions;
import SERVICES.Exceptions.TipoDatoErroneo;
import SERVICES.servicios.ServiceCrudGenerico;
import REPOSITORY.interfaz.ModelCrudGenerico;
import REPOSITORY.modelos.Horario;

public class ServiceHorarioImplement implements ServiceCrudGenerico<Horario>{
    private final ModelCrudGenerico crudRepositoryHorario;

    public ServiceHorarioImplement(ModelCrudGenerico crudRepositoryHorario){
        this.crudRepositoryHorario = crudRepositoryHorario;
    }

    @Override
    public List<Horario> void listar(){
        return this.crudRepositoryHorario.listar();
    }

    @Override
    public Horario busqueda(int id) throws NullExceptions, TipoDatoErroneo{

        Horario horario = this.crudRepositoryHorario.busqueda(id);

        if(horario == null){
            throw new NullExceptions("No se encontro Departamento");
        }

        if(horario.matches("\\d+")){
            throw new TipoDatoErroneo("Tipo de dato erroneo");
        }
        
        else{
            return horario;
        }
    }
