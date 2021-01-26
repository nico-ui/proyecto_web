<%-- 
    Document   : ingresos
    Created on : 25 ene 2021, 3:29:51
    Author     : Cristopher Salas
--%>

<%@page import="com.ipn.escom.mx.modelo.dto.IngresoDTO"%>
<%@page import="com.ipn.escom.mx.modelo.dao.IngresoDAO"%>
<%@page import="com.ipn.escom.mx.modelo.dto.PersonalMedicoDTO"%>
<%@page import="com.ipn.escom.mx.modelo.dao.PersonalMedicoDAO"%>
<%@page import="java.util.List"%>
<%@page errorPage="error.jsp?de=ingresos.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresos</title>
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
        <h1>Ingresos</h1>
        <div class="container">
            <h2>Lista de Ingresos</h2>
            <a href="IngresoServlet?accion=nuevo" class="btn btn-warning">Nuevo</a>
            <a href="ingresoServlet?accion=verPDF" class="btn btn-warning">Generar reporte</a>
            <br/>
            <br/>
            <br/>
            <div class="table-responsive">
                <div class="body3">
                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th>Clave</th>
                                <th>Paciente (número de seguridad social)</th>
                                <th>Fecha de Ingreso</th>
                                <th>Diagnóstico</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody> 
                            <c:forEach
                                var="ingresos" items="${listaDeIngresos}">
                                <tr>
                                    <td>
                                        <a class="btn btn-primary btn-xs"
                                           href="IngresoServlet?accion=ver&id=<c:out value="${ingresos.entidad.idIngreso}" />">
                                            <c:out value="${ingresos.entidad.idIngreso}" />
                                        </a>
                                    </td>
                                    <td><c:out value="${ingresos.entidad.nssPaciente}" /></td>
                                    <td><c:out value="${ingresos.entidad.fechaIngreso}" /></td>
                                    <td><c:out value="${ingresos.entidad.diagnostico}" /></td>
                                    <td>
                                        <a class="btn btn-success btn-xs"
                                           href="PacienteServlet?accion=ver&id=<c:out value="${ingresos.entidad.nssPaciente}" />">
                                            Ver Paciente
                                        </a>
                                        <a class="btn btn-success btn-xs"
                                           href="IngresoServlet?accion=nuevaActualizacion&id=<c:out value="${ingresos.entidad.idIngreso}" />">
                                            Modificar
                                        </a>
                                        <a class="btn btn-danger btn-xs"
                                           href="IngresoServlet?accion=eliminar&id=<c:out value="${ingresos.entidad.idIngreso}" />">
                                            Eliminar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" ></script>
    </body>
</html>
