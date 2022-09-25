package Controlador.Grupo2;
import Modelo.Grupo2.Modelo_Evaluacion_Reportes;
import Modelo.Grupo2.Modelo_Evaluacion_Datos;
import Vista.Grupo2.Vista_Evaluacion_Total;
import Vista.Grupo2.Vista_Reportes_Menu;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Controlador_Evaluacion_Reportes implements MouseListener{
    Vista_Reportes_Menu vistaReportes = new Vista_Reportes_Menu();
    Modelo_Evaluacion_Reportes modeloReportes = new Modelo_Evaluacion_Reportes();
    Vista_Evaluacion_Total vistaEvaluacion = new Vista_Evaluacion_Total();
    ResultSet rs;
    ResultSet rsCarga;
    
    public Controlador_Evaluacion_Reportes(Vista_Reportes_Menu vistaReportes) {
        this.vistaReportes = vistaReportes;
        mostrarDatosReports();
        this.vistaReportes.rdn_imprimir.addMouseListener(this);
        
        
       
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
    
     public void mostrarDatosReports() {
        DefaultTableModel tabla = (DefaultTableModel) this.vistaReportes.tabla_listado.getModel();
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
