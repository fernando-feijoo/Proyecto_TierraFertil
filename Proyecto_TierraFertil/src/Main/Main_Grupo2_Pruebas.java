
package Main;
import Vista.Grupo2.Vista_Escritorio_Prueba;
import Controlador.Grupo2.Controlador_Escritorio;
public class Main_Grupo2_Pruebas {

    
    public static void main(String[] args) {
        Vista_Escritorio_Prueba visEscritorio = new Vista_Escritorio_Prueba();
        Controlador_Escritorio ctrlEscritorio = new Controlador_Escritorio(visEscritorio);
        visEscritorio.setVisible(true);
    }
}