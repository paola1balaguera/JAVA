package REPOSITORY.modelos;

public class AsignaturaPeriodo {
    private int id;
    private int codigo;
    private Profesor profesor;
    private Periodo periodo;
    private Asignatura asignatura;


    public AsignaturaPeriodo(int id, int codigo, Profesor profesor,Periodo periodo,Asignatura asignatura ){
        this.id = id;
        this.codigo = codigo;
        this.profesor = profesor;
        this.periodo = periodo;
        this.asignatura = asignatura;
    }

}
