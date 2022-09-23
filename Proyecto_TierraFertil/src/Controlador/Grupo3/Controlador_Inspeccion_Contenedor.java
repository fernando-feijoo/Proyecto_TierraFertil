package Controlador.Grupo3;

import Modelo.Grupo3.Modelo_Contenedores;
import Modelo.Grupo3.Modelo_Inspeccion_Contenedor;
import Vista.Grupo3.Vista_Llegada;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Controlador_Inspeccion_Contenedor implements MouseListener, KeyListener {

    Vista_Llegada vistaLlegada;
    Modelo_Inspeccion_Contenedor modeloInspCont = new Modelo_Inspeccion_Contenedor();
    Modelo_Contenedores modeloInsContenedor = new Modelo_Contenedores();
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
        
        this.vistaLlegada.inspCont_obseraciones.addKeyListener(this);
        
        this.vistaLlegada.jp_grupoOpciones_datosLlegada.setEnabledAt(2, false);
        this.vistaLlegada.jp_grupoOpciones_datosLlegada.setEnabledAt(3, false);
        this.vistaLlegada.jp_grupoOpciones_datosLlegada.setEnabledAt(4, false);
    }
    
    // #SE NECESITA PROBAR BIEN ESTO AUN.
    public void idBusqueda(int idBusquedaUno){
        this.idContenedor = idBusquedaUno;
        this.modeloInspCont.id_contenedor = this.idContenedor;
    }

    public void guardarContenedor() {
        this.modeloInsContenedor.obser_Ins_Cont = this.observacionInspCont;
        System.out.println("Guardar Conten IC" + idContenedor + " ," + observacionInspCont);
    }

    public void idEntidadInspCont() {
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
        maxDato = ((idContenedor * 11) - 11);
        System.out.println("iI: " + this.modeloInsContenedor.id + " , codigoConte> " + this.modeloInsContenedor.codigo_Contenedor + " , OBSER: " + this.observacionInspCont);
        for (int i = 1; i < 12; i++) {
            this.modeloInspCont.id_contenedor = this.idContenedor;
            this.modeloInspCont.id = maxDato + i;
            this.modeloInspCont.id_verificar_lugar = i;
            switch (i) {
                case 1:
                    this.modeloInspCont.verificacion = this.opcionUno;
                    break;
                case 2:
                    this.modeloInspCont.verificacion = this.opcionDos;
                    break;
                case 3:
                    this.modeloInspCont.verificacion = this.opcionTres;
                    break;
                case 4:
                    this.modeloInspCont.verificacion = this.opcionCuatro;
                    break;
                case 5:
                    this.modeloInspCont.verificacion = this.opcionCinco;
                    break;
                case 6:
                    this.modeloInspCont.verificacion = this.opcionSeis;
                    break;
                case 7:
                    this.modeloInspCont.verificacion = this.opcionSiete;
                    break;
                case 8:
                    this.modeloInspCont.verificacion = this.opcionOcho;
                    break;
                case 9:
                    this.modeloInspCont.verificacion = this.opcionnueve;
                    break;
                case 10:
                    this.modeloInspCont.verificacion = this.opciondiez;
                    break;
                case 11:
                    this.modeloInspCont.verificacion = this.opciononce;
                    break;

            }
            this.modeloInspCont.pruebaGuardado();
            this.modeloInspCont.guardar_Inspeccion_Contenedor();

        }

    }

    public void cargarDatosInspCont() {
        rsD = this.modeloInspCont.consultaDatos_entidadInspCont();
        rsC = this.modeloInspCont.consultaInspCon();
        try {
            while (rsC.next()) {
                this.vistaLlegada.inspCont_obseraciones.setText(rsC.getString("obser_ins_cont"));
            }
            HashMap<Integer, Boolean> datos = new HashMap<>();
            while (rsD.next()) {
                datos.put(rsD.getInt("id_verificar_lugar"), rsD.getBoolean("verificacion"));
            }
            for (int i : datos.keySet()) {
                System.out.println("id: " + i + " verificacion: " + datos.get(i));
                switch (i) {
                    case 1:
                        this.vistaLlegada.inspCont_check_puertas1.setSelected(datos.get(i));
                        break;
                    case 2:
                        this.vistaLlegada.inspCont_check_parediz2.setSelected(datos.get(i));
                        break;
                    case 3:
                        this.vistaLlegada.inspCont_check_espaciadores3.setSelected(datos.get(i));
                        break;
                    case 4:
                        this.vistaLlegada.inspCont_check_paredfro4.setSelected(datos.get(i));
                        break;
                    case 5:
                        this.vistaLlegada.inspCont_check_paredde5.setSelected(datos.get(i));
                        break;
                    case 6:
                        this.vistaLlegada.inspCont_check_techo6.setSelected(datos.get(i));
                        break;
                    case 7:
                        this.vistaLlegada.inspCont_check_pisoin7.setSelected(datos.get(i));
                        break;
                    case 8:
                        this.vistaLlegada.inspCont_check_pisoex8.setSelected(datos.get(i));
                        break;
                    case 9:
                        this.vistaLlegada.inspCont_check_evaporadores9.setSelected(datos.get(i));
                        break;
                    case 10:
                        this.vistaLlegada.inspCont_check_tornillo10.setSelected(datos.get(i));
                        break;
                    case 11:
                        this.vistaLlegada.inspCont_check_delefactor11.setSelected(datos.get(i));
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("error de cargar checks: " + e);
        }
    }

    public void borrarCamposInspCont() {
        this.vistaLlegada.inspCont_obseraciones.setText(null);
        this.vistaLlegada.inspCont_check_puertas1.setSelected(false);
        this.vistaLlegada.inspCont_check_parediz2.setSelected(false);
        this.vistaLlegada.inspCont_check_espaciadores3.setSelected(false);
        this.vistaLlegada.inspCont_check_paredfro4.setSelected(false);
        this.vistaLlegada.inspCont_check_paredde5.setSelected(false);
        this.vistaLlegada.inspCont_check_techo6.setSelected(false);
        this.vistaLlegada.inspCont_check_pisoin7.setSelected(false);
        this.vistaLlegada.inspCont_check_pisoex8.setSelected(false);
        this.vistaLlegada.inspCont_check_evaporadores9.setSelected(false);
        this.vistaLlegada.inspCont_check_tornillo10.setSelected(false);
        this.vistaLlegada.inspCont_check_delefactor11.setSelected(false);
    }

    public void guardadoFinal() {
        this.almacenarInspeccionContendor();
        this.guardarContenedor();
        this.enviarGuardarInspeccionContenedor();
        this.modeloInsContenedor.guardarContenedorDatos();
        this.modeloInsContenedor.pruebaGuardado();
    }
    
    public void Completo() {
        if (vistaLlegada.inspCont_obseraciones.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(vistaLlegada, "Porfavor no dejar campos vacios ");
        }else {
             this.vistaLlegada.jp_grupoOpciones_datosLlegada.setSelectedIndex(2);
            this.vistaLlegada.jp_grupoOpciones_datosLlegada.setEnabledAt(2, true);
        }
        
    }
    
    

    @Override
    public void mouseClicked(MouseEvent e
    ) {
        if (e.getSource() == this.vistaLlegada.btn_siguiente_inspCont) {
            
            Completo();
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
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == this.vistaLlegada.inspCont_obseraciones){
             if(vistaLlegada.inspCont_obseraciones.getText().length()>=250){
                e.consume();
        }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
