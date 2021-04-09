package com.spring.mvc.user.mvc_controller;

import com.spring.mvc.user.domain.User;
import com.spring.mvc.user.repository.MemoryUserRepository;
import com.spring.mvc.user.repository.UserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//회원 목록 조회를 처리하는 컨트롤러
@WebServlet(urlPatterns = "/find-users")
public class FindUsersServlet extends HttpServlet {

    private UserRepository repository = new MemoryUserRepository();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //회원 저장소로부터 유저 리스트를 받아옴
        List<User> users = repository.findAllUsers();

        //모델에 화면에서 사용할 데이터를 담아 둠.
        //모델로 사용할 수 있는 객체(request(한개의 요청에 대에서만), session, application)
        request.setAttribute("userList", users);

        //모델에 담아둔 객체를 jsp파일로 전송(forwarding)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user-list.jsp");
        dispatcher.forward(request, response);

    }
}
