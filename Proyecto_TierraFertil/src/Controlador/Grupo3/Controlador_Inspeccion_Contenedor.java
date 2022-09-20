package Controlador.Grupo3;

import static Controlador.Grupo3.Controlador_Higiene_Contenedor.idContenedor;
import static Controlador.Grupo3.Controlador_Higiene_Contenedor.idHigCont;
import Modelo.Grupo3.Modelo_Contenedores;
import Modelo.Grupo3.Modelo_Inspeccion_Contenedor;
import Vista.Grupo3.Vista_Llegada;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Controlador_Inspeccion_Contenedor implements MouseListener, ComponentListener {

    Vista_Llegada vistaLlegada;
    Modelo_Inspeccion_Contenedor modeloInspCont = new Modelo_Inspeccion_Contenedor();
    Modelo_Contenedores modeloHeContenedor = new Modelo_Contenedores();
    ResultSet rs, rsD, rsC;
    ;
    public static int idContenedor;
    public static int idInspCont;
    public int tempClickG3;

    boolean opcionUno, opcionDos, opcionTres, opcionCuatro, opcionCinco, opcionSeis,
            opcionSiete, opcionOcho, opcionnueve, opciondiez, opciononce;
    String observacionInspCont;

    public Controlador_Inspeccion_Contenedor(Vista_Llegada vistaLlegada) {
        this.vistaLlegada = vistaLlegada;
        this.vistaLlegada.btn_siguiente_inspCont.addMouseListener(this);

        this.vistaLlegada.jp_opcion_InspeccionContendor.addComponentListener(this);

    }

    public void guardarContenedor() {
        this.modeloHeContenedor.obser_Ins_Cont = this.observacionInspCont;
        System.out.println("Guardar Conten IC" + idContenedor + " ," + observacionInspCont);
    }

    public void idEntidadHigCont() {
        try {
            rs = modeloInspCont.consultaID_entidadInspeccionContenedor();
            while (rs.next()) {
                idInspCont = Integer.parseInt(rs.getString("id_tablaInspeccionContenedor"));
            }
            System.out.println("id Entidad InspCont Controlador InspCont: " + idInspCont);
        } catch (SQLException ex) {
            System.out.println("Error de consulta y almacenamiento: " + ex);
        }

    }

    public void autoIncrementarID_Entidades(int herenciaTres, int herenciaCuatro) {
        this.idContenedor = herenciaTres;
        this.idInspCont = herenciaCuatro;
        System.out.println("ValorHerencia InspeccionConendor ContIC: " + this.idContenedor + 1 + " , idHC: " + this.idInspCont);
    }

    public void almacenarInspeccionContendor() {
        this.opcionUno = (this.vistaLlegada.inspCont_check_puertas1.isSelected());
        this.opcionDos = (this.vistaLlegada.inspCont_check_parediz2.isSelected());
        this.opcionTres = (this.vistaLlegada.inspCont_check_espaciadores3.isSelected());
        this.opcionCuatro = (this.vistaLlegada.inspCont_check_paredfro4.isSelected());
        this.opcionCinco = (this.vistaLlegada.inspCont_check_paredde5.isSelected());
        this.opcionSeis = (this.vistaLlegada.inspCont_check_techo6.isSelected());
        this.opcionSiete = (this.vistaLlegada.inspCont_check_pisoin7.isSelected());
        this.opcionOcho = (this.vistaLlegada.inspCont_check_pisoex8.isSelected());
        this.opcionnueve = (this.vistaLlegada.inspCont_check_evaporadores9.isSelected());
        this.opciondiez = (this.vistaLlegada.inspCont_check_tornillo10.isSelected());
        this.opciononce = (this.vistaLlegada.inspCont_check_delefactor11.isSelected());

        this.observacionInspCont = this.vistaLlegada.inspCont_obseraciones.getText();

    }

    public void enviarGuardarInspeccionContenedor() {
        int maxDato;
        maxDato = (((idContenedor * 11)));
        System.out.println("iI: " + this.modeloHeContenedor.id + " , codigoConte> " + this.modeloHeContenedor.codigo_Contenedor + " , OBSER: " + this.observacionInspCont);
        for (int i = 1; i < 12; i++) {
            this.modeloInspCont.id_contenedor = this.idContenedor;
            switch (i) {
                case 1:
                    this.modeloInspCont.id = maxDato + i;
                    this.modeloInspCont.id_verificar_lugar = i;
                    this.modeloInspCont.verificacion = this.opcionUno;
                    break;
                case 2:
                    this.modeloInspCont.id = maxDato + i;
                    this.modeloInspCont.id_verificar_lugar = i;
                    this.modeloInspCont.verificacion = this.opcionDos;
                    break;
                case 3:
                    this.modeloInspCont.id = maxDato + i;
                    this.modeloInspCont.id_verificar_lugar = i;
                    this.modeloInspCont.verificacion = this.opcionTres;
                    break;
                case 4:
                    this.modeloInspCont.id = maxDato + i;
                    this.modeloInspCont.id_verificar_lugar = i;
                    this.modeloInspCont.verificacion = this.opcionCuatro;
                    break;
                case 5:
                    this.modeloInspCont.id = maxDato + i;
                    this.modeloInspCont.id_verificar_lugar = i;
                    this.modeloInspCont.verificacion = this.opcionCinco;
                    break;
                case 6:
                    this.modeloInspCont.id = maxDato + i;
                    this.modeloInspCont.id_verificar_lugar = i;
                    this.modeloInspCont.verificacion = this.opcionSeis;
                    break;
                case 7:
                    this.modeloInspCont.id = maxDato + i;
                    this.modeloInspCont.id_verificar_lugar = i;
                    this.modeloInspCont.verificacion = this.opcionSiete;
                    break;
                case 8:
                    this.modeloInspCont.id = maxDato + i;
                    this.modeloInspCont.id_verificar_lugar = i;
                    this.modeloInspCont.verificacion = this.opcionOcho;
                    break;
                case 9:
                    this.modeloInspCont.id = maxDato + i;
                    this.modeloInspCont.id_verificar_lugar = i;
                    this.modeloInspCont.verificacion = this.opcionnueve;
                    break;
                case 10:
                    this.modeloInspCont.id = maxDato + i;
                    this.modeloInspCont.id_verificar_lugar = i;
                    this.modeloInspCont.verificacion = this.opciondiez;
                    break;
                case 11:
                    this.modeloInspCont.id = maxDato + i;
                    this.modeloInspCont.id_verificar_lugar = i;
                    this.modeloInspCont.verificacion = this.opciononce;
                    break;

            }
            this.modeloInspCont.guardar_Inspeccion_Contenedor();
            this.modeloInspCont.pruebaGuardado();

        }

    }

    public void cargarDatosInspCont() {
        rsD = this.modeloInspCont.consultaDatos_entidadInspCont();
        rsC = this.modeloInspCont.consultaInspCon();
        try {
            while (rsC.next()) {
                this.vistaLlegada.inspCont_obseraciones.setText(rsC.getString("obser_ins_cont"));

            }
            HashMap<Integer, String> datos = new HashMap<Integer, String>();
            while (rsD.next()) {
                datos.put(rsD.getInt("id_verificar_lugar"), rsD.getString("verificacion"));
            }
            for (int i : datos.keySet()) {
                System.out.println("id: " + i + " verificacion: " + datos.get(i));
                switch (i) {
                    case 1:
                }

            }

        } catch (Exception e) {
        }
    }

    public void borrarCamposInspCont() {
        this.vistaLlegada.inspCont_obseraciones.setText(null);

    }

    public void guardadoFinal() {
        this.almacenarInspeccionContendor();
        this.guardarContenedor();
        this.enviarGuardarInspeccionContenedor();
        this.modeloHeContenedor.guardarContenedorDatos();
        this.modeloInspCont.pruebaGuardado();
        this.modeloHeContenedor.pruebaGuardado();

    }

    @Override
    public void mouseClicked(MouseEvent e
    ) {
        if (e.getSource() == this.vistaLlegada.btn_siguiente_inspCont) {
            this.vistaLlegada.jp_grupoOpciones_datosLlegada.setSelectedIndex(2);

        }
    }

    @Override
    public void mousePressed(MouseEvent e
    ) {
    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {
    }

    @Override
    public void mouseEntered(MouseEvent e
    ) {
    }

    @Override
    public void mouseExited(MouseEvent e
    ) {
    }

    @Override
    public void componentResized(ComponentEvent e
    ) {
    }

    @Override
    public void componentMoved(ComponentEvent e
    ) {
    }

    @Override
    public void componentShown(ComponentEvent e
    ) {
    }

    @Override
    public void componentHidden(ComponentEvent e
    ) {
    }
}
