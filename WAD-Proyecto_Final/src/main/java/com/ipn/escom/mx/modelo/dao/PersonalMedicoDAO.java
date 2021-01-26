package com.ipn.escom.mx.modelo.dao;

import com.ipn.escom.mx.modelo.dto.PersonalMedicoDTO;
import static java.lang.System.out;
import java.sql.CallableStatement;
import java.sql.Connection;
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
public class PersonalMedicoDAO {
    
    private static final String SQL_INSERT = "insert into PersonalMedico (nombre, paterno, materno, cedula, cargo, unidadAcademica, especialidad, tipoUsuario, email, clave) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "update PersonalMedico set nombre = ?, paterno = ?, materno = ?, cedula = ?, cargo = ?, unidadAcademica = ?, especialidad = ?, tipoUsuario = ?, email = ?, clave = ? where email = ?";
    private static final String SQL_DELETE = "delete from PersonalMedico where email = ?";
    private static final String SQL_SELECT = "select * from PersonalMedico where email = ?";
    private static final String SQL_SELECT_ALL = "select * from PersonalMedico";
    private static final String SQL_FIND_USER = "select * from PersonalMedico where email = ? and clave = ?";
        
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
            Logger.getLogger(PersonalMedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public void create(PersonalMedicoDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        try{
            cs = con.prepareCall(SQL_INSERT);
            cs.setString(1, dto.getEntidad().getNombre());
            cs.setString(2, dto.getEntidad().getPaterno());
            cs.setString(3, dto.getEntidad().getMaterno());
            cs.setString(4, dto.getEntidad().getCedula());
            cs.setString(5, dto.getEntidad().getCargo());
            cs.setString(6, dto.getEntidad().getUnidadAcademica());
            cs.setInt(7, dto.getEntidad().getEspecialidad());    
            cs.setString(8, dto.getEntidad().getTipoUsuario());
            cs.setString(9, dto.getEntidad().getEmail());
            cs.setString(10, dto.getEntidad().getClave());
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
    
    public void update(PersonalMedicoDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        try{
            cs = con.prepareCall(SQL_UPDATE);
            cs.setString(1, dto.getEntidad().getNombre());
            cs.setString(2, dto.getEntidad().getPaterno());
            cs.setString(3, dto.getEntidad().getMaterno());
            cs.setString(4, dto.getEntidad().getCedula());
            cs.setString(5, dto.getEntidad().getCargo());
            cs.setString(6, dto.getEntidad().getUnidadAcademica());
            cs.setInt(7, dto.getEntidad().getEspecialidad());
            cs.setString(8, dto.getEntidad().getTipoUsuario());
            cs.setString(9, dto.getEntidad().getEmail());
            cs.setString(10, dto.getEntidad().getClave());
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
    
    public void delete(PersonalMedicoDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        try{
            cs = con.prepareCall(SQL_DELETE);
            cs.setString(1, dto.getEntidad().getEmail());
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
    
    public PersonalMedicoDTO read(PersonalMedicoDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        ResultSet rs = null;
        try{
            cs = con.prepareCall(SQL_SELECT);
            cs.setString(1, dto.getEntidad().getEmail());
            rs = cs.executeQuery();
            List lista = obtenerResultados(rs);
            if(lista.size() > 0){
                return (PersonalMedicoDTO) lista.get(0);
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
    
    public PersonalMedicoDTO findUser(PersonalMedicoDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        ResultSet rs = null;
        try{
            cs = con.prepareCall(SQL_FIND_USER);
            cs.setString(1, dto.getEntidad().getEmail());
            cs.setString(2, dto.getEntidad().getClave());
            rs = cs.executeQuery();
            List lista = obtenerResultados(rs);
            if(lista.size() > 0){
                return (PersonalMedicoDTO) lista.get(0);
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

    private List obtenerResultados(ResultSet rs) throws SQLException {
    
        List resultados = new ArrayList();
        while(rs.next()){
            PersonalMedicoDTO dto = new PersonalMedicoDTO();
            dto.getEntidad().setNombre(rs.getString("nombre"));
            dto.getEntidad().setPaterno(rs.getString("paterno"));
            dto.getEntidad().setMaterno(rs.getString("materno"));
            dto.getEntidad().setCedula(rs.getString("cedula"));
            dto.getEntidad().setCargo(rs.getString("cargo"));
            dto.getEntidad().setUnidadAcademica(rs.getString("unidadAcademica"));
            dto.getEntidad().setEspecialidad(rs.getInt("especialidad"));
            dto.getEntidad().setTipoUsuario(rs.getString("tipoUsuario"));
            dto.getEntidad().setEmail(rs.getString("email"));
            dto.getEntidad().setClave(rs.getString("clave"));
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