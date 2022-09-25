package Modelo.Grupo1;

import Modelo.Modelo_Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mod_listado_campo {

    Modelo_Conexion con = Modelo_Conexion.getInstancia();
    Connection conexion;
    
    public String buscar;

    public ResultSet consultas()  {
        try {
            Statement st = con.conectarBD().createStatement();
            String sql = "SELECT DISTINCT \n"
                    + "eva.id, eva.cod_evaluacion, prod.nombre as Nombre_Productor, prod.apellido AS Apellido_Productor, prod.finca AS Finca\n"
                    + "FROM productores prod inner join evaluaciones eva ON\n"
                    + "prod.codigo=eva.codigo_productor WHERE eva.cod_evaluacion like '"+this.buscar+"%'ORDER BY eva.id DESC;";
            ResultSet rs = st.executeQuery(sql);
            st.close();
            con.cerrarBD();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Mod_listado_campo.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
}
}
