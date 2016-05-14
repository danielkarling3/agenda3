/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.logica;

import br.ufpr.dao.ContatoDao;
import br.ufpr.modelo.Contato;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danielkarling
 */
public class AdicionaContatoLogica implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nome = request.getParameter("nome");

        String email = request.getParameter("email");
        String endereco = request.getParameter("endereco");
        String dataNascimentoTexto = request.getParameter("dataNascimento");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Calendar dataNascimento = Calendar.getInstance();
        try {
            dataNascimento.setTime(sdf.parse(dataNascimentoTexto));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException();
        }

        gravarBanco(nome, email, endereco, dataNascimento);
        return "contato-adicionado.jsp";
    }

    
    

    protected void gravarBanco(String nome, String email, String endereco, Calendar dataNascimento) {
        Contato contato = new Contato(nome, email, endereco, dataNascimento);
        ContatoDao dao = new ContatoDao();

        System.out.println("novo DAO");
        dao.adiciona(contato);
        System.out.println(contato.getNome());

    }
}
