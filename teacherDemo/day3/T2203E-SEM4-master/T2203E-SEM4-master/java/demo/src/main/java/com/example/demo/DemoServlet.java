package com.example.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Writer out = resp.getWriter();
        out.write("<html><body>");
        out.write("<form action='hello-servlet' method='POST'>");
        out.write("<input type='text' name='studentName' />");
        out.write("<input type='text' name='studentPhone' />");
        out.write("<input type='text' name='studentAddress' />");
        out.write("<input type='submit' value='Submit' />");
        out.write("</form>");
        out.write("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
