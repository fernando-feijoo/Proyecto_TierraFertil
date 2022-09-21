package Modelo;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Modelo_Login {
    Modelo_Conexion conexion = new Modelo_Conexion();
    public static String user;
    public String pass;
    public static String rol;
    
     public ResultSet consultarUsuario() {
        try {
            Statement st = conexion.conectarBD().createStatement();
            String SQL = "SELECT  usuario, contrasena, rol  FROM  roles where usuario = '"+this.user+"' and contrasena = '"+this.pass+"' ;";
          
            ResultSet rs =  st.executeQuery(SQL);
            st.close();
            conexion.conectarBD().close();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return null;
    }
}