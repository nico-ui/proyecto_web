<%-- 
    Document   : index
    Created on : 24 ene 2021, 17:35:36
    Author     : Cristopher Salas
--%>
<%@page session="true"%>
<%@page errorPage="error.jsp?de=index.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Iniciar sesión</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" >
        <link rel="stylesheet" href="css/estilos.css" >
    </head>
    <body class="body1">
        <div class="contenedor2">
            <label class="label1">Inicia sesión</label><br/>
            <form method="POST" action="LoginServlet?accion=login">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Correo electrónico</label>
                    <input id="email" type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"/>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Contraseña</label>
                    <input id="password" type="password" name="password" class="form-control" id="exampleInputPassword1"/>
                </div>
                <input class="btn btn-primary btn-lg btn-block" type="submit" value="Entrar" />
                <hr>
                <label class="label2">¿No tienes una cuenta?</label>
                <a href="PersonalMedicoExternoServlet?accion=listaE" class="btn btn-success btn-lg btn-block">Crear cuenta nueva</a>
            </form>
        </div>
    </body>
</html>