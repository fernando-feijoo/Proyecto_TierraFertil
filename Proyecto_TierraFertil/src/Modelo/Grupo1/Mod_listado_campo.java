package Modelo.Grupo1;

import Modelo.Modelo_Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Mod_listado_campo {

    Modelo_Conexion con = new Modelo_Conexion();
    Connection conexion;
    ResultSet rs; Statement st;
    public String buscar; public String id_evaluacion;

    public ResultSet consultas()  {
        try {
            Statement st = con.conectarBD().createStatement();
            String sql = "SELECT DISTINCT \n"
                    + "eva.id, eva.cod_evaluacion, prod.nombre as Nombre_Productor, prod.apellido AS Apellido_Productor, prod.finca AS Finca\n"
                    + "FROM productores prod inner join evaluaciones eva ON\n"
                    + "prod.codigo=eva.codigo_productor WHERE eva.cod_evaluacion like '"+this.buscar+"%' and eva.estado = 'Activo' ORDER BY eva.id DESC;";
            ResultSet rs = st.executeQuery(sql);
            st.close();
            con.conectarBD().close();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Mod_listado_campo.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
}
    
    public ResultSet eliminarRegistro() {
        try {
            st = con.conectarBD().createStatement();
            String sql = "UPDATE evaluaciones SET estado = 'Inactivo' WHERE id = "+this.id_evaluacion+";";
            st.executeUpdate(sql);
            st.close();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se elimino el registro" + e);
        }
        return null;
        
    }
}
