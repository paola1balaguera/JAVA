package UTILS;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionBD {

    private ConexionBD() {
    }
    //variable que guarda el estado de la conexion a la bd
    private static Connection conexion;
    //variable para crear solo una instancia
    private static ConexionBD instancia;
    
    //variables para la conexion de las bases de datos
    private static final String URL="jdbc:mysql://localhost:3306/universidad_proyecto?serverTimezone=UTC";
    private static final String USERNAME="root";
    private static final String PASSWORD="campus2024";
    
    // Método para obtener una instancia única de la conexión
    public static ConexionBD getInstance() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }
    
    // Método para establecer la conexión
    public Connection conectar() {
        try {
            // Por defecto
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("\n====================================\n");
            System.out.println("Conexión Exitosa.");
            
            return conexion;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: no se pudo abrir la conexion por: " + e + "\n"
                    + "Verifique si su base de datos está activa");
        }
        return conexion;
    }
    
    // Método para cerrar la conexión
    public void cerrarConexion() throws SQLException {
        try {
            conexion.close();
            System.out.println("\n====================================\n");
            System.out.println("Procediento con la desconexion de la base de datos\n"
                + "Desconectando de la base de datos......");
            System.out.println("Desconectado de la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: no se pudo cerrar por: " + e);
            conexion.close();
        } finally {
            // finally si o si cierra la conexión
            conexion.close();
        }
    }
}
