<%-- 
    Document   : verPaciente
    Created on : 25 ene 2021, 5:20:10
    Author     : Cristopher Salas
--%>

<%@page session="true"%>
<%@page import="com.ipn.escom.mx.modelo.dto.PacienteDTO"%>
<%@page import="com.ipn.escom.mx.modelo.dao.PacienteDAO"%>
<%@page import="java.util.List"%>
<%@page errorPage="error.jsp?de=verPaciente.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Paciente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" >
        <link rel="stylesheet" href="css/estilos.css" >
    </head>
    <body class="body1">
        <div class="contenedor3">
            <label class="label3">Datos del Paciente</label><br/>
            <hr>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Número de seguridad social</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${paciente.entidad.nss}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Nombre</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${paciente.entidad.nombre}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Apellido paterno</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${paciente.entidad.paterno}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Apellido materno</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${paciente.entidad.materno}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Teléfono</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${paciente.entidad.telefono}" />
                </div>
            </div>    
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Correo electrónico</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${paciente.entidad.email}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Fecha de nacimiento</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${paciente.entidad.fechaNacimiento}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Sexo</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${paciente.entidad.sexo}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>No. de Expediente</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${paciente.entidad.idExpediente}" />
                </div>
            </div>
            <a href="PacienteServlet?accion=listaDePacientes" class="btn btn-primary btn-lg btn-block">Regresar</a>
        </div>
    </body>
</html>
