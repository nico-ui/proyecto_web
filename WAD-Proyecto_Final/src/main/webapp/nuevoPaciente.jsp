<%-- 
    Document   : nuevoPaciente
    Created on : 25 ene 2021, 16:21:34
    Author     : Cristopher Salas
--%>

<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp?de=nuevoPaciente.jsp"%>
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
            <label class="label3">Agregar paciente nuevo</label><br/>
            <hr>
            <form method="POST" action="PacienteServlet?accion=guardar">
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm">No. de seguro social</span>
                    </div>
                    <input id="nss" name="nss" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                </div>
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
                        <span class="input-group-text" id="inputGroup-sizing-sm">Teléfono</span>
                    </div>
                    <input id="telefono" name="telefono" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm">Correo electrónico</span>
                    </div>
                    <input id="email" name="email" type="email" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm">Fecha de Nacimiento</span>
                    </div>
                    <input id="fechaNacimiento" name="fechaNacimiento" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm">Sexo</span>
                    </div>

                    <select id="sexo" name="sexo" type="text" class="custom-select" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                        <option value="M">Masculino</option>
                        <option value="F">Femenino</option>
                    </select>
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm">No. de expediente</span>
                    </div>
                    <input id="idExpediente" name="idExpediente" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                </div>
                <input class="btn btn-primary btn-lg btn-block" type="submit" value="Agregar"/>
            </form>
        </div>
    </body>
</html>
