package Modelo.Grupo3;

import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Modelo_Obtener_Reportes {
    
    Modelo_Conexion conexion = Modelo_Conexion.getInstancia();
    ResultSet rs;
    Statement st;
    public static String busquedaGeneral, busquedaID_Contenedor;
    public ResultSet consultarDatos() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT DISTINCT \n"
                    + "codigo, semana, fecha_insp, hora_llegada, nombre_finca, obser_ins_cont, obser_hig_cont, sello_verificador, obser_general\n"
                    + "FROM\n"
                    + "contenedores INNER JOIN datos_llegada  ON (contenedores.id = datos_llegada.id_contenedor) INNER JOIN\n"
                    + "datos_despacho  ON (contenedores.id = datos_despacho.id_contenedor)\n"
                    + "WHERE\n"
                    + "contenedores.codigo ILIKE '"+ busquedaGeneral +"%' AND contenedores.estado = 'true' \n"
                    + "ORDER BY\n"
                    + "semana DESC;";
            rs = st.executeQuery(sql);
            st.close();
            conexion.cerrarBD();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta.." + e);
        } 
        return rs;
    }

    public ResultSet consultaID_Contenedor(){
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT DISTINCT id FROM contenedores WHERE codigo = '"+ busquedaID_Contenedor +"';";
            rs = st.executeQuery(sql);
            st.close();
            conexion.cerrarBD();
            System.out.println("CODIGO CONTENEDOR MODELO LC: " + busquedaID_Contenedor);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ID Contenedor MODELO LIS-CONT.. " + e);
        } 
        return rs;
    }
}
