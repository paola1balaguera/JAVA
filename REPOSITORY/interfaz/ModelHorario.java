package REPOSITORY.interfaz;

import java.util.List;
import REPOSITORY.modelos.Horario;

public interface ModelHorario {
    
    List<Horario> listar();

    Horario busquedaPorAlumno(int id);
    
}
