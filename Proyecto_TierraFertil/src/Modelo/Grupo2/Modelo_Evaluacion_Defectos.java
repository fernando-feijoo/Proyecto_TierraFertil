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

    public String nombre, pcmd, codigoCargar2, id_detalle, codigoCargaTabulacionFinal, id_detalle_eliminar;
    public int id_defecto, total_defectos;
    public int id_calculo;
    public int pcmd_total;

    public boolean guardarDefectos() {
        try {
            st = conexion.conectarBD().createStatement();

            String sql = "insert into defectos_detalle_eva(id_detalle_ev, nombre, total_defectos, pcmd) values ('" + this.id_detalle + "', '" + this.nombre + "', "
                    + "'" + this.total_defectos + "', '" + this.pcmd + "');";
            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en guardarDefectos en modeloEvaluacionDefectos. " + e);
        }
        return false;

    }

    public ResultSet consultarDefectos() {
        try {
            st = conexion.conectarBD().createStatement();

            //OJO VA ID_DEFECTO.
            String sql = "select id,nombre,total_defectos,pcmd from defectos_detalle_eva where id_detalle_ev = '" + this.id_detalle + "' ;";
            rs = st.executeQuery(sql);

            return rs;
        } catch (Exception e) {
            System.out.println("Error al consultarDefectos. " + e);
        }

        return null;

    }

    public ResultSet obtenerTotalGajos() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "select total_gajos from detalle_evaluacion_emp WHERE id_evaluacion = '" + this.id_calculo + "'";
            rs = st.executeQuery(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en obtenerTotalGajos");
        }
        return null;
    }

    public ResultSet selecionDefectos() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT DISTINCT eva.nombre, eva.total_defectos  FROM defectos_detalle_eva eva INNER JOIN"
                    + " detalle_evaluacion_emp emp on emp.id = eva.id_detalle_ev INNER JOIN evaluaciones_empacadora eva_emp ON "
                    + "eva_emp.id = emp.id_evaluacion WHERE eva_emp.codigo = '" + this.codigoCargar2 + "';";
            rs = st.executeQuery(sql);

            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en seleccionDefectos modeloDefectos " + e);
        }
        return null;

    }

    public ResultSet calcularPcmdTotal() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT porc_fin('" + this.pcmd_total + "');";
            rs = st.executeQuery(sql);

            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en seleccionDefectos modeloDefectos " + e);
        }
        return null;

    }

    public ResultSet consultarTabulacionFinal() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "select id , caja_inspeccionada ,embalador, peso_neto, par4, par6, par8, impar5, impar7, total_gajos, pcmd_final from "
                    + " detalle_evaluacion_emp where id_evaluacion = '" + this.codigoCargaTabulacionFinal + "'"
                    + "order by id asc;";

            rs = st.executeQuery(sql);

            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en constultarTabulacion" + e);
        }
        return null;

    }

    public boolean eliminarDefectoPermanente() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "delete from defectos_detalle_eva WHERE id='"+this.id_detalle_eliminar+"';";
            st.executeUpdate(sql);
            st.close();

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en eliminar defecto " +e);
        }
        return true;
    }

}
