package REPOSITORY.implementaciones;
import java.util.List;

import REPOSITORY.interfaz.ModelCrudGenerico;
import REPOSITORY.modelos.Asignatura;
import REPOSITORY.modelos.Curso;

public class RepositoryAsignaturaImplement implements ModelCrudGenerico<Asignatura> {
    
    @Override
   public List<Asignatura> listar(){
    return Asignatura;
    
   }

   @Override
   public Asignatura busqueda(int id){
        return id;
   }

   @Override
   public void crear(Asignatura asignatura){

   }

   @Override
   public void editar(Asignatura asignatura){}

   @Override
   public void eliminar(int id){}
}
