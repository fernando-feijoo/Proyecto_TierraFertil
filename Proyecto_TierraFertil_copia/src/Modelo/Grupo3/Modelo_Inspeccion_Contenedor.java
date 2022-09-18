package Modelo.Grupo3;

import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.Statement;

public class Modelo_Inspeccion_Contenedor {
    
    Modelo_Conexion conexion = new Modelo_Conexion();
    ResultSet rs;
    Statement st;
    public boolean  puertas,pared_izquiera,espaciadores,pared_frontal,pared_derecha,techo,piso_interior,evaporadores,tornillo_seguridad,delefactor; 
    
    public boolean guardar_Inspeccion_Contenedor() {
        try {
            st = conexion.conectarBD().createStatement();

            String sql = "";
            st.executeUpdate(sql);
            st.close();

        } catch (Exception e) {
            System.out.println("Error al tratar guardar los datos de llegada del contenedor " + e);
        }
        return true;
    }
    
    
    public ResultSet consultaID_entidadInspeccionContenedor() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT COALESCE(MAX(id), 0) AS \"id_tablaInspeccionContenedor\" FROM inspeccion_contenedor;";
            rs = st.executeQuery(sql);
            st.close();
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener id entidad datos_llegada: " + e);
        }
        return rs;
    }
    
}
