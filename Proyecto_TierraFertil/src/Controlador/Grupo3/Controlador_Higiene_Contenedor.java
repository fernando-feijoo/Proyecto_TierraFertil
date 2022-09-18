package Controlador.Grupo3;

import Modelo.Grupo3.Modelo_Contenedores;
import Modelo.Grupo3.Modelo_Higiene_Contenedor;
import Vista.Grupo3.Vista_Llegada;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controlador_Higiene_Contenedor implements MouseListener {

    Vista_Llegada vistaLlegada;
    Modelo_Higiene_Contenedor modeloHigCont = new Modelo_Higiene_Contenedor();
    Modelo_Contenedores modeloHeContenedor = new Modelo_Contenedores();
    public static int idContenedor;
    String opcionUno, opcionDos, opcionTres, opcionCuatro, opcionCinco, opcionSeis,
            opcionSiete, opcionOcho, observacionHigCont;
    ResultSet rs;
    public static int idHigCont;

    public Controlador_Higiene_Contenedor(Vista_Llegada vistaLlegada) {
        this.vistaLlegada = vistaLlegada;
        this.vistaLlegada.btn_siguiente_higCont.addMouseListener(this);
        // Hay que modificar esto donde ira.
        this.idEntidadHigCont();
    }

    //  Se consultaria luego de guardar o querer hacer una nueva insercion(actualizacion)
    //  Lo de la actualizacion toca revisar porque puede haber inconvenientes, toca trajar la logica de idMAX
    public void idEntidadHigCont() {
        try {
            rs = modeloHigCont.consultaID_entidadHigCont();
            while (rs.next()) {
                idHigCont = Integer.parseInt(rs.getString("id_tablaHigCont"));
            }
            System.out.println("id Entidad Contenedor ControladorDatosLLegada: " + idHigCont);
        } catch (SQLException ex) {
            System.out.println("Error de consulta y almacenamiento: " + ex);
        }
    }

    public void autoIncrementarID_Entidades(int herenciaTres) {
        this.idContenedor = 1; //   ### Por ahora ppor motivos de prueba, cambiar. Con el que se inserta o actualiza.
        System.out.println("ValorHerencia HigieneConendor ContHC: " + idContenedor);
    }

    public void almacenarHigieneContendor() {
        this.opcionUno = (this.vistaLlegada.higCont_rb_si_lavado.isSelected()) ? "SI" : "NO";
        this.opcionDos = (this.vistaLlegada.higCont_rb_si_drenajes.isSelected()) ? "SI" : "NO";
        this.opcionTres = (this.vistaLlegada.higCont_rb_si_olor.isSelected()) ? "SI" : "NO";
        this.opcionCuatro = (this.vistaLlegada.higCont_rb_si_residuos.isSelected()) ? "SI" : "NO";
        this.opcionCinco = (this.vistaLlegada.higCont_rb_si_insectos.isSelected()) ? "SI" : "NO";
        this.opcionSeis = (this.vistaLlegada.higCont_rb_si_sello.isSelected()) ? "SI" : "NO";
        this.opcionSiete = (this.vistaLlegada.higCont_rb_si_moho.isSelected()) ? "SI" : "NO";
        this.opcionOcho = (this.vistaLlegada.higCont_rb_si_contenedor_aceptable.isSelected()) ? "SI" : "NO";
        this.observacionHigCont = this.vistaLlegada.higCont_observaciones.getText();
    }

    public void enviarHigieneContenedor() {
        int maxDato;
        maxDato = (idHigCont-8);
        this.modeloHeContenedor.obser_Hig_Cont = observacionHigCont;
        this.modeloHeContenedor.guardarContenedorDatos();
        System.out.println("idC: " + this.modeloHeContenedor.id + " , " + this.modeloHeContenedor.codigo_Contenedor);
        for (int i = 1; i < 9; i++) {
            this.modeloHigCont.id_contenedor = this.idContenedor;
            switch (i) {
                case 1:
                    this.modeloHigCont.id = maxDato+i;
                    this.modeloHigCont.id_limpieza_contenedor = i;
                    this.modeloHigCont.opcion = this.opcionUno;
                    break;
                case 2:
                    this.modeloHigCont.id = maxDato+i;
                    this.modeloHigCont.id_limpieza_contenedor = i;
                    this.modeloHigCont.opcion = this.opcionDos;
                    break;
                case 3:
                    this.modeloHigCont.id = maxDato+i;
                    this.modeloHigCont.id_limpieza_contenedor = i;
                    this.modeloHigCont.opcion = this.opcionTres;
                    break;
                case 4:
                    this.modeloHigCont.id = maxDato+i;
                    this.modeloHigCont.id_limpieza_contenedor = i;
                    this.modeloHigCont.opcion = this.opcionCuatro;
                    break;
                case 5:
                    this.modeloHigCont.id = maxDato+i;
                    this.modeloHigCont.id_limpieza_contenedor = i;
                    this.modeloHigCont.opcion = this.opcionCinco;
                    break;
                case 6:
                    this.modeloHigCont.id = maxDato+i;
                    this.modeloHigCont.id_limpieza_contenedor = i;
                    this.modeloHigCont.opcion = this.opcionSeis;
                    break;
                case 7:
                    this.modeloHigCont.id = maxDato+i;
                    this.modeloHigCont.id_limpieza_contenedor = i;
                    this.modeloHigCont.opcion = this.opcionSiete;
                    break;
                case 8:
                    this.modeloHigCont.id = maxDato+i;
                    this.modeloHigCont.id_limpieza_contenedor = i;
                    this.modeloHigCont.opcion = this.opcionOcho;
                    break;
            }
            this.modeloHigCont.pruebaGuardado();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vistaLlegada.btn_siguiente_higCont) {
            almacenarHigieneContendor();
            System.out.println(opcionUno + " , " + opcionDos + " , " + opcionTres + " , " + opcionCuatro + " , " + opcionCinco
                    + " , " + opcionSeis + " , " + opcionSiete + " , " + opcionOcho + " \n, " + observacionHigCont);

            enviarHigieneContenedor();
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
