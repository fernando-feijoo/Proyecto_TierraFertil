package Controlador.Grupo2;

import Modelo.Grupo2.Modelo_Evaluacion_Defectos;
import Vista.Grupo2.Vista_Evaluacion_Total;
import Vista.Grupo2.Vista_Listado_Menu;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador_Evaluacion_Defectos implements MouseListener {

    Vista_Evaluacion_Total vistaEvaluacion;
    Modelo_Evaluacion_Defectos modeloEvaluacionDefectos = new Modelo_Evaluacion_Defectos();

    ResultSet rs;
    ResultSet rsCargado;

    public Controlador_Evaluacion_Defectos(Vista_Evaluacion_Total vistaEvaluacion) {
        this.vistaEvaluacion = vistaEvaluacion;

        this.vistaEvaluacion.jb_agregar_defecto.addMouseListener(this);
        this.vistaEvaluacion.jb_guardar_caja.addMouseListener(this);
        this.vistaEvaluacion.lb_eliminar_defecto.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vistaEvaluacion.jb_agregar_defecto) {
            agregarDefecto();

        }
        if (e.getSource() == this.vistaEvaluacion.jb_guardar_caja) {

            guardadoPcmdFinal();
            limpiarDefectosTabulacion();

        }
        if (e.getSource() == this.vistaEvaluacion.lb_eliminar_defecto) {
            int respuesta = JOptionPane.showConfirmDialog(vistaEvaluacion, "¿Desea eliminar el registro seleccionado?", "ATENCION", JOptionPane.ERROR_MESSAGE);

            if (respuesta == 0) {
                seleccionDefectoEliminar();

            }

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

    public void mostrarDefectos() {
        /* this.vistaEvaluacion.tabla_defectos.setDefaultRenderer(Object.class, new Render());
        JLabel btn_eliminar = new JLabel(new ImageIcon(getClass().getResource("/Icon/user.png")));
         */
        DefaultTableModel tabla = (DefaultTableModel) this.vistaEvaluacion.tabla_defectos.getModel();

        tabla.setColumnCount(0);
        tabla.addColumn("Id");
        tabla.addColumn("Nombre");
        tabla.addColumn("Total de defectos");
        tabla.addColumn("Pcmd");
        tabla.setRowCount(0);
        try {
            modeloEvaluacionDefectos.id_detalle = this.vistaEvaluacion.lb_id_tabulacion.getText();

            rs = modeloEvaluacionDefectos.consultarDefectos();
            String[] defectos = new String[4];

            while (rs.next()) {
                defectos[0] = rs.getString("id");
                defectos[1] = rs.getString("nombre");
                defectos[2] = rs.getString("total_defectos");
                defectos[3] = rs.getString("pcmd");
                tabla.addRow(defectos);
                /*tabla.addRow(defectos);
                tabla.addRow(new Object[]{
                    btn_eliminar
                });*/
//                this.vistaEvaluacion.tabla_defectos.setRowHeight(40);
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

    public void cargarDefectos(String valor) {
        try {
            modeloEvaluacionDefectos.codigoCargar2 = valor;
            modeloEvaluacionDefectos.selecionDefectos();
            rsCargado = modeloEvaluacionDefectos.selecionDefectos();
            while (rsCargado.next()) {
                this.vistaEvaluacion.txt_nombre_defectos.setText(rsCargado.getString(1));
                this.vistaEvaluacion.txt_total_defectos.setText(rsCargado.getString(2));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaEvaluacion, "Error en cargarDefectos" + e);
        }
    }

    public void agregarDefecto() {
        try {
            modeloEvaluacionDefectos.nombre = this.vistaEvaluacion.txt_nombre_defectos.getText();
            modeloEvaluacionDefectos.total_defectos = Integer.parseInt(this.vistaEvaluacion.txt_total_defectos.getText());

            modeloEvaluacionDefectos.id_detalle = this.vistaEvaluacion.lb_id_tabulacion.getText();

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

    public void guardadoPcmdFinal() {
        try {
            modeloEvaluacionDefectos.pcmd_total = Integer.parseInt(this.vistaEvaluacion.lb_id_tabulacion.getText());
            modeloEvaluacionDefectos.calcularPcmdTotal();
            mostrarTabulacionFinal();
            JOptionPane.showMessageDialog(vistaEvaluacion, "Caja guardada correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaEvaluacion, "Error al intentar registrar la caja " + e);

        }

    }

    public void mostrarTabulacionFinal() {
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

            modeloEvaluacionDefectos.codigoCargaTabulacionFinal = vistaEvaluacion.lb_id_evaluacion.getText();

            rs = modeloEvaluacionDefectos.consultarTabulacionFinal();
            String[] tabulacion = new String[11];

            while (rs.next()) {

                tabulacion[0] = rs.getString(1);
                tabulacion[1] = rs.getString(2);
                tabulacion[2] = rs.getString(3);
                tabulacion[3] = rs.getString(4);
                tabulacion[4] = rs.getString(5);
                tabulacion[5] = rs.getString(6);
                tabulacion[6] = rs.getString(7);
                tabulacion[7] = rs.getString(8);
                tabulacion[8] = rs.getString(9);
                tabulacion[9] = rs.getString(10);
                tabulacion[10] = rs.getString(11);
                tabla.addRow(tabulacion);

            }

        } catch (Exception e) {
            System.out.println("Error en mostrarTabulacion. " + e);
        }
    }

    public void limpiarDefectosTabulacion() {
        //Setea los campos de defectos
        this.vistaEvaluacion.txt_nombre_defectos.setText("");
        this.vistaEvaluacion.txt_total_defectos.setText("");

        this.vistaEvaluacion.lb_id_tabulacion.setText("");
        //Setea los campos de tabulacion

        this.vistaEvaluacion.txt_caja_insp.setText("");
        this.vistaEvaluacion.txt_embalador.setText("");
        this.vistaEvaluacion.txt_peso_neto.setText("");
        this.vistaEvaluacion.txt_par4.setText("");
        this.vistaEvaluacion.txt_par6.setText("");
        this.vistaEvaluacion.txt_par8.setText("");
        this.vistaEvaluacion.txt_inpar5.setText("");
        this.vistaEvaluacion.txt_inpar7.setText("");
        mostrarDefectos();

    }

    public void seleccionDefectoEliminar() {
        if (this.vistaEvaluacion.tabla_defectos.getSelectedRowCount() == 1) {
            try {
                int fila = this.vistaEvaluacion.tabla_defectos.getSelectedRow();

                modeloEvaluacionDefectos.id_detalle_eliminar = this.vistaEvaluacion.tabla_defectos.getValueAt(fila, 0).toString();
                modeloEvaluacionDefectos.eliminarDefectoPermanente();
                mostrarDefectos();
                JOptionPane.showMessageDialog(vistaEvaluacion, "Registro eliminado con exito.");

            } catch (Exception ex) {
                System.out.println("Error al seleccionar datos: " + ex);
            }
        }

    }

}
