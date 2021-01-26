<%-- 
    Document   : verPersonalMedico
    Created on : 25 ene 2021, 4:59:39
    Author     : Cristopher Salas
--%>

<%@page session="true"%>
<%@page import="com.ipn.escom.mx.modelo.dto.PersonalMedicoDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.ipn.escom.mx.modelo.dao.PersonalMedicoDAO"%>
<%@page errorPage="error.jsp?de=verPersonalMedico.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Personal Médico</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" >
        <link rel="stylesheet" href="css/estilos.css" >
    </head>
    <body class="body1">
        <div class="contenedor3">
            <c:set var="tipo" scope="session" value="${personalMedico.entidad.tipoUsuario}"/>
            <c:if test="${tipo=='M'} ">
            <label class="label3">Datos del Médico</label><br/>
            </c:if>
            <c:if test="${tipo=='E'} ">
            <label class="label3">Datos del Enfermero(a)</label><br/>
            </c:if>
            <hr>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Nombre</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${personalMedico.entidad.nombre}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Apellido paterno</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${personalMedico.entidad.paterno}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Apellido materno</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${personalMedico.entidad.materno}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Cédula Profesional</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${personalMedico.entidad.cedula}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Cargo</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${personalMedico.entidad.cargo}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Universidad de Procedencia</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${personalMedico.entidad.unidadAcademica}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Especialidad</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${personalMedico.entidad.especialidad}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Correo electrónico</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${personalMedico.entidad.email}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Contraseña</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${personalMedico.entidad.clave}" />
                </div>
            </div>
            <c:if test="${tipo=='M'} ">
            <a href="PersonalMedicoServlet?accion=listaDeMedicos" class="btn btn-primary btn-lg btn-block">Regresar</a>
            </c:if>
            <c:if test="${tipo=='E'} ">
            <a href="PersonalMedicoServlet?accion=listaDeEnfermeros" class="btn btn-primary btn-lg btn-block">Regresar</a>
            </c:if>
        </div>
    </body>
</html>
