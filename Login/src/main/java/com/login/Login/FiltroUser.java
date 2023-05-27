package com.login.Login;

import java.io.IOException;

import org.springframework.stereotype.Controller;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/user")
public class FiltroUser implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)request).getSession();
        var tipo = session.getAttribute("tipo");

        if(tipo == null){
            ((HttpServletResponse) response).sendRedirect("index.html");

        }else if(tipo.equals("user")){
            chain.doFilter(request, response);
        }else{
            ((HttpServletResponse) response).sendRedirect("index.html");
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        Filter.super.init(filterConfig);
    }
    
}
