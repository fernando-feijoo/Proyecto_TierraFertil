package Modelo.Grupo2;

import Modelo.Modelo_Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Modelo_Evaluacion_Listado {

    Modelo_Conexion Conexion = new Modelo_Conexion();
    ResultSet rs;
    Statement st;
    PreparedStatement ps;
    public String fecha, codigo, cargaCodigo;
    public String estado;

    public ResultSet mostrarListado() {
        try {
            st = Conexion.conectarBD().createStatement();
            String sql = "select distinct  eva.codigo, eva.fecha, eva.id_semana,eva.destino,count(det.caja_inspeccionada)"
                    + "as cajas_inspeccionadas from evaluaciones_empacadora eva inner join detalle_evaluacion_emp det on"
                    + "(eva.id=det.id_evaluacion) where eva.estado_act_inac='ACTIVO' group by eva.codigo, eva.fecha, eva.id_semana,eva.destino;";

            rs = st.executeQuery(sql);

            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en mostrarListado en ModeloListado" + e);
        }

        return null;

    }

    public ResultSet eliminarRegistro() {
        try {
            //CAMBIAR POR UPDATE
            int resultado = 0;
            st = Conexion.conectarBD().createStatement();
            String sql = "update evaluaciones_empacadora set estado_act_inac='INACTIVO' where codigo ='" + this.codigo + "'";
            st.executeUpdate(sql);

            st.close();

            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en eliminarRegistro en ModeloListado" + e);
        }
        return null;

    }

    

}
