/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.servlets;

import br.ufpr.logica.Logica;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danielkarling
 */
@WebServlet(name = "ControlerServlet", urlPatterns = {"/mvc"})
public class ControlerServlet extends HttpServlet {

    private static final long serialVersionUID = 1l;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("logica");
        try {
            Class classe = Class.forName("br.ufpr.logica."+nome);
            Logica logica = (Logica)classe.newInstance();
            String visao = logica.executa(request, response);
            RequestDispatcher rd = request.getRequestDispatcher(visao);
            rd.forward(request, response);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControlerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ControlerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControlerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControlerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

}
