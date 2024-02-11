package REPOSITORY.modelos;

public class Alumno {
    private int id;
    private Persona persona; 
    private Programa programa;

    public Alumno(int id, Persona persona, Programa programa) {
        this.id = id;
        this.persona = persona;
        this.programa = programa;
    }
}
