package Controlador.Grupo3;

import Modelo.Grupo3.Modelo_Listado_Contenedores;
import Vista.Grupo3.Vista_Listado_Contenedores;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador_Listado_Contenedores {

    Vista_Listado_Contenedores vistaListadoCont;
    Modelo_Listado_Contenedores modeloListadoContenedore = new Modelo_Listado_Contenedores();
    ResultSet rs;
   
    

    public Controlador_Listado_Contenedores(Vista_Listado_Contenedores vistaListadoCont) {
        this.vistaListadoCont = vistaListadoCont;
        mostrarDatos();
    }

    public void mostrarDatos() {
//         JLabel btn1 = new JLabel(new ImageIcon(getClass().getResource("/Icon/diskette_24px.png")));

        this.vistaListadoCont.tabla_listado_contenedores.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel tabla = (DefaultTableModel) this.vistaListadoCont.tabla_listado_contenedores.getModel();
        tabla.setColumnCount(0);
        tabla.addColumn("codigo");
        tabla.addColumn("semana");
        tabla.addColumn("fecha_insp");
        
        
        tabla.setRowCount(0);

        try {
            rs = modeloListadoContenedore.consultarDatos();
            String [] registros = new String[3];
            while (rs.next()){
//                registros [0] = rs.getString("codigo");
//                registros [1] = rs.getString("semana");
//                registros [2] = rs.getString("fecha_insp");
                
                tabla.addRow( new Object[]{
//                    btn1
                        
//                    new JLabel(new ImageIcon(getClass().getResource("/Icon/diskette_24px.png")))
                        
                });
                 
                this.vistaListadoCont.tabla_listado_contenedores.setRowHeight(40);
                
            }
            
            
        } catch (Exception e) {
                        JOptionPane.showMessageDialog(vistaListadoCont, " al llenar datos" + e);

        }
 
    }
}
