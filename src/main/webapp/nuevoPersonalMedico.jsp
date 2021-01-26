<%-- 
    Document   : nuevoPersonalMedico
    Created on : 24 ene 2021, 19:41:59
    Author     : Cristopher Salas
--%>
<%@page import="com.ipn.escom.mx.modelo.dto.EspecialidadDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.ipn.escom.mx.modelo.dao.EspecialidadDAO"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp?de=nuevoPersonalmedico.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" >
        <link rel="stylesheet" href="css/estilos.css" >
    </head>
    <body class="body1">
        <div class="contenedor3">
            <label class="label3">Crear cuenta nueva</label><br/>
            <hr>
            <form method="POST" action="PersonalMedicoServlet?accion=guardar">
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm">Nombre</span>
                    </div>
                    <input id="nombre" name="nombre" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm">Apellido paterno</span>
                    </div>
                    <input id="paterno" name="paterno" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm">Apellido materno</span>
                    </div>
                    <input id="materno" name="materno" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm">Cédula Profesional</span>
                    </div>
                    <input id="cedula" name="cedula" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm">Cargo</span>
                    </div>
                    <input id="cargo" name="cargo" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm">Unidad Académica</span>
                    </div>
                    <input id="unidadAcademica" name="unidadAcademica" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm">Especialidad</span>
                    </div>
                    <select id="especialidad" name="especialidad" type="text" class="custom-select" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                        <c:forEach 
                            var="especialidades" items="${listaDeEspecialidades}">
                            <option value="${especialidades.entidad.idEspecialidad}">
                                ${ especialidades.entidad.nombre }
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm">Tipo</span>
                    </div>

                    <select id="tipoUsuario" name="tipoUsuario" type="text" class="custom-select" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                        <option value="M">Médico</option>
                        <option value="E">Enfermero(a)</option>
                    </select>
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm">Correo electrónico</span>
                    </div>
                    <input id="email" name="email" type="email" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm">Contraseña</span>
                    </div>
                    <input id="clave" name="clave" type="password" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                </div>
                <input class="btn btn-primary btn-lg btn-block" type="submit" value="Registrarme"/>
            </form>
        </div>
    </body>
</html>