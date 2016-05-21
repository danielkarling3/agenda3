/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.logica;

import br.ufpr.dao.ContatoDao;
import br.ufpr.modelo.Contato;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danielkarling
 */
public class DeletaContatoLogica implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("br.ufpr.logica.DeletaContatoLogica.executa()");
        Long id = Long.parseLong(request.getParameter("id"));
        Connection conexao = (Connection) request.getAttribute("conexao");
        deletarDoBanco(id, conexao);
        return "mvc?logica=ListaContatosLogica";
    }

    protected void deletarDoBanco(Long id, Connection conexao) {
        Contato contato = new Contato();
        contato.setID(id);
        ContatoDao dao = new ContatoDao(conexao);
        dao.deletar(contato);
    }
}
