package Main;

import Vista.Vista_General;
import Controlador.Controlador_General;

public class Main_Grupo3_Pruebas {
    public static void main(String[] args) {
        Vista_General vistaGeneral = new Vista_General();
        Controlador_General controladorGeneral = new Controlador_General(vistaGeneral);
        vistaGeneral.show();
        
    }
}