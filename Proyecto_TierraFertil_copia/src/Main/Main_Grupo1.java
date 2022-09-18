package Main;

import Controlador.Grupo1.Ctrl_menu_temporal;
import Vista.Grupo1.Menu_Campo;
import Vista.Grupo1.Menu_temporal;
import Vista.Grupo1.Vista_campo_1;

public class Main_Grupo1 {
    
    public static void main(String[] args) {
    Menu_temporal m_tem = new Menu_temporal();
    Vista_campo_1 v_cam= new Vista_campo_1();
    Menu_Campo m_cam = new Menu_Campo();
    Ctrl_menu_temporal c_tem = new Ctrl_menu_temporal(m_tem);
    m_tem.Escritorio_In.add(v_cam);
    m_tem.Escritorio_tan.add(m_cam);
    m_cam.setVisible(true);
    v_cam.setVisible(true);
    m_tem.setVisible(true);   
    }
}