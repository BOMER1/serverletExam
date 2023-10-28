package com.example.demo.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/asynchronous-servlet", asyncSupported = true)
public class AsynchronousServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Synchronous Servlet</h1>");
        out.println("<progress id='progress' max='100'></progress>");
        AsyncContext asyncContext = req.startAsync();
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i <= 100) {
                    out.println("<script>document.getElementById('progress').value = '"+ i++ +"';</script>");
                    out.flush();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                asyncContext.complete();
            }
        });

        out.println("<h1>success progress</h1>");
        out.println("</body></html>");
    }
}
