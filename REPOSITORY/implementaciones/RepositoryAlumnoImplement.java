package REPOSITORY.implementaciones;
import REPOSITORY.modelos.Alumno;

import java.util.List;

import REPOSITORY.interfaz.ModelCrudGenerico;

public class RepositoryAlumnoImplement implements ModelCrudGenerico<Alumno> {
   //logica base de datos

   @Override
   public List<Alumno> listar(){
    return Alumno;
    
   }

   @Override
   public Alumno busqueda(int id){
        return id;
   }

   @Override
   public void crear(Alumno alumno){

   }

   @Override
   public void editar(Alumno alumno){}

   @Override
   public void eliminar(int id){}
}
