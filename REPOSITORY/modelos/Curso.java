package REPOSITORY.modelos;

public class Curso {
    private int id;
    private String nombre;
    private String temas;
    private String competencias;


    public Curso(int id, String nombre, String temas, String competencias){
        this.id = id;
        this.nombre = nombre;
        this.temas = temas;
        this.competencias = competencias;
        
    }
}
