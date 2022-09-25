package Modelo.Grupo3;

import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Modelo_Listado_Contenedores {

    Modelo_Conexion conexion = Modelo_Conexion.getInstancia();
    ResultSet rs;
    Statement st;
    public static String busquedaGeneral, busquedaID_Contenedor, elimando_Contenedor;
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
            System.out.println("CODIGO CONTENEDOR MODELO LC: " + busquedaID_Contenedor);
            rs = st.executeQuery(sql);
            st.close();
            conexion.cerrarBD();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ID Contenedor MODELO LIS-CONT.. " + e);
        } 
        return rs;
    }
    
    public void eliminadoLogico_Contenedor(){
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "UPDATE contenedores SET estado = 'false' WHERE codigo = '"+ elimando_Contenedor +"';";
            rs = st.executeQuery(sql);
            st.close();
            conexion.cerrarBD();
            System.out.println("ELIMINADO CONTENEDOR MODELO LC: " + elimando_Contenedor);
        } catch (Exception e) {
        } 
    }
}
