<%-- 
    Document   : verExpediente
    Created on : 25 ene 2021, 15:23:08
    Author     : Cristopher Salas
--%>

<%@page session="true"%>
<%@page import="com.ipn.escom.mx.modelo.dto.ExpedienteDTO"%>
<%@page import="com.ipn.escom.mx.modelo.dao.ExpedienteDAO"%>
<%@page import="java.util.List"%>
<%@page errorPage="error.jsp?de=verExpediente.jsp"%>
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
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>No. de Expediente</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${expediente.entidad.idExpediente}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Edad</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${expediente.entidad.edad}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Sexo</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${expediente.entidad.sexo}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Tipo Sanguíneo</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${expediente.entidad.tipoSanguineo}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Altura</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${expediente.entidad.altura}" />
                </div>
            </div>    
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Peso</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${expediente.entidad.Peso}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Presion arterial</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${expediente.entidad.presionArterial}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Temperatura</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${expediente.entidad.temperatura}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Glocosa</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${expediente.entidad.glucosa}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Frecuencia cardiaca</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${expediente.entidad.frecuenciaCardiaca}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Frecuencia respiratoria</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${expediente.entidad.frecuenciaRespiratoria}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Medicamentos</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${expediente.entidad.medicamentos}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Alergias</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${expediente.entidad.alergias}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Antecedentes Familiares</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${expediente.entidad.antecedentesFamiliares}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Estudios de laboratorio</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${expediente.entidad.estudiosLaboratorio}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Padecimiento actual</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${expediente.entidad.padecimientoActual}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Padecimientos previos</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${expediente.entidad.padecimientosPrevios}" />
                </div>
            </div>
            <a href="PacienteServlet?accion=listaDePacientes" class="btn btn-primary btn-lg btn-block">Regresar</a>
        </div>
    </body>
</html>
