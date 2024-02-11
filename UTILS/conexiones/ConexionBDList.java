package UTILS.conexiones;

import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import UTILS.ConexionBD;
import REPOSITORY.modelos.Profesor;
import REPOSITORY.modelos.Alumno;
import REPOSITORY.modelos.Asignatura;
import REPOSITORY.modelos.AsignaturaPeriodo;
import REPOSITORY.modelos.BloqueHorario;
import REPOSITORY.modelos.Ciudad;
import REPOSITORY.modelos.Curso;
import REPOSITORY.modelos.Edificio;
import REPOSITORY.modelos.Facultad;
import REPOSITORY.modelos.Horario;
import REPOSITORY.modelos.Matricula;
import REPOSITORY.modelos.Persona;
import REPOSITORY.modelos.Programa;
import REPOSITORY.modelos.Salon;
import REPOSITORY.modelos.Periodo;
import REPOSITORY.modelos.Tarifa;


public class ConexionBDList {
    private static ConexionBDList conexion;
    private List<Profesor> listaProfesores;
    private List<Alumno> listaAlumnos;
    private List<Ciudad> listaCiudades;
    private List<Facultad> listaFacultades;
    private List<Programa> listaProgramas;
    private List<Periodo> listaPeriodos;
    private List<Tarifa> listaTarifas;
    private List<Asignatura> listaAsignaturas;
    private List<BloqueHorario> listaBloqueHorarios;
    private List<AsignaturaPeriodo> listaAsignaturaPeriodos;
    private List<Horario> listaHorarios;
    private List<Curso> listaCursos;
    private List<Salon> listaSalones;
    private List<Matricula> listaMatriculas;


    public static ConexionBDList getConexion() {
        if (conexion != null) {
            return conexion;
        } else {
            conexion = new ConexionBDList();
            return conexion;
        }
    }

    private void loadData() {
        cargarAlumno();
        cargarCiudad();
        cargarFacultad();
        cargarProfesor();
        cargarPrograma();
        cargarPeriodo();
        cargarTarifa();
        cargarAsignatura();
        cargarBloqueHorario();
        cargarAsignaturaPeriodo();
        cargarHorario();
        cargarCurso();
        cargarSalon();
        cargarMatricula();
    }


    private ConexionBDList() {
        listaAlumnos = new ArrayList<>();
        listaCiudades= new ArrayList<>();
        listaFacultades = new ArrayList<>();
        listaProfesores = new ArrayList<>();
        listaProgramas = new ArrayList<>();
        listaPeriodos = new ArrayList<>();
        listaTarifas = new ArrayList<>();
        listaAsignaturas = new ArrayList<>();
        listaBloqueHorarios = new ArrayList<>();
        listaAsignaturaPeriodos = new ArrayList<>();
        listaHorarios = new ArrayList<>();
        listaCursos = new ArrayList<>();
        listaSalones = new ArrayList<>();
        listaMatriculas = new ArrayList<>();




        this.loadData();
    }

