package Modelo.Grupo1;

import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mod_sel_emp {

    Modelo_Conexion con = Modelo_Conexion.getInstancia();
    ResultSet rs;
    Statement st;

    public int clusterf1, ph1, clusterf2, ph2, clusterf3, ph3, id_eva;
    public int f1_1, f1_2, f1_3, f1_4, f1_5, f1_6, f1_7, f1_8, f1_9, f1_10, f1_11, f1_12, f1_13, f1_14, f1_15, f1_16, f1_17, f1_18, tot_f1;
    public int f2_1, f2_2, f2_3, f2_4, f2_5, f2_6, f2_7, f2_8, f2_9, f2_10, f2_11, f2_12, f2_13, f2_14, f2_15, f2_16, f2_17, f2_18, tot_f2;
    public int f3_1, f3_2, f3_3, f3_4, f3_5, f3_6, f3_7, f3_8, f3_9, f3_10, f3_11, f3_12, f3_13, f3_14, f3_15, f3_16, f3_17, f3_18, tot_f3;
    public int total_filas, total_cluster, total_ph2; public double promedio;
    public String observacion;

    public boolean registrar_seleccion_empaque() throws SQLException {
        st = con.conectarBD().createStatement();
        String sql = "INSERT INTO public.seleccion_empaque(\n"
                + "	cluster_caja, ph, sel_br, sel_cc, sel_ct, sel_lf, \n"
                + "	sel_ni, sel_ns, sel_ps, sel_sk, sel_sr, sel_tc, sel_tf, \n"
                + "	sel_yb, sel_sc, sel_dp, emp_br, emp_sr, emp_srf, emp_dp,total_filas, id_evaluacion)\n"
                + "	VALUES (" + this.clusterf1 + ", " + this.ph1 + ", " + this.f1_1 + ", " + this.f1_2 + ", " + this.f1_3 + ", " + this.f1_4 + ", " + this.f1_5 + ","
                + " " + this.f1_6 + ", " + this.f1_7 + ", " + this.f1_8 + ", " + this.f1_9 + ", " + this.f1_10 + ", " + this.f1_11 + ", " + this.f1_12 + ","
                + " " + this.f1_13 + ", " + this.f1_14 + ", " + this.f1_15 + ", " + this.f1_16 + ", " + this.f1_17 + ", " + this.f1_18 + ", " + this.tot_f1 + "," + this.id_eva + "),\n"
                + "	(" + this.clusterf2 + ", " + this.ph2 + ", " + this.f2_1 + ", " + this.f2_2 + ", " + this.f2_3 + ", " + this.f2_4 + ", " + this.f2_5 + ","
                + " " + this.f2_6 + ", " + this.f2_7 + ", " + this.f2_8 + ", " + this.f2_9 + ", " + this.f2_10 + ", " + this.f2_11 + ", " + this.f2_12 + ","
                + " " + this.f2_13 + ", " + this.f2_14 + ", " + this.f2_15 + ", " + this.f2_16 + ", " + this.f2_17 + ", " + this.f2_18 + "," + this.tot_f2 + ", " + this.id_eva + "),\n"
                + "	(" + this.clusterf3 + ", " + this.ph3 + ", " + this.f3_1 + ", " + this.f3_2 + ", " + this.f3_3 + ", " + this.f3_4 + ", " + this.f3_5 + ","
                + " " + this.f3_6 + ", " + this.f3_7 + ", " + this.f3_8 + ", " + this.f3_9 + ", " + this.f3_10 + ", " + this.f3_11 + ", " + this.f3_12 + ","
                + " " + this.f3_13 + ", " + this.f3_14 + ", " + this.f3_15 + ", " + this.f3_16 + ", " + this.f3_17 + ", " + this.f3_18 + "," + this.tot_f3 + ", " + this.id_eva + ");";
        st.executeUpdate(sql);
        con.cerrarBD();
        return true;
    }

    public boolean registrar_totales() throws SQLException {
        st = con.conectarBD().createStatement();
        String sql = "INSERT INTO public.datos_se_resultados(\n"
                + "	total_cluster, total_ph, total_defectos, promedio_tot, observacion, id_evaluacion)\n"
                + "	VALUES ("+this.total_cluster+", "+this.ph2+", "+this.total_filas+", "+this.promedio+",'"+this.observacion+"', "+this.id_eva+");";
        st.executeUpdate(sql);
        con.cerrarBD();
        return true;
    }

}
