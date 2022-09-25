package Controlador.Grupo1;

import Modelo.Grupo1.Mod_listado_campo;
import Vista.Grupo1.Listar_campo;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Ctrl_listar_campo implements ActionListener, MouseListener, KeyListener {

    Listar_campo nn = new Listar_campo();
    Mod_listado_campo mlis = new Mod_listado_campo();
    
    public static String id_evaEliminar, id_evaActualizar;

    public Ctrl_listar_campo(Listar_campo nn) {
        
        this.nn = nn;
        
        this.nn.btn_ok.addActionListener(this);
        this.nn.btn_elminar.addActionListener(this);
        
        buscar_campo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.nn.btn_ok) {
            buscar_campo();
        }
        if (e.getSource() == this.nn.btn_elminar) {
            eliminar_campo();
        }
    }

    public void tabla_listado_campo() {
        try {

            DefaultTableModel tablac = (DefaultTableModel) this.nn.tabla_campo.getModel();

            tablac.setColumnCount(0);
            tablac.setRowCount(0);

            tablac.addColumn("ID");
            tablac.addColumn("COD");
            tablac.addColumn("NOMBRE_PROD");
            tablac.addColumn("APELLIDO_PROD");
            tablac.addColumn("FINCA_PROD");

            ResultSet rs = mlis.consultas();

            String[] registroCliente = new String[5];

            while (rs.next()) {

                registroCliente[0] = rs.getString(1);
                registroCliente[1] = rs.getString(2);
                registroCliente[2] = rs.getString(3);
                registroCliente[3] = rs.getString(4);
                registroCliente[4] = rs.getString(5);


                tablac.addRow(registroCliente);
            }
        } catch (Exception e) {

        }
    }

    public void buscar_campo (){
        this.mlis.buscar=this.nn.txt_buscar_listado.getText();
        this.mlis.consultas();
        this.tabla_listado_campo();
    }
    
    public void eliminar_campo (){
        try {
                int fila = this.nn.tabla_campo.getSelectedRow();
                id_evaEliminar =(String) this.nn.tabla_campo.getValueAt(fila, 0);
                this.mlis.id_evaluacion = id_evaEliminar;
                JOptionPane.showMessageDialog(nn, "El id de eva es: "+this.id_evaEliminar);

                int respuesta = JOptionPane.showConfirmDialog(nn, "¿Desea eliminar el registro?", "ATENCION", JOptionPane.YES_OPTION);
                if (respuesta == 0) {
                    mlis.eliminarRegistro();
                    tabla_listado_campo();
                }
                DefaultTableModel tabla = (DefaultTableModel) this.nn.tabla_campo.getModel();

                System.out.println("Eliminado ejecutado");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(nn, "Error :/" + ex);
            }
    }
    
    public void actualizar_campo (){
        try {
                int fila = this.nn.tabla_campo.getSelectedRow();
                id_evaActualizar =(String) this.nn.tabla_campo.getValueAt(fila, 0);
                this.mlis.id_evaluacion = id_evaActualizar;
                JOptionPane.showMessageDialog(nn, "El id de eva es: "+this.id_evaActualizar);

                int respuesta = JOptionPane.showConfirmDialog(nn, "¿Desea Actualizar el registro?", "ATENCION", JOptionPane.YES_OPTION);
                if (respuesta == 0) {
                    mlis.eliminarRegistro();
                    tabla_listado_campo();
                }
                DefaultTableModel tabla = (DefaultTableModel) this.nn.tabla_campo.getModel();

                System.out.println("Eliminado ejecutado");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(nn, "Error :/" + ex);
            }
    }
    public void filtrarTabla(String valor) {
        //Caracteristica de ordenamiento
        DefaultTableModel tabla = (DefaultTableModel) this.nn.tabla_campo.getModel();
        //Permite añadir caracteristica de ordenamiento
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(tabla);
        this.nn.tabla_campo.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + valor, 1));

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
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

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == this.nn.txt_buscar_listado) {
            filtrarTabla(nn.txt_buscar_listado.getText());
        }
    }
        
    }


