<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mysql.fabric.xmlrpc.base.Param"%>
<%@page import="br.ufpr.modelo.Contato"%>
<%@page import="java.awt.Button"%>
<%@page import="br.ufpr.dao.ContatoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Contato</title>
    </head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="jquery-ui.min.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="jquery.js"></script>
    <script src="jquery-ui.js"></script>
<!--     <script scr="http://code.jquery.com/jquery-1.9.1.js"></script> 
     <script scr="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script> -->
    <body>

        <jsp:useBean id="dao" class="br.ufpr.dao.ContatoDao" />
        <jsp:useBean id="contato" class="br.ufpr.modelo.Contato" />

        <%
            String idS = request.getParameter("id");
            contato = dao.buscaContato(Long.parseLong(idS));
        %>

        <form role="form"
              action="alteraContatoServlet?id=<%=contato.getID()%>" method="POST">
            <div class="container">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <center>Alterar Dados</center>
                    </div>
                    <div class="panel-body">
                        <div class="form-group">
                            <label for="nome">Nome:</label><input type="nome"
                                                                  class="form-control" name="nome" value="<%=contato.getNome()%>">
                        </div>

                        <div class="form-group">
                            <label for="email">E-mail:</label><input type="email"
                                                                     class="form-control" name="email" value="<%=contato.getEmail()%>">
                        </div>

                        <div class="form-group">
                            <label for="endereco">Endereço:</label><input type="endereco"
                                                                          class="form-control" name="endereco"
                                                                          value="<%=contato.getEndereco()%>">
                        </div>

                        <div class="form-group">
                            <label for="dataNascimento">Data de Nascimento:</label><input
                                id="dataNascimento" type="date" class="form-control"
                                name="dataNascimento"
                                value="<%=new SimpleDateFormat("dd/MM/yyyy").format(contato.getDataNascimento().getTime())%>">
                            <script>
                                var $j = jQuery.noConflict();
                                $j("#dataNascimento").datepicker({
                                    dateformat: 'dd/mm/yy'
                                });
                            </script>
                        </div>
                        <button type="submit" class="btn btn-info">Alterar</button>
                        <button type="button" class="btn btn-info"
                                onclick="window.location.href = 'listar-contatos.jsp';">Voltar</button>

                    </div>
                </div>
            </div>
        </form>


    </body>
</html>