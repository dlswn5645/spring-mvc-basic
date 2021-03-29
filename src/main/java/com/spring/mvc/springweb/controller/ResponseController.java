package com.spring.mvc.springweb.controller;

import com.spring.mvc.springweb.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseController {

    @GetMapping("/response/res-ex")
    public String resEx(){
        return "response/res-ex";
    }

    //Model객체를 활용하여 화면(view)에 데이터 전송하기
    @GetMapping("/response/test")
    public String test(int age, Model model) {
        //화면으로 보낸 데이터를 모델 객체에 세팅
        model.addAttribute("userAge",age);
        model.addAttribute("nick","뽀삐");
        return "response/test";
    }

    /*
    @GetMapping("/response/test2")
    public String test2(User user, Model model) {
        model.addAttribute("user",user);
        return "response/test2";
    }
     */

    //ModelAndView 객체를 활용한 처리
    //RestController: REST API작업할 때 String을 리턴하게되면
    //클라이언트로 문자열이 바로전송되므로 화면을 포워딩할 때 쓰임
    @GetMapping("/response/test2")
    public String test2(User user) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",user);
        mv.setViewName("response/test2");
        return "response/test2";
    }

    @GetMapping("/response/res-login")
    public String resQuiz(){
        return "response/res-quiz";
    }

    @PostMapping("/response/res-login")
    public String resLogin(User user, Model model){
        model.addAttribute("user",user);
        if(user.getUserId().equals("kim1234")&&user.getUserPw().equals("kkk1234")){
            return "response/res-quiz-success";
        }else {
            return "response/res-quiz-fail";
        }
    }



}
