package Controlador.Grupo3;

import Modelo.Grupo3.Modelo_Obtener_Reportes;
import Modelo.Modelo_Conexion;
import Vista.Grupo3.Vista_Obtener_Reportes;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Controlador_Obtener_Reportes implements MouseListener {

    Vista_Obtener_Reportes vistaObtReport;
    Modelo_Obtener_Reportes modeloObtenerReportes = new Modelo_Obtener_Reportes();
    Modelo_Conexion modeloConexion = Modelo_Conexion.getInstancia();

    ResultSet rs;
    public static String busqueda;
    public static int idContenedor;
    public String parametro;

    public Controlador_Obtener_Reportes(Vista_Obtener_Reportes vistaObtReport) {
        this.vistaObtReport = vistaObtReport;
        this.vistaObtReport.boton_Buscar.addMouseListener(this);
        this.vistaObtReport.tabla_reporte_contenedores.addMouseListener(this);
    }

    public void cargaDatosInicial() {
        this.busquedaDatos();
    }

    public void busquedaDatos() {
        this.busqueda = this.vistaObtReport.ListadoContenedor_txf_Busqueda.getText();
        this.modeloObtenerReportes.busquedaGeneral = this.busqueda;
        this.modeloObtenerReportes.consultarDatos();
        this.vistaObtReport.tabla_reporte_contenedores.revalidate();
        this.vistaObtReport.tabla_reporte_contenedores.repaint();
        this.mostrarDatos();
    }

    // Hay que probar si funciona.
    public void busquedaID_Contenedor() {
        try {
            rs = modeloObtenerReportes.consultaID_Contenedor();
            while (rs.next()) {
                idContenedor = Integer.parseInt(rs.getString("id"));
            }
            rs.close();
            System.out.println("id Entidad Contenedor LC: " + idContenedor);
        } catch (SQLException ex) {
            System.out.println("Error de consulta ID_Contenedor LC: " + ex);
        }
    }

    public void mostrarDatos() {
        ImageIcon iconoUno = (new ImageIcon(getClass().getResource("/Icon/imprimir_32px.png")));
        JLabel botonUno = new JLabel(iconoUno);

        DefaultTableModel tabla = (DefaultTableModel) this.vistaObtReport.tabla_reporte_contenedores.getModel();
        this.vistaObtReport.tabla_reporte_contenedores.setDefaultRenderer(Object.class, new Render());
        tabla.setColumnCount(0);
        tabla.setRowCount(0);
        tabla.addColumn("CODIGO");
        tabla.addColumn("SEMANA");
        tabla.addColumn("INSPECCIÓN");
        tabla.addColumn("LLEGADA");
        tabla.addColumn("FINCA");
        tabla.addColumn("OB INS CON");
        tabla.addColumn("OB HIG CON");
        tabla.addColumn("SELLO VERF");
        tabla.addColumn("OB GENERAL");
        tabla.addColumn(" ");

        try {
            rs = modeloObtenerReportes.consultarDatos();
            Object[] registros = new Object[10];
            while (rs.next()) {
                this.vistaObtReport.tabla_reporte_contenedores.setRowHeight(37);

                this.vistaObtReport.tabla_reporte_contenedores.getColumnModel().getColumn(9).setPreferredWidth((37));

                registros[0] = rs.getString("codigo");
                registros[1] = rs.getString("semana");
                registros[2] = rs.getString("fecha_insp");
                registros[3] = rs.getString("hora_llegada");
                registros[4] = rs.getString("nombre_finca");
                registros[5] = rs.getString("obser_ins_cont");
                registros[6] = rs.getString("obser_hig_cont");
                registros[7] = rs.getString("sello_verificador");
                registros[8] = rs.getString("obser_general");
                registros[9] = botonUno;

                tabla.addRow(registros);
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaObtReport, " al llenar datos" + e);
        }
    }

    public void generarReporte() {
            try {
                JasperReport reporte;
                JasperPrint jprint = null;
                HashMap<String, Object> param = new HashMap<String, Object>();
                param.put("OBS_GENERAL", this.parametro);
//                param.put("subReporteUno", "/C:\\Users\\USUARIO PC\\JaspersoftWorkspace\\Proyecto_TierraFertil\\Proyecto_TierraFertil\\Reporte_Principal\\datosLlegada.jasper");
                param.put("subReporteUno", "Reportes\\Grupo3\\datosLlegada.jasper");
                param.put("subReporteDos", "/C:\\Users\\USUARIO PC\\JaspersoftWorkspace\\Proyecto_TierraFertil\\Proyecto_TierraFertil\\Reporte_Principal\\Inspeccion.jasper");
                param.put("subReporteTres", "/C:\\Users\\USUARIO PC\\JaspersoftWorkspace\\Proyecto_TierraFertil\\Proyecto_TierraFertil\\Reporte_Principal\\Higiene.jasper");
                param.put("subReporteTresObs", "/C:\\Users\\USUARIO PC\\JaspersoftWorkspace\\Proyecto_TierraFertil\\Proyecto_TierraFertil\\Reporte_Principal\\Observacion_Higiene.jasper");
                param.put("subReporteCuatro", "/C:\\Users\\USUARIO PC\\JaspersoftWorkspace\\Proyecto_TierraFertil\\Proyecto_TierraFertil\\Reporte_Principal\\Despacho.jasper");
                param.put("subReporteCinco", "/C:\\Users\\USUARIO PC\\JaspersoftWorkspace\\Proyecto_TierraFertil\\Proyecto_TierraFertil\\Reporte_Principal\\ControlPalet.jasper");
                reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/Grupo3/Reporte.jasper"));
                jprint = JasperFillManager.fillReport(reporte, param, modeloConexion.conectarBD());
                if (jprint != null) {
                    JasperViewer view = new JasperViewer(jprint);
                    view.setVisible(true);
                }
            } catch (Exception ex) {
                System.out.println("Error: " + ex);
            }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int filaSeleccionada = this.vistaObtReport.tabla_reporte_contenedores.getSelectedRow();
        if (me.getSource() == this.vistaObtReport.boton_Buscar) {
            this.busquedaDatos();
        }
        if (this.vistaObtReport.tabla_reporte_contenedores.getSelectedColumn() == 9) {
            this.parametro = this.vistaObtReport.tabla_reporte_contenedores.getValueAt(filaSeleccionada, 0).toString();
            System.out.println("Ingreso Genrar reporte Parametro: " + this.parametro);
            this.generarReporte();
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
