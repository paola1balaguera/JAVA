package REPOSITORY.modelos;

public class Profesor {
    private int id;
    private Persona persona;
    private Facultad departamento;

    public Profesor(int id, Persona persona, Facultad departamento) {
        this.id = id;
        this.persona = persona;
    }
}
