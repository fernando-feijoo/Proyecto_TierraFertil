package Modelo.Grupo3;

import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.Statement;

public class Modelo_Inspeccion_Contenedor {

    Modelo_Conexion conexion = new Modelo_Conexion();
    ResultSet rs;
    Statement st;
    public int id, id_contenedor, id_verificar_lugar;
    public String verificacion;

    public void guardar_Inspeccion_Contenedor() {
        try {
            st = conexion.conectarBD().createStatement();

            String sql = "SELECT \"insertarDatosInspeccion\" (" + id + "," + id_contenedor + " , " + id_verificar_lugar + " , '" + verificacion + "')";
            st.executeUpdate(sql);
            st.close();

        } catch (Exception e) {
            System.out.println("Error al tratar guardar los datos de llegada del contenedor " + e);
        }
    }

    public ResultSet consultaID_entidadInspeccionContenedor() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT COALESCE(MAX(id), 11 ) AS \"id_tablaInspeccionContenedor\" FROM inspeccion_contenedor;";
            rs = st.executeQuery(sql);
            st.close();
            System.out.println("Consulta id entidad InspConte... BD MODELO, " + id);

        } catch (Exception e) {
            System.out.println("Error al tratar de obtener  id entidad InspeccionContenedor BD MODELO: " + e);
        }
        return rs;
    }
    
      public void pruebaGuardado() {
        System.out.println("IC: " + id + " , " + id_contenedor + " , " + id_verificar_lugar + " , " + verificacion);
    }

}
