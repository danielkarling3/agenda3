<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="br.ufpr.modelo.Contato"%>
<%@ page import="br.ufpr.dao.ContatoDao"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://displaytag.sf.net/el" prefix="display"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Contatos</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <br>
        <center>
            <c:import url="cabecalho.jsp"></c:import>
            </center>
            <br>
        <jsp:useBean id="dao" class="br.ufpr.dao.ContatoDao"></jsp:useBean>



        <% request.setAttribute("tabela", new ContatoDao().getLista());%>

        <div class="container"> 
            <div class="panel panel-info">
                <div class="panel-heading"> 
                    <center>Listar Contatos</center>
                </div> 
                <div class="panel-info"> 



                    <display:table name="tabela"  class="table">
                        <display:column property="nome" title="nome"></display:column>
                        <display:column property="email" title="email"></display:column>

                        <display:column property="endereco" title="endereço"></display:column>
                        <display:column property="dataNascimento" title="data de nascimento"></display:column>

                        
                        </div>
                    </display:table>

                    <button align="center" class="btn btn-info" 
                            onclick="window.location.href = 'adiciona-contato.jsp';"> 
                        Adicionar Contato</button> 
                </div>
            </div>
        </div> 
    </div> 
</div>
<c:import url="rodape.jsp"></c:import>
</body>
</html>