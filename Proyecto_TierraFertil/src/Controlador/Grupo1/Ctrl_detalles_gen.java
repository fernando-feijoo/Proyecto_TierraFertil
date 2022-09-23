package Controlador.Grupo1;

import Modelo.Grupo1.Mod_detalles_gen;
import Vista.Grupo1.Vista_campo_respaldo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Ctrl_detalles_gen implements ActionListener {

    Vista_campo_respaldo nn;
    Mod_detalles_gen dg = new Mod_detalles_gen();
    SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");

    String cod_prod, cod_eva, cod_insp, nom_pod, ape_prod, vapor, hora_eva;
    String finca_prod, nom_insp, ape_insp, placa, fecha_eva, tipo_caja;

    int id_eva, semana;

    public Ctrl_detalles_gen(Vista_campo_respaldo nn) {
        this.nn = nn;
        //cbx_semanas();  
//        id_eva = dg.id_evaluacion();
//        id_eva = id_eva;
//        System.out.println("El id actual de evaluacion es: " + id_eva);
        this.nn.btn_guardar_detgenerales.addActionListener(this);
    }

    public void datos() {

        cod_prod = this.nn.txt_codigo_prod.getText();
        nom_pod = this.nn.txt_nombre_prod.getText();
        ape_prod = this.nn.txt_apellido_prod.getText();
        finca_prod = this.nn.txt_finca_prod.getText();
        cod_insp = this.nn.txt_cod_insp.getText();
        nom_insp = this.nn.txt_nombre_insp.getText();
        ape_insp = this.nn.txt_apellido_insp.getText();
        cod_eva = this.nn.txt_cod_eva.getText();
        placa = this.nn.txt_placa_vehiculo.getText();
        vapor = this.nn.txt_vapor.getText();
        tipo_caja = this.nn.txt_tipo_caja_eva.getText();
        fecha_eva = fecha.format(this.nn.txt_fecha_eva.getDate()).toString();
        hora_eva = hora.format(this.nn.txt_hora_eva.getValue()).toString();
        semana = this.nn.txt_semana_eva.getValue();
    }

    public void guradar_datos_evaluacion() {
        try {
            datos();
            dg.cod_eva = cod_eva;
            dg.cod_insp = cod_insp;
            dg.cod_prod = cod_prod;
            dg.nom_pod = nom_pod;
            dg.ape_prod = ape_prod;
            dg.finca_prod = finca_prod;
            dg.nom_insp = nom_insp;
            dg.ape_insp = ape_insp;
            dg.placa = placa;
            dg.vapor = vapor;
            dg.tipo_caja = tipo_caja;
            dg.fecha_eva = fecha_eva;
            dg.hora_eva = hora_eva;
            dg.semana = semana;

            id_eva = id_eva + 1;
            dg.id_eva = id_eva;
            System.out.println("El id incrementable de evaluacion es: " + id_eva);
            boolean dat = dg.guardar_productores();
            boolean dat2 = dg.guardar_inspector();
            boolean dat3 = dg.guardar_evaluaciones();

            if (dat == true && dat2 == true && dat3 == true) {
                JOptionPane.showMessageDialog(nn, "Guardado");
            }
        } catch (SQLException e) {
        }

    }

    public Date funcionFecha_Formato(String x) {
        Date datoSQLFecha;
        try {
            datoSQLFecha = fecha.parse(x);
            return datoSQLFecha;
        } catch (ParseException ex) {
            System.out.println("Error al convertir fecha: " + ex);
        }
        return null;
    }

    public Date funcionHora_Formato(String y) {
        Date datosHora;
        try {
            datosHora = hora.parse(y);
            return datosHora;
        } catch (ParseException ex) {
            System.out.println("Error al convertir hora: " + ex);
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.nn.btn_guardar_detgenerales) {
            guradar_datos_evaluacion();
        }
    }

}
