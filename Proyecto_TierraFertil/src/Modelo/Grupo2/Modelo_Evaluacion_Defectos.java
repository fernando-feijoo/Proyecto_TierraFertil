
package Modelo.Grupo2;
import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Modelo_Evaluacion_Defectos {
    Modelo_Conexion conexion = new Modelo_Conexion();
    ResultSet rs;
    Statement st;
    
    public String nombre, total_defectos, pcmd;
    public int id_detalle, id_defecto;
    
    
    
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
    
    public ResultSet consultarDefectos(){
        try {
            st = conexion.conectarBD().createStatement();
            
            //OJO VA ID_DEFECTO.
            String sql = "select id,nombre,total_defectos,pcmd from defectos_detalle_eva where id_detalle_ev = '"+this.id_detalle+"' ;";
            rs = st.executeQuery(sql);
            
            return rs;
        } catch (Exception e) {
            System.out.println("Error al consultarDefectos. "+e);
        }
        
        return null;
        
    }
   
    

    
    
}
