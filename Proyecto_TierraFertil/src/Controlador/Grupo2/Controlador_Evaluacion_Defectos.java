package Controlador.Grupo2;

import Modelo.Grupo2.Modelo_Evaluacion_Defectos;
import Vista.Grupo2.Vista_Evaluacion_Total;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador_Evaluacion_Defectos implements MouseListener {

    ResultSet rs;
    Vista_Evaluacion_Total vistaEvaluacion;
    Modelo_Evaluacion_Defectos modeloEvaluacionDefectos = new Modelo_Evaluacion_Defectos();
    

    public Controlador_Evaluacion_Defectos(Vista_Evaluacion_Total vistaEvaluacion) {
        this.vistaEvaluacion = vistaEvaluacion;

        this.vistaEvaluacion.jb_agregar_defecto.addMouseListener(this);
        this.vistaEvaluacion.jb_nuevos_datos.addMouseListener(this);
        mostrarDefectos();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vistaEvaluacion.jb_agregar_defecto) {
            try {
                modeloEvaluacionDefectos.id_detalle = Integer.parseInt(this.vistaEvaluacion.txt_id_defecto.getText());
                modeloEvaluacionDefectos.nombre = this.vistaEvaluacion.txt_nombre_defectos.getText();
                modeloEvaluacionDefectos.total_defectos = Integer.parseInt(this.vistaEvaluacion.txt_total_defectos.getText());

                int total_defec, total_gajos, total_final;

                total_final = Integer.parseInt(this.vistaEvaluacion.txt_total_defectos.getText());
                String pcmd_total = "";

                modeloEvaluacionDefectos.pcmd = pcmd_total;

//                 String total_defectos = this.modeloEvaluacionDefectos.total_defectos;
//                 double pcmd_total = (Double.parseDouble(total_defectos) * 100 / total_gajos) - 100;
                boolean aux = modeloEvaluacionDefectos.guardarDefectos();
                if (aux = true) {
                    System.out.println("SEGUIMIENTO: Campos de tabulacion almacenados corretamente. ");
                    JOptionPane.showMessageDialog(vistaEvaluacion, "Datos almacenados correctamente. ", "REGISTROS", JOptionPane.INFORMATION_MESSAGE);
                    mostrarDefectos();

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vistaEvaluacion, "Error al intentar guardar los datos. " + ex);
            }
        }
        if (e.getSource() == this.vistaEvaluacion.jb_nuevos_datos) {
            mostrarDefectos();

        }

    }

    public void mostrarDefectos() {
        DefaultTableModel tabla = (DefaultTableModel) this.vistaEvaluacion.tabla_defectos.getModel();
        tabla.setColumnCount(0);
        tabla.addColumn("Id");
        tabla.addColumn("Nombre");
        tabla.addColumn("Total de defectos");
        tabla.addColumn("Pcmd");
        tabla.setRowCount(0);
        try {
            modeloEvaluacionDefectos.id_detalle = Integer.parseInt(this.vistaEvaluacion.txt_id_defecto.getText());
            rs = modeloEvaluacionDefectos.consultarDefectos();
            String[] defectos = new String[4];

            while (rs.next()) {
                defectos[0] = rs.getString("id");
                defectos[1] = rs.getString("nombre");
                defectos[2] = rs.getString("total_defectos");
                defectos[3] = rs.getString("pcmd");
                tabla.addRow(defectos);

            }

        } catch (Exception e) {
            System.out.println("Error al llenar los datos de defectos. " + e);
        }

    }

    public void mostrarTotalGajos() {
        try {
            
           
            modeloEvaluacionDefectos.id_calculo = Integer.parseInt(this.vistaEvaluacion.lb_id_evaluacion.getName());
            rs = modeloEvaluacionDefectos.obtenerTotalGajos();
            
            while (rs.next()) {
                String variableTemp = rs.getString(rs.getString("total_gajos"));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaEvaluacion, "Error en mostrarIdEvaluacion. " + e);
        }
    }

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
