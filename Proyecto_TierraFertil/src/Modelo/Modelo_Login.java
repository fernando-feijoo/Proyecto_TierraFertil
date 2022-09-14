/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Modelo_Login {
    Modelo_Conexion conn = new Modelo_Conexion();
    public String user;
    public String pass;
    
    
     public ResultSet consultarUsuario() {
        try {
            Statement st = conn.conectarBD().createStatement();
            String SQL = "SELECT  usuario, contrasena,rol  FROM  roles where usuario = '"+this.user+"' and contrasena = '"+this.pass+"' ;";
          
            ResultSet rs =  st.executeQuery(SQL);
            
            return rs;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return null;
    }
    
}
