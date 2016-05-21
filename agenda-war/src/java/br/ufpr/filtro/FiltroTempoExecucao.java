/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author danielkarling
 */
@WebFilter("/*")
public class FiltroTempoExecucao implements Filter{

   
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
 
        long tempoInicial = System.currentTimeMillis();
        chain.doFilter(request, response);
        long tempoFinal = System.currentTimeMillis();
        String uri =((HttpServletRequest) request).getRequestURI();
        String parametros = ((HttpServletRequest) request).getParameter("logica");
        System.out.println("Tempo da requisição de " +uri+"?logica="+parametros+" demorou (ms): "+(tempoFinal-tempoInicial) );    
    }

    @Override
    public void destroy() {
        
    }
     @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

}
