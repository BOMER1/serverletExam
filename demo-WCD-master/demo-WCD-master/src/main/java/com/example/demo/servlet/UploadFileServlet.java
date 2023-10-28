package com.example.demo.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet (value = "/upload-file")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class UploadFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        writer.write("<html><body>");
        writer.write("<form method='post' action='upload-file' enctype='multipart/form-data'>");
        writer.write("<input type='file' name='file' />");
        writer.write("<input type='submit' value='Upload' />");
        writer.write("</form>");
        writer.write("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part filePart = req.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        for (Part part : req.getParts()) {
            part.write("C:\\Users\\Admin\\Desktop\\upload" + fileName);
        }
        resp.getWriter().print("uploaded sucessfully");
    }
}
