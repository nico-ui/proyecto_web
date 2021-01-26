<%-- 
    Document   : pacientes
    Created on : 25 ene 2021, 3:29:20
    Author     : Cristopher Salas
--%>

<%@page import="com.ipn.escom.mx.modelo.dto.PacienteDTO"%>
<%@page import="com.ipn.escom.mx.modelo.dao.PacienteDAO"%>
<%@page import="com.ipn.escom.mx.modelo.dto.PersonalMedicoDTO"%>
<%@page import="com.ipn.escom.mx.modelo.dao.PersonalMedicoDAO"%>
<%@page import="java.util.List"%>
<%@page errorPage="error.jsp?de=pacientes.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pacientes</title>
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
        <h1>Pacientes</h1>
        <div class="container">
            <h2>Lista de Pacientes</h2>
            <a href="PacienteServlet?accion=nuevo" class="btn btn-warning">Nuevo</a>
            <a href="PacienteServlet?accion=verPDF" class="btn btn-warning">Generar reporte</a>
            <br/>
            <br/>
            <br/>
            <div class="table-responsive">
                <div class="body3">
                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th>No. Seguro Social</th>
                                <th>Nombre</th>
                                <th>A. Paterno</th>
                                <th>A. Materno</th>
                                <th>Fecha de Nacimiento</th>
                                <th>Sexo</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody> 
                            <c:forEach
                                var="pacientes" items="${listaDePacientes}">
                                <tr>
                                    <td>
                                        <a class="btn btn-primary btn-xs"
                                           href="PacienteServlet?accion=ver&nss=<c:out value="${pacientes.entidad.nss}" />">
                                            <c:out value="${pacientes.entidad.nss}" />
                                        </a>
                                    </td>
                                    <td><c:out value="${pacientes.entidad.nombre}" /></td>
                                    <td><c:out value="${pacientes.entidad.paterno}" /></td>
                                    <td><c:out value="${pacientes.entidad.materno}" /></td>
                                    <td><c:out value="${pacientes.entidad.fechaNacimiento}" /></td>
                                    <td><c:out value="${pacientes.entidad.sexo}" /></td>
                                    <td>
                                        <a class="btn btn-success btn-xs"
                                           href="ExpedienteServlet?accion=ver&idExpediente=<c:out value="${pacientes.entidad.idExpediente}" />">
                                            Ver Expediente
                                        </a>
                                        <a class="btn btn-success btn-xs"
                                           href="PacienteServlet?accion=nuevaActualizacion&nss=<c:out value="${pacientes.entidad.nss}" />">
                                            Modificar
                                        </a>
                                        <a class="btn btn-danger btn-xs"
                                           href="PacienteServlet?accion=eliminar&nss=<c:out value="${pacientes.entidad.nss}" />">
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
