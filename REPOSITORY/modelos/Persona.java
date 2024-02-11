package REPOSITORY.modelos;
import java.util.Date;

public class Persona {
    private int id;
    private TipoDocumento tipoDocumento;
    private long documento;
    private String nombres;
    private String apellidos;
    private String direccion;
    private long numeroTelefono;
    private Date fecha;
    private boolean sexo;
    private Ciudad ciudad;
    public static int nextCodigo;

    public Persona(){
        this.id = ++nextCodigo;
    }

    public Persona(int id, TipoDocumento tipoDocumento, long documento, String nombres,
                   String apellidos, String direccion, long numeroTelefono, Date fecha,
                   boolean sexo, Ciudad ciudad) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.numeroTelefono = numeroTelefono;
        this.fecha = fecha;
        this.sexo = sexo;
        this.ciudad = ciudad;
    }

    public enum TipoDocumento{
        CEDULA,
        CEDULA_EXTRANJERIA,
        NUMERO_PASAPORTE,
        TARJETA_IDENTIDAD
    }
}
