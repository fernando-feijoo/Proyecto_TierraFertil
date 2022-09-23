package Controlador.Grupo2;

import Vista.Grupo2.Vista_Listado_Menu;
import java.awt.Label;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Controlador_Listado_Menu {

    Vista_Listado_Menu vistaListadoMenu = new Vista_Listado_Menu();

    public Controlador_Listado_Menu(Vista_Listado_Menu vistaListado) {
        this.vistaListadoMenu = vistaListadoMenu;

    }

    public void mostrarDatos() {

        this.vistaListadoMenu.tabla_listado.setDefaultRenderer(Object.class, new Render());
        JLabel btn_eliminar = new JLabel(new ImageIcon(getClass().getResource("/Icon/user.png")));

       /* tabla.addRow(new Object[]{
            btn_eliminar
        });  */
    }

}
