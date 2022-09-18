package Controlador.Grupo2;
import Modelo.Grupo2.Modelo_Evaluacion_Defectos;
import Vista.Grupo2.Vista_Evaluacion_Total;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
public class Controlador_Evaluacion_Defectos implements MouseListener{
    Vista_Evaluacion_Total vistaEvaluacion = new Vista_Evaluacion_Total();
    Modelo_Evaluacion_Defectos modeloEvaluacionDefectos = new Modelo_Evaluacion_Defectos();

    public Controlador_Evaluacion_Defectos(Vista_Evaluacion_Total vistaEvaluacion) {
        this.vistaEvaluacion = vistaEvaluacion;
        
        this.vistaEvaluacion.jb_agregar_defecto.addMouseListener(this);
        this.vistaEvaluacion.jb_nuevos_datos.addMouseListener(this);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        modeloEvaluacionDefectos.id_detalle = Integer.parseInt(this.vistaEvaluacion.txt_id_defecto.getText());
        modeloEvaluacionDefectos.nombre = this.vistaEvaluacion.txt_nombre_defectos.getText();
        modeloEvaluacionDefectos.pcmd = this.vistaEvaluacion.txt_contenedor.getText();
        try {
            
            boolean aux = modeloEvaluacionDefectos.guardarDefectos();
            if (aux = true) {
                System.out.println("SEGUIMIENTO: Campos de tabulacion almacenados corretamente. ");
                JOptionPane.showMessageDialog(vistaEvaluacion, "Datos almacenados correctamente. " +e, "REGISTROS", JOptionPane.INFORMATION_MESSAGE);
                
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vistaEvaluacion, "Error al intentar guardar los datos. "+ex);
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
