package Controlador.Grupo2;
import Vista.Grupo2.Vista_Escritorio_Prueba;
import Vista.Grupo2.Vis_evaluacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class Controlador_Escritorio implements ActionListener, MouseListener{
    Vis_evaluacion visEvaluacion = new Vis_evaluacion();
    Vista_Escritorio_Prueba visEscritorio = new Vista_Escritorio_Prueba();
    
    public Controlador_Escritorio(Vista_Escritorio_Prueba visEscritorio) {
        this.visEscritorio = visEscritorio;
        this.visEscritorio.btn_control.addMouseListener(null);
        
      
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
    
}
