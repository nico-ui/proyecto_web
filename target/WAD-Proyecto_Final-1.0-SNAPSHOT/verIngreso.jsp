<%-- 
    Document   : verIngreso
    Created on : 25 ene 2021, 12:58:06
    Author     : Cristopher Salas
--%>

<%@page session="true"%>
<%@page import="com.ipn.escom.mx.modelo.dto.IngresoDTO"%>
<%@page import="com.ipn.escom.mx.modelo.dao.IngresoDAO"%>
<%@page import="java.util.List"%>
<%@page errorPage="error.jsp?de=verIngreso.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ingreso</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" >
        <link rel="stylesheet" href="css/estilos.css" >
    </head>
    <body class="body1">
        <div class="contenedor3">
            <label class="label3">Datos del Ingreso</label><br/>
            <hr>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Clave de ingreso</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${ingreso.entidad.idIngreso}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Fecha de ingreso</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${ingreso.entidad.fechaIngreso}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Hora de ingreso</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${ingreso.entidad.horaIngreso}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Edificio</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${ingreso.entidad.edificio}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Piso</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${ingreso.entidad.piso}" />
                </div>
            </div>    
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Cama</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${ingreso.entidad.cama}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Observaciones</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${ingreso.entidad.observaciones}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Costo</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${ingreso.entidad.costo}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Diagnóstico</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${ingreso.entidad.diagnostico}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>No. de seguridad social del paciente</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${ingreso.entidad.nssPaciente}" />
                </div>
            </div>
            <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm"><strong>Cédula del médico que ingresó</strong></span>
                </div>
                <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" readonly>
                    <c:out value="${ingreso.entidad.cedulaMedico}" />
                </div>
            </div>
            <a href="IngresoServlet?accion=listaDeIngresos" class="btn btn-primary btn-lg btn-block">Regresar</a>
        </div>
    </body>
</html>
