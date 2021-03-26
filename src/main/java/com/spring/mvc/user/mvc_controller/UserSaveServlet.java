package com.spring.mvc.user.mvc_controller;

import com.spring.mvc.user.domain.User;
import com.spring.mvc.user.repository.MemoryUserRepository;
import com.spring.mvc.user.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//회원 저장을 수행하는 컨트롤러
@WebServlet(urlPatterns = "/user-save")
public class UserSaveServlet extends HttpServlet {

    private UserRepository repository = new MemoryUserRepository();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //쿼리 파라미터를 읽어야함
        String name = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        User newUser = new User(name,age);

        //회원 저장소에 저장
        repository.save(newUser);

        //회원 목록 조회 요청
        resp.sendRedirect("/find-users");
    }
}
