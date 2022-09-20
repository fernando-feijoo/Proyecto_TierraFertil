package Modelo.Grupo3;

import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.Statement;

public class Modelo_Contenedores {
    Modelo_Conexion conexion = new Modelo_Conexion();
    ResultSet rs;
    Statement st;
    public static int id;
    public static String codigo_Contenedor, obser_Ins_Cont, obser_Hig_Cont, obser_General;
    public boolean estado;
    
    public void guardarContenedorDatos() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT \"insertarDatosContenedor\"("+id+", '"+codigo_Contenedor+"', '"+obser_Ins_Cont+"', '"+obser_Hig_Cont+"', '"+obser_General+"');";
            st.executeUpdate(sql);
            st.close();
            System.out.println(id + " Datos almacenados Contenedor BD MODELO.");
        } catch (Exception e) {
        }
    }
    
    public ResultSet consultaID_contenedor() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT COALESCE(MAX(id), 0) AS id_contenedor FROM contenedores;";
            rs = st.executeQuery(sql);
            st.close();
            conexion.conectarBD().close();
            System.out.println("Consulta id contenedor... BD MODELO, " + id);
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener id entidad contenedores en BD MODELO: " + e);
        }
        return rs;
    }
    
    public void pruebaGuardado(){
        System.out.println(id + " , " + codigo_Contenedor + " , " + obser_Ins_Cont + " , " + obser_Hig_Cont + " , " + obser_General);
    }
}
