package REPOSITORY.modelos;

public class Asignatura {
    private int id;
    private String nombre;
    private int creditos;
    private int cupoDisponible;
    private Curso curso;
    private Programa programa;

    public Asignatura(int id, String nombre,int creditos,int cupoDisponible, Curso curso, Programa programa){
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
        this.cupoDisponible = cupoDisponible;
        this.curso = curso;
        this.programa = programa;
    }
}
