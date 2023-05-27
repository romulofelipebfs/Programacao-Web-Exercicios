package com.login.Login;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
public class Login {
    

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException{
        var login = request.getParameter("login");
        var password = request.getParameter("password");

        if(login.equals("user") && password.equals("123")){
            HttpSession session = request.getSession();
            session.setAttribute("tipo", "user");
            response.sendRedirect("/user");

        }else if(login.equals("admin") && password.equals("456")){
            HttpSession session = request.getSession();
            session.setAttribute("tipo", "admin");
            response.sendRedirect("/admin");

        }else{
            response.sendRedirect("index.html");
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public void doGetUser(HttpServletRequest request, HttpServletResponse response) throws IOException{
        var writer = response.getWriter();
        writer.println("Estou logado como USUÁRIO");
        String pessoa = request.getParameter("pessoa");
        Cookie c = new Cookie("nome", pessoa);
        response.addCookie(c);
        Cookie[] cookies = request.getCookies();

        for (Cookie c1: cookies){
            response.getWriter().println(c1.getValue());
        }
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public void doGetAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException{
        var writer = response.getWriter();
        writer.println("Estou logado como ADMIN");
    }



}
