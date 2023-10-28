package servlet;

import dao.StudentDAO;
import entity.Student;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({
        "/student/index",
        "/student/create",
        "/student/update",
        "/student/delete",
        "/student/reset",
        "/student/edit/*",
        "/student/delete/*",

})
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public StudentServlet(){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String url = request.getRequestURL().toString();
        request.setCharacterEncoding("utf-8");

        Student student = null;
        if (url.contains("delete")){
            StudentDAO dao = new StudentDAO();
            if (request.getParameter("id")!= null){
                dao.remove(request.getParameter("id"));
                request.setAttribute("message", "Delete success!");
            }
            student = new Student();
            request.setAttribute("student", student);
        }
        else if (url.contains("edit")){
            StudentDAO dao = new StudentDAO();
            if (request.getParameter("id")!= null)
                student = dao.findById(request.getParameter("id"));
            request.setAttribute("student", student);
        } else if (url.contains("reset")) {
            student = new Student();
            request.setAttribute("student", student);
        }

        findAll(request, response);
        request.getRequestDispatcher("/views/student.jsp").forward(request,response);
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            StudentDAO dao = new StudentDAO();
            List<Student> list = dao.findAll();
            request.setAttribute("students", list);
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("error","Error: "+ e.getMessage() );
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String url = request.getRequestURL().toString();
        request.setCharacterEncoding("utf-8");
        Student student = new Student();
        if (url.contains("create")){
            create(request, response);
        } else if (url.contains("update")) {
            update(request, response);
        } else if (url.contains("delete")) {
            delete(request, response);
        } else if (url.contains("reset")) {
            request.setAttribute("student", new Student());
        }
        findAll(request, response);
        request.getRequestDispatcher("/views/student.jsp").forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            Student student = new Student();
            BeanUtils.populate(student, request.getParameterMap());
            StudentDAO dao = new StudentDAO();
            dao.create(student);
            request.setAttribute("message", "Create success!");
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }
    private void update(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            Student student = new Student();
            BeanUtils.populate(student, request.getParameterMap());
            StudentDAO dao = new StudentDAO();
            dao.update(student);
            request.setAttribute("message", "Update success!");
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        try {
            Student student = new Student();
            BeanUtils.populate(student, request.getParameterMap());
            StudentDAO dao = new StudentDAO();
            if (student.getId()!=null)
                dao.remove(student.getId());
            request.setAttribute("message", "Delete success!");
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

}