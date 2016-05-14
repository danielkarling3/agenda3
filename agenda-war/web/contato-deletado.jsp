<%-- 
    Document   : contato-deletado
    Created on : 13/05/2016, 21:11:13
    Author     : danielkarling
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="jquery-ui.min.css">
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <br>
        <div class="container">
            
                Contato ${param.nome} deletado com sucesso
        </div>
        <br>
        <button align ="center" type="button" class="btn btn-info"
                onclick="window.location.href = 'listar-contatos.jsp';">Voltar</button>
    </body>
</html>
