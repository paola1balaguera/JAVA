package REPOSITORY.modelos;

public class Salon {
    private int id;
    private int capacidadAlumnos;
    private int piso;
    private String identificador;
    private Edificio edificio;

    public Salon(int id,int capacidadAlumnos, int piso, String identificador, Edificio edificio ){
        this.id = id; 
        this.capacidadAlumnos = capacidadAlumnos;
        this.piso = piso;
        this.identificador = identificador;
        this.edificio = edificio;
    }
}
