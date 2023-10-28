package com.example.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;

@WebServlet(value = "/upload-file")
@MultipartConfig(
        fileSizeThreshold = 1024*1024*10,
        maxFileSize = 1024*1024*100,
        maxRequestSize = 1024*1024*100
)
public class UploadFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        writer.write("<html><body>");
        writer.write("<form action ='upload-file' method='post' enctype='multipart/form-data'>");
        writer.write("File : <input type='file' name='file' multiple />");
        writer.write("<input type='submit' value='submit' />");
        writer.write("</form>");
        writer.write("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        try {
            String outputPath = getServletContext().getRealPath("") + File.separator + "fileUpload";
            File file = new File(outputPath);
            if(!file.exists()){
                file.mkdir();
            }
            Collection<Part> parts = req.getParts();
            for(Part p : parts){
                String fileName = p.getSubmittedFileName();
                p.write(outputPath+ File.separator+fileName);
            }
            writer.write("<html><body>");
            writer.write("upload file thanh cong");
            writer.write("<img src='fileUpload/avata.png'></img>");
            writer.write("</body></html>");
        } catch (Exception ex){
            log("error upload file"+ex.getMessage());
            writer.write("upload file loi");
        }
    }
}
