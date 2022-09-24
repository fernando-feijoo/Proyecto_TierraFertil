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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Ctrl_listar_campo implements ActionListener, MouseListener, KeyListener {

    Listar_campo nn = new Listar_campo();
    Mod_listado_campo mlis = new Mod_listado_campo();
    
    int id_evaluaciones;

    public Ctrl_listar_campo(Listar_campo nn) {
        
        this.nn = nn;
        
        this.nn.btn_ok.addActionListener(this);
        buscar_campo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.nn.btn_ok) {
            buscar_campo();
        }
    }

    public void tabla_listado_campo() {
        try {
//            ImageIcon iconoUno = (new ImageIcon(getClass().getResource("/Icon/data_processing_32px.png")));
//            ImageIcon iconoDos = (new ImageIcon(getClass().getResource("/Icon/trash_bin_32px.png")));
//            JLabel botonUno = new JLabel(iconoUno);
//            JLabel botonDos = new JLabel(iconoDos);

            DefaultTableModel tablac = (DefaultTableModel) this.nn.tabla_campo.getModel();
//            this.nn.tabla_campo.setDefaultRenderer(Object.class, new Render());
            tablac.setColumnCount(0);
            tablac.setRowCount(0);

            tablac.addColumn("ID");
            tablac.addColumn("COD");
            tablac.addColumn("NOMBRE_PROD");
            tablac.addColumn("APELLIDO_PROD");
            tablac.addColumn("FINCA_PROD");
//            tablac.addColumn(" ");
//            tablac.addColumn(" ");
         
            //tablac.addColumn("F.nac");
            ResultSet rs = mlis.consultas();

            String[] registroCliente = new String[5];

            while (rs.next()) {
//                this.nn.tabla_campo.setRowHeight(37);
//                this.nn.tabla_campo.getColumnModel().getColumn(5).setPreferredWidth((37));
//                this.nn.tabla_campo.getColumnModel().getColumn(6).setPreferredWidth((37));
                
                registroCliente[0] = rs.getString(1);
                registroCliente[1] = rs.getString(2);
                registroCliente[2] = rs.getString(3);
                registroCliente[3] = rs.getString(4);
                registroCliente[4] = rs.getString(5);
//                registroCliente[5] = botonUno;
//                registroCliente[6] = botonDos;

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
        
    }
        
    }


