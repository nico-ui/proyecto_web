package com.ipn.escom.mx.modelo.dao;

import com.ipn.escom.mx.modelo.dto.IngresoDTO;
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
public class IngresoDAO {
    
    private static final String SQL_INSERT = "insert into Ingreso (idIngreso, fechaIngreso, horaIngreso, edificio, piso, cama, observaciones, costoTratamiento, diagnostico, nssPaciente, cedulaMedico) " + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "update Ingreso set idIngreso = ?, fechaIngreso = ?, horaIngreso = ?, edificio = ?, piso = ?, cama = ?, observaciones = ?, costoTratamiento = ?, diagnostico = ?, nssPaciente = ?, cedulaMedico = ? where nss = ?";
    private static final String SQL_DELETE = "delete from Ingreso where nss = ?";
    private static final String SQL_SELECT = "select * from Ingreso where nss = ?";
    private static final String SQL_SELECT_ALL = "select * from Ingreso";
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
    
    public void create(IngresoDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        try{
            cs = con.prepareCall(SQL_INSERT);
            cs.setInt(1, dto.getEntidad().getIdIngreso());
            cs.setDate(2, (Date) dto.getEntidad().getFechaIngreso());
            cs.setString(3, dto.getEntidad().getHoraIngreso());
            cs.setString(4, dto.getEntidad().getEdificio());
            cs.setString(5, dto.getEntidad().getPiso());
            cs.setString(6, dto.getEntidad().getCama());
            cs.setString(7, dto.getEntidad().getObservaciones());
            cs.setDouble(8, dto.getEntidad().getCostoTratamiento());
            cs.setString(9, dto.getEntidad().getDiagnostico());
            cs.setInt(10, dto.getEntidad().getNssPaciente());
            cs.setString(11, dto.getEntidad().getEmailMedico());
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
    
    public void update(IngresoDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        try{
            cs = con.prepareCall(SQL_UPDATE);
            cs.setInt(1, dto.getEntidad().getIdIngreso());
            cs.setDate(2, (Date) dto.getEntidad().getFechaIngreso());
            cs.setString(3, dto.getEntidad().getHoraIngreso());
            cs.setString(4, dto.getEntidad().getEdificio());
            cs.setString(5, dto.getEntidad().getPiso());
            cs.setString(6, dto.getEntidad().getCama());
            cs.setString(7, dto.getEntidad().getObservaciones());
            cs.setDouble(8, dto.getEntidad().getCostoTratamiento());
            cs.setString(9, dto.getEntidad().getDiagnostico());
            cs.setInt(10, dto.getEntidad().getNssPaciente());
            cs.setString(11, dto.getEntidad().getEmailMedico());
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
    
    public void delete(IngresoDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        try{
            cs = con.prepareCall(SQL_DELETE);
            cs.setInt(1, dto.getEntidad().getIdIngreso());
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
    
    public IngresoDTO read(IngresoDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        ResultSet rs = null;
        try{
            cs = con.prepareCall(SQL_SELECT);
            cs.setInt(1, dto.getEntidad().getIdIngreso());
            rs = cs.executeQuery();
            List lista = obtenerResultados(rs);
            if(lista.size() > 0){
                return (IngresoDTO) lista.get(0);
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
            IngresoDTO dto = new IngresoDTO();
            dto.getEntidad().setIdIngreso(rs.getInt("idIngreso"));
            dto.getEntidad().setFechaIngreso(rs.getDate("fechaIngreso"));
            dto.getEntidad().setHoraIngreso(rs.getString("horaIngreso"));
            dto.getEntidad().setEdificio(rs.getString("edificio"));
            dto.getEntidad().setPiso(rs.getString("piso"));
            dto.getEntidad().setCama(rs.getString("cama"));
            dto.getEntidad().setObservaciones(rs.getString("observaciones"));
            dto.getEntidad().setCostoTratamiento(rs.getFloat("costoTratamiento"));
            dto.getEntidad().setDiagnostico(rs.getString("diagnostico"));
            dto.getEntidad().setNssPaciente(rs.getInt("nssPaciente"));
            dto.getEntidad().setEmailMedico(rs.getString("emailMedico"));
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