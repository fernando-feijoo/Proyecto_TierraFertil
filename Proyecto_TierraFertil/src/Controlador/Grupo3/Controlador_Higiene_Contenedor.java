package Controlador.Grupo3;

import Modelo.Grupo3.Modelo_Contenedores;
import Modelo.Grupo3.Modelo_Higiene_Contenedor;
import Vista.Grupo3.Vista_Llegada;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controlador_Higiene_Contenedor implements MouseListener, ComponentListener {

    Vista_Llegada vistaLlegada;
    Modelo_Higiene_Contenedor modeloHigCont = new Modelo_Higiene_Contenedor();
    Modelo_Contenedores modeloHeContenedor = new Modelo_Contenedores();
    public static int idContenedor;
    String opcionUno, opcionDos, opcionTres, opcionCuatro, opcionCinco, opcionSeis,
            opcionSiete, opcionOcho, observacionHigCont;
    ResultSet rs;
    public static int idHigCont;
    public int tempClickG3;

    public Controlador_Higiene_Contenedor(Vista_Llegada vistaLlegada) {
        this.vistaLlegada = vistaLlegada;
        this.vistaLlegada.btn_siguiente_higCont.addMouseListener(this);
        //  Con este podemos hacer el guardado cuando se oculta esta ventana.
        this.vistaLlegada.jp_opcion_HiegieneContenedor.addComponentListener(this);

    }

    //  #borrar mensajes de mas en consola.
    public void controlGuardado(int herenciaClicks) {
        this.tempClickG3 = herenciaClicks;
        System.out.println("HerenciaClic HC: " + tempClickG3);
    }

    public void guardarContenedor() {
        this.modeloHeContenedor.obser_Hig_Cont = this.observacionHigCont;
        System.out.println("Guardar Conten DHC: " + idContenedor + " , " + observacionHigCont);
    }

    //  El id ya viene de la consulta con id = 8, ya que inicia en null la base de datos.
    public void idEntidadHigCont() {
        try {
            rs = modeloHigCont.consultaID_entidadHigCont();
            while (rs.next()) {
                idHigCont = Integer.parseInt(rs.getString("id_tablaHigCont"));
            }
            System.out.println("id Entidad HigCont ControladorHigCont: " + idHigCont);
        } catch (SQLException ex) {
            System.out.println("Error de consulta y almacenamiento: " + ex);
        }
    }

    public void autoIncrementarID_Entidades(int herenciaTres, int herenciaCuatro) {
        this.idContenedor = herenciaTres;
        this.idHigCont = herenciaCuatro;
        System.out.println("ValorHerencia HigieneConendor ContHC: " + this.idContenedor + " , idHC: " + this.idHigCont);
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

    //  Se envia y guarda, ya que se guarda fila por fila.
    public void enviarGuardarHigieneContenedor() {
        int maxDato;
        //  La idea es traer el 8 por directo y luego el id contenedor x 8, ya que tiene que se multiplo y se le resta 8 para empezar conteo. (BigInt necesario a futuro)
        maxDato = (((idContenedor * 8)) - 8);
        System.out.println("idC: " + this.modeloHeContenedor.id + " , codigoConte> " + this.modeloHeContenedor.codigo_Contenedor + " , OBSER: " + this.observacionHigCont);
        for (int i = 1; i < 9; i++) {
            this.modeloHigCont.id_contenedor = this.idContenedor;
            switch (i) {
                case 1:
                    this.modeloHigCont.id = maxDato + i;
                    this.modeloHigCont.id_limpieza_contenedor = i;
                    this.modeloHigCont.opcion = this.opcionUno;
                    break;
                case 2:
                    this.modeloHigCont.id = maxDato + i;
                    this.modeloHigCont.id_limpieza_contenedor = i;
                    this.modeloHigCont.opcion = this.opcionDos;
                    break;
                case 3:
                    this.modeloHigCont.id = maxDato + i;
                    this.modeloHigCont.id_limpieza_contenedor = i;
                    this.modeloHigCont.opcion = this.opcionTres;
                    break;
                case 4:
                    this.modeloHigCont.id = maxDato + i;
                    this.modeloHigCont.id_limpieza_contenedor = i;
                    this.modeloHigCont.opcion = this.opcionCuatro;
                    break;
                case 5:
                    this.modeloHigCont.id = maxDato + i;
                    this.modeloHigCont.id_limpieza_contenedor = i;
                    this.modeloHigCont.opcion = this.opcionCinco;
                    break;
                case 6:
                    this.modeloHigCont.id = maxDato + i;
                    this.modeloHigCont.id_limpieza_contenedor = i;
                    this.modeloHigCont.opcion = this.opcionSeis;
                    break;
                case 7:
                    this.modeloHigCont.id = maxDato + i;
                    this.modeloHigCont.id_limpieza_contenedor = i;
                    this.modeloHigCont.opcion = this.opcionSiete;
                    break;
                case 8:
                    this.modeloHigCont.id = maxDato + i;
                    this.modeloHigCont.id_limpieza_contenedor = i;
                    this.modeloHigCont.opcion = this.opcionOcho;
                    break;
            }
            this.modeloHigCont.pruebaGuardado();
            this.modeloHigCont.guardarActualizar_DatosLlegada();
        }
    }

    public void guardadoFinal() {
        almacenarHigieneContendor();
        this.guardarContenedor();
        this.modeloHeContenedor.guardarContenedorDatos();
        this.modeloHeContenedor.pruebaGuardado();
        enviarGuardarHigieneContenedor();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vistaLlegada.btn_siguiente_higCont) {
            this.vistaLlegada.jp_grupoOpciones_datosLlegada.setSelectedIndex(3);

            if (this.tempClickG3 != 0) {
                this.guardadoFinal();

                this.tempClickG3 = 0;
            }

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

    @Override
    public void componentResized(ComponentEvent ce) {

    }

    @Override
    public void componentMoved(ComponentEvent ce) {

    }

    @Override
    public void componentShown(ComponentEvent ce) {

    }

    @Override
    public void componentHidden(ComponentEvent ce) {
        if (ce.getSource() == this.vistaLlegada.jp_opcion_HiegieneContenedor) {
            System.out.println("Ingreso Opcion. HIDE");
            if (this.tempClickG3 != 0) {

                this.guardadoFinal();

                this.tempClickG3 = 0;
            }
        }
    }
}
