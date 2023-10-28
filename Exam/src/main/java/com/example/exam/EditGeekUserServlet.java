package com.example.exam;
import Model.GeekUsers;
import dao.GeekUsersDao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet")
public class EditGeekUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<h1>Update GeekUser</h1>");
        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);

        // We need to get the id from view servlet
        // request and it has to be parsed with
        // Integer.parseInt in order to get as number
        // Then specific user is retrieved by means
        // of GeekUsersDao.getGeekUsersById(id)
        GeekUsers e= GeekUsersDao.getGeekUsersById(id);

        out.print("<form action='EditServlet2' method='post'>");
        out.print("<table>");
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
        out.print("<tr><td>Number Of Posts:</td><td><input type='text' name='numberOfPosts' value='"+e.getNumberOfPosts()+"'/></td></tr>");
        out.print("<tr><td>Technologies Preferred:</td><td><input type='text' name='technologiesPreferred' value='"+e.gettechnologiesPreferred()+"'/></td></tr>");

        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
        out.print("</table>");
        out.print("</form>");

        out.close();
    }
}