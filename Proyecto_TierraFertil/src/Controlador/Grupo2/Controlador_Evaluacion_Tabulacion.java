package Controlador.Grupo2;

import Vista.Grupo2.Vista_Evaluacion_Total;
import Modelo.Grupo2.Modelo_Evaluacion_Tabulacion;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador_Evaluacion_Tabulacion implements MouseListener {

    //Instanciaciones de la vista y modelo
    Vista_Evaluacion_Total vistaEvaluacion;
    Modelo_Evaluacion_Tabulacion modeloEvaluacionTabulacion = new Modelo_Evaluacion_Tabulacion();

    ResultSet rs;
    ResultSet rsCargar;

    //Constructor
    public Controlador_Evaluacion_Tabulacion(Vista_Evaluacion_Total vistaEvaluacion) {
        this.vistaEvaluacion = vistaEvaluacion;

        this.vistaEvaluacion.jb_btn_guardar.addMouseListener(this);
        mostrarTabulacion();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vistaEvaluacion.jb_btn_guardar) {
            System.out.println("Boton guardar tabulacion presionado");
            try {
                modeloEvaluacionTabulacion.caja_inspeccionada = Integer.parseInt(this.vistaEvaluacion.txt_caja_insp.getText());

                modeloEvaluacionTabulacion.embalador = Integer.parseInt(this.vistaEvaluacion.txt_embalador.getText());

                modeloEvaluacionTabulacion.peso_neto = Double.parseDouble(this.vistaEvaluacion.txt_peso_neto.getText());
                modeloEvaluacionTabulacion.par4 = Integer.parseInt(this.vistaEvaluacion.txt_par4.getText());
                modeloEvaluacionTabulacion.par6 = Integer.parseInt(this.vistaEvaluacion.txt_par6.getText());
                modeloEvaluacionTabulacion.par8 = Integer.parseInt(this.vistaEvaluacion.txt_par8.getText());
                modeloEvaluacionTabulacion.impar5 = Integer.parseInt(this.vistaEvaluacion.txt_inpar5.getText());
                modeloEvaluacionTabulacion.impar7 = Integer.parseInt(this.vistaEvaluacion.txt_inpar7.getText());

                int respuesta = JOptionPane.showConfirmDialog(vistaEvaluacion, "Para continuar presione SI. ", "ATENCION", JOptionPane.YES_OPTION);
                if (respuesta == 0) {
                    modeloEvaluacionTabulacion.guardarTabulacion();
                    mostrarTabulacion();

                    System.out.println("SEGUIMIENTO: Campos de datos almacenados correctamente");
                    JOptionPane.showMessageDialog(vistaEvaluacion, "Datos guardados correctamente ", "Registros", JOptionPane.INFORMATION_MESSAGE);

                }
                if (respuesta == 1) {
                    System.out.println("Guardar datos de tabulacion cancelado.");

                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vistaEvaluacion, "Error al intentar guardar los datos." + ex);
            }

        }

    }

    public void mostrarTabulacion() {
        DefaultTableModel tabla = (DefaultTableModel) this.vistaEvaluacion.tabla_tabulacion.getModel();
//        tabla.setColumnCount(0);
        tabla.setColumnCount(0);
        tabla.addColumn("ID");
        tabla.addColumn("Caja Inspeccionada");
        tabla.addColumn("Embalador");
        tabla.addColumn("Peso Neto");
        tabla.addColumn("Par4");
        tabla.addColumn("par6");
        tabla.addColumn("Par8");
        tabla.addColumn("Impar5");
        tabla.addColumn("Impar7");
        tabla.addColumn("Total Gajos");
        tabla.addColumn("Pcmd");
        tabla.setRowCount(0);
//        tabla.setRowCount(0);
        try {
            rs = modeloEvaluacionTabulacion.consultarTabulacion();
            String[] tabulacion = new String[12];

            while (rs.next()) {

                tabulacion[0] = rs.getString("id");
                tabulacion[1] = rs.getString("caja_inspeccionada");
                tabulacion[2] = rs.getString("embalador");
                tabulacion[3] = rs.getString("peso_neto");
                tabulacion[4] = rs.getString("par4");
                tabulacion[5] = rs.getString("par6");
                tabulacion[6] = rs.getString("par8");
                tabulacion[7] = rs.getString("impar5");
                tabulacion[8] = rs.getString("impar7");
                tabulacion[10] = rs.getString("total_gajos");
                tabulacion[11] = rs.getString("pcmd_final");
                tabla.addRow(tabulacion);

            }

        } catch (Exception e) {
            System.out.println("Error en mostrarTabulacion. " + e);
        }
    }

    public void cargarTabulacion(String valorTabu) {
        try {

            modeloEvaluacionTabulacion.codigoCargar = valorTabu;
            modeloEvaluacionTabulacion.selecionTabulacion();
            rsCargar = modeloEvaluacionTabulacion.selecionTabulacion();

            while (rsCargar.next()) {

                this.vistaEvaluacion.txt_caja_insp.setText(rsCargar.getString(1));
                this.vistaEvaluacion.txt_embalador.setText(rsCargar.getString(2));
                this.vistaEvaluacion.txt_peso_neto.setText(rsCargar.getString(3));
                this.vistaEvaluacion.txt_par4.setText(rsCargar.getString(4));
                this.vistaEvaluacion.txt_par6.setText(rsCargar.getString(5));
                this.vistaEvaluacion.txt_par8.setText(rsCargar.getString(6));
                this.vistaEvaluacion.txt_inpar5.setText(rsCargar.getString(7));
                this.vistaEvaluacion.txt_inpar7.setText(rsCargar.getString(8));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaEvaluacion, "Error en cargarTabulacion" + e);
        }
    }

