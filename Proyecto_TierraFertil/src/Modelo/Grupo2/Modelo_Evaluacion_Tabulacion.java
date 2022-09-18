package Modelo.Grupo2;
import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class Modelo_Evaluacion_Tabulacion {
    
    Modelo_Conexion conexion = new Modelo_Conexion();
    ResultSet rs;
    Statement st;
    
    public Double  peso_neto;
    public int caja_inspeccionada, embalador, par4, par6, par8, impar5, impar7;

    public boolean guardarTabulacion(){
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "insert into detalle_evaluacion_emp(id_evaluacion, caja_inspeccionada, embalador, peso_neto, par4, par8, impar5, impar7)"
                    + "values((select max(id)from evaluaciones_empacadora),'"+this.caja_inspeccionada+"'"
                    + "'"+this.embalador+"', '"+this.peso_neto+"', '"+this.par4+"', '"+this.par6+"', '"+this.par8+"', '"+this.impar5+"', '"+this.impar7+"')";
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en guardarTabulacion en modeloTabulacion. " +e);
        }
        
        
        return false;
        
    }
   
            
    
}
