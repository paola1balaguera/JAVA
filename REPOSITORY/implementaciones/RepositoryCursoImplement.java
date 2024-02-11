package REPOSITORY.implementaciones;

import java.util.List;

import REPOSITORY.interfaz.ModelCrudGenerico;
import REPOSITORY.modelos.Alumno;
import REPOSITORY.modelos.Curso;

public class RepositoryCursoImplement implements ModelCrudGenerico<Curso>{
    
    
    @Override
   public List<Curso> listar(){
    return Curso;
    
   }

   @Override
   public Curso busqueda(int id){
        return id;
   }

   @Override
   public void crear(Curso curso){

   }

   @Override
   public void editar(Curso curso){}

   @Override
   public void eliminar(int id){}
}
