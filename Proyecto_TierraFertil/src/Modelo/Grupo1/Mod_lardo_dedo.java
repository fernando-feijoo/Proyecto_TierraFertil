package Modelo.Grupo1;

import Modelo.Modelo_Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mod_lardo_dedo {

    Modelo_Conexion con = Modelo_Conexion.getInstancia();
    Statement st; ResultSet rs;
    
    public int can6,can7,can8,can9,can10,can11,cantot;
    public double num6,num7,num8,num9,num10,num11,numtot,numprom;
    public int id_max_ld, id_eva;
    
    public boolean ld_can () throws SQLException {
        st=con.conectarBD().createStatement();
        st.executeUpdate("INSERT INTO public.largo_dedo(\n" +
"	id, cant_ld6, cant_ld7, cant_ld8, cant_ld9, cant_ld10,\n" +
"	cant_ld11, total_cant_ld, id_evaluacion)\n" +
"	VALUES ("+id_max_ld+","+this.can6+", "+this.can7+", "+this.can8+", "+this.can9+", "+this.can10+", "+this.can11+", "+this.cantot+", "+this.id_eva+");");
        con.cerrarBD();
        return true;
    }
    
    public boolean ld_num () throws SQLException {
        st=con.conectarBD().createStatement();
        st.executeUpdate("INSERT INTO public.datos_ld(\n" +
"	ld6, ld7, ld8, ld9, ld10, \n" +
"	ld11, total_res_ld, promedio_ld, id_largo_dedo)\n" +
"	VALUES ("+this.num6+", "+this.num7+", "+this.num8+", "+this.num9+", "+this.num10+",\n" +
"	"+this.num11+", "+this.numtot+", "+this.numprom+", "+this.id_max_ld+");");
        con.cerrarBD();
        return true;
    }
    public int id_ld () throws SQLException{
        int id=1;
        st=con.conectarBD().createStatement();
        rs=st.executeQuery("select max (id) from public.largo_dedo;");
        while (rs.next()) {            
            id=rs.getInt(1);
        }
        con.cerrarBD();
        return id;
    }
}
