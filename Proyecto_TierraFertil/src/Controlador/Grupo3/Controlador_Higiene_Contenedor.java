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
import java.util.HashMap;

public class Controlador_Higiene_Contenedor implements MouseListener, ComponentListener {

    Vista_Llegada vistaLlegada;
    Modelo_Higiene_Contenedor modeloHigCont = new Modelo_Higiene_Contenedor();
    Modelo_Contenedores modeloHeContenedor = new Modelo_Contenedores();
    public static int idContenedor;
    String opcionUno, opcionDos, opcionTres, opcionCuatro, opcionCinco, opcionSeis,
            opcionSiete, opcionOcho, observacionHigCont;
    ResultSet rs, rsD, rsC;
    public static int idHigCont;
    public int tempClickG3;

    public Controlador_Higiene_Contenedor(Vista_Llegada vistaLlegada) {
        this.vistaLlegada = vistaLlegada;
        this.vistaLlegada.btn_siguiente_higCont.addMouseListener(this);
        //  Con este podemos hacer el guardado cuando se oculta esta ventana.
        this.vistaLlegada.jp_opcion_HiegieneContenedor.addComponentListener(this);

    }

    public void idBusqueda(int idHerenciaContenedor) {
        this.idContenedor = idHerenciaContenedor;
        this.modeloHigCont.id_contenedor = this.idContenedor;
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
        // #PROBAR SACAANDO LOS VALORES REDUNDANTES AFERA DEL CASE.
        for (int i = 1; i < 9; i++) {
            this.modeloHigCont.id_contenedor = this.idContenedor;
            //  Aumente esto para evaluar funcionamiento.
            this.modeloHigCont.id = maxDato + i;
            this.modeloHigCont.id_limpieza_contenedor = i;
            switch (i) {
                case 1:
                    this.modeloHigCont.opcion = this.opcionUno;
                    break;
                case 2:
                    this.modeloHigCont.opcion = this.opcionDos;
                    break;
                case 3:
                    this.modeloHigCont.opcion = this.opcionTres;
                    break;
                case 4:
                    this.modeloHigCont.opcion = this.opcionCuatro;
                    break;
                case 5:
                    this.modeloHigCont.opcion = this.opcionCinco;
                    break;
                case 6:
                    this.modeloHigCont.opcion = this.opcionSeis;
                    break;
                case 7:
                    this.modeloHigCont.opcion = this.opcionSiete;
                    break;
                case 8:
                    this.modeloHigCont.opcion = this.opcionOcho;
                    break;
            }
            this.modeloHigCont.pruebaGuardado();
            this.modeloHigCont.guardarActualizar_DatosLlegada();
        }
    }

    //  Tengo que cargar dos de estos el otro solo trae el comentario. Aunque podria ser en este mismo solo es una linea.
    // ##AQUI hago la consulta de la entidad de datos y comentario de contenedor.
    public void cargarDatosHigCont() {
        rsD = this.modeloHigCont.consultaDatos_entidadHigCont();
        rsC = this.modeloHigCont.consultaObsHigCon();
        try {
            while (rsC.next()) {
                this.vistaLlegada.higCont_observaciones.setText(rsC.getString("obser_hig_cont"));
            }
            HashMap<Integer, String> datos = new HashMap<Integer, String>();
            while (rsD.next()) {
                datos.put(rsD.getInt("id_limpieza_contenedor"), rsD.getString("opcion"));
            }
            for (int i : datos.keySet()) {
                System.out.println("id: " + i + " opcion: " + datos.get(i));
                switch (i) {
                    case 1:
                        this.vistaLlegada.bg_lavado.setSelected(this.vistaLlegada.higCont_rb_si_lavado.getModel(), (datos.get(i).equals("SI")));
                        this.vistaLlegada.bg_lavado.setSelected(this.vistaLlegada.higCont_rb_no_lavado.getModel(), (datos.get(i).equals("NO")));
                        break;
                    case 2:
                        this.vistaLlegada.bg_drenajes.setSelected(this.vistaLlegada.higCont_rb_si_drenajes.getModel(), (datos.get(i).equals("SI")));
                        this.vistaLlegada.bg_drenajes.setSelected(this.vistaLlegada.higCont_rb_no_drenajes.getModel(), (datos.get(i).equals("NO")));
                        break;
                    case 3:
                        this.vistaLlegada.bg_olor.setSelected(this.vistaLlegada.higCont_rb_si_olor.getModel(), (datos.get(i).equals("SI")));
                        this.vistaLlegada.bg_olor.setSelected(this.vistaLlegada.higCont_rb_no_olor.getModel(), (datos.get(i).equals("NO")));
                        break;
                    case 4:
                        this.vistaLlegada.bg_residuos.setSelected(this.vistaLlegada.higCont_rb_si_residuos.getModel(), (datos.get(i).equals("SI")));
                        this.vistaLlegada.bg_residuos.setSelected(this.vistaLlegada.higCont_rb_no_residuos.getModel(), (datos.get(i).equals("NO")));
                        break;
                    case 5:
                        this.vistaLlegada.bg_insectos.setSelected(this.vistaLlegada.higCont_rb_si_insectos.getModel(), (datos.get(i).equals("SI")));
                        this.vistaLlegada.bg_insectos.setSelected(this.vistaLlegada.higCont_rb_no_insectos.getModel(), (datos.get(i).equals("NO")));
                        break;
                    case 6:
                        this.vistaLlegada.bg_sello.setSelected(this.vistaLlegada.higCont_rb_si_sello.getModel(), (datos.get(i).equals("SI")));
                        this.vistaLlegada.bg_sello.setSelected(this.vistaLlegada.higCont_rb_no_sello.getModel(), (datos.get(i).equals("NO")));
                        break;
                    case 7:
                        this.vistaLlegada.bg_moho.setSelected(this.vistaLlegada.higCont_rb_si_moho.getModel(), (datos.get(i).equals("SI")));
                        this.vistaLlegada.bg_moho.setSelected(this.vistaLlegada.higCont_rb_no_moho.getModel(), (datos.get(i).equals("NO")));
                        break;
                    case 8:
                        this.vistaLlegada.bg_contenedor_aceptable.setSelected(this.vistaLlegada.higCont_rb_si_contenedor_aceptable.getModel(), (datos.get(i).equals("SI")));
                        this.vistaLlegada.bg_contenedor_aceptable.setSelected(this.vistaLlegada.higCont_rb_no_contenedor_aceptable.getModel(), (datos.get(i).equals("NO")));
                        break;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error datos HiCn Array: " + ex);
        }
    }

    public void borrarCamposHigCont() {
        this.vistaLlegada.bg_lavado.clearSelection();
        this.vistaLlegada.bg_drenajes.clearSelection();
        this.vistaLlegada.bg_olor.clearSelection();
        this.vistaLlegada.bg_residuos.clearSelection();
        this.vistaLlegada.bg_insectos.clearSelection();
        this.vistaLlegada.bg_sello.clearSelection();
        this.vistaLlegada.bg_moho.clearSelection();
        this.vistaLlegada.bg_contenedor_aceptable.clearSelection();
        this.vistaLlegada.higCont_observaciones.setText(null);
    }

    public void guardadoFinal() {
        this.almacenarHigieneContendor();
        this.guardarContenedor();
        this.enviarGuardarHigieneContenedor();
        this.modeloHeContenedor.guardarContenedorDatos();
        this.modeloHeContenedor.pruebaGuardado();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vistaLlegada.btn_siguiente_higCont) {
            this.vistaLlegada.jp_grupoOpciones_datosLlegada.setSelectedIndex(3);

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

        }
    }
}
