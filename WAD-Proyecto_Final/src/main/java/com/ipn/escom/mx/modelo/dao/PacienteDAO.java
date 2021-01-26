package com.ipn.escom.mx.modelo.dao;

import com.ipn.escom.mx.modelo.dto.PacienteDTO;
import static java.lang.System.out;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Cristopher Salas
 */
public class PacienteDAO {
    
    private static final String SQL_INSERT = "insert into Paciente (nss, nombre, paterno, materno, telefono, email, fechaNacimiento, sexo, idExpediente) " + "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "update Paciente set nss = ?, nombre = ?, paterno = ?, materno = ?, telefono = ?, email = ?, fechaNacimiento = ?, sexo = ?, idExpediente = ? where nss = ?";
    private static final String SQL_DELETE = "delete from Paciente where nss = ?";
    private static final String SQL_SELECT = "select * from Paciente where nss = ?";
    private static final String SQL_SELECT_ALL = "select * from Paciente";
    //private static final String SQL_FIND_USER = "select * from Paciente where email = ? and claveUsuario = ?";
        
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
    
    public void create(PacienteDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        try{
            cs = con.prepareCall(SQL_INSERT);
            cs.setInt(1, dto.getEntidad().getNss());
            cs.setString(2, dto.getEntidad().getNombre());
            cs.setString(3, dto.getEntidad().getPaterno());
            cs.setString(4, dto.getEntidad().getMaterno());
            cs.setString(5, dto.getEntidad().getTelefono());
            cs.setString(6, dto.getEntidad().getEmail());
            cs.setString(7, dto.getEntidad().getFechaNacimiento());
            cs.setString(8, dto.getEntidad().getSexo());
            cs.setInt(9, dto.getEntidad().getIdExpediente());
            cs.executeUpdate();
        }finally{
            if(cs != null){
                cs.close();
            }
            if(con != null){
                con.close();
            }
        }
    }
    
    public void update(PacienteDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        try{
            cs = con.prepareCall(SQL_UPDATE);
            cs.setInt(1, dto.getEntidad().getNss());
            cs.setString(2, dto.getEntidad().getNombre());
            cs.setString(3, dto.getEntidad().getPaterno());
            cs.setString(4, dto.getEntidad().getMaterno());
            cs.setString(5, dto.getEntidad().getTelefono());
            cs.setString(6, dto.getEntidad().getEmail());
            cs.setString(7, dto.getEntidad().getFechaNacimiento());
            cs.setString(8, dto.getEntidad().getSexo());
            cs.setInt(9, dto.getEntidad().getIdExpediente());
            cs.execute();
        }finally{
            if(cs != null){
                cs.close();
            }
            if(con != null){
                con.close();
            }
        }
    }
    
    public void delete(PacienteDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        try{
            cs = con.prepareCall(SQL_DELETE);
            cs.setInt(1, dto.getEntidad().getNss());
            cs.executeUpdate();
        }finally{
            if(cs != null){
                cs.close();
            }
            if(con != null){
                con.close();
            }
        }
    }
    
    public PacienteDTO read(PacienteDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        ResultSet rs = null;
        try{
            cs = con.prepareCall(SQL_SELECT);
            cs.setInt(1, dto.getEntidad().getNss());
            rs = cs.executeQuery();
            List lista = obtenerResultados(rs);
            if(lista.size() > 0){
                return (PacienteDTO) lista.get(0);
            }else{
                return null;
            }
        }finally{
            if(cs != null){
                cs.close();
            }
            if(con != null){
                con.close();
            }
        }
    }
    
    public List readAll() throws SQLException {
        obtenerConexion();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = con.prepareCall(SQL_SELECT_ALL);
            rs = cs.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return resultados;
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cs != null) {
                cs.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    private List obtenerResultados(ResultSet rs) throws SQLException {
    
        List resultados = new ArrayList();
        while(rs.next()){
            PacienteDTO dto = new PacienteDTO();
            dto.getEntidad().setNss(rs.getInt("nss"));
            dto.getEntidad().setNombre(rs.getString("nombre"));
            dto.getEntidad().setPaterno(rs.getString("paterno"));
            dto.getEntidad().setMaterno(rs.getString("materno"));
            dto.getEntidad().setTelefono(rs.getString("telefono"));
            dto.getEntidad().setEmail(rs.getString("email"));
            dto.getEntidad().setFechaNacimiento(rs.getString("fechaNacimiento"));
            dto.getEntidad().setSexo(rs.getString("sexo"));
            dto.getEntidad().setIdExpediente(rs.getInt("idExpediente"));
            resultados.add(dto);
        }
        return resultados;
    }
    
    private boolean login(String usuario, String clave) throws SQLException {
        obtenerConexion();
        CallableStatement cs = null;
        ResultSet rs = null;
        try{
            cs = con.prepareCall(SQL_SELECT);
            //cs.setLong(1, dto.getEntidad().getIdUsuario());
            rs = cs.executeQuery();
            List lista = obtenerResultados(rs);
            if(lista.size() > 0){
                return true;
            }else{
                return true;
            }
        }finally{
            if(cs != null){
                cs.close();
            }
            if(con != null){
                con.close();
            }
        }
        //return true;
    }
}