package com.example.exam;
import Model.GeekUsers;
import dao.GeekUsersDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")
public class ViewGeekUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter=response.getWriter();
        printWriter.println("<a href='index.html'>Add New GeekUser</a>");
        printWriter.println("<h1>GeekUsers List</h1>");

        List<GeekUsers> list= GeekUsersDao.getAllGeekUses();

        printWriter.print("<table border='1' bordercolor='#009879' width='50%'");
        printWriter.print("<tr><th>Id</th><th>Name</th><th>Number Of Post</th><th>Preferred Technology</th><th>Edit</th><th>Delete</th></tr>");
        for(GeekUsers e:list){
            // each row is identified by means of its id
            // hence on click of 'edit', it is sent as
            // <a href='EditServlet?id="+e.getId()+"'>edit</a>
            // on click of 'delete', it is sent as
            // <a href='DeleteServlet?id="+e.getId()+"'>delete</a>
            printWriter.print("<tr><td >"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getNumberOfPosts()+"</td><td>"+e.gettechnologiesPreferred()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");
        }
        printWriter.print("</table>");

        printWriter.close();
    }
}
