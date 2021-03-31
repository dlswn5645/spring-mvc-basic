package com.spring.mvc.springweb.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public class ModifyBoard {

    private int boardNo;
    private String writer;
    private String title;
    private String content;
}
