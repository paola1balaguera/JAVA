package REPOSITORY.implementaciones;

import java.util.List;

import REPOSITORY.modelos.Salon;
import REPOSITORY.interfaz.ModelCrudGenerico;


public class RepositorySalonImplement implements ModelCrudGenerico<Salon> {
    @Override
   public List<Salon> listar(){
    return Salon;
    
   }

   @Override
   //busqueda por identificador
   public Salon busqueda(int id){
        return id;
   }
}
