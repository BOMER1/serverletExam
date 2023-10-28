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
@WebServlet("/SaveServlet")
public class SaveGeekUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Getting all the request parameters from
        // index.html
        String name = request.getParameter("name");
        int numberOfPosts = Integer.parseInt(
                request.getParameter("numberOfPosts"));
        String technologiesPreferred
                = request.getParameter("technologiesPreferred");

        // GeekUsers object is created
        GeekUsers geekUser = new GeekUsers();

        // Collected parameters like name, numberOfPosts and
        // technologiesPreferred are set for the object so
        // that it can be retrieved in other places
        geekUser.setName(name);
        geekUser.setNumberOfPosts(numberOfPosts);
        geekUser.setTechnologiesPreferred(
                technologiesPreferred);

        // Calling save method in GeekUsersDao by passing
        // geekUser
        int status = GeekUsersDao.save(geekUser);

        // This is possible when the record is saved
        // successfully
        if (status > 0) {
            out.print("<p>Record saved successfully!</p>");
            request.getRequestDispatcher("index.jsp")
                    .include(request, response);
        }
        else {
            // If there is an issue in saving the record, we
            // need to show this message
            out.println("Sorry! unable to save record");
        }

        out.close();
    }
}
