package com.example.exam;

import dao.GeekUsersDao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteGeekUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException
    {
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        // GeekUsersDao.delete method is called with the
        // corresponding id and then it is redirected to
        // viewservlet
        GeekUsersDao.delete(id);
        response.sendRedirect("ViewServlet");
    }
}
