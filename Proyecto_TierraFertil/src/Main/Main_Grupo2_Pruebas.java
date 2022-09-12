
package Main;
import Vista.Grupo2.Vista_Escritorio_Prueba;
import Vista.Grupo2.Vis_evaluacion;
public class Main_Grupo2_Pruebas {

    
    public static void main(String[] args) {
        Vista_Escritorio_Prueba visEscritorio = new Vista_Escritorio_Prueba();
        Vis_evaluacion vistaEvaluacion = new Vis_evaluacion();
        visEscritorio.setVisible(true);
        visEscritorio.escritorio.add(vistaEvaluacion);
        vistaEvaluacion.setVisible(true);
        
        
                
        
    }
    
    
}
