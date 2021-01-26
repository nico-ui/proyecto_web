<%-- 
    Document   : actualizarExpediente
    Created on : 25 ene 2021, 14:48:23
    Author     : Cristopher Salas
--%>

<%@page import="com.ipn.escom.mx.modelo.dto.ExpedienteDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.ipn.escom.mx.modelo.dao.ExpedienteDAO"%>
<%@page errorPage="error.jsp?de=actualizarExpediente.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Expediente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" >
        <link rel="stylesheet" href="css/estilos.css" >
    </head>
    <body class="body1">
        <div class="contenedor3">
            <label class="label3">Informe de Expediente</label><br/>
            <hr>
            <form method="POST" action="ExpedienteServlet?accion=actualizar&idExpediente=<c:out value="${expediente.entidad.idExpediente}" />">
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>No. de Expediente</strong></span>
                    </div>
                    <input id="idExpediente" name="idExpediente" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${expediente.entidad.idExpediente}" />" readonly>
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Edad</strong></span>
                    </div>
                    <input id="edad" name="edad" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${expediente.entidad.edad}" />">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Sexo</strong></span>
                    </div>
                    <input id="sexo" name="sexo" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${expediente.entidad.idExpediente}" />" readonly>
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Tipo Sanguíneo</strong></span>
                    </div>
                    <input id="tipoSanguineo" name="tipoSanguineo" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${expediente.entidad.tipoSanguineo}" />" readonly>
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Altura</strong></span>
                    </div>
                    <input id="altura" name="altura" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${expediente.entidad.altura}" />">
                </div>    
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Peso</strong></span>
                    </div>
                    <input id="peso" name="peso" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${expediente.entidad.peso}" />">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Presion arterial</strong></span>
                    </div>
                    <input id="presionArterial" name="presionArterial" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${expediente.entidad.presionArterial}" />" >
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Temperatura</strong></span>
                    </div>
                    <input id="temperatura" name="temperatura" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${expediente.entidad.temperatura}" />" >
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Glocosa</strong></span>
                    </div>
                    <input id="glucosa" name="glucosa" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${expediente.entidad.glucosa}" />" >
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Frecuencia cardiaca</strong></span>
                    </div>
                    <input id="frecuenciaCardiaca" name="frecuenciaCardiaca" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${expediente.entidad.frecuenciaCardiaca}" />" >
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Frecuencia respiratoria</strong></span>
                    </div>
                    <input id="frecuenciaRespiratoria" name="frecuenciaRespiratoria" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${expediente.entidad.frecuenciaRespiratoria}" />" >
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Medicamentos</strong></span>
                    </div>
                    <input id="medicamentos" name="medicamentos" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${expediente.entidad.medicamentos}" />" >
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Alergias</strong></span>
                    </div>
                    <input id="alergias" name="alergias" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${expediente.entidad.alergias}" />" >
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Antecedentes Familiares</strong></span>
                    </div>
                    <input id="antecedentesFamiliares" name="antecedentesFamiliares" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${expediente.entidad.antecedentesFamiliares}" />" >
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Estudios de laboratorio</strong></span>
                    </div>
                    <input id="estudiosLaboratorio" name="estudiosLaboratorio" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${expediente.entidad.estudiosLaboratorio}" />" >
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Padecimiento actual</strong></span>
                    </div>
                    <input id="padecimientoActual" name="padecimientoActual" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${expediente.entidad.padecimientoActual}" />" >
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Padecimientos previos</strong></span>
                    </div>
                    <input id="padecimientosPrevios" name="padecimientosPrevios" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${expediente.entidad.padecimientosPrevios}" />" >
                </div>
                <input class="btn btn-primary btn-lg btn-block" type="submit" value="Actualizar"/>
                <div class="botonCancelar">
                    <a class="btn btn-danger btn-xs"
                       href="PacienteServlet?accion=listaDePacientes">
                        Cancelar
                    </a>
                </div>
            </form>
        </div>
    </body>
</html>
