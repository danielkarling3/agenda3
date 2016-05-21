/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.logica;

import br.ufpr.dao.ContatoDao;
import br.ufpr.modelo.Contato;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danielkarling
 */
public class AlteraContatoLogica implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(request.getParameter("id"));

        Long id = Long.parseLong(request.getParameter("id"));

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

        System.out.println("gravar\n");

        System.out.println(sdf.format(dataNascimento.getTime()));

         Connection conexao = (Connection) request.getAttribute("conexao");
         
        System.out.println("conexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxao\n");
        gravarBanco(id, nome, email, endereco, dataNascimento, conexao);
         return "mvc?logica=ListaContatosLogica";
    }

    protected void gravarBanco(Long id, String nome, String email, String endereco, Calendar dataNascimento, Connection conexao) {
        Contato contato = new Contato();
        contato.setDataNascimento(dataNascimento);
        contato.setEmail(email);
        contato.setID(id);
        contato.setNome(nome);
        contato.setEndereco(endereco);
        ContatoDao dao = new ContatoDao(conexao);

        System.out.println("novo DAO");
        dao.alterar(contato);
        System.out.println(contato.getNome());

    }
}


