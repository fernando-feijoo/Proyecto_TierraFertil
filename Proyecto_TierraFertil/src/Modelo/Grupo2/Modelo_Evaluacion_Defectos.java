
package Modelo.Grupo2;
import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class Modelo_Evaluacion_Defectos {
    Modelo_Conexion conexion = new Modelo_Conexion();
    ResultSet rs;
    Statement st;
    
    public String nombre, total_defectos, pcmd;
    public int id_detalle;
    
    
    public boolean guardarDefectos(){
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "insert into defectos_detalle_eva(id_detalle_ev, nombre, total_defectos) values ('"+this.id_detalle+"', '"+this.nombre+"', "
                    + "'"+this.total_defectos+"');";
            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en guardarDefectos en modeloEvaluacionDefectos. "+ e);
        }
        return false;
        
    }

    
    
}
