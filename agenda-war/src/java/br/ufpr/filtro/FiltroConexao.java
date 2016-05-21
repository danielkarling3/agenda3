/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.filtro;

import br.ufpr.jdbc.MysqlConectionFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 *
 * @author danielkarling
 */

@WebFilter("/*")
public class FiltroConexao implements Filter{


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
     
        Connection connection = (new MysqlConectionFactory()).getConnection();
        request.setAttribute("conexao", connection);
        chain.doFilter(request, response);
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(FiltroConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void destroy() {
       
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       
    }
    
}
