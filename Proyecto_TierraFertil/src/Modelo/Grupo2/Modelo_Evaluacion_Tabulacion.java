package Modelo.Grupo2;

import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Vista.Grupo2.Vista_Evaluacion_Total;

public class Modelo_Evaluacion_Tabulacion {

    Modelo_Conexion conexion = new Modelo_Conexion();
   
    ResultSet rs;
    Statement st;

    public Double peso_neto;
    public int caja_inspeccionada, embalador, par4, par6, par8, impar5, impar7, total_gajos;
    public double pcmd_total;
    public String codigoCargar, codigoCargaTabulacion, idTabulacionActualizar, num_id;
    

    public boolean guardarTabulacion() {
        try {
            st = conexion.conectarBD().createStatement();

            total_gajos = par4 + par6 + par8 + impar5 + impar7;

            // (total defecto x 100) / total gajos  después 100-respuesta calculo anterior
            String sql = "insert into detalle_evaluacion_emp(id_evaluacion,caja_inspeccionada,embalador,peso_neto,par4,par6,par8,impar5,impar7, total_gajos, pcmd_final)"
                    + "values((select max(id)from evaluaciones_empacadora), '" + this.caja_inspeccionada + "', '" + this.embalador + "', '" + this.peso_neto
                    + "', '" + this.par4 + "', '" + this.par6 + "', '" + this.par8 + "', '" + this.impar5 + "','" + this.impar7 + "', '" + this.total_gajos + "', '" + this.pcmd_total + "');";

            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en guardarTabulacion en modeloTabulacion. " + e);
        }

        return false;

    }
        //Sentencia para mostrar datos en la grilla
    public ResultSet consultarTabulacion() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "select id , caja_inspeccionada ,embalador, peso_neto, par4, par6, par8, impar5, impar7, total_gajos, pcmd_final from "
                    + " detalle_evaluacion_emp where id_evaluacion = '"+this.codigoCargaTabulacion+"'"
                    
                    + "order by id asc;";

            rs = st.executeQuery(sql);

            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en constultarTabulacion" + e);
        }
        return null;

    }
    public ResultSet seleccionIdTabulacion() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "select id , caja_inspeccionada ,embalador, peso_neto, par4, par6, par8, impar5, impar7, total_gajos, pcmd_final from "
                    + " detalle_evaluacion_emp where id_evaluacion = '"+this.codigoCargaTabulacion+"' AND id = '"+this.num_id+"'"
                    
                    + "order by id asc;";

            rs = st.executeQuery(sql);

            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en constultarTabulacion" + e);
        }
        return null;

    }

    public ResultSet selecionTabulacion() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT DISTINCT emp.caja_inspeccionada, emp.embalador, emp.peso_neto, emp.par4, emp.par6, emp.par8, emp.impar5, emp.impar7 "
                    + "FROM detalle_evaluacion_emp emp inner join evaluaciones_empacadora eva_empaca on"
                    + "  emp.id = eva_empaca.id WHERE eva_empaca.codigo = '" + this.codigoCargar + "';";
            rs = st.executeQuery(sql);

            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en seleccionTabulacion modeloTabulacion " + e);
        }
        return null;

    }
    public ResultSet obtenerIdTabulacion() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "select max(id)as id_det from detalle_evaluacion_emp;";
            rs = st.executeQuery(sql);

            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en obtenerIdEvaluacion. " + e);
        }
        return null;
    }
     public boolean actualizarTabulacion() {
        try {
            st = conexion.conectarBD().createStatement();

            total_gajos = par4 + par6 + par8 + impar5 + impar7;

            // (total defecto x 100) / total gajos  después 100-respuesta calculo anterior
            String sql = "update detalle_evaluacion_emp set caja_inspeccionada='"+this.caja_inspeccionada+"', embalador='"+this.embalador+
                    "', peso_neto='"+this.peso_neto+"', par4='"+this.par4+"', par6='"+this.par6
                    +"', par8='"+this.par8+"', impar5='"+this.impar5+"', impar7='"+this.impar7+"', total_gajos='"+total_gajos+"' where id='"+this.idTabulacionActualizar+"';";

            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en guardarTabulacion en modeloTabulacion. " + e);
        }

        return false;
        

    }
     
}
