package REPOSITORY.implementaciones;

import java.util.List;

import REPOSITORY.interfaz.ModelCrudGenerico;


public class RepositoryMatriculaImplement implements ModelCrudGenerico<Matricula> {
    @Override
   public List<Matricula> listar(){
    return Matricula;
    
   }

   @Override
   public Matricula busqueda(int id){
        return id;
   }

   @Override
   public void crear(Matricula matricula){

   }

   @Override
   public void editar(Matricula matricula){}

   @Override
   public void eliminar(int id){}
}

