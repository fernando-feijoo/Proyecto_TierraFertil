package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Modelo_Conexion {

    private static Modelo_Conexion instancia;
    private static int conTemp = 0;
    private Connection conexion = null;

    private Modelo_Conexion() {

    }

    public static Modelo_Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Modelo_Conexion();
        } else {
            System.out.println("No se puede crear el objeto " + instancia + " porque ya existe un objeto de la clase.");
        }
        return instancia;
    }

    public Connection conectarBD() {
        try {
            String url = "jdbc:postgresql://localhost:5432/bd_tierra_fertil";
            String user = "postgres";
            String pass = "postgres";

            conexion = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion exitosa.");
            return conexion;
        } catch (Exception e) {
            System.out.println("Error de conexion: " + e);
            if (conTemp == 0) {
                JOptionPane.showMessageDialog(null, "Error al conectar la BD");
                conTemp++;
            }
        }
        return null;
    }

    public void cerrarBD() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("BD Cerrada nice.");
            } catch (SQLException ex) {
            }
        }
    }
}
