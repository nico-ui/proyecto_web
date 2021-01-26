<%-- 
    Document   : actualizarIngreso
    Created on : 25 ene 2021, 14:46:55
    Author     : Cristopher Salas
--%>

<%@page import="com.ipn.escom.mx.modelo.dto.IngresoDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.ipn.escom.mx.modelo.dao.IngresoDAO"%>
<%@page errorPage="error.jsp?de=actualizarUsuario.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Actualización de Ingresos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" >
        <link rel="stylesheet" href="css/estilos.css" >
    </head>
    <body class="body1">
        <div class="contenedor3">
            <label class="label3">Datos del Ingreso</label><br/>
            <hr>
            <form method="POST" action="IngresoServlet?accion=actualizar&idIngreso=<c:out value="${ingreso.entidad.idIngreso}" />">
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Clave de ingreso</strong></span>
                    </div>
                    <input id="idIngreso" name="idIngreso" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${ingreso.entidad.idIngreso}" />" readonly>
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Fecha de ingreso</strong></span>
                    </div>
                    <input id="fechaIngreso" name="fechaIngreso" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${ingreso.entidad.fechaIngreso}" />">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Hora de ingreso</strong></span>
                    </div>
                    <input id="horaIngreso" name="horaIngreso" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${ingreso.entidad.horaIngreso}" />">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Edificio</strong></span>
                    </div>
                    <input id="edificio" name="edificio" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${ingreso.entidad.edificio}" />" >
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Piso</strong></span>
                    </div>
                    <input id="piso" name="piso" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${ingreso.entidad.piso}" />" >
                </div>    
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Cama</strong></span>
                    </div>
                    <input id="cama" name="cama" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${ingreso.entidad.cama}" />">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Observaciones</strong></span>
                    </div>
                    <input id="observaciones" name="observaciones" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${ingreso.entidad.observaciones}" />" >
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Costo</strong></span>
                    </div>
                    <input id="costo" name="costo" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${ingreso.entidad.costo}" />">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Diagnóstico</strong></span>
                    </div>
                    <input id="diagnostico" name="diagnostico" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${ingreso.entidad.diagnostico}" />">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>No. de seguridad social del paciente</strong></span>
                    </div>
                    <input id="nssPaciente" name="nssPaciente" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${ingreso.entidad.nssPaciente}" />">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Cédula del médico que ingresó</strong></span>
                    </div>
                    <input id="cedulaMedico" name="cedulaMedico" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="<c:out value="${ingreso.entidad.cedulaMedico}" />">
                </div>
                <input class="btn btn-primary btn-lg btn-block" type="submit" value="Actualizar"/>
                <div class="botonCancelar">
                    <a class="btn btn-danger btn-xs"
                       href="IngresoServlet?accion=listaDeIngresos">
                        Cancelar
                    </a>
                </div>
            </form>
        </div>
    </body>
</html>
