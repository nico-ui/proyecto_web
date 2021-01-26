package com.ipn.escom.mx.modelo.dao;

import com.ipn.escom.mx.modelo.dto.ExpedienteDTO;
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
public class ExpedienteDAO {
    
    private static final String SQL_INSERT = "insert into Expediente (idExpediente, edad, sexo, tipoSanguineo, altura, peso, presionArterial, temperatura, glucosa, frecuenciaCardiaca, frecuenciaRespiratoria, medicamentos, alergias, antecedentesFamiliares, estudiosLaboratorio, padecimientoActual, padecimientosPrevios) " + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "update Expediente set idExpediente = ?, edad = ?, sexo = ?, tipoSanguineo = ?, altura = ?, peso = ?, presionArterial = ?, temperatura = ?, glucosa = ?, frecuenciaCardiaca = ?, frecuenciaRespiratoria = ?, medicamentos = ?, alergias = ?, antecedentesFamiliares = ?, estudiosLaboratorio = ?, padecimientoActual = ?, padecimientosPrevios = ? where idExpediente = ?";
    private static final String SQL_DELETE = "delete from Expediente where idExpediente = ?";
    private static final String SQL_SELECT = "select * from Expediente where idExpediente = ?";
    private static final String SQL_SELECT_ALL = "select * from Expediente";
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
    
    public void create(ExpedienteDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        try{
            cs = con.prepareCall(SQL_INSERT);
            cs.setInt(1, dto.getEntidad().getIdExpediente());
            cs.setString(2, dto.getEntidad().getEdad());
            cs.setString(3, dto.getEntidad().getSexo());
            cs.setString(4, dto.getEntidad().getTipoSanguineo());
            cs.setString(5, dto.getEntidad().getAltura());
            cs.setString(6, dto.getEntidad().getPeso());
            cs.setString(7, dto.getEntidad().getPresionArterial());
            cs.setString(8, dto.getEntidad().getTemperatura());
            cs.setString(9, dto.getEntidad().getGlucosa());
            cs.setString(10, dto.getEntidad().getFrecuenciaCardiaca());
            cs.setString(11, dto.getEntidad().getFrecuenciaRespiratoria());
            cs.setString(12, dto.getEntidad().getMedicamentos());
            cs.setString(13, dto.getEntidad().getAlergias());
            cs.setString(14, dto.getEntidad().getAntecedentesFamiliares());
            cs.setString(15, dto.getEntidad().getEstudiosLaboratorio());
            cs.setString(16, dto.getEntidad().getPadecimientoActual());
            cs.setString(17, dto.getEntidad().getPadecimientosPrevios());
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
    
    public void update(ExpedienteDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        try{
            cs = con.prepareCall(SQL_UPDATE);
            cs.setInt(1, dto.getEntidad().getIdExpediente());
            cs.setString(2, dto.getEntidad().getEdad());
            cs.setString(3, dto.getEntidad().getSexo());
            cs.setString(4, dto.getEntidad().getTipoSanguineo());
            cs.setString(5, dto.getEntidad().getAltura());
            cs.setString(6, dto.getEntidad().getPeso());
            cs.setString(7, dto.getEntidad().getPresionArterial());
            cs.setString(8, dto.getEntidad().getTemperatura());
            cs.setString(9, dto.getEntidad().getGlucosa());
            cs.setString(10, dto.getEntidad().getFrecuenciaCardiaca());
            cs.setString(11, dto.getEntidad().getFrecuenciaRespiratoria());
            cs.setString(12, dto.getEntidad().getMedicamentos());
            cs.setString(13, dto.getEntidad().getAlergias());
            cs.setString(14, dto.getEntidad().getAntecedentesFamiliares());
            cs.setString(15, dto.getEntidad().getEstudiosLaboratorio());
            cs.setString(16, dto.getEntidad().getPadecimientoActual());
            cs.setString(17, dto.getEntidad().getPadecimientosPrevios());
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
    
    public void delete(ExpedienteDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        try{
            cs = con.prepareCall(SQL_DELETE);
            cs.setInt(1, dto.getEntidad().getIdExpediente());
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
    
    public ExpedienteDTO read(ExpedienteDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        ResultSet rs = null;
        try{
            cs = con.prepareCall(SQL_SELECT);
            cs.setInt(1, dto.getEntidad().getIdExpediente());
            rs = cs.executeQuery();
            List lista = obtenerResultados(rs);
            if(lista.size() > 0){
                return (ExpedienteDTO) lista.get(0);
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
            ExpedienteDTO dto = new ExpedienteDTO();
            dto.getEntidad().setIdExpediente(rs.getInt("idExpediente"));
            dto.getEntidad().setEdad(rs.getString("edad"));
            dto.getEntidad().setSexo(rs.getString("sexo"));
            dto.getEntidad().setTipoSanguineo(rs.getString("tipoSanguineo"));
            dto.getEntidad().setAltura(rs.getString("altura"));
            dto.getEntidad().setPeso(rs.getString("peso"));
            dto.getEntidad().setPresionArterial(rs.getString("presionArterial"));
            dto.getEntidad().setTemperatura(rs.getString("temperatura"));
            dto.getEntidad().setGlucosa(rs.getString("glucosa"));
            dto.getEntidad().setFrecuenciaCardiaca(rs.getString("frecuenciaCardiaca"));
            dto.getEntidad().setFrecuenciaRespiratoria(rs.getString("frecuanciaRespiratoria"));
            dto.getEntidad().setMedicamentos(rs.getString("medicamentos"));
            dto.getEntidad().setAlergias(rs.getString("alergias"));
            dto.getEntidad().setAntecedentesFamiliares(rs.getString("antecedentesFamiliares"));
            dto.getEntidad().setEstudiosLaboratorio(rs.getString("estudiosLaboratorio"));
            dto.getEntidad().setPadecimientoActual(rs.getString("padecimientoActual"));
            dto.getEntidad().setPadecimientosPrevios(rs.getString("pacecimientosPrevios"));
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