package Controlador.Grupo1;

import Modelo.Grupo1.Mod_detalles_gen;
import Modelo.Grupo1.Mod_gc_ld;
import Vista.Grupo1.Vista_campo_respaldo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Ctrl_gc_ld implements ActionListener{

    Vista_campo_respaldo nn;
    Mod_gc_ld mgl = new Mod_gc_ld();
    Mod_detalles_gen dg = new Mod_detalles_gen();
    
    public Ctrl_gc_ld(Vista_campo_respaldo nn) {
        this.nn=nn;
        
        this.nn.btn_ok_gc.addActionListener(this);
        this.nn.btn_guardar_c_gc.addActionListener(this);
        datos();
        try {
            id_gc=mgl.id_gc();
        
        id_gc=id_gc;
        System.out.println("El id actual de grado calibre es: "+id_gc);
        
        id_evalu=dg.id_evaluacion();
        id_evalu=id_evalu;
        System.out.println("El id actual de evaluacion en la vista gc: "+id_evalu);
        } catch (SQLException ex) {
            Logger.getLogger(Ctrl_gc_ld.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    int c36, c37, c38, c39, c40, c41, c42, c43, c44, c45, c46, c47, c48, c49, c50, c51, c52, total; int id_gc, id_evalu;
    int n36, n37, n38, n39, n40, n41, n42, n43, n44, n45, n46, n47, n48, n49, n50, n51, n52;
    double nprom, ntotal;
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource()==this.nn.btn_ok_gc) {
            
            datos();
            System.out.println("el total es:"+total);
            
            this.nn.c_gc_total.setText(String.valueOf(total));
            
            this.nn.n_gc_36.setText(String.valueOf(n36));
            this.nn.n_gc_37.setText(String.valueOf(n37));
            this.nn.n_gc_38.setText(String.valueOf(n38));
            this.nn.n_gc_39.setText(String.valueOf(n39));
            this.nn.n_gc_40.setText(String.valueOf(n40));
            this.nn.n_gc_41.setText(String.valueOf(n41));
            this.nn.n_gc_42.setText(String.valueOf(n42));
            this.nn.n_gc_43.setText(String.valueOf(n43));
            this.nn.n_gc_44.setText(String.valueOf(n44));
            this.nn.n_gc_45.setText(String.valueOf(n45));
            this.nn.n_gc_46.setText(String.valueOf(n46));
            this.nn.n_gc_47.setText(String.valueOf(n47));
            this.nn.n_gc_48.setText(String.valueOf(n48));
            this.nn.n_gc_49.setText(String.valueOf(n49));
            this.nn.n_gc_50.setText(String.valueOf(n50));
            this.nn.n_gc_51.setText(String.valueOf(n51));
            this.nn.n_gc_52.setText(String.valueOf(n52)); 
            this.nn.n_gc_total.setText(String.valueOf(ntotal)); 
            this.nn.n_gc_totalN.setText(Double.toString(nprom)); 
            
        }else if (e.getSource()==this.nn.btn_guardar_c_gc) {
            try {
                guardar_cantidad_gc ();
            } catch (SQLException ex) {
                Logger.getLogger(Ctrl_gc_ld.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
    public void datos(){
            if (this.nn.c_gc_36.getText().equals("")) { 
                this.nn.c_gc_36.setText(String.valueOf(0));
                this.nn.c_gc_37.setText(String.valueOf(0));
                this.nn.c_gc_38.setText(String.valueOf(0));
                this.nn.c_gc_39.setText(String.valueOf(0));
                this.nn.c_gc_40.setText(String.valueOf(0));
                this.nn.c_gc_41.setText(String.valueOf(0));
                this.nn.c_gc_42.setText(String.valueOf(0));
                this.nn.c_gc_43.setText(String.valueOf(0));
                this.nn.c_gc_44.setText(String.valueOf(0));
                this.nn.c_gc_45.setText(String.valueOf(0));
                this.nn.c_gc_46.setText(String.valueOf(0));
                this.nn.c_gc_47.setText(String.valueOf(0));
                this.nn.c_gc_48.setText(String.valueOf(0));
                this.nn.c_gc_49.setText(String.valueOf(0));
                this.nn.c_gc_50.setText(String.valueOf(0));
                this.nn.c_gc_51.setText(String.valueOf(0));
                this.nn.c_gc_52.setText(String.valueOf(0));
            }
            
            c36=Integer.parseInt(this.nn.c_gc_36.getText());
            c37=Integer.parseInt(this.nn.c_gc_37.getText());
            c38=Integer.parseInt(this.nn.c_gc_38.getText());
            c39=Integer.parseInt(this.nn.c_gc_39.getText());
            c40=Integer.parseInt(this.nn.c_gc_40.getText());
            c41=Integer.parseInt(this.nn.c_gc_41.getText());
            c42=Integer.parseInt(this.nn.c_gc_42.getText());
            c43=Integer.parseInt(this.nn.c_gc_43.getText());
            c44=Integer.parseInt(this.nn.c_gc_44.getText());
            c45=Integer.parseInt(this.nn.c_gc_45.getText());
            c46=Integer.parseInt(this.nn.c_gc_46.getText());
            c47=Integer.parseInt(this.nn.c_gc_47.getText());
            c48=Integer.parseInt(this.nn.c_gc_48.getText());
            c49=Integer.parseInt(this.nn.c_gc_49.getText());
            c50=Integer.parseInt(this.nn.c_gc_50.getText());
            c51=Integer.parseInt(this.nn.c_gc_51.getText());
            c52=Integer.parseInt(this.nn.c_gc_52.getText());
            
            total=(c36+c37+c38+c39+c40+c41+c42+c43+c44+c45+c46+c47+c48+c49+c50+c51+c52);
            
            n36=c36*36; n37=c37*37; n38=c38*38; n39=c39*39; 
            n40=c40*40; n41=c41*41; n42=c42*42; n43=c43*43; 
            n44=c44*44; n45=c45*45; n46=c46*46; n47=c47*47; 
            n48=c48*48; n49=c49*49; n50=c50*50; n51=c51*51;
            n52=c52*52; 
            
            ntotal=(n36+n37+n38+n39+n40+n41+n42+n43+n44+n45+n46+n47+n48+n49+n50+n51+n52);
            nprom=(ntotal/total);
        }      
    
    public void guardar_cantidad_gc () throws SQLException{
        
        mgl.cant36=Integer.parseInt(this.nn.c_gc_36.getText());
        mgl.cant37=Integer.parseInt(this.nn.c_gc_37.getText());
        mgl.cant38=Integer.parseInt(this.nn.c_gc_38.getText());
        mgl.cant39=Integer.parseInt(this.nn.c_gc_39.getText());
        mgl.cant40=Integer.parseInt(this.nn.c_gc_40.getText());
        mgl.cant41=Integer.parseInt(this.nn.c_gc_41.getText());
        mgl.cant42=Integer.parseInt(this.nn.c_gc_42.getText());
        mgl.cant43=Integer.parseInt(this.nn.c_gc_43.getText());
        mgl.cant44=Integer.parseInt(this.nn.c_gc_44.getText());
        mgl.cant45=Integer.parseInt(this.nn.c_gc_45.getText());
        mgl.cant46=Integer.parseInt(this.nn.c_gc_46.getText());
        mgl.cant47=Integer.parseInt(this.nn.c_gc_47.getText());
        mgl.cant48=Integer.parseInt(this.nn.c_gc_48.getText());
        mgl.cant49=Integer.parseInt(this.nn.c_gc_49.getText());
        mgl.cant50=Integer.parseInt(this.nn.c_gc_50.getText());
        mgl.cant51=Integer.parseInt(this.nn.c_gc_51.getText());
        mgl.cant52=Integer.parseInt(this.nn.c_gc_52.getText());
        mgl.cantTotal=Integer.parseInt(this.nn.c_gc_total.getText());
        
        mgl.num36=Integer.parseInt(this.nn.n_gc_36.getText());
        mgl.num37=Integer.parseInt(this.nn.n_gc_37.getText());
        mgl.num38=Integer.parseInt(this.nn.n_gc_38.getText());
        mgl.num39=Integer.parseInt(this.nn.n_gc_39.getText());
        mgl.num40=Integer.parseInt(this.nn.n_gc_40.getText());
        mgl.num41=Integer.parseInt(this.nn.n_gc_41.getText());
        mgl.num42=Integer.parseInt(this.nn.n_gc_42.getText());
        mgl.num43=Integer.parseInt(this.nn.n_gc_43.getText());
        mgl.num44=Integer.parseInt(this.nn.n_gc_44.getText());
        mgl.num45=Integer.parseInt(this.nn.n_gc_45.getText());
        mgl.num46=Integer.parseInt(this.nn.n_gc_46.getText());
        mgl.num47=Integer.parseInt(this.nn.n_gc_47.getText());
        mgl.num48=Integer.parseInt(this.nn.n_gc_48.getText());
        mgl.num49=Integer.parseInt(this.nn.n_gc_49.getText());
        mgl.num50=Integer.parseInt(this.nn.n_gc_50.getText());
        mgl.num51=Integer.parseInt(this.nn.n_gc_51.getText());
        mgl.num52=Integer.parseInt(this.nn.n_gc_52.getText());
        mgl.total_l=Double.parseDouble(this.nn.n_gc_total.getText());
        mgl.promedio_l=Double.parseDouble(this.nn.n_gc_totalN.getText());
        
        id_evalu=id_evalu+1;
        mgl.id_evaluacion=id_evalu;
        System.out.println("El id de evaluacion incrementable en la vista grado calibre es: "+id_evalu);
        id_gc=id_gc+1;
        mgl.id_max=id_gc;
        System.out.println("El id incrementable de grado calibre es: "+id_gc);
        
        boolean dat = mgl.gc_cantidad();
        boolean dato = mgl.gc_numeros();
        
        if (dat==true && dato==true) {
            JOptionPane.showMessageDialog(nn, "Guardado");
        }
    }
    }