
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>adicionar contato</title>

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="jquery-ui.min.css">
        <script src="js/bootstrap.min.js"></script>
        <script src="jquery.js"></script>
        <script src="jquery-ui.js"></script>
        <!-- <script scr="http://code.jquery.com/jquery-1.9.1.js"></script> -->
        <!-- <script scr="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script> -->


    </head>
    <body>
        <form role="form" action="mvc?logica=AdicionaContatoLogica" method="POST">
            <div class="container">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <center>Adicionar Contato</center>
                    </div>
                    <div class="panel-body">
                        <div class="form-group">
                            <label for="nome">Nome:</label><input type="nome"
                                                                  class="form-control" name="nome">
                        </div>

                        <div class="form-group">
                            <label for="email">E-mail:</label><input type="email"
                                                                     class="form-control" name="email">
                        </div>

                        <div class="form-group">
                            <label for="endereco">Endereço:</label><input type="endereco"
                                                                          class="form-control" name="endereco">
                        </div>


                        <div class="form-group">
                            <label for="dataNascimento">Data de Nascimento:</label>

                            <myTags:campoData id="dataNascimento"/>


                            


                        <button type="submit" class="btn btn-info">Adicionar</button>
                        <button type="button" class="btn btn-info"
                                onclick="window.location.href = 'mvc?logica=ListaContatosLogica';">Voltar</button>

                    </div>
                </div>
            </div>
        </form>
    </body>
</html>