package com.spring.mvc.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/req-param")
public class RequestServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("userName");
        int age = Integer.parseInt(req.getParameter("age"));

        //Database 연동이 중간에 들어가야 함

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        PrintWriter w = resp.getWriter();
        w.println("<html>");
        w.println("<head>");
        w.println("</head>");
        w.println("<body>");
        w.println("     <div>");
        w.println("         <p>");
        w.println("             이름: " + name + ", 나이: " + age + "세");
        w.println("         </p>");
        w.println("     </div>");
        w.println("</body>");
        w.println("</html>");


    }
}
