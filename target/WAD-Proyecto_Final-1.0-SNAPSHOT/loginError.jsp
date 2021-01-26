<%-- 
    Document   : loginError
    Created on : 25 ene 2021, 17:10:21
    Author     : Cristopher Salas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp?de=loginError.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inicia sesión</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" >
        <link rel="stylesheet" href="css/estilos.css" >
    </head>
    <body class="body1">
        <div class="contenedor2">
            <label class="label1">Inicia sesión</label><br/>
            <form action="LoginServlet?accion=login" method="POST">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Correo electrónico</label>
                    <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"/>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Contraseña</label>
                    <input type="password" name="password" class="form-control" id="exampleInputPassword1"/>
                </div>
                <input class="btn btn-primary btn-lg btn-block" type="submit" value="Entrar" />
                <hr>
                <label class="label2">¿No tienes una cuenta?</label>
                <a href="nuevoPersonalMedico.html" class="btn btn-success btn-lg btn-block">Crear cuenta nueva</a>
            </form>
        </div>
    </body>
</html>
