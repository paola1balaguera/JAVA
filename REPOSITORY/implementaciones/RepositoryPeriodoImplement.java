package REPOSITORY.implementaciones;
import java.util.List;

import REPOSITORY.interfaz.ModelCrudGenerico;
import REPOSITORY.modelos.Periodo;
import REPOSITORY.modelos.Profesor;

public class RepositoryPeriodoImplement implements ModelCrudGenerico<Periodo> {
    
   @Override
   public List<Periodo> listar(){
    return Periodo;
    
   }

   @Override
   public Periodo busqueda(int id){
        return id;
   }

   @Override
   public void crear(Periodo periodo){

   }

   @Override
   public void editar(Periodo periodo){}

   @Override
   public void eliminar(int id){}
}
