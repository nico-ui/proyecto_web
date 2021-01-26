<%-- 
    Document   : loginExito
    Created on : 24 ene 2021, 17:51:58
    Author     : Cristopher Salas
--%>

<%@page session="true"%>
<%@page import="com.ipn.escom.mx.modelo.dto.PersonalMedicoDTO"%>
<%@page import="com.ipn.escom.mx.modelo.dao.PersonalMedicoDAO"%>
<%@page import="java.util.List"%>
<%@page errorPage="error.jsp?de=loginExito.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inicio</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" >
        <link rel="stylesheet" href="css/estilos.css" >
    </head>
    <body>
        <!-- INICIA NAV GENERAL -->
        <header>
            <ul class="nav nav-pills">
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="LoginServlet?accion=loginExito">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="PersonalMedicoServlet?accion=elegirPersonalMedico">Personal Médico</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="PacienteServlet?accion=listaDePacientes">Pacientes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="IngresoServlet?accion=listaDeIngresos">Ingresos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Sesión iniciada</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"><c:out value="${usuarioLogueado}" /></a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item"
                           href="PersonalMedicoServlet?accion=ver&email=<c:out value="${idLogueado}" />">
                            Ver cuenta(<c:out value="${usuarioLogueado}" />)
                        </a>
                        <a class="dropdown-item"
                           href="PersonalMedicoServlet?accion=nuevaActualizacion&email=<c:out value="${idLogueado}" />">
                            Modificar cuenta
                        </a>
                        <a class="dropdown-item"
                           href="PersonalMedicoServlet?accion=eliminar&email=<c:out value="${idLogueado}" />">
                            Eliminar cuenta
                        </a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="LoginServlet?accion=logout">Cerrar sesión</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
            </ul>
        </header>
        <!-- TERMINA NAV GENERAL -->
        <h1>Bienvenido</h1>
        <div class="contenedor">
            <a title="PersonalMedico" href="PersonalMedicoServlet?accion=elegirPersonalMedico"><img src="img/personalmedico.jpg" alt="Ícono de Pacientes"></a>
            <a title="Pacientes" href="PacienteServlet?accion=listaDePacientes"><img src="img/pacientes.jpg" alt="Ícono de Pacientes"></a>
            <a title="Ingresos" href="IngresoServlet?accion=listaDeIngresos"><img src="img/ingreso.jpg" alt="Ícono de Ingresos"></a>
            <br/>
            <a title="PersonalMedico" href="PersonalMedicoServlet?accion=elegirPersonalMedico"><button class="button" style="vertical-align:middle"><span>Personal Médico</span></button></a>
            <a title="Pacientes" href="PacienteServlet?accion=listaDePacientes"><button class="button" style="vertical-align:middle"><span>Pacientes</span></button></a>
            <a title="Ingresos" href="IngresoServlet?accion=listaDeIngresos"><button class="button" style="vertical-align:middle"><span>Ingresos</span></button></a>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" ></script>
    </body>
</html>