package SERVICES.servicios.implementaciones;

import SERVICES.Exceptions.NullExceptions;
import SERVICES.Exceptions.TipoDatoErroneo;
import SERVICES.servicios.ServiceCrudGenerico;
import REPOSITORY.interfaz.ModelCrudGenerico;
import REPOSITORY.modelos.Horario;
import REPOSITORY.modelos.Salon;

public class ServiceSalonImplement implements ServiceCrudGenerico<Salon> {
    private final ModelCrudGenerico crudRepositorySalon;

    public ServiceSalonImplement(ModelCrudGenerico crudRepositorySalon){
        this.crudRepositorySalon = crudRepositorySalon;
    }

     @Override
    public List<Salon> void listar(){
        return this.crudRepositorySalon.listar();
    }

    @Override
    public Salon busqueda(int id) throws NullExceptions, TipoDatoErroneo{

        Salon salon = this.crudRepositorySalon.busqueda(id);

        if(salon == null){
            throw new NullExceptions("No se encontro Departamento");
        }

        if(salon.matches("\\d+")){
            throw new TipoDatoErroneo("Tipo de dato erroneo");
        }
        
        else{
            return salon;
        }
    }






}
