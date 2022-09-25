package Modelo.Grupo1;

import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mod_detalles_gen {

    Statement st;
    ResultSet rs;
    Modelo_Conexion con = new Modelo_Conexion();

    public String cod_prod, cod_eva, cod_insp, nom_pod, ape_prod, vapor, hora_eva;
    public String finca_prod, nom_insp, ape_insp, placa, fecha_eva, tipo_caja;
    public int id_eva, semana; public String id_cargar;

    public int id_evaluacion() throws SQLException {
        int id = 1;
        st = con.conectarBD().createStatement();
        rs = st.executeQuery("select max (id) from public.evaluaciones;");
        while (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }

    public boolean guardar_inspector() throws SQLException {
        st = con.conectarBD().createStatement();
        st.executeUpdate("INSERT INTO public.inspectotes (codigo, nombre, apellido) VALUES ('" + this.cod_insp + "', '" + this.nom_insp + "', '" + this.ape_insp + "');");
        return true;
    }

    public boolean guardar_productores() throws SQLException {
        st = con.conectarBD().createStatement();
        st.executeUpdate("INSERT INTO public.productores(codigo, nombre, apellido, finca) VALUES ('" + this.cod_prod + "', '" + this.nom_pod + "', '" + this.ape_prod + "', '" + this.finca_prod + "');");
        return true;
    }

    public boolean guardar_evaluaciones() throws SQLException {
        st = con.conectarBD().createStatement();
        st.executeUpdate("INSERT INTO public.evaluaciones(\n"
                + "	id, cod_evaluacion, fecha_eva, hora_eva, vapor, tipo_caja, placa_vehivulo, "
                + "     id_semana, codigo_inspector, codigo_productor, estado)\n"
                + "	VALUES (" + id_eva + ",'" + cod_eva + "', '" + fecha_eva + "', '" + hora_eva + "', '" + vapor + "','" + tipo_caja + "', '" + placa + "', " + semana + ", '" + this.cod_insp + "', '" + this.cod_prod + "', 'Activo');");
        return true;
    }

    public ResultSet cargar_dg() {
        try {
            st = con.conectarBD().createStatement();
            rs = st.executeQuery("SELECT DISTINCT prod.codigo, prod.nombre, prod.apellido, prod.finca, insp.codigo, insp.nombre, insp.apellido,\n"
                    + "eva.cod_evaluacion, eva.fecha_eva, eva.hora_eva, eva.vapor, tipo_caja, eva.placa_vehivulo, eva.id_semana\n"
                    + "FROM productores prod inner join evaluaciones eva on\n"
                    + "prod.codigo = eva.codigo_productor inner join inspectotes insp ON \n"
                    + "insp.codigo= eva.codigo_inspector WHERE eva.id = '" + this.id_cargar + "';");
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Mod_detalles_gen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
