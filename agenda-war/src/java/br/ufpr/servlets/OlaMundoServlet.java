package br.ufpr.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OlaMundoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        //super.service(request, response);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Exemplo</title></head>");
        out.println("<body>Hello World com Servlets</body>");
        out.println("</html>");
    }

}
