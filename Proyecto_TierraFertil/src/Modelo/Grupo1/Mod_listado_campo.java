package Modelo.Grupo1;

import Modelo.Modelo_Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mod_listado_campo {

    Modelo_Conexion con = new Modelo_Conexion();
    Connection conexion;

    public ResultSet consultas() throws SQLException {
        Statement st = con.conectarBD().createStatement();
        String sql = "SELECT \n"
                + "prod.nombre, fin.nombre as finca, eva.tipo_caja, eva.vapor, \n"
                + "eva.fecha_eva, eva.placa_vehivulo, \n"
                + "sem.id as semana, eva.cod_evaluacion, eva.hora_eva\n"
                + "FROM semanas sem inner join evaluaciones eva ON\n"
                + "sem.id = eva.id_semana inner join productores prod ON \n"
                + "prod.codigo = eva.codigo_productor inner join finca fin ON\n"
                + "prod.codigo = fin.codigo_productor;";
        ResultSet rs = st.executeQuery(sql);
        return rs;

    }
}