//    public void cargarDatosLlegada() {
//        String sellosInternos = "", sellosExternos = "";
//        rsC = modeloDatosLlegada.consultaDatos_entidadDatosLlegada();
//        try {
//            while (rsC.next()) {
//                this.vistaLlegada.datosLlegada_fechaInsp.setDate(funcionFecha_Formato(rsC.getString("fecha_insp")));
//                this.vistaLlegada.datosLlegada_semana.setValue(Integer.parseInt(rsC.getString("semana")));
//                this.vistaLlegada.datosLlegada_fechaSalida.setDate(funcionFecha_Formato(rsC.getString("fecha_hora_salida").substring(0, 10)));
//                this.vistaLlegada.datosLlegada_horaSalida.setValue(funcionHora_Formato(rsC.getString("fecha_hora_salida").substring(11, 19)));
//                this.vistaLlegada.datosLlegada_horaLlegada.setValue(funcionHora_Formato(rsC.getString("hora_llegada")));
//                this.vistaLlegada.datosLlegada_tipocaja.setText(rsC.getString("tipo_caja"));
//                this.vistaLlegada.datosLlegada_cupo.setText(rsC.getString("cupo"));
//                this.vistaLlegada.datosLlegada_contenedor.setText(rsC.getString("contenedor"));
//                this.vistaLlegada.datosLlegada_placa.setText(rsC.getString("placa"));
//                this.vistaLlegada.datosLlegada_chasis.setText(rsC.getString("chasis"));
//                this.vistaLlegada.datosLlegada_chofer.setText(rsC.getString("chofer_contenedor"));
//                this.vistaLlegada.datosLlegada_ci.setText(rsC.getString("cedula_chofer"));
//                this.vistaLlegada.datosLlegada_nombrefinca.setText(rsC.getString("nombre_finca"));
//                this.vistaLlegada.datosLlegada_candadosllegada.setText(rsC.getString("candados"));
//                sellosInternos = rsC.getString("sellos_internos");
//                sellosExternos = rsC.getString("sellos_externos");
//            }
//            /*  
//               
//
//        } catch (Exception e) {
//            System.out.println("Error al cargar componentes Modelo_Datos_LLegada: " + e);
//        }
//    }
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
