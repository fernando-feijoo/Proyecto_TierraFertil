package Controlador.Grupo3;

import Modelo.Grupo3.Modelo_Datos_Llegada;
import Vista.Grupo3.Vista_Llegada;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controlador_Datos_Llegada implements MouseListener{
    Vista_Llegada vistaLlegada;
    Modelo_Datos_Llegada modeloDatosLlegada = new Modelo_Datos_Llegada();
    ResultSet rs;
    public static int idContenedor;
    public static int idDatosLlegada;
    
    public Controlador_Datos_Llegada(Vista_Llegada vistaLlegada) {
        this.vistaLlegada = vistaLlegada;
        this.idEntidadContenedores();
        this.idEntidadDatosLlegada();
        System.out.println("Activado Controlador Llegada");
    }
    
    public void idEntidadContenedores (){
        try {
            rs = modeloDatosLlegada.consultaID_contenedor();
            while (rs.next()) {
                idContenedor = Integer.parseInt(rs.getString("id_contenedor"));
            }
            //  Lo mejor que veo es no sumar aqui directo para que solo sea una consulta al iniciar nada mas.
//            idContenedor++;
            System.out.println("Dato Contenedor Controlador: " + idContenedor);
        } catch (SQLException ex) {
            System.out.println("Error de consulta y almacenamiento: " + ex);
        }
    }
    
    public void idEntidadDatosLlegada (){
        try {
            rs = modeloDatosLlegada.consultaID_contenedor();
            while (rs.next()) {
                idDatosLlegada = Integer.parseInt(rs.getString("id_contenedor"));
            }
//            idDatosLlegada++;
            System.out.println("DatosLlegada Controlador: " + idDatosLlegada);
        } catch (SQLException ex) {
            System.out.println("Error de consulta y almacenamiento: " + ex);
        }
    }
    //  Sirve para incrementar el valor idContenedor y de todos, se llama en el ControladorGeneral y aumenta ahi cuando se guarde.
    //  ESTO SE DEBERIA AUTO INCREMENTAR POR CONDICION SI ES PRIMER INGRESO SE SUMA, SI SE GUARDA SE SUMA.
    //  Mientras no se guarde no se suma.
    public void autoIncrementarID_Entidades(int heredado){
        this.idContenedor = heredado;
        System.out.println("ValorTemp: " + idContenedor);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}