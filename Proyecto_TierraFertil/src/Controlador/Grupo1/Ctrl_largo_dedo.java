package Controlador.Grupo1;

import Modelo.Grupo1.Mod_detalles_gen;
import Modelo.Grupo1.Mod_lardo_dedo;
import Vista.Grupo1.Vista_campo_respaldo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Ctrl_largo_dedo implements ActionListener {

    Vista_campo_respaldo nn;
    Mod_lardo_dedo mla = new Mod_lardo_dedo();
    Mod_detalles_gen dg = new Mod_detalles_gen();
    
    public Ctrl_largo_dedo(Vista_campo_respaldo nn){
        this.nn=nn;
        
        this.nn.btn_ok_c.addActionListener(this);
        this.nn.btn_ok_n.addActionListener(this);
        
        datos();
    }

    int c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,ctot,can6,can7,can8,can9,can10,can11;
    double n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,n11,n12,n13,n14,n15,n16,n17,n18,n19,n20,n21,n22,n23,n24,n25,n26,n27,n28,n29,n30,ntot,nprom,num6,num7,num8,num9,num10,num11;
    int id_ld, id_evalu, id_ld_actualizable;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        datos();
        if (e.getSource()==this.nn.btn_ok_c) {
            this.nn.txt_gc_f1_total.setText(String.valueOf(ctot));
        }else if (e.getSource()==this.nn.btn_ok_n) {
            this.nn.txt_gc_f2_total.setText(String.valueOf(ntot));
            this.nn.txt_gc_f2_promedio.setText(Double.toString(nprom));
        }
    }
    
    public void datos(){
            if (this.nn.txt_gc_f1_1.getText().equals("")) { 
                this.nn.txt_gc_f1_2.setText(String.valueOf(0)); this.nn.txt_gc_f1_3.setText(String.valueOf(0));
                this.nn.txt_gc_f1_4.setText(String.valueOf(0)); this.nn.txt_gc_f1_5.setText(String.valueOf(0));
                this.nn.txt_gc_f1_6.setText(String.valueOf(0)); this.nn.txt_gc_f1_7.setText(String.valueOf(0));
                this.nn.txt_gc_f1_8.setText(String.valueOf(0)); this.nn.txt_gc_f1_9.setText(String.valueOf(0));
                this.nn.txt_gc_f1_10.setText(String.valueOf(0)); this.nn.txt_gc_f1_11.setText(String.valueOf(0));
                this.nn.txt_gc_f1_12.setText(String.valueOf(0)); this.nn.txt_gc_f1_13.setText(String.valueOf(0));
                this.nn.txt_gc_f1_14.setText(String.valueOf(0)); this.nn.txt_gc_f1_15.setText(String.valueOf(0));
                this.nn.txt_gc_f1_16.setText(String.valueOf(0)); this.nn.txt_gc_f1_17.setText(String.valueOf(0));
                this.nn.txt_gc_f1_18.setText(String.valueOf(0)); this.nn.txt_gc_f1_19.setText(String.valueOf(0));
                this.nn.txt_gc_f1_20.setText(String.valueOf(0)); this.nn.txt_gc_f1_21.setText(String.valueOf(0));
                this.nn.txt_gc_f1_22.setText(String.valueOf(0)); this.nn.txt_gc_f1_23.setText(String.valueOf(0));
                this.nn.txt_gc_f1_24.setText(String.valueOf(0)); this.nn.txt_gc_f1_25.setText(String.valueOf(0));
                this.nn.txt_gc_f1_26.setText(String.valueOf(0)); this.nn.txt_gc_f1_27.setText(String.valueOf(0));
                this.nn.txt_gc_f1_28.setText(String.valueOf(0)); this.nn.txt_gc_f1_29.setText(String.valueOf(0));
                this.nn.txt_gc_f1_30.setText(String.valueOf(0)); this.nn.txt_gc_f1_1.setText(String.valueOf(0));
                
                this.nn.txt_gc_f2_1.setText(String.valueOf(0)); this.nn.txt_gc_f2_2.setText(String.valueOf(0));
                this.nn.txt_gc_f2_3.setText(String.valueOf(0)); this.nn.txt_gc_f2_4.setText(String.valueOf(0));
                this.nn.txt_gc_f2_5.setText(String.valueOf(0)); this.nn.txt_gc_f2_6.setText(String.valueOf(0));
                this.nn.txt_gc_f2_7.setText(String.valueOf(0)); this.nn.txt_gc_f2_8.setText(String.valueOf(0));
                this.nn.txt_gc_f2_9.setText(String.valueOf(0)); this.nn.txt_gc_f2_10.setText(String.valueOf(0));
                this.nn.txt_gc_f2_11.setText(String.valueOf(0)); this.nn.txt_gc_f2_12.setText(String.valueOf(0));
                this.nn.txt_gc_f2_13.setText(String.valueOf(0)); this.nn.txt_gc_f2_14.setText(String.valueOf(0));
                this.nn.txt_gc_f2_15.setText(String.valueOf(0)); this.nn.txt_gc_f2_16.setText(String.valueOf(0));
                this.nn.txt_gc_f2_17.setText(String.valueOf(0)); this.nn.txt_gc_f2_18.setText(String.valueOf(0));
                this.nn.txt_gc_f2_19.setText(String.valueOf(0)); this.nn.txt_gc_f2_20.setText(String.valueOf(0));
                this.nn.txt_gc_f2_21.setText(String.valueOf(0)); this.nn.txt_gc_f2_22.setText(String.valueOf(0));
                this.nn.txt_gc_f2_23.setText(String.valueOf(0)); this.nn.txt_gc_f2_24.setText(String.valueOf(0));
                this.nn.txt_gc_f2_25.setText(String.valueOf(0)); this.nn.txt_gc_f2_26.setText(String.valueOf(0));
                this.nn.txt_gc_f2_27.setText(String.valueOf(0)); this.nn.txt_gc_f2_28.setText(String.valueOf(0));
                this.nn.txt_gc_f2_29.setText(String.valueOf(0)); this.nn.txt_gc_f2_30.setText(String.valueOf(0));
            }
            
            c1=Integer.parseInt(this.nn.txt_gc_f1_1.getText()); c2=Integer.parseInt(this.nn.txt_gc_f1_2.getText());
                c3=Integer.parseInt(this.nn.txt_gc_f1_3.getText()); c4=Integer.parseInt(this.nn.txt_gc_f1_4.getText());
                c5=Integer.parseInt(this.nn.txt_gc_f1_5.getText()); c6=Integer.parseInt(this.nn.txt_gc_f1_6.getText());
                c7=Integer.parseInt(this.nn.txt_gc_f1_7.getText()); c8=Integer.parseInt(this.nn.txt_gc_f1_8.getText());
                c9=Integer.parseInt(this.nn.txt_gc_f1_9.getText()); c10=Integer.parseInt(this.nn.txt_gc_f1_10.getText());
                c11=Integer.parseInt(this.nn.txt_gc_f1_11.getText()); c12=Integer.parseInt(this.nn.txt_gc_f1_12.getText());
                c13=Integer.parseInt(this.nn.txt_gc_f1_13.getText()); c14=Integer.parseInt(this.nn.txt_gc_f1_14.getText());
                c15=Integer.parseInt(this.nn.txt_gc_f1_15.getText()); c16=Integer.parseInt(this.nn.txt_gc_f1_16.getText());
                c17=Integer.parseInt(this.nn.txt_gc_f1_17.getText()); c18=Integer.parseInt(this.nn.txt_gc_f1_18.getText());
                c19=Integer.parseInt(this.nn.txt_gc_f1_19.getText()); c20=Integer.parseInt(this.nn.txt_gc_f1_20.getText());
                c21=Integer.parseInt(this.nn.txt_gc_f1_21.getText()); c22=Integer.parseInt(this.nn.txt_gc_f1_22.getText());
                c23=Integer.parseInt(this.nn.txt_gc_f1_23.getText()); c24=Integer.parseInt(this.nn.txt_gc_f1_24.getText());
                c25=Integer.parseInt(this.nn.txt_gc_f1_25.getText()); c26=Integer.parseInt(this.nn.txt_gc_f1_26.getText());
                c27=Integer.parseInt(this.nn.txt_gc_f1_27.getText()); c28=Integer.parseInt(this.nn.txt_gc_f1_28.getText());
                c29=Integer.parseInt(this.nn.txt_gc_f1_29.getText()); c30=Integer.parseInt(this.nn.txt_gc_f1_30.getText());
                
                can6=(c1+c2+c3+c4+c5); can7=(c6+c7+c8+c9+c10); can8=(c11+c12+c13+c14+c15);
                can9=(c16+c17+c18+c19+c20); can10=(c21+c22+c23+c24+c25); can11=(c26+c27+c28+c29+c30); 
                ctot=(can6+can7+can8+can9+can10+can11);
                
                n1=Double.parseDouble(this.nn.txt_gc_f2_1.getText()); n2=Double.parseDouble(this.nn.txt_gc_f2_2.getText());
                n3=Double.parseDouble(this.nn.txt_gc_f2_3.getText()); n4=Double.parseDouble(this.nn.txt_gc_f2_4.getText());
                n5=Double.parseDouble(this.nn.txt_gc_f2_5.getText()); n6=Double.parseDouble(this.nn.txt_gc_f2_6.getText());
                n7=Double.parseDouble(this.nn.txt_gc_f2_7.getText()); n8=Double.parseDouble(this.nn.txt_gc_f2_8.getText());
                n9=Double.parseDouble(this.nn.txt_gc_f2_9.getText()); n10=Double.parseDouble(this.nn.txt_gc_f2_10.getText());
                n11=Double.parseDouble(this.nn.txt_gc_f2_11.getText()); n12=Double.parseDouble(this.nn.txt_gc_f2_12.getText());
                n13=Double.parseDouble(this.nn.txt_gc_f2_13.getText()); n14=Double.parseDouble(this.nn.txt_gc_f2_14.getText());
                n15=Double.parseDouble(this.nn.txt_gc_f2_15.getText()); n16=Double.parseDouble(this.nn.txt_gc_f2_16.getText());
                n17=Double.parseDouble(this.nn.txt_gc_f2_17.getText()); n18=Double.parseDouble(this.nn.txt_gc_f2_18.getText());
                n19=Double.parseDouble(this.nn.txt_gc_f2_19.getText()); n20=Double.parseDouble(this.nn.txt_gc_f2_20.getText());
                n21=Double.parseDouble(this.nn.txt_gc_f2_21.getText()); n22=Double.parseDouble(this.nn.txt_gc_f2_22.getText());
                n23=Double.parseDouble(this.nn.txt_gc_f2_23.getText()); n24=Double.parseDouble(this.nn.txt_gc_f2_24.getText());
                n25=Double.parseDouble(this.nn.txt_gc_f2_25.getText()); n26=Double.parseDouble(this.nn.txt_gc_f2_26.getText());
                n27=Double.parseDouble(this.nn.txt_gc_f2_27.getText()); n28=Double.parseDouble(this.nn.txt_gc_f2_28.getText());
                n29=Double.parseDouble(this.nn.txt_gc_f2_29.getText()); n30=Double.parseDouble(this.nn.txt_gc_f2_30.getText());
                
                num6=(n1+n2+n3+n4+n5); num7=(n6+n7+n8+n9+n10); num8=(n11+n12+n13+n14+n15);
                num9=(n16+n17+n18+n19+n20); num10=(n21+n22+n23+n24+n25); num11=(n26+n27+n28+n29+n30);
                ntot=(num6+num7+num8+num9+num10+num11); nprom=(ntot/ctot);    
        }
    
    public void guardar_datos() {
        try {
            mla.can6=can6; mla.can7=can7;
            mla.can8=can8;mla.can9=can9;
            mla.can10=can10; mla.can11=can11;
            mla.cantot=ctot;
            
            mla.num6=num6; mla.num7=num7;
            mla.num8=num8; mla.num9=num9;
            mla.num10=num10; mla.num11=num11;
            mla.numtot=ntot; mla.numprom=nprom;
            
            id_evalu=dg.id_evaluacion();
            id_evalu=id_evalu;
            mla.id_eva=id_evalu;
            System.out.println("El id incrementable de evaluacion en la vista ld: "+id_evalu);
            id_ld=mla.id_ld();
            id_ld=id_ld+1;
            mla.id_max_ld=id_ld;
            System.out.println("El id incrementable de largo dedo es: "+id_ld);
            
            boolean dat = mla.ld_can();
            boolean dato = mla.ld_num();
            
            if (dat==true && dato==true) {
                JOptionPane.showMessageDialog(nn, "Guardado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ctrl_largo_dedo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void CargarDatosGradoCalibre (String dato_eva){
        mla.id_cargar=dato_eva;
        JOptionPane.showMessageDialog(nn, "ID en largo_dedo es: "+dato_eva);
        try {
            ResultSet rs = mla.cargar_largo_dedo();
            while (rs.next()) {

                this.id_ld_actualizable=rs.getInt(1);
                JOptionPane.showMessageDialog(nn, "ID local es: "+this.id_ld_actualizable);
                this.nn.txt_gc_f1_total.setText(rs.getString(2));
            }
            
            mla.id_ld_actualizable=id_ld_actualizable;
            ResultSet rsL = mla.cargar_datos_largo_dedo();
            while (rsL.next()) {                
                this.nn.txt_gc_f2_total.setText(rsL.getString(1));
                this.nn.txt_gc_f2_promedio.setText(rsL.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ctrl_detalles_gen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
