<%-- 
    Document   : error
    Created on : 25 ene 2021, 16:05:30
    Author     : Cristopher Salas
--%>

<%@page isErrorPage="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>P&aacute;gina de Error</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" >
    </head>
    <body>
        <h1>Error Inesperado</h1>
        <%
            String de = request.getParameter("de");
        %>
        <p>
            Ocurrió un error en: <%= de%>
        </p>
        <p>
            El error es:<%= exception%>
        </p>
        <h3>Por favor acuda con el personal del área de sistemas</h3>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" ></script>
    </body>
</html>
