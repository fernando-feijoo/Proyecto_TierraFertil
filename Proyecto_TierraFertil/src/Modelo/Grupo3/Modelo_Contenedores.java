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
    
    public boolean guardarContenedorDatos() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT \"insertarDatosContenedor\"("+this.id+", "+this.codigo_Contenedor+", '"+this.obser_Ins_Cont+"', '"+this.obser_Hig_Cont+"', '"+this.obser_General+"');";
            st.executeUpdate(sql);
            st.close();

        } catch (Exception e) {
            System.out.println("Error al tratar guardar los datos de llegada del contenedor " + e);
        }
        return true;
    }
    
    public ResultSet consultaID_contenedor() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT COALESCE(MAX(id), 0) AS id_contenedor FROM contenedores;";
            rs = st.executeQuery(sql);
            st.close();
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener id entidad contenedores: " + e);
        }
        return rs;
    }
}
