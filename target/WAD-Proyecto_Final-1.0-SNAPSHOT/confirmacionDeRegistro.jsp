<%-- 
    Document   : confirmacionDeRegistro
    Created on : 25 ene 2021, 16:10:16
    Author     : Cristopher Salas
--%>
<%@page session="true"%>
<%@page import="com.ipn.escom.mx.modelo.dto.PersonalMedicoDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.ipn.escom.mx.modelo.dao.PersonalMedicoDAO"%>
<%@page errorPage="error.jsp?de=confirmacionDeRegistro.jsp"%>
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
                <label><strong>Estimado Dr.(a): <c:out value=" ${personalMedico.entidad.nombre} " /> <c:out value="${personalMedico.entidad.paterno} " /> <c:out value="${personalMedico.entidad.materno}" /> 
                               gracias por registrarse en el sistema.
                Ahora podrá hacer uso de su cuenta e iniciar sesión con los siguientes datos:</strong> </label><br/>
                </c:if>
                <c:if test="${tipo=='E'} ">
                <label><strong>Estimado Enfermero(a): <c:out value=" ${personalMedico.entidad.nombre} " /> <c:out value="${personalMedico.entidad.paterno} " /> <c:out value="${personalMedico.entidad.materno}" /> 
                               gracias por registrarse en el sistema.
                Ahora podrá hacer uso de su cuenta e iniciar sesión con los siguientes datos:</strong> </label><br/>
                </c:if>
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
                <a href="index.jsp" class="btn btn-primary btn-lg btn-block">Iniciar sesión</a>
            </div>
    </body>
</html>
