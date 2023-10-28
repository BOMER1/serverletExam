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
@WebServlet("/EditServlet2")
public class EditGeekUserServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);
        String name=request.getParameter("name");
        int numberOfPosts=Integer.parseInt(request.getParameter("numberOfPosts"));
        String technologiesPreferred=request.getParameter("technologiesPreferred");

        GeekUsers geekUser=new GeekUsers();
        geekUser.setId(id);
        geekUser.setName(name);
        geekUser.setNumberOfPosts(numberOfPosts);
        geekUser.setTechnologiesPreferred(technologiesPreferred);

        // GeekUsersDao.update method is called
        // along with the modified values for geekUser
        int status= GeekUsersDao.update(geekUser);
        if(status>0){
            response.sendRedirect("ViewServlet");
        }else{
            out.println("Sorry! unable to update record");
        }

        out.close();
    }

}
