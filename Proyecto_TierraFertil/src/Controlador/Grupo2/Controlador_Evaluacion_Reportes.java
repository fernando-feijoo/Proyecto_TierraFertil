package Controlador.Grupo2;

import Modelo.Grupo2.Modelo_Evaluacion_Reportes;
import Modelo.Grupo2.Modelo_Evaluacion_Datos;
import Vista.Grupo2.Vista_Evaluacion_Total;
import Modelo.Modelo_Conexion;
import Vista.Grupo2.Vista_Reportes_Menu;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.codehaus.groovy.control.messages.ExceptionMessage;

public class Controlador_Evaluacion_Reportes implements MouseListener {

    Vista_Reportes_Menu vistaReportes = new Vista_Reportes_Menu();
    Modelo_Evaluacion_Reportes modeloReportes = new Modelo_Evaluacion_Reportes();
    Vista_Evaluacion_Total vistaEvaluacion = new Vista_Evaluacion_Total();
    Modelo_Conexion conexion = new Modelo_Conexion();
    ResultSet rs;
    ResultSet rsCarga;

    public Controlador_Evaluacion_Reportes(Vista_Reportes_Menu vistaReportes) {
        this.vistaReportes = vistaReportes;
        mostrarDatosReports();
        this.vistaReportes.rdn_imprimir.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vistaReportes.rdn_imprimir) {
            JOptionPane.showMessageDialog(vistaReportes, "REPORTE GENERADO, PULSE OK PARA IMPRIMIR");

        }
        if (e.getSource() == vistaReportes.rdn_imprimir) {
            generarReporte();
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

    public void generarReporte() {
        try {

            int fila = this.vistaReportes.tabla_reportes.getSelectedRow();
            String respuesta = this.vistaReportes.tabla_reportes.getValueAt(fila, 0).toString();

            JasperReport reporte;
            JasperPrint jprint;

            HashMap<String, Object> parameters = new HashMap<>();

            parameters.put("parametro_codigo", respuesta);
            DefaultTableModel tabla = (DefaultTableModel) this.vistaReportes.tabla_reportes.getModel();

            reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes_Grupo2/Reporte_Evaluacion.jasper"));
            jprint = JasperFillManager.fillReport(reporte, parameters, conexion.conectarBD());

            if (jprint != null) {
                JasperViewer view = new JasperViewer(jprint);
                view.setVisible(true);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vistaReportes, "Error al generar reporte: " + ex);
        }
    }

    public void mostrarDatosReports() {
        DefaultTableModel tabla = (DefaultTableModel) this.vistaReportes.tabla_reportes.getModel();
        tabla.setColumnCount(0);
        tabla.addColumn("Codigo");
        tabla.addColumn("Fecha");
        tabla.addColumn("Semana");
        tabla.addColumn("Destino");
        tabla.addColumn("Cajas inspeccionadas");
        tabla.setRowCount(0);

        try {
            rs = modeloReportes.mostrarListado();
            String[] tabulacion = new String[5];

            while (rs.next()) {

                tabulacion[0] = rs.getString("codigo");
                tabulacion[1] = rs.getString("fecha");
                tabulacion[2] = rs.getString("id_semana");
                tabulacion[3] = rs.getString("destino");
                tabulacion[4] = rs.getString("cajas_inspeccionadas");
                tabla.addRow(tabulacion);

            }

        } catch (Exception e) {
            System.out.println("Error en mostrarListado. " + e);
        }

    }

}
