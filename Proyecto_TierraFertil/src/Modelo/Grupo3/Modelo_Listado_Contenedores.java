package Modelo.Grupo3;

import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Modelo_Listado_Contenedores {

    Modelo_Conexion conexion = new Modelo_Conexion();
    ResultSet rs;
    Statement st;

    public ResultSet consultarDatos() {

        try {
            st = conexion.conectarBD().createStatement();
            String sql = "Select distinct \n"
                    + "codigo,semana,fecha_insp,hora_llegada,nombre_finca,obser_ins_cont,obser_hig_cont,sello_verificador,obser_general\n"
                    + "from\n"
                    + "contenedores inner join datos_llegada  on (contenedores.id = datos_llegada.id_contenedor) inner join\n"
                    + " datos_despacho  on (contenedores.id = datos_despacho.id_contenedor)\n"
                    + " where\n"
                    + " contenedores.codigo ilike '%'\n"
                    + " order by\n"
                    + " codigo;";

            rs = st.executeQuery(sql);
            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta.." + e);
        }
        return null;

    }
}
