<%-- 
    Document   : navGeneral
    Created on : 25 ene 2021, 17:12:51
    Author     : Cristopher Salas
--%>

<%@page session="true"%>
<%@page import="com.ipn.escom.mx.modelo.dto.PersonalMedicoDTO"%>
<%@page import="com.ipn.escom.mx.modelo.dao.PersonalMedicoDAO"%>
<%@page import="java.util.List"%>
<%@page errorPage="error.jsp?de=navGeneral.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
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

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" ></script>
    </body>
</html>
