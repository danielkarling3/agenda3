<%-- 
    Document   : contato-adicionado
    Created on : 12/05/2016, 19:41:47
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
            
                Contato ${param.nome} adicionado com sucesso
        </div>
        <br>
        <button align ="center" type="button" class="btn btn-info"
                onclick="window.location.href = 'mvc?logica=ListaContatosLogica';">Voltar</button>
    </body>
</html>
