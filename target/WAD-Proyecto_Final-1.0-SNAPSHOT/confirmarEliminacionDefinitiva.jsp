<%-- 
    Document   : confirmarEliminacionDefinitiva
    Created on : 25 ene 2021, 17:02:34
    Author     : Cristopher Salas
--%>

<%@page session="true"%>
<%@page import="com.ipn.escom.mx.modelo.dto.PersonalMedicoDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.ipn.escom.mx.modelo.dao.PersonalMedicoDAO"%>
<%@page errorPage="error.jsp?de=confirmarEliminacionDefinitiva.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Eliminar cuenta</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" >
        <link rel="stylesheet" href="css/estilos.css" >
    </head>
    <body class="body1">
            <div class="contenedor3">
                <strong>¿Seguro que deseas eliminar tu cuenta de forma definitiva?</strong><br/>
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
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Cédula</strong></span>
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
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Universidad de procedencia</strong></span>
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
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Tipo</strong></span>
                    </div>
                    <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                        <c:out value="${personalMedico.entidad.tipoUsuario}" />
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
                <a href="PersonalMedicoServlet?accion=listaDeMedicos" class="btn btn-primary btn-lg btn-block">Cancelar</a>
                <a href="PersonalMedicoServlet?accion=eliminarDefinitivoA" class="btn btn-danger btn-lg btn-block">Eliminar</a>
            </div>
    </body>
</html>
