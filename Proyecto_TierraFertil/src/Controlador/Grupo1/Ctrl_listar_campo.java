package Controlador.Grupo1;

import Modelo.Grupo1.Mod_listado_campo;
import Vista.Grupo1.Listar_campo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ctrl_listar_campo implements ActionListener{

    Listar_campo nn = new Listar_campo();
    Mod_listado_campo mlis = new Mod_listado_campo();
    
    public Ctrl_listar_campo(Listar_campo nn) {
        this.nn=nn;
        
        this.nn.btn_ok.addActionListener(this);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==this.nn.btn_ok) {
            try {           
                tabla_listado_campo();
            } catch (SQLException ex) {
                Logger.getLogger(Ctrl_listar_campo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    public void tabla_listado_campo () throws SQLException{
        try {
            DefaultTableModel tablac = (DefaultTableModel) this.nn.tabla_campo.getModel();
            tablac.setColumnCount(0);
            tablac.setRowCount(0);

            tablac.addColumn("Nombre");
            tablac.addColumn("Finca");
            tablac.addColumn("Tipo_caja");
            tablac.addColumn("Vapor");
            tablac.addColumn("Fecha_eva");
            tablac.addColumn("Placa_vehiculo");
            tablac.addColumn("Semana");
            tablac.addColumn("Cod_eva");
            tablac.addColumn("Hora_eva");
            
            //tablac.addColumn("F.nac");

            ResultSet rs = mlis.consultas();
            String[] registroCliente = new String[9];

            while (rs.next()) {
                registroCliente[0] = rs.getString(1);
                registroCliente[1] = rs.getString(2);
                registroCliente[2] = rs.getString(3);
                registroCliente[3] = rs.getString(4);
                registroCliente[4] = rs.getString(5);
                registroCliente[5] = rs.getString(6);
                registroCliente[6] = rs.getString(7);
                registroCliente[7] = rs.getString(8);
                registroCliente[8] = rs.getString(9);

                tablac.addRow(registroCliente);
            }
        } catch (Exception e) {
            
        }   
    } 
    
}
