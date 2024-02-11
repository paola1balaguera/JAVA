package REPOSITORY.implementaciones;

import java.util.List;

import REPOSITORY.modelos.Facultad;
import REPOSITORY.modelos.Profesor;
import REPOSITORY.interfaz.ModelCrudGenerico;

public class RepositoryDepartamentoImplement implements ModelCrudGenerico<Facultad>{
    @Override
   public List<Facultad> listar(){
    return Profesor;
    
   }

   @Override
   public Facultad busqueda(int id){
        return id;
   }

   @Override
   public void crear(Facultad departamento){

   }

   @Override
   public void editar(Facultad departamento){}

   @Override
   public void eliminar(int id){}
}
