package Main;

import Controlador.Controlador_Login;
import Vista.Vista_Login;

public class Main_Proyecto {
    public static void main(String[] args) {
       Vista_Login vistaLogin = new Vista_Login();
        Controlador_Login controladorLogin = new Controlador_Login(vistaLogin);
        vistaLogin.show();
       
      
    }
}