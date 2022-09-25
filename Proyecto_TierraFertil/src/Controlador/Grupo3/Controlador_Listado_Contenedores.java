package Controlador.Grupo3;

import Modelo.Grupo3.Modelo_Listado_Contenedores;
import Vista.Grupo3.Vista_Listado_Contenedores;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Controlador_Listado_Contenedores implements MouseListener {

    Vista_Listado_Contenedores vistaListadoCont;
    Modelo_Listado_Contenedores modeloListadoContenedore = new Modelo_Listado_Contenedores();
    ResultSet rs;
    public static String busqueda;
    public static int idContenedor;
    public int tempClickG3 = 0;

    public Controlador_Listado_Contenedores(Vista_Listado_Contenedores vistaListadoCont) {
        this.vistaListadoCont = vistaListadoCont;
        this.vistaListadoCont.boton_Buscar.addMouseListener(this);
        this.vistaListadoCont.tabla_listado_contenedores.addMouseListener(this);

    }

    public void cargaDatosInicial() {
        this.busquedaDatos();
    }

    // Hay que probar si funciona.
    public void busquedaDatos() {
        this.busqueda = this.vistaListadoCont.ListadoContenedor_txf_Busqueda.getText();
        this.modeloListadoContenedore.busquedaGeneral = this.busqueda;
        this.modeloListadoContenedore.consultarDatos();
        this.mostrarDatos();
    }

    // Hay que probar si funciona.
    public void busquedaID_Contenedor() {
        try {
            rs = modeloListadoContenedore.consultaID_Contenedor();
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
        ImageIcon iconoUno = (new ImageIcon(getClass().getResource("/Icon/data_processing_32px.png")));
        ImageIcon iconoDos = (new ImageIcon(getClass().getResource("/Icon/trash_bin_32px.png")));
        JLabel botonUno = new JLabel(iconoUno);
        JLabel botonDos = new JLabel(iconoDos);

        DefaultTableModel tabla = (DefaultTableModel) this.vistaListadoCont.tabla_listado_contenedores.getModel();
        this.vistaListadoCont.tabla_listado_contenedores.setDefaultRenderer(Object.class, new Render());
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
        tabla.addColumn(" ");
        try {
            rs = modeloListadoContenedore.consultarDatos();
            Object[] registros = new Object[11];
            while (rs.next()) {
                this.vistaListadoCont.tabla_listado_contenedores.setRowHeight(37);

                this.vistaListadoCont.tabla_listado_contenedores.getColumnModel().getColumn(0).setPreferredWidth(100);
                this.vistaListadoCont.tabla_listado_contenedores.getColumnModel().getColumn(1).setPreferredWidth(25);
                this.vistaListadoCont.tabla_listado_contenedores.getColumnModel().getColumn(2).setPreferredWidth((50));
                this.vistaListadoCont.tabla_listado_contenedores.getColumnModel().getColumn(3).setPreferredWidth((50));
                this.vistaListadoCont.tabla_listado_contenedores.getColumnModel().getColumn(4).setPreferredWidth((50));
                this.vistaListadoCont.tabla_listado_contenedores.getColumnModel().getColumn(5).setPreferredWidth((50));
                this.vistaListadoCont.tabla_listado_contenedores.getColumnModel().getColumn(6).setPreferredWidth((50));
                this.vistaListadoCont.tabla_listado_contenedores.getColumnModel().getColumn(7).setPreferredWidth((50));
                this.vistaListadoCont.tabla_listado_contenedores.getColumnModel().getColumn(8).setPreferredWidth((50));

                //  Dos ultimos botones.
                this.vistaListadoCont.tabla_listado_contenedores.getColumnModel().getColumn(9).setPreferredWidth(27);
                this.vistaListadoCont.tabla_listado_contenedores.getColumnModel().getColumn(10).setPreferredWidth(27);

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
                registros[10] = botonDos;

                tabla.addRow(registros);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaListadoCont, " al llenar datos" + e);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int filaSeleccionada = this.vistaListadoCont.tabla_listado_contenedores.getSelectedRow();
        if (me.getSource() == this.vistaListadoCont.boton_Buscar) {
            this.busquedaDatos();
        }
        if (this.vistaListadoCont.tabla_listado_contenedores.getSelectedColumn() == 9) {
            this.modeloListadoContenedore.busquedaID_Contenedor = this.vistaListadoCont.tabla_listado_contenedores.getValueAt(filaSeleccionada, 0).toString();
            this.modeloListadoContenedore.consultaID_Contenedor();
            this.busquedaID_Contenedor();
            this.tempClickG3 = 3;
            System.out.println("CARGADO LISTA: " + this.vistaListadoCont.tabla_listado_contenedores.getValueAt(filaSeleccionada, 0).toString());
        }
        if (this.vistaListadoCont.tabla_listado_contenedores.getSelectedColumn() == 10) {
            int opcion = JOptionPane.showConfirmDialog(vistaListadoCont, "¿Esta seguro de eliminar, este registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (opcion == 0) {
                this.modeloListadoContenedore.elimando_Contenedor = this.vistaListadoCont.tabla_listado_contenedores.getValueAt(filaSeleccionada, 0).toString();
                this.modeloListadoContenedore.eliminadoLogico_Contenedor();
                JOptionPane.showMessageDialog(vistaListadoCont, "Dato Eliminado Correctamente", "Confirmacion de Eliminado", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("ELIMINADO LISTA: " + this.vistaListadoCont.tabla_listado_contenedores.getValueAt(filaSeleccionada, 0).toString());
                this.cargaDatosInicial();
            } else {
                JOptionPane.showMessageDialog(vistaListadoCont, "Registro no eliminado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }
}

class Render extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if (value instanceof JLabel) {
            JLabel btn = (JLabel) value;
            return btn;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
