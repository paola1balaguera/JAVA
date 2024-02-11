package REPOSITORY.implementaciones;
import REPOSITORY.modelos.Alumno;
import REPOSITORY.modelos.Programa;

import java.util.List;

import REPOSITORY.interfaz.ModelCrudGenerico;

public class RepositoryProgramaImplement implements ModelCrudGenerico<Programa>{
   
   @Override
   public List<Programa> listar(){
    return Programa;
    
   }

   @Override
   public Programa busqueda(int id){
        return id;
   }

   @Override
   public void crear(Programa programa){

   }

   @Override
   public void editar(Programa programa){}

   @Override
   public void eliminar(int id){}
}
