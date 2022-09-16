package Modelo.Grupo3;

import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.Statement;

public class Modelo_Datos_Llegada {

    Modelo_Conexion conexion = new Modelo_Conexion();
    Modelo_Contenedores modeloContenedor = new Modelo_Contenedores();
    ResultSet rs;
    Statement st;
    public int id, id_contenedor, semana;
    public String fecha_insp, fecha_horaSalida, hora_llegada, caja, cupo, contenedor, placa, chasis, chofer, ci, finca, candados, sellos_internos, sellos_externos;

    public boolean guardar_llegada() {
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

    public ResultSet consultaID_entidadDatosLlegada() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT COALESCE(MAX(id), 0) AS \"id_tablaDatosLlegada\" FROM datos_llegada;";
            rs = st.executeQuery(sql);
            st.close();
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener id entidad datos_llegada: " + e);
        }
        return rs;
    }
}