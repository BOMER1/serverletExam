package com.example.demo.filter;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
@WebFilter(urlPatterns = {"/upload-file"})
public class AuthenFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try{
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse)  servletResponse;
            HttpSession session = request.getSession();
            String username = (String)session.getAttribute("username");
            String uri = request.getRequestURI();
            if (username == null) {
                response.sendRedirect("login-servlet");
            }
            filterChain.doFilter(request,response);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
