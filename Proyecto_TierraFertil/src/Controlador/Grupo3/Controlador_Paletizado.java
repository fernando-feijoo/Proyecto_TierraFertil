package Controlador.Grupo3;

import Modelo.Grupo3.Modelo_Contenedores;
import Modelo.Grupo3.Modelo_Paletizado;
import Vista.Grupo3.Vista_Llegada;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controlador_Paletizado {

    Vista_Llegada vistaLlegada;
    Modelo_Paletizado modeloPaletizado = new Modelo_Paletizado();
    Modelo_Contenedores modeloPaContenedor = new Modelo_Contenedores();

    public static int idContenedor;
    public static int idPaletizado;
    String observacionGeneralPale;
    int codigo, idCajas;
    ResultSet rs;
    public int tempClickG3;

    public Controlador_Paletizado(Vista_Llegada vistaLlegada) {
        this.vistaLlegada = vistaLlegada;
    }

    //  #borrar mensajes de mas en consola.
    public void controlGuardado(int herenciaClicks) {
        this.tempClickG3 = herenciaClicks;
        System.out.println("HerenciaClic PA: " + tempClickG3);
    }

    public void guardarContenedor() {
        this.modeloPaContenedor.obser_General = this.observacionGeneralPale;
        System.out.println("Guardar Conten PA: " + idContenedor + " , " + observacionGeneralPale);
    }
    
    public void idEntidadPalet() {
        try {
            rs = modeloPaletizado.consultaID_entidadPallet();
            while (rs.next()) {
                idPaletizado = Integer.parseInt(rs.getString("id_tablaPallet"));
            }
            System.out.println("id Entidad HigCont ControladorHigCont: " + idPaletizado);
        } catch (SQLException ex) {
            System.out.println("Error de consulta y almacenamiento PA: " + ex);
        }
    }
    
    public void autoIncrementarID_Entidades(int herenciaTres, int herenciaCuatro) {
        this.idContenedor = herenciaTres;
        this.idPaletizado = herenciaCuatro;
        System.out.println("ValorHerencia HigieneConendor ContPA: " + this.idContenedor + " , idPA: " + this.idPaletizado);
    }
}
