
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;



public class Modelo_Conexion {
    Connection conexion;
     public Connection conectarBD() {
        try {
            String url = "jdbc:postgresql://localhost:5432/bd_tierra_fertil";
            String user = "postgres";
            String pass = "postgres";

            conexion = DriverManager.getConnection(url, user, pass);
                    return conexion;  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar la BD");

        }

        return null;

    }
    
}
