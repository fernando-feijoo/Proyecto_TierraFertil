package Controlador.Grupo3;

import Modelo.Grupo3.Modelo_Contenedores;
import Modelo.Grupo3.Modelo_Paletizado;
import Vista.Grupo3.Vista_Llegada;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Controlador_Paletizado implements MouseListener, ComponentListener {

    Vista_Llegada vistaLlegada;
    Modelo_Paletizado modeloPaletizado = new Modelo_Paletizado();
    Modelo_Contenedores modeloPaContenedor = new Modelo_Contenedores();

    public static int idContenedor;
    public static int idPalet;
    String observacionGeneralPale;
    int idCajas, codigoUno, codigoDos, codigoTres, codigoCuatro, codigoCinco, codigoSeis, codigoSiete, codigoOcho, codigoNueve, codigoDiez,
            codigoOnce, codigoDoce, codigoTrece, codigoCatorce, codigoQuince, codigoDiezSeis, codigoDiezSiete, codigoDiezOcho, codigoDiezNueve, codigoVeinte;
    ResultSet rs, rsC;
    public int tempClickG3;

    public Controlador_Paletizado(Vista_Llegada vistaLlegada) {
        this.vistaLlegada = vistaLlegada;
        this.vistaLlegada.btn_guardar.addMouseListener(this);
        this.vistaLlegada.jp_opcion_Paletizado.addComponentListener(this);
    }

    public void idBusqueda(int idHerenciaContenedor) {
        this.idContenedor = idHerenciaContenedor;
        this.modeloPaletizado.id_contenedor = this.idContenedor;
    }

    public void guardarContenedor() {
        this.modeloPaContenedor.obser_General = this.observacionGeneralPale;
        System.out.println("Guardar Conten PA: " + idContenedor + " , " + observacionGeneralPale);
    }

    public void idEntidadPalet() {
        try {
            rs = modeloPaletizado.consultaID_entidadPallet();
            while (rs.next()) {
                idPalet = Integer.parseInt(rs.getString("id_tablaPallet"));
            }
            System.out.println("id Entidad HigCont ControladorHigCont: " + idPalet);
        } catch (SQLException ex) {
            System.out.println("Error de consulta y almacenamiento PA: " + ex);
        }
    }

    public void autoIncrementarID_Entidades(int herenciaTres, int herenciaCuatro) {
        this.idContenedor = herenciaTres;
        this.idPalet = herenciaCuatro;
        System.out.println("ValorHerencia HigieneConendor ContPA: " + this.idContenedor + " , idPA: " + this.idPalet);
    }

    public void almacenarPalet() {
        this.observacionGeneralPale = this.vistaLlegada.paletizado_observacionesGenerales.getText();
        try {
            this.codigoUno = Integer.parseInt(this.vistaLlegada.paletizado_pallet1.getText());
            this.codigoDos = Integer.parseInt(this.vistaLlegada.paletizado_pallet2.getText());
            this.codigoTres = Integer.parseInt(this.vistaLlegada.paletizado_pallet3.getText());
            this.codigoCuatro = Integer.parseInt(this.vistaLlegada.paletizado_pallet4.getText());
            this.codigoCinco = Integer.parseInt(this.vistaLlegada.paletizado_pallet5.getText());
            this.codigoSeis = Integer.parseInt(this.vistaLlegada.paletizado_pallet6.getText());
            this.codigoSiete = Integer.parseInt(this.vistaLlegada.paletizado_pallet7.getText());
            this.codigoOcho = Integer.parseInt(this.vistaLlegada.paletizado_pallet8.getText());
            this.codigoNueve = Integer.parseInt(this.vistaLlegada.paletizado_pallet9.getText());
            this.codigoDiez = Integer.parseInt(this.vistaLlegada.paletizado_pallet10.getText());
            this.codigoOnce = Integer.parseInt(this.vistaLlegada.paletizado_pallet11.getText());
            this.codigoDoce = Integer.parseInt(this.vistaLlegada.paletizado_pallet12.getText());
            this.codigoTrece = Integer.parseInt(this.vistaLlegada.paletizado_pallet13.getText());
            this.codigoCatorce = Integer.parseInt(this.vistaLlegada.paletizado_pallet14.getText());
            this.codigoQuince = Integer.parseInt(this.vistaLlegada.paletizado_pallet15.getText());
            this.codigoDiezSeis = Integer.parseInt(this.vistaLlegada.paletizado_pallet16.getText());
            this.codigoDiezSiete = Integer.parseInt(this.vistaLlegada.paletizado_pallet17.getText());
            this.codigoDiezOcho = Integer.parseInt(this.vistaLlegada.paletizado_pallet18.getText());
            this.codigoDiezNueve = Integer.parseInt(this.vistaLlegada.paletizado_pallet19.getText());
            this.codigoVeinte = Integer.parseInt(this.vistaLlegada.paletizado_pallet20.getText());
        } catch (Exception e) {
            System.out.println("Error almacenarPalet: " + e);
        }

    }

    public void enviarGuardarPalet() {
        int maxDato;
        maxDato = (((idContenedor * 20)) - 20);
        for (int i = 1; i < 21; i++) {
            this.modeloPaletizado.id_contenedor = this.idContenedor;
            this.modeloPaletizado.id = maxDato + i;
            this.modeloPaletizado.id_cantidad_cajas = this.vistaLlegada.paletizado_cb_numero_cajas.getSelectedIndex() + 1;
            switch (i) {
                case 1:
                    this.modeloPaletizado.codigo = this.codigoUno;
                    break;
                case 2:
                    this.modeloPaletizado.codigo = this.codigoDos;
                    break;
                case 3:
                    this.modeloPaletizado.codigo = this.codigoTres;
                    break;
                case 4:
                    this.modeloPaletizado.codigo = this.codigoCuatro;
                    break;
                case 5:
                    this.modeloPaletizado.codigo = this.codigoCinco;
                    break;
                case 6:
                    this.modeloPaletizado.codigo = this.codigoSeis;
                    break;
                case 7:
                    this.modeloPaletizado.codigo = this.codigoSiete;
                    break;
                case 8:
                    this.modeloPaletizado.codigo = this.codigoOcho;
                    break;
                case 9:
                    this.modeloPaletizado.codigo = this.codigoNueve;
                    break;
                case 10:
                    this.modeloPaletizado.codigo = this.codigoDiez;
                    break;
                case 11:
                    this.modeloPaletizado.codigo = this.codigoOnce;
                    break;
                case 12:
                    this.modeloPaletizado.codigo = this.codigoDoce;
                    break;
                case 13:
                    this.modeloPaletizado.codigo = this.codigoTrece;
                    break;
                case 14:
                    this.modeloPaletizado.codigo = this.codigoCatorce;
                    break;
                case 15:
                    this.modeloPaletizado.codigo = this.codigoQuince;
                    break;
                case 16:
                    this.modeloPaletizado.codigo = this.codigoDiezSeis;
                    break;
                case 17:
                    this.modeloPaletizado.codigo = this.codigoDiezSiete;
                    break;
                case 18:
                    this.modeloPaletizado.codigo = this.codigoDiezOcho;
                    break;
                case 19:
                    this.modeloPaletizado.codigo = this.codigoDiezNueve;
                    break;
                case 20:
                    this.modeloPaletizado.codigo = this.codigoVeinte;
                    break;
            }
            this.modeloPaletizado.guardarActualizar_DatosLlegada();
            this.modeloPaletizado.pruebaGuardado();
        }
    }

    // ##AQUI hago la consulta de la entidad de datos y comentario de contenedor.
    public void cargarDatosPalet() {
        int aux = 0, auxDos = 0, cont = 1;
        rs = this.modeloPaletizado.consultaDatos_entidadPaletizado();
        rsC = this.modeloPaletizado.consultaObsGeneral();
        try {
            while (rsC.next()) {
                this.vistaLlegada.paletizado_observacionesGenerales.setText(rsC.getString("obser_general"));
            }
            HashMap<Integer, String> datos = new HashMap<Integer, String>();
            while (rs.next()) {
                datos.put(rs.getInt("id"), rs.getString("codigo"));
                //  observar lo de id cajas aun.
                this.vistaLlegada.paletizado_cb_numero_cajas.setSelectedIndex(rs.getInt("id_cantidad_cajas") - 1);
            }
            for (int i : datos.keySet()) {
                // #Error de algortimo de busqueda o seteo de id.
                
                aux = (i % 10);
                
                if ((i % 10) == 0) {
                    if (cont == 1) {
                        aux = 10;
                    } else {
                        aux = 20;
                    }
                    cont++;
                }else{
                    aux = i;
                }
                
                System.out.println("id: " + aux + " opcion: " + datos.get(i));
                switch (aux) {
                    case 1:
                        this.vistaLlegada.paletizado_pallet1.setText(datos.get(i));
                        break;
                    case 2:
                        this.vistaLlegada.paletizado_pallet2.setText(datos.get(i));
                        break;
                    case 3:
                        this.vistaLlegada.paletizado_pallet3.setText(datos.get(i));
                        break;
                    case 4:
                        this.vistaLlegada.paletizado_pallet4.setText(datos.get(i));
                        break;
                    case 5:
                        this.vistaLlegada.paletizado_pallet5.setText(datos.get(i));
                        break;
                    case 6:
                        this.vistaLlegada.paletizado_pallet6.setText(datos.get(i));
                        break;
                    case 7:
                        this.vistaLlegada.paletizado_pallet7.setText(datos.get(i));
                        break;
                    case 8:
                        this.vistaLlegada.paletizado_pallet8.setText(datos.get(i));
                        break;
                    case 9:
                        this.vistaLlegada.paletizado_pallet9.setText(datos.get(i));
                        break;
                    case 10:
                        this.vistaLlegada.paletizado_pallet10.setText(datos.get(i));
                        break;
                    case 11:
                        this.vistaLlegada.paletizado_pallet11.setText(datos.get(i));
                        break;
                    case 12:
                        this.vistaLlegada.paletizado_pallet12.setText(datos.get(i));
                        break;
                    case 13:
                        this.vistaLlegada.paletizado_pallet13.setText(datos.get(i));
                        break;
                    case 14:
                        this.vistaLlegada.paletizado_pallet14.setText(datos.get(i));
                        break;
                    case 15:
                        this.vistaLlegada.paletizado_pallet15.setText(datos.get(i));
                        break;
                    case 16:
                        this.vistaLlegada.paletizado_pallet16.setText(datos.get(i));
                        break;
                    case 17:
                        this.vistaLlegada.paletizado_pallet17.setText(datos.get(i));
                        break;
                    case 18:
                        this.vistaLlegada.paletizado_pallet18.setText(datos.get(i));
                        break;
                    case 19:
                        this.vistaLlegada.paletizado_pallet19.setText(datos.get(i));
                        break;
                    case 20:
                        this.vistaLlegada.paletizado_pallet20.setText(datos.get(i));
                        break;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar datos PA: " + ex);
        }
    }

    public void borrarCamposPalet() {
        this.vistaLlegada.paletizado_pallet1.setText(null);
        this.vistaLlegada.paletizado_pallet2.setText(null);
        this.vistaLlegada.paletizado_pallet3.setText(null);
        this.vistaLlegada.paletizado_pallet4.setText(null);
        this.vistaLlegada.paletizado_pallet5.setText(null);
        this.vistaLlegada.paletizado_pallet6.setText(null);
        this.vistaLlegada.paletizado_pallet7.setText(null);
        this.vistaLlegada.paletizado_pallet8.setText(null);
        this.vistaLlegada.paletizado_pallet9.setText(null);
        this.vistaLlegada.paletizado_pallet10.setText(null);
        this.vistaLlegada.paletizado_pallet11.setText(null);
        this.vistaLlegada.paletizado_pallet12.setText(null);
        this.vistaLlegada.paletizado_pallet13.setText(null);
        this.vistaLlegada.paletizado_pallet14.setText(null);
        this.vistaLlegada.paletizado_pallet15.setText(null);
        this.vistaLlegada.paletizado_pallet16.setText(null);
        this.vistaLlegada.paletizado_pallet17.setText(null);
        this.vistaLlegada.paletizado_pallet18.setText(null);
        this.vistaLlegada.paletizado_pallet19.setText(null);
        this.vistaLlegada.paletizado_pallet20.setText(null);
    }

    public void guardadoFinal() {
        this.almacenarPalet();
        this.guardarContenedor();
        this.enviarGuardarPalet();

        this.modeloPaContenedor.guardarContenedorDatos();
        this.modeloPaContenedor.pruebaGuardado();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == this.vistaLlegada.btn_guardar) {
            System.out.println("Gruadado Final, guarda todo?");
        }
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
    }
}
