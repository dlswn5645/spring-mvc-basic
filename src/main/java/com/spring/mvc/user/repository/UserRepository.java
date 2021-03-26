package com.spring.mvc.user.repository;

import com.spring.mvc.user.domain.User;
import java.util.List;

public interface UserRepository {

    //회원 저장 기능(insert)
    void save(User user);

    //회원 전체 목록 조회 기능(select)
    List<User> findAllUsers();
}
