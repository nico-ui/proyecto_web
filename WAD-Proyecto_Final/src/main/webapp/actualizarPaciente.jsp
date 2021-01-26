<%-- 
    Document   : actualizarPaciente
    Created on : 25 ene 2021, 14:46:05
    Author     : Cristopher Salas
--%>

<%@page import="com.ipn.escom.mx.modelo.dto.PacienteDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.ipn.escom.mx.modelo.dao.PacienteDAO"%>
<%@page errorPage="error.jsp?de=actualizarPaciente.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Actualizar Paciente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" >
        <link rel="stylesheet" href="css/estilos.css" >
    </head>
    <body class="body1">
        <div class="contenedor3">
            <label class="label3">Datos del Paciente</label><br/>
            <hr>
            <form method="POST" action="PacienteServlet?accion=actualizar&nss=<c:out value="${paciente.entidad.nss}" />">
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Número de seguridad social</strong></span>
                    </div>
                    <input id="nss" name="nss" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${paciente.entidad.nss}" />" readonly>
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Nombre</strong></span>
                    </div>
                    <input id="nombre" name="nombre" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${paciente.entidad.nombre}" />">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Apellido paterno</strong></span>
                    </div>
                    <input id="idUsuario" name="idUsuario" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${paciente.entidad.paterno}" />">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Apellido materno</strong></span>
                    </div>
                    <input id="materno" name="materno" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${paciente.entidad.materno}" />">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Teléfono</strong></span>
                    </div>
                    <input id="telefono" name="telefono" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${paciente.entidad.telefono}" />">
                </div>    
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Correo electrónico</strong></span>
                    </div>
                    <input id="email" name="email" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${paciente.entidad.email}" />" >
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Fecha de nacimiento</strong></span>
                    </div>
                    <input id="fechaNacimiento" name="fechaNacimiento" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${paciente.entidad.fechaNacimiento}" />" >
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Sexo</strong></span>
                    </div>
                    <input id="sexo" name="sexo" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${paciente.entidad.sexo}" />">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>No. de Expediente</strong></span>
                    </div>
                    <input id="idExpediente" name="idExpediente" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${paciente.entidad.idExpediente}" />" readonly>
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
