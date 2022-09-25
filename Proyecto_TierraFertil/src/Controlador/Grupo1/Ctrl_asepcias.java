package Controlador.Grupo1;

import Modelo.Grupo1.Mod_asepcias;
import Modelo.Grupo1.Mod_detalles_gen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Vista.Grupo1.Vista_campo_respaldo;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ctrl_asepcias implements ActionListener{

    Vista_campo_respaldo nn;
    Mod_asepcias con=new Mod_asepcias();
    Mod_detalles_gen dg = new Mod_detalles_gen();
    
    public Ctrl_asepcias(Vista_campo_respaldo nn) {
        this.nn = nn;
        
        this.nn.btn_sig_det_general.addActionListener(this);
        this.nn.btn_guardar_asepcias.addActionListener(this);
        
        this.nn.btn_sig_gc.addActionListener(this);
        
        this.nn.fila1.add(this.nn.cbx_f1_c1); this.nn.fila1.add(this.nn.cbx_f1_c2); this.nn.fila1.add(this.nn.cbx_f1_c3);
        this.nn.fila2.add(this.nn.cbx_f2_c1); this.nn.fila2.add(this.nn.cbx_f2_c2); this.nn.fila2.add(this.nn.cbx_f2_c3);
        this.nn.fila3.add(this.nn.cbx_f3_c1); this.nn.fila3.add(this.nn.cbx_f3_c2); this.nn.fila3.add(this.nn.cbx_f3_c3);
        this.nn.fila4.add(this.nn.cbx_f4_c1); this.nn.fila4.add(this.nn.cbx_f4_c2); this.nn.fila4.add(this.nn.cbx_f4_c3);
        this.nn.fila5.add(this.nn.cbx_f5_c1); this.nn.fila5.add(this.nn.cbx_f5_c2); this.nn.fila5.add(this.nn.cbx_f5_c3);
        this.nn.fila6.add(this.nn.cbx_f6_c1); this.nn.fila6.add(this.nn.cbx_f6_c2); this.nn.fila6.add(this.nn.cbx_f6_c3);
        this.nn.fila7.add(this.nn.cbx_f7_c1); this.nn.fila7.add(this.nn.cbx_f7_c2); this.nn.fila7.add(this.nn.cbx_f7_c3);
        this.nn.fila8.add(this.nn.cbx_f8_c1); this.nn.fila8.add(this.nn.cbx_f8_c2); this.nn.fila8.add(this.nn.cbx_f8_c3);
        this.nn.fila9.add(this.nn.cbx_f9_c1); this.nn.fila9.add(this.nn.cbx_f9_c2); this.nn.fila9.add(this.nn.cbx_f9_c3);
        this.nn.fila10.add(this.nn.cbx_f10_c1); this.nn.fila10.add(this.nn.cbx_f10_c2); this.nn.fila10.add(this.nn.cbx_f10_c3);
        this.nn.fila11.add(this.nn.cbx_f11_c1); this.nn.fila11.add(this.nn.cbx_f11_c2); this.nn.fila11.add(this.nn.cbx_f11_c3);
        
        this.nn.fila12.add(this.nn.cbx_f12_c1); this.nn.fila12.add(this.nn.cbx_f12_c2); this.nn.fila12.add(this.nn.cbx_f12_c3);
        this.nn.fila13.add(this.nn.cbx_f13_c1); this.nn.fila13.add(this.nn.cbx_f13_c2); this.nn.fila13.add(this.nn.cbx_f13_c3);
        this.nn.fila14.add(this.nn.cbx_f14_c1); this.nn.fila14.add(this.nn.cbx_f14_c2); this.nn.fila14.add(this.nn.cbx_f14_c3);
        this.nn.fila15.add(this.nn.cbx_f15_c1); this.nn.fila15.add(this.nn.cbx_f15_c2); this.nn.fila15.add(this.nn.cbx_f15_c3);
        this.nn.fila16.add(this.nn.cbx_f16_c1); this.nn.fila16.add(this.nn.cbx_f16_c2); this.nn.fila16.add(this.nn.cbx_f16_c3);
        this.nn.fila17.add(this.nn.cbx_f17_c1); this.nn.fila17.add(this.nn.cbx_f17_c2); this.nn.fila17.add(this.nn.cbx_f17_c3);
        this.nn.fila18.add(this.nn.cbx_f18_c1); this.nn.fila18.add(this.nn.cbx_f18_c2); this.nn.fila18.add(this.nn.cbx_f18_c3);
        this.nn.fila19.add(this.nn.cbx_f19_c1); this.nn.fila19.add(this.nn.cbx_f19_c2); this.nn.fila19.add(this.nn.cbx_f19_c3);
        this.nn.fila20.add(this.nn.cbx_f20_c1); this.nn.fila20.add(this.nn.cbx_f20_c2); this.nn.fila20.add(this.nn.cbx_f20_c3);
        this.nn.fila21.add(this.nn.cbx_f21_c1); this.nn.fila21.add(this.nn.cbx_f21_c2); this.nn.fila21.add(this.nn.cbx_f21_c3);
        this.nn.fila22.add(this.nn.cbx_f22_c1); this.nn.fila22.add(this.nn.cbx_f22_c2); this.nn.fila22.add(this.nn.cbx_f22_c3);
    }
    int id_evalu;
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource()==this.nn.btn_guardar_asepcias) {
            guardar_asepcias();
            limpiar();
        }
    }
    
    public void guardar_asepcias (){
        try {
            String mensaje1 = ""; String mensaje2 = ""; String mensaje3 = "";
            String mensaje4 = ""; String mensaje5 = ""; String mensaje6 = "";
            String mensaje7 = ""; String mensaje8 = ""; String mensaje9 = "";
            String mensaje10 = ""; String mensaje11 = ""; String mensaje12 = "";
            String mensaje13 = ""; String mensaje14 = ""; String mensaje15 = "";
            String mensaje16 = ""; String mensaje17 = ""; String mensaje18 = "";
            String mensaje19 = ""; String mensaje20 = ""; String mensaje21 = "";
            String mensaje22 = ""; String mensaje23 = ""; String mensaje24 = "";
            String mensaje25 = ""; String mensaje26 = ""; String mensaje27 = "";
            String mensaje28 = ""; String mensaje29 = ""; String mensaje30 = "";
            String mensaje31 = ""; String mensaje32 = ""; String mensaje33 = "";
            
            String mensaje34 = ""; String mensaje35 = ""; String mensaje36 = "";
            String mensaje37 = ""; String mensaje38 = ""; String mensaje39 = "";
            String mensaje40 = ""; String mensaje41 = ""; String mensaje42 = "";
            String mensaje43 = ""; String mensaje44 = ""; String mensaje45 = "";
            String mensaje46 = ""; String mensaje47 = ""; String mensaje48 = "";
            String mensaje49 = ""; String mensaje50 = ""; String mensaje51 = "";
            String mensaje52 = ""; String mensaje53 = ""; String mensaje54 = "";
            String mensaje55 = ""; String mensaje56 = ""; String mensaje57 = "";
            String mensaje58 = ""; String mensaje59 = ""; String mensaje60 = "";
            String mensaje61 = ""; String mensaje62 = ""; String mensaje63 = "";
            String mensaje64 = ""; String mensaje65 = ""; String mensaje66 = "";
            //fila1
            if (this.nn.cbx_f1_c1.isSelected()) {
                mensaje1+="X";
            }else if (this.nn.cbx_f1_c2.isSelected()) {
                mensaje2+="X";
            }else if (this.nn.cbx_f1_c3.isSelected()) {
                mensaje3+="X";
            }
            //fila2
            if (this.nn.cbx_f2_c1.isSelected()) {
                mensaje4+="X";
            }else if (this.nn.cbx_f2_c2.isSelected()) {
                mensaje5+="X";
            }else if (this.nn.cbx_f2_c3.isSelected()) {
                mensaje6+="X";
            }
            //fila3
            if (this.nn.cbx_f3_c1.isSelected()) {
                mensaje7+="X";
            }else if (this.nn.cbx_f3_c2.isSelected()) {
                mensaje8+="X";
            }else if (this.nn.cbx_f3_c3.isSelected()) {
                mensaje9+="X";
            }
            //fila4
            if (this.nn.cbx_f4_c1.isSelected()) {
                mensaje10+="X";
            }else if (this.nn.cbx_f4_c2.isSelected()) {
                mensaje11+="X";
            }else if (this.nn.cbx_f4_c3.isSelected()) {
                mensaje12+="X";
            }
            //fila5
            if (this.nn.cbx_f5_c1.isSelected()) {
                mensaje13+="X";
            }else if (this.nn.cbx_f5_c2.isSelected()) {
                mensaje14+="X";
            }else if (this.nn.cbx_f5_c3.isSelected()) {
                mensaje15+="X";
            }
            //fila6
            if (this.nn.cbx_f6_c1.isSelected()) {
                mensaje16+="X";
            }else if (this.nn.cbx_f6_c2.isSelected()) {
                mensaje17+="X";
            }else if (this.nn.cbx_f6_c3.isSelected()) {
                mensaje18+="X";
            }
            //fila7
            if (this.nn.cbx_f7_c1.isSelected()) {
                mensaje19+="X";
            }else if (this.nn.cbx_f7_c2.isSelected()) {
                mensaje20+="X";
            }else if (this.nn.cbx_f7_c3.isSelected()) {
                mensaje21+="X";
            }
            //fila8
            if (this.nn.cbx_f8_c1.isSelected()) {
                mensaje22+="X";
            }else if (this.nn.cbx_f8_c2.isSelected()) {
                mensaje23+="X";
            }else if (this.nn.cbx_f8_c3.isSelected()) {
                mensaje24+="X";
            }
            //fila9
            if (this.nn.cbx_f9_c1.isSelected()) {
                mensaje25+="X";
            }else if (this.nn.cbx_f9_c2.isSelected()) {
                mensaje26+="X";
            }else if (this.nn.cbx_f9_c3.isSelected()) {
                mensaje27+="X";
            }
            //fila10
            if (this.nn.cbx_f10_c1.isSelected()) {
                mensaje28+="X";
            }else if (this.nn.cbx_f10_c2.isSelected()) {
                mensaje29+="X";
            }else if (this.nn.cbx_f10_c3.isSelected()) {
                mensaje30+="X";
            }
            //fila11
            if (this.nn.cbx_f11_c1.isSelected()) {
                mensaje31+="X";
            }else if (this.nn.cbx_f11_c2.isSelected()) {
                mensaje32+="X";
            }else if (this.nn.cbx_f11_c3.isSelected()) {
                mensaje33+="X";
            }
            //fila12
            if (this.nn.cbx_f12_c1.isSelected()) {
                mensaje34+="X";
            }else if (this.nn.cbx_f12_c2.isSelected()) {
                mensaje35+="X";
            }else if (this.nn.cbx_f12_c3.isSelected()) {
                mensaje36+="X";
            }
            //fila13
            if (this.nn.cbx_f13_c1.isSelected()) {
                mensaje37+="X";
            }else if (this.nn.cbx_f13_c2.isSelected()) {
                mensaje38+="X";
            }else if (this.nn.cbx_f13_c3.isSelected()) {
                mensaje39+="X";
            }
            //fila14
            if (this.nn.cbx_f14_c1.isSelected()) {
                mensaje40+="X";
            }else if (this.nn.cbx_f14_c2.isSelected()) {
                mensaje41+="X";
            }else if (this.nn.cbx_f14_c3.isSelected()) {
                mensaje42+="X";
            }
            //fila15
            if (this.nn.cbx_f15_c1.isSelected()) {
                mensaje43+="X";
            }else if (this.nn.cbx_f15_c2.isSelected()) {
                mensaje44+="X";
            }else if (this.nn.cbx_f15_c3.isSelected()) {
                mensaje45+="X";
            }
            //fila16
            if (this.nn.cbx_f16_c1.isSelected()) {
                mensaje46+="X";
            }else if (this.nn.cbx_f16_c2.isSelected()) {
                mensaje47+="X";
            }else if (this.nn.cbx_f16_c3.isSelected()) {
                mensaje48+="X";
            }
            //fila17
            if (this.nn.cbx_f17_c1.isSelected()) {
                mensaje49+="X";
            }else if (this.nn.cbx_f17_c2.isSelected()) {
                mensaje50+="X";
            }else if (this.nn.cbx_f17_c3.isSelected()) {
                mensaje51+="X";
            }
            //fila18
            if (this.nn.cbx_f18_c1.isSelected()) {
                mensaje52+="X";
            }else if (this.nn.cbx_f18_c2.isSelected()) {
                mensaje53+="X";
            }else if (this.nn.cbx_f18_c3.isSelected()) {
                mensaje54+="X";
            }
            //fila19
            if (this.nn.cbx_f19_c1.isSelected()) {
                mensaje55+="X";
            }else if (this.nn.cbx_f19_c2.isSelected()) {
                mensaje56+="X";
            }else if (this.nn.cbx_f19_c3.isSelected()) {
                mensaje57+="X";
            }
            //fila20
            if (this.nn.cbx_f20_c1.isSelected()) {
                mensaje58+="X";
            }else if (this.nn.cbx_f20_c2.isSelected()) {
                mensaje59+="X";
            }else if (this.nn.cbx_f20_c3.isSelected()) {
                mensaje60+="X";
            }
            //fila21
            if (this.nn.cbx_f21_c1.isSelected()) {
                mensaje61+="X";
            }else if (this.nn.cbx_f21_c2.isSelected()) {
                mensaje62+="X";
            }else if (this.nn.cbx_f21_c3.isSelected()) {
                mensaje63+="X";
            }
            //fila22
            if (this.nn.cbx_f22_c1.isSelected()) {
                mensaje64+="X";
            }else if (this.nn.cbx_f22_c2.isSelected()) {
                mensaje65+="X";
            }else if (this.nn.cbx_f22_c3.isSelected()) {
                mensaje66+="X";
            }
            
            con.men1=mensaje1; con.men2=mensaje2; con.men3=mensaje3;
            con.men4=mensaje4; con.men5=mensaje5; con.men6=mensaje6;
            con.men7=mensaje7; con.men8=mensaje8; con.men9=mensaje9;
            con.men10=mensaje10; con.men11=mensaje11; con.men12=mensaje12;
            con.men13=mensaje13; con.men14=mensaje14; con.men15=mensaje15;
            con.men16=mensaje16; con.men17=mensaje17; con.men18=mensaje18;
            con.men19=mensaje19; con.men20=mensaje20; con.men21=mensaje21;
            con.men22=mensaje22; con.men23=mensaje23; con.men24=mensaje24;
            con.men25=mensaje25; con.men26=mensaje26; con.men27=mensaje27;
            con.men28=mensaje28; con.men29=mensaje29; con.men30=mensaje30;
            con.men31=mensaje31; con.men32=mensaje32; con.men33=mensaje33;
            
            con.men34=mensaje34; con.men35=mensaje35; con.men36=mensaje36;
            con.men37=mensaje37; con.men38=mensaje38; con.men39=mensaje39;
            con.men40=mensaje40; con.men41=mensaje41; con.men42=mensaje42;
            con.men43=mensaje43; con.men44=mensaje44; con.men45=mensaje45;
            con.men46=mensaje46; con.men47=mensaje47; con.men48=mensaje48;
            con.men49=mensaje49; con.men50=mensaje50; con.men51=mensaje51;
            con.men52=mensaje52; con.men53=mensaje53; con.men54=mensaje54;
            con.men55=mensaje55; con.men56=mensaje56; con.men57=mensaje57;
            con.men58=mensaje58; con.men59=mensaje59; con.men60=mensaje60;
            con.men61=mensaje61; con.men62=mensaje62; con.men63=mensaje63;
            con.men64=mensaje64; con.men65=mensaje65; con.men66=mensaje66;
            
            id_evalu=dg.id_evaluacion();
            id_evalu=id_evalu;
            con.id_evaluacion=id_evalu;
            System.out.println("el id incrementable de evaluacion en la vista asepcias es: "+id_evalu);
            
            boolean confirma = con.datos_generales();
            
            if (confirma==true) {
                JOptionPane.showMessageDialog(nn, "Se registro correctamente");
            }else {
                JOptionPane.showMessageDialog(nn, "No Se registro");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ctrl_asepcias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void limpiar(){
        this.nn.fila1.clearSelection();
        this.nn.fila2.clearSelection();
        this.nn.fila3.clearSelection();
        this.nn.fila4.clearSelection();
        this.nn.fila5.clearSelection();
        this.nn.fila6.clearSelection();
        this.nn.fila7.clearSelection();
        this.nn.fila8.clearSelection();
        this.nn.fila9.clearSelection();
        this.nn.fila10.clearSelection();
        this.nn.fila11.clearSelection();
        this.nn.fila12.clearSelection();
        this.nn.fila13.clearSelection();
        this.nn.fila14.clearSelection();
        this.nn.fila15.clearSelection();
        this.nn.fila16.clearSelection();
        this.nn.fila17.clearSelection();
        this.nn.fila18.clearSelection();
        this.nn.fila19.clearSelection();
        this.nn.fila20.clearSelection();
        this.nn.fila21.clearSelection();
        this.nn.fila22.clearSelection();
    }
}