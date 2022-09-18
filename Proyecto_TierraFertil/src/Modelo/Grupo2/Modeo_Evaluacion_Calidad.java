package Modelo.Grupo2;

import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Modeo_Evaluacion_Calidad{
    Modelo_Conexion conexion = new Modelo_Conexion();
    ResultSet rs;
    Statement st;
    
    public String fecha, calibracion, vapor, transporte, l_dedos, pedido, tipo_caja, peso, destino, fumigacion, destino2, semana,  finca, codigo, observaciones;
  
   
    
    public boolean guardarDatos(){
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "insert into evaluaciones_empacadora (id_semana, id_finca, codigo, fecha, pdo, vapor, tipo_caja, peso, destino, l_dedos, calibracion, fumigacion, transporte, observaciones) "
                    + " values ('"+this.semana+"', '"+this.finca+"', '"+this.codigo+"', '"+this.fecha+"', '"+this.pedido+"', '"+this.vapor
                    +"', '"+this.tipo_caja+"', '"+this.peso+"', '"+this.destino+"', '"+this.l_dedos+"', '"+this.calibracion+"', '"+this.fumigacion+"', '"+this.transporte+"', '"+this.observaciones+"');";
            
            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en guardarDatos de Modelo_Evaluacion. "+e);
        }
        return false;
    }
    
    public boolean guardarTabulacion(){
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "";
            
            st.execute(sql);
            st.close();
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en guardarTabulacion en Modelo_Evaluacion. "+e);
        }
        return false;
        
    }
    
}
