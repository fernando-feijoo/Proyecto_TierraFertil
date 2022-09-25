
package Modelo.Grupo2;

import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Modelo_Evaluacion_Datos {
     Modelo_Conexion conexion = new Modelo_Conexion();
    ResultSet rs;
    Statement st;
    
    public String fecha, calibracion, vapor, transporte, l_dedos, pedido, tipo_caja, peso, destino, fumigacion, codigo, observaciones;
    public int semana, finca;
    
    public String estado = "A";
    
    public boolean guardarDatos(){
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "insert into evaluaciones_empacadora (id_semana, finca, codigo, fecha, pdo, vapor, tipo_caja, peso, destino, l_dedos, calibracion, fumigacion, transporte, observaciones, estado_act_inac) "
                    + " values ('"+this.semana+"', '"+this.finca+"', '"+this.codigo+"', '"+this.fecha+"', '"+this.pedido+"', '"+this.vapor
                    +"', '"+this.tipo_caja+"', '"+this.peso+"', '"+this.destino+"', '"+this.l_dedos+"', '"+this.calibracion+"', '"+this.fumigacion+"', '"+this.transporte+"', '"+this.observaciones+"', '"+this.estado+"');";
            
            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en guardarDatos de Modelo_Evaluacion. "+e);
        }
        return false;
    }
    

     
     public ResultSet obtenerIdEvaluaciones(){
         try {
             st = conexion.conectarBD().createStatement();
             String sql = "select max(id) as id_ev from evaluaciones_empacadora";
             rs = st.executeQuery(sql);
             
             return rs;
             
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error en obtenerIdEvaluacion. "+e);
         }
         return null;
     }
     
     public ResultSet mostrarDatos(){
         try {
             st = conexion.conectarBD().createStatement();
             String sql = "";
             rs = st.executeQuery(sql);
         } catch (Exception e) {
         }
         return null;
         
     }
    
     
 
   
     
    
    
}
