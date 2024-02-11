package REPOSITORY.modelos;
import java.util.Date;

public class Periodo {
    private int id;
    private int codigo;
    private Date año;
    private int semestre;

    public Periodo(int id, int codigo, Date año, int semestre){
        this.id = id;
        this.codigo = codigo;
        this.año = año;
        this.semestre = semestre;
    }
}
