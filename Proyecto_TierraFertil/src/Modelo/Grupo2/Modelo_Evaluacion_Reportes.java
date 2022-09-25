package Modelo.Grupo2;
import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class Modelo_Evaluacion_Reportes {
    Modelo_Conexion conexion = new Modelo_Conexion();
    ResultSet rs;
    Statement st;
    
    public ResultSet mostrarListado() {
        try {
            st = conexion.conectarBD().createStatement();
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
}
