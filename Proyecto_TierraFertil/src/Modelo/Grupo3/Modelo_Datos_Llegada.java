package Modelo.Grupo3;

import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class Modelo_Datos_Llegada {

    Modelo_Conexion conexion = new Modelo_Conexion();
    ResultSet rs;
    Statement st;
    public String fecha_insp, semana, fecha_horasalida, hora_llegada, caja, cupo, contenedor, placa, chasis, chofer, ci, finca, candados, sellos_internos, sellos_externos;

    public boolean guardar_llegada() {
        try {
            st = conexion.conectarBD().createStatement();
            
            String sql = "INSERT INTO datos_llegada(id_contenedor, fecha_insp, semana, fecha_hora_salida, hora_llegada, tipo_caja, cupo, placa, chasis, chofer_contenedor, cedula_chofer, nombre_finca, sellos_internos, sellos_externos) "
                    + "VALUES ('"+this.contenedor+"', '"+this.fecha_insp+"', '"+this.semana+"', '"+this.fecha_horasalida+"', '"+this.hora_llegada+"', '"+this.caja+"', '"+this.cupo+"', '"+this.contenedor+"', '"+this.placa+"', '"+this.chasis+"', '"+this.chofer+"', '"+this.ci+"', '"+this.finca+"', '"+this.candados+"');";
            st.executeUpdate(sql);
            st.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al tratar guardar los datos de llegada del contenedor" + e);

        }

        return true;

    }
    public boolean guardar_contenedor() {
            try {
              st = conexion.conectarBD().createStatement();
              String sql="INSERT INTO contenedores(codigo) VALUES ('"+this.contenedor+"');";
              st.executeUpdate(sql);
            st.close();
            } catch (Exception e) {
            }
        return true;
}
}

