package REPOSITORY.implementaciones;

import java.util.List;

import REPOSITORY.modelos.Profesor;
import REPOSITORY.interfaz.ModelCrudGenerico;

public class RepositoryProfesorImplement implements ModelCrudGenerico<Profesor>{
    @Override
   public List<Profesor> listar(){
    return Profesor;
    
   }

   @Override
   public Profesor busqueda(int id){
        return id;
   }

   @Override
   public void crear(Profesor profesor){

   }

   @Override
   public void editar(Profesor profesor){}

   @Override
   public void eliminar(int id){}
}

