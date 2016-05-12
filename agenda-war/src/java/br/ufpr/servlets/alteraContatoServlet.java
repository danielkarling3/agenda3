package br.ufpr.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufpr.dao.ContatoDao;
import br.ufpr.modelo.Contato;

/**
 * Servlet implementation class alteraContatoServlet
 */
@WebServlet("/alteraContatoServlet")
public class alteraContatoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public alteraContatoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println(request.getParameter("id"));

        Long id = Long.parseLong(request.getParameter("id"));

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String endereco = request.getParameter("endereco");
        String dataNascimentoTexto = request.getParameter("dataNascimento");

        //
        //
        // out.println("Nome : " + nome);
        // out.println("Email : " + email);
        // out.println("Endereco : " + endereco);
        // out.println("Data de Nascimento : " + dataNascimentoTexto);
        //
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

        gravarBanco(id, nome, email, endereco, dataNascimento);
        response.sendRedirect("listar-contatos.jsp");
    }

    protected void gravarBanco(Long id, String nome, String email, String endereco, Calendar dataNascimento) {
        Contato contato = new Contato();
        contato.setDataNascimento(dataNascimento);
        contato.setEmail(email);
        contato.setID(id);
        contato.setNome(nome);
        contato.setEndereco(endereco);
        ContatoDao dao = new ContatoDao();

        System.out.println("novo DAO");
        dao.alterar(contato);
        System.out.println(contato.getNome());

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
