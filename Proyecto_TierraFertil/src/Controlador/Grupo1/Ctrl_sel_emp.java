package Controlador.Grupo1;

import Modelo.Grupo1.Mod_detalles_gen;
import Modelo.Grupo1.Mod_sel_emp;
import Vista.Grupo1.Vista_campo_respaldo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Ctrl_sel_emp implements ActionListener{

    Vista_campo_respaldo nn;
    Mod_sel_emp mse = new Mod_sel_emp();
    Mod_detalles_gen dg = new Mod_detalles_gen();
    
    public Ctrl_sel_emp(Vista_campo_respaldo nn){
    
        this.nn=nn;
        this.nn.btn_ok_sel_emp.addActionListener(this);
        this.nn.btn_guardar_se.addActionListener(this);
    }
    int f1_1,f1_2,f1_3,f1_4,f1_5,f1_6,f1_7,f1_8,f1_9,f1_10,f1_11,f1_12,f1_13,f1_14,f1_15,f1_16,f1_17,f1_18, tot_f1;
    int f2_1,f2_2,f2_3,f2_4,f2_5,f2_6,f2_7,f2_8,f2_9,f2_10,f2_11,f2_12,f2_13,f2_14,f2_15,f2_16,f2_17,f2_18,tot_f2;
    int f3_1,f3_2,f3_3,f3_4,f3_5,f3_6,f3_7,f3_8,f3_9,f3_10,f3_11,f3_12,f3_13,f3_14,f3_15,f3_16,f3_17,f3_18,tot_f3, total_filas;
    int cluster1, cluster2, cluster3, totalcluster, ph1, ph2, ph3, totalph, totalph2;
    double t1, t2, resta, promedio;
    
    int id_evaluacion;
    @Override
    public void actionPerformed(ActionEvent e) {
    
        if (e.getSource() == this.nn.btn_ok_sel_emp) {
            datos();
            this.nn.txt_total_defectos1.setText(String.valueOf(tot_f1));
            this.nn.txt_total_defectos2.setText(String.valueOf(tot_f2));
            this.nn.txt_total_defectos3.setText(String.valueOf(tot_f3));
            this.nn.txt_total_defectos.setText(String.valueOf(total_filas));
            this.nn.txt_sel_total_cluster.setText(String.valueOf(totalcluster));
            this.nn.txt_sel_total_ph.setText(String.valueOf(totalph2));
            this.nn.txt_promedio_se.setText(String.valueOf(promedio));
        }else if (e.getSource() == this.nn.btn_guardar_se) {
            try {
                guardar_datos();
            } catch (SQLException ex) {
                Logger.getLogger(Ctrl_sel_emp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void datos(){
        f1_1=Integer.parseInt(this.nn.txt_sel_br1.getText()); f1_2=Integer.parseInt(this.nn.txt_sel_cc1.getText()); f1_3=Integer.parseInt(this.nn.txt_seleccion_ct1.getText());
        f1_4=Integer.parseInt(this.nn.txt_sel_lf1.getText()); f1_5=Integer.parseInt(this.nn.txt_sel_ni1.getText()); f1_6=Integer.parseInt(this.nn.txt_sel_ns1.getText());
        f1_7=Integer.parseInt(this.nn.txt_sel_ps1.getText()); f1_8=Integer.parseInt(this.nn.txt_sel_sk1.getText()); f1_9=Integer.parseInt(this.nn.txt_sel_sr1.getText());
        f1_10=Integer.parseInt(this.nn.txt_sel_tc1.getText()); f1_11=Integer.parseInt(this.nn.txt_sel_tf1.getText()); f1_12=Integer.parseInt(this.nn.txt_sel_yb1.getText());
        f1_13=Integer.parseInt(this.nn.txt_sel_sc1.getText()); f1_14=Integer.parseInt(this.nn.txt_sel_dp1.getText()); f1_15=Integer.parseInt(this.nn.txt_empaq_br1.getText());
        f1_16=Integer.parseInt(this.nn.txt_empaq_sr1.getText()); f1_17=Integer.parseInt(this.nn.txt_empaq_srf1.getText()); f1_18=Integer.parseInt(this.nn.txt_empaq_dp1.getText());
        
        f2_1=Integer.parseInt(this.nn.txt_sel_br2.getText()); f2_2=Integer.parseInt(this.nn.txt_sel_cc2.getText()); f2_3=Integer.parseInt(this.nn.txt_seleccion_ct2.getText());
        f2_4=Integer.parseInt(this.nn.txt_sel_lf2.getText()); f2_5=Integer.parseInt(this.nn.txt_sel_ni2.getText()); f2_6=Integer.parseInt(this.nn.txt_sel_ns2.getText());
        f2_7=Integer.parseInt(this.nn.txt_sel_ps2.getText()); f2_8=Integer.parseInt(this.nn.txt_sel_sk2.getText()); f2_9=Integer.parseInt(this.nn.txt_sel_sr2.getText());
        f2_10=Integer.parseInt(this.nn.txt_sel_tc2.getText()); f2_11=Integer.parseInt(this.nn.txt_sel_tf2.getText()); f2_12=Integer.parseInt(this.nn.txt_sel_yb2.getText());
        f2_13=Integer.parseInt(this.nn.txt_sel_sc2.getText()); f2_14=Integer.parseInt(this.nn.txt_sel_dp2.getText()); f2_15=Integer.parseInt(this.nn.txt_empaq_br2.getText());
        f2_16=Integer.parseInt(this.nn.txt_empaq_sr2.getText()); f2_17=Integer.parseInt(this.nn.txt_empaq_srf2.getText()); f2_18=Integer.parseInt(this.nn.txt_empaq_dp2.getText());
        
        f3_1=Integer.parseInt(this.nn.txt_sel_br3.getText()); f3_2=Integer.parseInt(this.nn.txt_sel_cc3.getText()); f3_3=Integer.parseInt(this.nn.txt_seleccion_ct3.getText());
        f3_4=Integer.parseInt(this.nn.txt_sel_lf3.getText()); f3_5=Integer.parseInt(this.nn.txt_sel_ni3.getText()); f3_6=Integer.parseInt(this.nn.txt_sel_ns3.getText());
        f3_7=Integer.parseInt(this.nn.txt_sel_ps3.getText()); f3_8=Integer.parseInt(this.nn.txt_sel_sk3.getText()); f3_9=Integer.parseInt(this.nn.txt_sel_sr3.getText());
        f3_10=Integer.parseInt(this.nn.txt_sel_tc3.getText()); f3_11=Integer.parseInt(this.nn.txt_sel_tf3.getText()); f3_12=Integer.parseInt(this.nn.txt_sel_yb3.getText());
        f3_13=Integer.parseInt(this.nn.txt_sel_sc3.getText()); f3_14=Integer.parseInt(this.nn.txt_sel_dp3.getText()); f3_15=Integer.parseInt(this.nn.txt_empaq_br3.getText());
        f3_16=Integer.parseInt(this.nn.txt_empaq_sr3.getText()); f3_17=Integer.parseInt(this.nn.txt_empaq_srf3.getText()); f3_18=Integer.parseInt(this.nn.txt_empaq_dp3.getText());
        
        cluster1=Integer.parseInt(this.nn.txt_sel_cluster1.getText()); cluster2=Integer.parseInt(this.nn.txt_sel_cluster2.getText());
        cluster3=Integer.parseInt(this.nn.txt_sel_cluster3.getText());
        
        ph1=Integer.parseInt(this.nn.txt_sel_ph1.getText()); ph2=Integer.parseInt(this.nn.txt_sel_ph2.getText()); ph3=Integer.parseInt(this.nn.txt_sel_ph3.getText());
        
        tot_f1=(f1_1+f1_2+f1_3+f1_4+f1_5+f1_6+f1_7+f1_8+f1_9+f1_10+f1_11+f1_12+f1_13+f1_14+f1_15+f1_16+f1_17+f1_18);
        tot_f2=(f2_1+f1_2+f2_3+f2_4+f2_5+f2_6+f2_7+f2_8+f2_9+f2_10+f2_11+f2_12+f2_13+f2_14+f2_15+f2_16+f2_17+f2_18);
        tot_f3=(f3_1+f1_2+f3_3+f3_4+f3_5+f3_6+f3_7+f3_8+f3_9+f3_10+f3_11+f3_12+f3_13+f3_14+f3_15+f3_16+f3_17+f3_18);
        total_filas=(tot_f1+tot_f2+tot_f3); totalcluster=(cluster1+cluster2+cluster3); totalph=(ph1+ph2+ph3); totalph2=(totalph/3);
        
        t1=(total_filas*100); t2=(t1/60); resta=(100-t2); promedio=(resta/100);
        
    }
    
    public void guardar_datos () throws SQLException {
        datos();
        mse.f1_1=f1_1; mse.f1_2=f1_2; mse.f1_3=f1_3; mse.f1_4=f1_4; mse.f1_5=f1_5;
        mse.f1_6=f1_6; mse.f1_7=f1_7; mse.f1_8=f1_8; mse.f1_9=f1_9; mse.f1_10=f1_10;
        mse.f1_11=f1_11; mse.f1_12=f1_12; mse.f1_13=f1_13; mse.f1_14=f1_14; mse.f1_15=f1_15;
        mse.f1_16=f1_16; mse.f1_17=f1_17; mse.f1_18=f1_18;
        
        mse.f2_1=f2_1; mse.f2_2=f2_2; mse.f2_3=f2_3; mse.f2_4=f2_4; mse.f2_5=f2_5;
        mse.f2_6=f2_6; mse.f2_7=f2_7; mse.f2_8=f2_8; mse.f2_9=f2_9; mse.f2_10=f2_10;
        mse.f2_11=f2_11; mse.f2_12=f2_12; mse.f2_13=f2_13; mse.f2_14=f1_14; mse.f2_15=f2_15;
        mse.f2_16=f2_16; mse.f2_17=f2_17; mse.f2_18=f2_18;
        
        mse.f3_1=f3_1; mse.f3_2=f3_2; mse.f3_3=f1_3; mse.f3_4=f1_4; mse.f3_5=f3_5;
        mse.f3_6=f3_6; mse.f3_7=f3_7; mse.f3_8=f1_8; mse.f3_9=f1_9; mse.f3_10=f3_10;
        mse.f3_11=f3_11; mse.f3_12=f3_12; mse.f3_13=f1_13; mse.f1_14=f1_14; mse.f3_15=f3_15;
        mse.f3_16=f3_16; mse.f3_17=f3_17; mse.f3_18=f3_18;
        
        mse.tot_f1=tot_f1; mse.tot_f2=tot_f2; mse.tot_f3=tot_f3;
        mse.ph1=ph1; mse.ph2=ph2; mse.ph3=ph3;
        mse.clusterf1=cluster1; mse.clusterf2=cluster2; mse.clusterf3=cluster3;
        mse.total_ph2=ph2; mse.total_filas=total_filas; mse.promedio=promedio; mse.total_cluster=totalcluster;
        
        mse.observacion=this.nn.txt_observacion.getText();
        
        id_evaluacion=dg.id_evaluacion();
        id_evaluacion= id_evaluacion;
        mse.id_eva=id_evaluacion;
        System.out.println("El id incrementable de evaluacion en la vista se es: "+id_evaluacion);
        
        boolean dato1=mse.registrar_seleccion_empaque();
        boolean dato2=mse.registrar_totales();
        
        if (dato1==true && dato2==true) {
            JOptionPane.showMessageDialog(nn, "Guardado corectamente");
        }
        
        
        
    }

}