    private void cargarAlumno(){
         try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombre_basedatos", "usuario", "contraseña");
             //preparacion del estado de la extraccion de datos
            PreparedStatement stmt = conn.prepareStatement("SELECT a.id_alumno, p.*, pr.* FROM Alumno a JOIN Persona p ON a.id_persona = p.id_persona JOIN Programa pr ON a.id_programa = pr.id_programa");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idAlumno = rs.getInt("id_alumno");
                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String correo = rs.getString("correo");
                // Obtener datos del programa
                int idPrograma = rs.getInt("id_programa");
                String nombrePrograma = rs.getString("nombre_programa");
                // Crear objetos Persona y Programa
                Persona persona = new Persona(idPersona, nombre, apellido, correo);
                Programa programa = new Programa(idPrograma, nombrePrograma);
                // Crear objeto Alumno
                Alumno alumno = new Alumno(idAlumno, persona, programa);
                // Agregar alumno a la lista
                listaAlumnos.add(alumno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarCiudad(){
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ciudad");
        ResultSet rs = stmt.executeQuery()) {

       while (rs.next()) {
           int idCiudad = rs.getInt("id_ciudad");
           String nombre = rs.getString("nombre");
           // Crear objeto Ciudad
           Ciudad ciudad = new Ciudad(idCiudad, nombre);
           // Agregar ciudad a la lista
           listaCiudades.add(ciudad);
       }
   } catch (SQLException e) {
       e.printStackTrace();
   }

   //return listaCiudades;
}


    private void cargarFacultad(){
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM facultad");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idDepartamento = rs.getInt("id_facultad");
                String nombre = rs.getString("nombre");
                // Crear objeto Departamento
                Facultad departamento = new Facultad(idDepartamento, nombre);
                // Agregar departamento a la lista
                listaFacultades.add(departamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //return listaFacultades;

    }

    private void cargarProfesor(){}

    private void cargarCurso(){
         try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM curso");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idCurso = rs.getInt("id_curso");
                String nombre = rs.getString("nombre");
                String temas = rs.getString("temas");
                String competencias = rs.getString("competencias");
                // Crear objeto Curso
                Curso curso = new Curso(idCurso, nombre, temas, competencias);
                // Agregar curso a la lista
                listaCursos.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return listaCursos;
    }
    }

    private void cargarSalon(){
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM salon");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idSalon = rs.getInt("id_salon");
                int capacidadAlumnos = rs.getInt("capacidad_alumnos");
                int piso = rs.getInt("piso");
                String identificador = rs.getString("identificador");
                int idEdificio = rs.getInt("id_edificio");
                // Crear objeto Salon
                Edificio edificio = obtenerEdificioPorId(idEdificio); // Método para obtener el edificio por su ID
                Salon salon = new Salon(idSalon, capacidadAlumnos, piso, identificador, edificio);
                // Agregar salon a la lista
                listaSalones.add(salon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return listaSalones;
    }

    private void cargarMatricula(){
        //cambiar lo del enummmmmm
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM matricula");
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            int idMatricula = rs.getInt("id_matricula");
            int idAlumno = rs.getInt("id_alumno");
            int idAsignaturaPeriodo = rs.getInt("id_asignatura_periodo");
            String estadoStr = rs.getString("estado");

            Alumno alumno = obtenerAlumnoPorId(idAlumno);
            AsignaturaPeriodo asignaturaPeriodo = obtenerAsignaturaPeriodoPorId(idAsignaturaPeriodo);

            Matricula.Estado estado;
            if (estadoStr.equals("a")) {
                estado = Matricula.Estado.A;
            } else if (estadoStr.equals("b")) {
                estado = Matricula.Estado.B;
            } else if (estadoStr.equals("c")) {
                estado = Matricula.Estado.C;
            } else {
                estado = Matricula.Estado.UNDEFINED;
            }

            Matricula matricula = new Matricula(idMatricula, alumno, asignaturaPeriodo, estado);
            listaMatriculas.add(matricula);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }





    private void cargarPrograma(){
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM programa");
        ResultSet rs = stmt.executeQuery()) {

       while (rs.next()) {
           int idPrograma = rs.getInt("id_programa");
           String nombre = rs.getString("nombre");
           boolean nivel = rs.getBoolean("nivel");
           // Crear objeto Programa
           Programa programa = new Programa(idPrograma, nombre, nivel);
           // Agregar programa a la lista
           listaProgramas.add(programa);
       }
   } catch (SQLException e) {
       e.printStackTrace();
   }

   //return listaProgramas;
    }


    private void cargarPeriodo(){
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM periodo");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idPeriodo = rs.getInt("id_periodo");
                int codigo = rs.getInt("codigo");
                Date año = rs.getDate("año");
                int semestre = rs.getInt("semestre");
                // Crear objeto Periodo
                Periodo periodo = new Periodo(idPeriodo, codigo, año, semestre);
                // Agregar periodo a la lista
                listaPeriodos.add(periodo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //return listaPeriodos;
    }
    

    private void cargarTarifa(){
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tarifa");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idTarifa = rs.getInt("id_tarifa");
                double valorCredito = rs.getDouble("valor_credito");
                int idPeriodo = rs.getInt("id_periodo");
                int idPrograma = rs.getInt("id_programa");
                // Crear objeto Tarifa
                Tarifa tarifa = new Tarifa(idTarifa, valorCredito,
                                new Periodo(idPeriodo), new Programa(idPrograma));
                // Agregar tarifa a la lista
                listaTarifas.add(tarifa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return listaTarifas;
    }


    private void cargarAsignatura(){
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM asignatura");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idAsignatura = rs.getInt("id_asignatura");
                String nombre = rs.getString("nombre");
                int creditos = rs.getInt("creditos");
                int cupoDisponible = rs.getInt("cupo_disponible");
                int idCurso = rs.getInt("id_curso");
                int idPrograma = rs.getInt("id_programa");

                // Obtener el objeto Curso asociado
                Curso curso = obtenerCursoPorId(idCurso);
                // Obtener el objeto Programa asociado
                Programa programa = obtenerProgramaPorId(idPrograma);

                // Crear objeto Asignatura
                Asignatura asignatura = new Asignatura(idAsignatura, nombre, creditos, cupoDisponible, curso, programa);
                // Agregar asignatura a la lista
                listaAsignaturas.add(asignatura);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //return listaAsignaturas;
    }
    
    private void cargarBloqueHorario(){
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bloque_horario");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idBloqueHorario = rs.getInt("id_bloque_horario");
                LocalTime horaInicio = rs.getTime("hora_inicio").toLocalTime();
                LocalTime horaFin = rs.getTime("hora_fin").toLocalTime();
                // Crear objeto BloqueHorario
                BloqueHorario bloqueHorario = new BloqueHorario(idBloqueHorario, horaInicio, horaFin);
                // Agregar bloqueHorario a la lista
                listaBloqueHorarios.add(bloqueHorario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return listaBloqueHorario;
    }




    private void cargarAsignaturaPeriodo(){
                try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM asignatura_periodo");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idAsignaturaPeriodo = rs.getInt("id_asignatura_periodo");
                int codigo = rs.getInt("codigo");
                int idProfesor = rs.getInt("id_profesor");
                int idPeriodo = rs.getInt("id_periodo");
                int idAsignatura = rs.getInt("id_asignatura");
                // Crear objeto AsignaturaPeriodo
                AsignaturaPeriodo asignaturaPeriodo = new AsignaturaPeriodo(idAsignaturaPeriodo, codigo,
                        new Profesor(idProfesor), new Periodo(idPeriodo), new Asignatura(idAsignatura));
                // Agregar asignaturaPeriodo a la lista
                listaAsignaturaPeriodo.add(asignaturaPeriodo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAsignaturaPeriodo;
    }

    
    private void cargarHorario(){
         try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM horario")) {

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id_horario");
                    Date dia = rs.getDate("dia");
                    int idSalon = rs.getInt("id_salon");
                    int idBloqueHorario = rs.getInt("id_bloque_horario");
                    // Obtener objetos Salon y BloqueHorario por sus respectivos IDs
                    Salon salon = obtenerSalonPorId(idSalon);
                    BloqueHorario bloqueHorario = obtenerBloqueHorarioPorId(idBloqueHorario);
                    // Crear objeto Horario y agregarlo a la lista
                    Horario horario = new Horario(id, dia, salon, bloqueHorario);
                    listaHorarios.add(horario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return horarios;
    }

    public Salon obtenerSalonPorId(int idSalon) {
    Salon salon = null;
    try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM salon WHERE id_salon = ?")) {
        stmt.setInt(1, idSalon);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                int id = rs.getInt("id_salon");
                String nombre = rs.getString("nombre");
                // Crear objeto Salon y asignar sus atributos
                salon = new Salon(id, nombre);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return salon;
}

    public BloqueHorario obtenerBloqueHorarioPorId(int idBloqueHorario) {
        BloqueHorario bloqueHorario = null;
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bloque_horario WHERE id_bloque_horario = ?")) {
            stmt.setInt(1, idBloqueHorario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id_bloque_horario");
                    // Obtener hora de inicio y fin del bloque horario
                    Time horaInicio = rs.getTime("hora_inicio");
                    Time horaFin = rs.getTime("hora_fin");
                    // Crear objeto BloqueHorario y asignar sus atributos
                    bloqueHorario = new BloqueHorario(id, horaInicio, horaFin);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bloqueHorario;
    }



    private Curso obtenerCursoPorId(int idCurso) {
    Curso curso = null;
    try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    //arreglar la consulta y revisar el metodo
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM curso WHERE id_curso = ?")) {
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                int id = rs.getInt("id_curso");
                String nombre = rs.getString("nombre");
                String temas = rs.getString("temas");
                String competencias = rs.getString("competencias");
                // Crear objeto Curso
                curso = new Curso(id, nombre, temas, competencias);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return curso;
}

    private Programa obtenerProgramaPorId(int idPrograma) {
        Programa programa = null;
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM programa WHERE id_programa = ?")) {

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id_programa");
                    String nombre = rs.getString("nombre");
                    boolean nivel = rs.getBoolean("nivel");
                    // Crear objeto Programa
                    programa = new Programa(id, nombre, nivel);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return programa;
    }

    private Edificio obtenerEdificioPorId(int idEdificio) {
        Edificio edificio = null;
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM edificio WHERE id_edificio = ?");
        ) {
            stmt.setInt(1, idEdificio);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id_edificio");
                    String nombre = rs.getString("nombre");
                    edificio = new Edificio(id, nombre);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return edificio;
    }

    private Alumno obtenerAlumnoPorId(int idAlumno) {
        Alumno alumno = null;
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM alumno WHERE id_alumno = ?");
        ) {
            stmt.setInt(1, idAlumno);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id_alumno");
                    // Obtener datos adicionales del alumno según la estructura de la tabla en la base de datos
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    // Crear una instancia de Alumno con los datos obtenidos
                    alumno = new Alumno(id, nombre, apellido);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumno;
     }
    }






