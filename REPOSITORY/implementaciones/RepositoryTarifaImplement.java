package REPOSITORY.implementaciones;

import java.util.List;

import REPOSITORY.modelos.Tarifa;
import REPOSITORY.interfaz.ModelCrudGenerico;

public class RepositoryTarifaImplement implements ModelCrudGenerico<Tarifa> {
    
    @Override
   public List<Tarifa> listar(){
    return Tarifa;
    
   }

   @Override
   public Tarifa busqueda(int id){
        return id;
   }

   @Override
   public void crear(Tarifa tarifa){

   }

   @Override
   public void editar(Tarifa tarifa){}

   @Override
   public void eliminar(int id){}
}
