package Modelo.Grupo3;

import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.Statement;


public class Modelo_Despacho {
    
    
    Modelo_Conexion conexion = new Modelo_Conexion();
    Modelo_Contenedores modeloContenedor = new Modelo_Contenedores();
    ResultSet rs;
    Statement st;
    public int id, id_contenedor;
    
    public ResultSet consultaID_entidadDespacho() {
        try {
            System.out.println("Consulta id entidad Despacho... BD Modelo, " + this.id);
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT COALESCE(MAX(id), 0) AS \"id_tablaDatosDespacho\" FROM datos_despacho;";
            rs = st.executeQuery(sql);
            st.close();
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener id entidad datos_despacho: " +e);
        }
        return rs;
    }
    
}
