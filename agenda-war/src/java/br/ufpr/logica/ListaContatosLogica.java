/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.logica;

import br.ufpr.dao.ContatoDao;
import br.ufpr.modelo.Contato;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danielkarling
 */
public class ListaContatosLogica implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Connection conexao = (Connection) request.getAttribute("conexao");
        ContatoDao dao = new ContatoDao(conexao);
        List<Contato>  contatos = dao.getLista();
        request.setAttribute("contatos", contatos);        
        return "/WEB-INF/jsp/listar-contatos.jsp";
        
    }
    
}
