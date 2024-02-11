package REPOSITORY.modelos;

import java.util.Date;


public class Horario {
    private int id;
    private Date dia;
    private Salon salon;
    private BloqueHorario bloquehorario;
    private AsignaturaPeriodo asignaturaPeriodo;

    public Horario(int id, Date dia, Salon salon, BloqueHorario bloquehorario, AsignaturaPeriodo asignaturaperiodo){
        this.id = id;
        this.dia = dia;
        this.salon = salon;
        this.bloquehorario = bloquehorario;
        this.asignaturaPeriodo = asignaturaperiodo;
    }
}
