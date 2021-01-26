package com.ipn.escom.mx.modelo.dao;

import com.ipn.escom.mx.modelo.dto.GraficaDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Cristopher Salas
 */
public class GraficaDAO {

    private static final String SQL_GRAFICAR = "select c.nombreCategoria as categoria, count(*) as productos"
                                            + "from Categoria c, Producto p"
                                            + "where c.idCategoria = p.idCategoria"
                                            + "group by c.idCategoria";
            
    private Connection con;

    //Conexion a Base de Datos en Heroku AWS
    public Connection obtenerConexion() {
        String user = "mliehpumayxvcr";
        String pwd = "9a066c65a8651ff9a0359458a75103b0e3f2903bdd25d012f52b35610e6ee578";
        String url = "jdbc:postgresql://ec2-54-208-233-243.compute-1.amazonaws.com:5432/desl2v601ot8jn?sslmode=require";
        String driver = "org.postgresql.Driver";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public List grafica() throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List lista = new ArrayList();
        try {
            ps = con.prepareStatement(SQL_GRAFICAR);
            rs = ps.executeQuery();
            while (rs.next()) {
                GraficaDTO dto = new GraficaDTO();
                dto.setNombre(rs.getString("categoria"));
                dto.setCantidad(rs.getInt("productos"));
                lista.add(dto);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return lista;
    }
}