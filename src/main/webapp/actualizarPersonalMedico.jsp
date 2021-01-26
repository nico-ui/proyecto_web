<%-- 
    Document   : actualizarPersonalMedico
    Created on : 25 ene 2021, 14:45:22
    Author     : Cristopher Salas
--%>

<%@page import="com.ipn.escom.mx.modelo.dto.PersonalMedicoDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.ipn.escom.mx.modelo.dao.PersonalMedicoDAO"%>
<%@page import="com.ipn.escom.mx.modelo.dto.EspecialidadDTO"%>
<%@page import="com.ipn.escom.mx.modelo.dao.EspecialidadDAO"%>
<%@page errorPage="error.jsp?de=actualizarPersonalMedico.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Actualizar Personal Médico</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" >
        <link rel="stylesheet" href="css/estilos.css" >
    </head>
    <body class="body1">
        <div class="contenedor3">
            <label class="label3">Datos del Personal Médico</label><br/>
            <hr>
            <form method="POST" action="PersonalMedicoServlet?accion=actualizar&email=<c:out value="${personalMedico.entidad.email}" />">
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Nombre</strong></span>
                    </div>
                    <input id="nombre" name="nombre" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${personalMedico.entidad.nombre}" />">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Apellido paterno</strong></span>
                    </div>
                    <input id="paterno" name="paterno" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${personalMedico.entidad.paterno}" />">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Apellido materno</strong></span>
                    </div>
                    <input id="materno" name="materno" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${personalMedico.entidad.materno}" />">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Cédula Profesional</strong></span>
                    </div>
                    <input id="cedula" name="cedula" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${personalMedico.entidad.cedula}" />">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Cargo</strong></span>
                    </div>
                    <input id="cargo" name="cargo" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${personalMedico.entidad.cargo}" />">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Universidad de Procedencia</strong></span>
                    </div>
                    <input id="unidadAcademica" name="unidadAcademica" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${personalMedico.entidad.unidadAcademica}" />">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm">Especialidad</span>
                    </div>
                    <input id="especialidad" name="especialidad" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${personalMedico.entidad.especialidad}" />">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm">Tipo</span>
                    </div>
                    <input id="tipo" name="tipo" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${personalMedico.entidad.tipoUsuario}" />" readonly>
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Correo electrónico</strong></span>
                    </div>
                    <input id="email" name="email" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${personalMedico.entidad.email}" />" readonly>
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Contraseña</strong></span>
                    </div>
                   <input id="clave" name="clave" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${personalMedico.entidad.clave}" />">
                </div>
                <input class="btn btn-primary btn-lg btn-block" type="submit" value="Actualizar"/>
                <div class="botonCancelar">
                    <a class="btn btn-danger btn-xs"
                       href="PersonalMedicoServlet?accion=elegirPersonalMedico">
                        Cancelar
                    </a>
                </div>
            </form>
        </div>
    </body>
</html>
