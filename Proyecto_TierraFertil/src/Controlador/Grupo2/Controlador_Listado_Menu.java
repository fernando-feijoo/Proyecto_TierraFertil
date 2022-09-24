package Controlador.Grupo2;

import Modelo.Grupo2.Modelo_Evaluacion_Listado;
import Vista.Grupo2.Vista_Listado_Menu;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import sun.tools.jar.resources.jar;

public class Controlador_Listado_Menu implements MouseListener, KeyListener, ActionListener {

    Vista_Listado_Menu vistaListadoMenu = new Vista_Listado_Menu();
    Modelo_Evaluacion_Listado modeloEvaluacionListado = new Modelo_Evaluacion_Listado();
    ResultSet rs;

    public Controlador_Listado_Menu(Vista_Listado_Menu vistaListadoMenu) {
        this.vistaListadoMenu = vistaListadoMenu;
        this.vistaListadoMenu.txt_buscar.addKeyListener(this);
        this.vistaListadoMenu.txt_buscar.addMouseListener(this);
        this.vistaListadoMenu.jb_buscar.addMouseListener(this);
        this.vistaListadoMenu.jb_eliminar.addMouseListener(this);
        mostrarDatos();

    }

    public void mostrarDatos() {
        DefaultTableModel tabla = (DefaultTableModel) this.vistaListadoMenu.tabla_listado.getModel();
        tabla.setColumnCount(0);
        tabla.addColumn("Codigo");
        tabla.addColumn("Fecha");
        tabla.addColumn("Semana");
        tabla.addColumn("Destino");
        tabla.addColumn("Cajas inspeccionadas");
        tabla.setRowCount(0);

        try {
            rs = modeloEvaluacionListado.mostrarListado();
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

    public void filtrarTabla(String valor) {
        //Caracteristica de ordenamiento
        DefaultTableModel tabla = (DefaultTableModel) this.vistaListadoMenu.tabla_listado.getModel();
        //Permite añadir caracteristica de ordenamiento
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(tabla);
        vistaListadoMenu.tabla_listado.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + valor, 1));

    }

    

    //        this.vistaListadoMenu.tabla_listado.setDefaultRenderer(Object.class, new Render());
//        JLabel btn_eliminar = new JLabel(new ImageIcon(getClass().getResource("/Icon/user.png")));

    /* tabla.addRow(new Object[]{
            btn_eliminar
        });  */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vistaListadoMenu.jb_eliminar) {
            try {
                DefaultTableModel tabla = (DefaultTableModel) this.vistaListadoMenu.tabla_listado.getModel();

                int fila = this.vistaListadoMenu.tabla_listado.getSelectedRow();
                this.modeloEvaluacionListado.codigo = (String) this.vistaListadoMenu.tabla_listado.getValueAt(fila, 0);
                    this.modeloEvaluacionListado.eliminarRegistro();
                    this.modeloEvaluacionListado.mostrarListado();
                
                
                System.out.println("Eliminado ejecutado");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vistaListadoMenu, "Error :/" + ex);
            }

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == this.vistaListadoMenu.txt_buscar) {
            this.vistaListadoMenu.txt_buscar.setText("");

        }

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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == this.vistaListadoMenu.txt_buscar) {
            filtrarTabla(vistaListadoMenu.txt_buscar.getText());

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
