package Modelo.Grupo3;

import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.Statement;

public class Modelo_Datos_Llegada {

    private static Modelo_Datos_Llegada instancia;
    
    private Modelo_Datos_Llegada(){
        
    }
    
    public static Modelo_Datos_Llegada getInstancia() {
        if (instancia == null) {
            instancia = new Modelo_Datos_Llegada();
        } else {
            System.out.println("No se puede crear el objeto " + instancia + " porque ya existe un objeto de la clase.");
        }
        return instancia;
    }
    
    Modelo_Conexion conexion = Modelo_Conexion.getInstancia();
    ResultSet rs;
    Statement st;
    public int id, id_contenedor, semana;
    public String fecha_insp, fecha_salida, hora_salida, hora_llegada, tipo_caja, cupo, contenedor, placa,
            chasis, chofer, ci, nombre_finca, candados, sellos_internos, sellos_externos;

    //  Modifique el metodo para ver si cambia la excepcion.
    public void guardarActualizar_DatosLlegada() {
        try {
            st = conexion.conectarBD().createStatement();

            String sql = "SELECT \"insertarDatosLlegada\"("+id+", "+id_contenedor+", '"+fecha_insp+"', "+semana+", '"+(fecha_salida + " " +hora_salida)+"', '"+hora_llegada+"', "
                    + "'"+tipo_caja+"', '"+cupo+"', '"+placa+"', '"+chasis+"', '"+chofer+"', '"+ci+"', '"+nombre_finca+"', '"+candados+"', '"+sellos_internos+"', '"+sellos_externos+"');";
            st.execute(sql);
            st.close();
            conexion.cerrarBD();
            System.out.println(id + " Datos almacenados DatosLLegada BD MODELO.");
        } catch (Exception e) {
        }
    }

    public ResultSet consultaID_entidadDatosLlegada() {
        try {
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT COALESCE(MAX(id), 0) AS \"id_tablaDatosLlegada\" FROM datos_llegada;";
            rs = st.executeQuery(sql);
            st.close();
            conexion.cerrarBD();
            System.out.println("Consulta id entidad Llegada... BD MODELO. " + id);
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener id entidad datos_llegada MODELO: " + e);
        } 
        return rs;
    }
    
    public ResultSet consultaDatos_entidadDatosLlegada() {
        try {
            //  Luego se debe cambiar el id, por el de los datos a actualizar.
            st = conexion.conectarBD().createStatement();
            String sql = "SELECT id, (SELECT codigo FROM contenedores WHERE id = id_contenedor) AS contenedor, fecha_insp, semana, fecha_hora_salida, hora_llegada, tipo_caja, "
                    + "cupo, placa, chasis, chofer_contenedor, cedula_chofer, nombre_finca, candados, sellos_internos, "
                    + "sellos_externos FROM datos_llegada WHERE id = "+id_contenedor+";";
            rs = st.executeQuery(sql);
            st.close();
            conexion.cerrarBD();
            System.out.println("Consulta id entidad Llegada... BD MODELO, " + id_contenedor);
        } catch (Exception e) {
            System.out.println("Error al tratar de obtener datos entidad datos_llegada MODELO: " + e);
        } 
        return rs;
    }
    
    public void pruebaGuardado(){
        // para validar si esta enviando bien la informacion.
            System.out.println(id + " , " + id_contenedor + " , " + fecha_insp + " , " + semana + " , " + fecha_salida
             + " , \n" + hora_salida  + " , " +  hora_llegada + " , " + tipo_caja + " , " +  cupo + " , " + contenedor
             + " , \n" + placa + " , " + chasis + " , " + chofer + " , " + ci + " , " + nombre_finca + " , " + candados
             + " , \n" + sellos_internos  + " , " + sellos_externos);
    }
}
