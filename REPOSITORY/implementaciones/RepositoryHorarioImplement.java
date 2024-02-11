package REPOSITORY.implementaciones;

import java.util.List;
import REPOSITORY.interfaz.ModelHorario;
import REPOSITORY.modelos.Horario;
import REPOSITORY.modelos.Periodo;

public class RepositoryHorarioImplement implements ModelHorario {
    
   @Override
   public List<Horario> listar(){
    return Horario;
    
   }

   @Override
   public Horario busquedaPorAlumno(int id){
        return id;
   }
}
