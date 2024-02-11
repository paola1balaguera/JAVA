package SERVICES.servicios;

import java.util.List;

import REPOSITORY.modelos.Horario;

public interface ServiceHorario {

    List<Horario> listar();

    Horario busquedaPorAlumno(int id);
    
}
